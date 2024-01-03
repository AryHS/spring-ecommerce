package com.ibm.ecommerce.controller;

import com.ibm.ecommerce.model.Product;
import com.ibm.ecommerce.service.ProductService;
import com.ibm.ecommerce.service.ProductServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

  @Autowired
  private ProductServiceImpl productService;

  @GetMapping("")
  public String home(Model model){
    List<Product> productList = productService.findAll();
    model.addAttribute("productList", productList);

    return "user/home";
  }
}
