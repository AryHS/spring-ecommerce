package com.ibm.ecommerce.service.user;

import com.ibm.ecommerce.model.User;
import com.ibm.ecommerce.repository.IUserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

  @Autowired
  private IUserRepository userRepository;

  @Override
  public Optional<User> findById(Integer id) {
    return userRepository.findById(id);
  }
}
