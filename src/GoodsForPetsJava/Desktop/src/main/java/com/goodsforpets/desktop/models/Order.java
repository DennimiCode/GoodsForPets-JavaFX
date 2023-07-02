package com.goodsforpets.desktop.models;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Orders", schema = "dbo")
public class Order {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "Id", nullable = false)
  private int id;
  @Basic
  @Column(name = "Status", nullable = false, length = 2147483647)
  private String status;
  @Basic
  @Column(name = "OrderDate", nullable = false)
  private Date orderDate;
  @Basic
  @Column(name = "DeliveryDate", nullable = false)
  private Date deliveryDate;
  @Basic
  @Column(name = "LocationId", nullable = false)
  private int locationId;
  @Basic
  @Column(name = "UserId", nullable = false)
  private int userId;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Date getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }

  public Date getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(Date deliveryDate) {
    this.deliveryDate = deliveryDate;
  }

  public int getLocationId() {
    return locationId;
  }

  public void setLocationId(int locationId) {
    this.locationId = locationId;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Order order = (Order) o;
    return id == order.id && locationId == order.locationId && userId == order.userId && Objects.equals(
        status, order.status) && Objects.equals(orderDate, order.orderDate) && Objects.equals(
        deliveryDate, order.deliveryDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, orderDate, deliveryDate, locationId, userId);
  }
}
