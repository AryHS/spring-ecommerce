package com.ibm.ecommerce.controller;

import com.ibm.ecommerce.model.Order;
import com.ibm.ecommerce.model.Product;
import com.ibm.ecommerce.model.Summary;
import com.ibm.ecommerce.model.User;
import com.ibm.ecommerce.service.order.IOrderService;
import com.ibm.ecommerce.service.order.ISummaryService;
import com.ibm.ecommerce.service.product.ProductService;
import com.ibm.ecommerce.service.user.IUserService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {

  private final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

  @Autowired
  private ProductService productService;
  @Autowired
  private IUserService userService;
  @Autowired
  private IOrderService orderService;
  @Autowired
  private ISummaryService summaryService;


  //Para guardar los detalles del carrito
  List<Summary> summaryList = new ArrayList<Summary>();

  Order order = new Order();

  @GetMapping("")
  public String home(Model model){
    List<Product> productList = productService.findAll();
    model.addAttribute("productList", productList);
    LOGGER.info("Tamaño de la lista del Carrito: {}", summaryList.size());
    model.addAttribute("cart", summaryList);

    return "user/home";
  }
  @GetMapping("showProduct/{id}")
  public String showProduct(@PathVariable Integer id, Model model){
    LOGGER.info("Id producto enviado como parámetro {}", id);
    Product product = productService.get(id).get();
    model.addAttribute("product", product);
    model.addAttribute("cart", summaryList);

    return "user/show_product";
  }

  @PostMapping("/cart")
  public String addCart(@RequestParam Integer id, @RequestParam Integer cantity, Model model){
    Summary summary = new Summary();
    Product product;
    double total = 0;

    Optional<Product> productOptional = productService.get(id);
    LOGGER.info("Producto añadido: {}", productOptional.get());
    LOGGER.info("Cantidad: {}", cantity);
    product = productOptional.get();

    summary.setCantity(cantity);
    summary.setPrice(product.getPrice());
    summary.setName(product.getName());
    summary.setTotal(product.getPrice()*cantity);
    summary.setProduct(product);

    //Validación para agregar solo una vez cada producto al carrito
    Integer idProduct = product.getId();
    boolean isAdded = summaryList.stream().anyMatch(p -> p.getProduct().getId() == idProduct);

    if(!isAdded) {
      summaryList.add(summary);
    }

    total = summaryList.stream().mapToDouble(Summary::getTotal).sum();

    order.setTotal(total);
    model.addAttribute("cart", summaryList);
    model.addAttribute("order", order);

    return "user/cart";
  }

  //Método para eliminar un producto del carrito de Compras
  @GetMapping("/delete/cart/{id}")
  public String deleteProductCart(@PathVariable Integer id, Model model){

    //Lista auxiliar para conservar los demás elementos
    List<Summary> summaryListNew = new ArrayList<Summary>();

    for(Summary s: summaryList) {
      if(s.getProduct().getId() != id) {
        summaryListNew.add(s);
      }
    }
    // Se devuelve la lista con los demás productos
    summaryList = summaryListNew;

    double total = summaryList.stream().mapToDouble(Summary::getTotal).sum();

    order.setTotal(total);
    model.addAttribute("cart", summaryList);
    model.addAttribute("order", order);

    return "user/cart";
  }

  @GetMapping("/getCart")
  public String getCart(Model model){
    model.addAttribute("cart", summaryList);
    model.addAttribute("order", order);

    return "/user/cart";
  }

  @GetMapping("/order")
  public String viewOrder(Model model) {
    User user = userService.findById(1).get();

    model.addAttribute("cart", summaryList);
    model.addAttribute("order", order);
    model.addAttribute("user", user);

    return "user/summary_order";
  }

  // Método para guardar la orden de Compra
  @GetMapping("/saveOrder")
  public String saveOrder() {
    Date created = new Date();
    order.setCreationDate(created);
    order.setNumberOrder(orderService.generateIdOrder());

    // Guardar usuario en la orden
    User user = userService.findById(1).get();
    order.setUser(user);

    orderService.save(order);

    // Guardar Detalles de compra
    for(Summary s:summaryList) {
      s.setOrder(order);
      summaryService.save(s);
    }

    //Limpiar la lista y orden para nueva compra
    order = new Order();
    summaryList.clear();

    return "redirect:/";
  }

  @PostMapping("/search")
  public String searchProduct(@RequestParam String name, Model model){
    LOGGER.info("Nombre del producto buscado: {}", name);
    List<Product> productList = productService.findAll().stream().filter(p -> p.getName().contains(name)).collect(Collectors.toList());

    model.addAttribute("cart", summaryList);
    model.addAttribute("productList",productList);


    return "user/home";
  }
}
