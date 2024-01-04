package com.ibm.ecommerce.repository;

import com.ibm.ecommerce.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
  Optional<User> findByEmail(String email);
}
