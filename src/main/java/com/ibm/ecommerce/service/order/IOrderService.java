package com.ibm.ecommerce.service.order;

import com.ibm.ecommerce.model.Order;
import java.util.List;

public interface IOrderService {
  Order save(Order order);
  List<Order> findAll();
  String generateIdOrder();
}
