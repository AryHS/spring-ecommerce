package com.ibm.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_id")
  private Integer id;
  @Column(name = "product_name")
  private String name;
  @Column(name = "product_description")
  private String description;
  @Column(name = "product_image")
  private String image;
  @Column(name = "product_price")
  private double price;
  @Column(name = "product_cantity")
  private int cantity;

  @ManyToOne
  private User user;

  public Product() {
  }

  public Product(Integer id, String name, String description, String image, double price,
      int cantity, User user) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.image = image;
    this.price = price;
    this.cantity = cantity;
    this.user = user;
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getCantity() {
    return cantity;
  }

  public void setCantity(int cantity) {
    this.cantity = cantity;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return "Product{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", image='" + image + '\'' +
        ", price=" + price +
        ", cantity=" + cantity +
        '}';
  }
}
