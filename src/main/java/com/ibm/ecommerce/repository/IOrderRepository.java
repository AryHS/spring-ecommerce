package com.ibm.ecommerce.repository;

import com.ibm.ecommerce.model.Order;
import com.ibm.ecommerce.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer> {
  List<Order> findByUser(User user);
}
