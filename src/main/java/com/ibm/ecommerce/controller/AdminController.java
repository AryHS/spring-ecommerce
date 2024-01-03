package com.ibm.ecommerce.controller;

import com.ibm.ecommerce.model.Product;
import com.ibm.ecommerce.service.ProductService;
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

  @GetMapping("")
  public String home(Model model) {
    List<Product> productList = productService.findAll();
    model.addAttribute("productList", productList );

    return "admin/home";
  }
}
