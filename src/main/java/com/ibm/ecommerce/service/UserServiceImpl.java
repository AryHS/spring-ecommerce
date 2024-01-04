package com.ibm.ecommerce.service;

import com.ibm.ecommerce.model.User;
import com.ibm.ecommerce.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UserService{

  @Autowired
  private UserRepository userRepository;

  @Override
  public Optional<User> findById(Integer id) {
    return userRepository.findById(id);
  }
}
