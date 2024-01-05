package com.ibm.ecommerce.controller;

import com.ibm.ecommerce.model.Product;
import com.ibm.ecommerce.service.order.IOrderService;
import com.ibm.ecommerce.service.product.ProductService;
import com.ibm.ecommerce.service.user.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
  @Autowired
  private ProductService productService;
  @Autowired
  private IUserService userService;
  @Autowired
  private IOrderService orderService;

  @GetMapping("")
  public String home(Model model) {
    List<Product> productList = productService.findAll();
    model.addAttribute("productList", productList );

    return "admin/home";
  }
  @GetMapping("/users")
  public String users(Model model){
    model.addAttribute("usersList", userService.findAll());

    return "admin/users";
  }

  @GetMapping("/orders")
  public String orders(Model model){
    model.addAttribute("ordersList", orderService.findAll());
    return "admin/orders";
  }
}
