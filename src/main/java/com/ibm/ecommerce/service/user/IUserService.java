package com.ibm.ecommerce.service.user;

import com.ibm.ecommerce.model.User;
import java.util.Optional;

public interface IUserService {
  Optional<User> findById(Integer id);
  User save(User user);
}
