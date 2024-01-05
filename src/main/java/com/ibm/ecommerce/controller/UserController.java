package com.ibm.ecommerce.controller;

import com.ibm.ecommerce.model.Order;
import com.ibm.ecommerce.model.User;
import com.ibm.ecommerce.service.order.IOrderService;
import com.ibm.ecommerce.service.user.IUserService;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

  private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
  @Autowired
  private IUserService userService;

  @Autowired
  private IOrderService orderService;

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

  @GetMapping("/login")
  public String login(){
    return "user/login";
  }


  @PostMapping("/signIn")
  public String signIn(User user, HttpSession session){
    LOGGER.info("Accesos: {}",user);

    Optional<User> userOptional = userService.findByEmail(user.getEmail());
    //LOGGER.info("Usuario obtenido de db: {}",userOptional.get());

    if(userOptional.isPresent()){
      session.setAttribute("idUser", userOptional.get().getId());
      if(userOptional.get().getTypeUser().equals("ADMIN")) {
        return "redirect:/admin";
      }else {
        return "redirect:/";
      }
    }else {
      LOGGER.info("Usuario no existe");
    }

    return "redirect:/";
  }

  @GetMapping("/purchases")
  public String getPurchases(Model model, HttpSession session){
    model.addAttribute("session", session.getAttribute("idUser"));

    User user = userService.findById( Integer.parseInt(session.getAttribute("idUser").toString())).get();
    List<Order> orderList = orderService.findByUser(user);

    model.addAttribute("orderList", orderList);

    return "user/purchases";
  }

  @GetMapping("/details/{id}")
  public String purchasesDetails(@PathVariable Integer id, HttpSession session, Model model){
    LOGGER.info("Id de la orden: {}", id);
    Optional<Order> order = orderService.findById(id);

    model.addAttribute("details", order.get().getSummary());

    //session
    model.addAttribute("session", session.getAttribute("idUser"));

    return "user/purchases_details";
  }

  @GetMapping("/signOut")
  public String signOut(HttpSession session){
    session.removeAttribute("idUser");
    return "redirect:/";
  }
}
