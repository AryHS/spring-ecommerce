package com.ibm.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "summary")
public class Summary {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "summary_id")
  private Integer id;
  @Column(name = "summary_name")
  private String name;
  @Column(name = "summary_cantity")
  private double cantity;
  @Column(name = "summary_price")
  private double price;
  @Column(name = "summary_total")
  private double total;

  @ManyToOne
  private Order order;
  @ManyToOne
  private Product product;

  public Summary() {
  }

  public Summary(Integer id, String name, double cantity, double price, double total) {
    this.id = id;
    this.name = name;
    this.cantity = cantity;
    this.price = price;
    this.total = total;
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

  public double getCantity() {
    return cantity;
  }

  public void setCantity(double cantity) {
    this.cantity = cantity;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  @Override
  public String toString() {
    return "Summary{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", cantity=" + cantity +
        ", price=" + price +
        ", total=" + total +
        '}';
  }
  
  
}
