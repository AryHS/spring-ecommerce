package com.ibm.ecommerce.service.order;

import com.ibm.ecommerce.model.Order;
import com.ibm.ecommerce.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService{

  @Autowired
  private IOrderRepository orderRepository;

  @Override
  public Order save(Order order) {
    return orderRepository.save(order);
  }
}
