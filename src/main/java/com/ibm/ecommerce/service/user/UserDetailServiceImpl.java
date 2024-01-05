package com.ibm.ecommerce.service.user;

import com.ibm.ecommerce.model.User;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
  @Autowired
  private IUserService userService;
  @Autowired
  private BCryptPasswordEncoder bCrypt;
  @Autowired
  HttpSession session;
  private Logger LOGGER = LoggerFactory.getLogger(UserDetailServiceImpl.class);


  /**
   *
   * @param username
   * @return
   * @throws UsernameNotFoundException
   */
  //Para cargar el usuario a través del email en la variable username
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    LOGGER.info("Este es el username");
    Optional<User> optionalUser = userService.findByEmail(username);

    if(optionalUser.isPresent()){
      LOGGER.info("Esto es el id del usuario: {}",optionalUser.get().getId());
      session.setAttribute("idUser", optionalUser.get().getId());
      User user = optionalUser.get();
      return org.springframework.security.core.userdetails.User.builder().username(user.getName()).password(user.getPassword()).roles(user.getTypeUser()).build();
    }else {
      throw new UsernameNotFoundException("Usuario no encontrado");
    }
  }
}
