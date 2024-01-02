package com.ibm.ecommerce.controller;

import com.ibm.ecommerce.model.Product;
import com.ibm.ecommerce.model.User;
import com.ibm.ecommerce.service.ProductService;
import com.ibm.ecommerce.service.UploadFileService;
import java.io.IOException;
import java.util.Optional;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/products")
public class ProductController {
  //Variable auxiliar para manejar los Logs en las pruebas
  private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

  @Autowired
  private ProductService productService;

  @Autowired
  private UploadFileService upload;

  // Método para cargar la vista donde se muestran los productos
  @GetMapping("")
  public String show(Model model){
    model.addAttribute("products", productService.findAll());
    return "products/show";
  }

  //Método para cargar la vista donde se crea un producto
  @GetMapping("/create")
  public String create(){
    return "products/create";
  }

  @PostMapping("/save")
  public String save(Product product, @RequestParam("img") MultipartFile file) throws IOException {
    LOGGER.info("Este es el objeto producto {}", product);
    User user = new User(1, "", "", "", "", "");
    product.setUser(user);

    //Image
    if(product.getId() == null) { //Validación cuando se crea un producto el id va null
      String nameImage = upload.saveImage(file);
      product.setImage(nameImage);
    }else {
      if(file.isEmpty()) { //Validación cuando se edita el producto y NO se carga nueva imagen
        Product productLoaded = new Product();
        productLoaded = productService.get(product.getId()).get();
        product.setImage(productLoaded.getImage());
      } else {
        String nameImage = upload.saveImage(file);
        product.setImage(nameImage);
      }
    }

    productService.save(product);
    return "redirect:/products";
  }

  //Método que carga la vista donde se edita un producto junto con lógica de recuperación
  @GetMapping("/edit/{id}")
  public String edit(@PathVariable Integer id, Model model) {
    Product product = new Product();
    Optional<Product> optionalProduct = productService.get(id);
    product = optionalProduct.get();

    LOGGER.info("Producto buscado: {}", product);
    model.addAttribute("product", product);

    return "products/edit";
  }

  @PostMapping("/update")
  public String update(Product product) {
    productService.update(product);
    return "redirect:/products";
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable Integer id) {
    productService.delete(id);
    return "redirect:/products";
  }

}
