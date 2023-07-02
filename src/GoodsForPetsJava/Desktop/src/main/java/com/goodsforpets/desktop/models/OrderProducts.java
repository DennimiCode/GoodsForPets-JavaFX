package com.goodsforpets.desktop.models;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class OrderProducts {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "Id", nullable = false)
  private int id;
  @Basic
  @Column(name = "ProductAmount", nullable = false)
  private int productAmount;
  @Basic
  @Column(name = "OrderId", nullable = false)
  private int orderId;
  @Basic
  @Column(name = "ProductId", nullable = false, length = 100)
  private String productId;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getProductAmount() {
    return productAmount;
  }

  public void setProductAmount(int productAmount) {
    this.productAmount = productAmount;
  }

  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderProducts that = (OrderProducts) o;
    return id == that.id && productAmount == that.productAmount && orderId == that.orderId && Objects.equals(
        productId, that.productId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, productAmount, orderId, productId);
  }
}
