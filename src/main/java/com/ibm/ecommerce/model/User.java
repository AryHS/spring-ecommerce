package com.ibm.ecommerce.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Integer id;
  @Column(name = "user_fullName")
  private String name;
  @Column(name = "user_alias")
  private String username;
  @Column(name = "user_email")
  private String email;
  @Column(name = "user_address")
  private String address;
  @Column(name = "user_password")
  private String password;

  // Para los dos diferentes tipos de usuario que pueda existir: ADMIN / Normal
  @Column(name = "user_type")
  private String typeUser;

  // Campo mapeado a la variable dentro de Product
  @OneToMany(mappedBy = "user")
  private List<Product> productList;

  @OneToMany(mappedBy = "user")
  private List<Order> orderList;

  public User() {
  }

  public User(Integer id, String name, String username, String email, String address, String password,
      String typeUser) {
    this.id = id;
    this.name = name;
    this.username = username;
    this.email = email;
    this.address = address;
    this.password = password;
    this.typeUser = typeUser;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getTypeUser() {
    return typeUser;
  }

  public void setTypeUser(String typeUser) {
    this.typeUser = typeUser;
  }

  public List<Product> getProductList() {
    return productList;
  }

  public void setProductList(List<Product> productList) {
    this.productList = productList;
  }

  public List<Order> getOrderList() {
    return orderList;
  }

  public void setOrderList(List<Order> orderList) {
    this.orderList = orderList;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", username='" + username + '\'' +
        ", email='" + email + '\'' +
        ", address='" + address + '\'' +
        ", password='" + password + '\'' +
        ", typeUser='" + typeUser + '\'' +
        '}';
  }
}
