package com.ibm.ecommerce.model;

public class User {

  private Integer id;
  private String name;
  private String username;
  private String email;
  private String password;
  // Para los dos diferentes tipos de usuario que pueda existir: ADMIN / Normal
  private String typeUser;

  public User() {
  }

  public User(Integer id, String name, String username, String email, String password,
      String typeUser) {
    this.id = id;
    this.name = name;
    this.username = username;
    this.email = email;
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

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", username='" + username + '\'' +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        ", typeUser='" + typeUser + '\'' +
        '}';
  }
}
