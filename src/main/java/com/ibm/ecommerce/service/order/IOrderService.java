package com.ibm.ecommerce.service.order;

import com.ibm.ecommerce.model.Order;
import com.ibm.ecommerce.model.User;
import java.util.List;

public interface IOrderService {
  Order save(Order order);
  List<Order> findAll();
  String generateIdOrder();
  List<Order> findByUser(User user);
}
