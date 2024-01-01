package com.ibm.ecommerce.model;

public class Product {

  private Integer id;
  private String name;
  private String description;
  private String image;
  private double price;
  private int cantity;

  public Product() {
  }

  public Product(Integer id, String name, String description, String image, double price,
      int cantity) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.image = image;
    this.price = price;
    this.cantity = cantity;
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
