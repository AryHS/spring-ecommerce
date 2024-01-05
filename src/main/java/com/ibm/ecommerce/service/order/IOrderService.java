package com.ibm.ecommerce.service.order;

import com.ibm.ecommerce.model.Order;
import com.ibm.ecommerce.model.User;
import java.util.List;
import java.util.Optional;

public interface IOrderService {
  List<Order> findAll();
  Optional<Order> findById(Integer id);
  Order save(Order order);
  String generateIdOrder();
  List<Order> findByUser(User user);
}
