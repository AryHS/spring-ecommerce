package com.ibm.ecommerce.model;

import java.util.Date;

public class Order {

  private Integer id;
  private String numberOrder;
  private Date creationDate;
  private Date receivedDate;
  private double total;

  public Order() {
  }

  public Order(Integer id, String numberOrder, Date creationDate, Date receivedDate, double total) {
    this.id = id;
    this.numberOrder = numberOrder;
    this.creationDate = creationDate;
    this.receivedDate = receivedDate;
    this.total = total;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNumberOrder() {
    return numberOrder;
  }

  public void setNumberOrder(String numberOrder) {
    this.numberOrder = numberOrder;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public Date getReceivedDate() {
    return receivedDate;
  }

  public void setReceivedDate(Date receivedDate) {
    this.receivedDate = receivedDate;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  @Override
  public String toString() {
    return "Order{" +
        "id=" + id +
        ", numberOrder='" + numberOrder + '\'' +
        ", creationDate=" + creationDate +
        ", receivedDate=" + receivedDate +
        ", total=" + total +
        '}';
  }
}
