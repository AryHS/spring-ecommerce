package com.ibm.ecommerce.model;

public class Summary {
  
  private Integer id;
  private String name;
  private double cantity;
  private double price;
  private double total;

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
