package com.ibm.ecommerce.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_id")
  private Integer id;
  @Column(name = "order_numberOrder")
  private String numberOrder;
  @Column(name = "order_creationDate")
  private Date creationDate;
  @Column(name = "order_receivedDate")
  private Date receivedDate;
  @Column(name = "order_total")
  private double total;

  @ManyToOne
  private User user;
  @OneToOne(mappedBy = "order")
  private Summary summary;

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

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Summary getSummary() {
    return summary;
  }

  public void setSummary(Summary summary) {
    this.summary = summary;
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
