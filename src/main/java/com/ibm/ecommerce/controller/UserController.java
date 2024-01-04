package com.ibm.ecommerce.controller;

import com.ibm.ecommerce.model.User;
import com.ibm.ecommerce.service.user.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

  private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
  @Autowired
  private IUserService userService;

  @GetMapping("/registry")
  public String create(){
    return "user/registry";
  }

  @PostMapping("/save")
  public String home(User user){
    LOGGER.info("Usuario enviado: {}",user);
    user.setTypeUser("USER");
    userService.save(user);
    return "redirect:/";
  }
}
