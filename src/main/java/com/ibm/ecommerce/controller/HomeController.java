package com.ibm.ecommerce.controller;

import com.ibm.ecommerce.model.Product;
import com.ibm.ecommerce.service.ProductService;
import com.ibm.ecommerce.service.ProductServiceImpl;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

  private final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

  @Autowired
  private ProductServiceImpl productService;

  @GetMapping("")
  public String home(Model model){
    List<Product> productList = productService.findAll();
    model.addAttribute("productList", productList);

    return "user/home";
  }
  @GetMapping("show_product/{id}")
  public String showProduct(@PathVariable Integer id, Model model){
    LOGGER.info("Id producto enviado como parámetro {}", id);
    Product product = productService.get(id).get();

    model.addAttribute("product", product);

    return "user/show_product";
  }
}
