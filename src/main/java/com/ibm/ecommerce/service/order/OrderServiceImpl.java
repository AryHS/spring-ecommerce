package com.ibm.ecommerce.service.order;

import com.ibm.ecommerce.model.Order;
import com.ibm.ecommerce.repository.IOrderRepository;
import java.util.ArrayList;
import java.util.List;
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
  @Override
  public List<Order> findAll() {
    return orderRepository.findAll();
  }
  public String generateIdOrder(){
    int number = 0;
    String parsedNumber = "";

    List<Order> ordersList = findAll();
    List<Integer> numbersList = new ArrayList<Integer>();

    ordersList.stream().forEach(o -> numbersList.add(Integer.parseInt(o.getNumberOrder())));

    if(ordersList.isEmpty()) {
      number = 1;
    }else {
      number = numbersList.stream().max(Integer::compare).get();
      number++;
    }

    parsedNumber = String.valueOf(number);

    return parsedNumber;
  }
}
