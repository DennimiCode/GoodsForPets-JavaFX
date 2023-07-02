package com.goodsforpets.desktop.models;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Products", schema = "dbo")
public class Product {

  @Id
  @Column(name = "Id", nullable = false, length = 100)
  private String id;
  @Basic
  @Column(name = "Name", nullable = false, length = 2147483647)
  private String name;
  @Basic
  @Column(name = "Cost", nullable = false, precision = 0)
  private double cost;
  @Basic
  @Column(name = "MaxDiscountAmount", nullable = false)
  private int maxDiscountAmount;
  @Basic
  @Column(name = "CurrentDiscountAmount", nullable = false)
  private int currentDiscountAmount;
  @Basic
  @Column(name = "QuantityInStock", nullable = false)
  private int quantityInStock;
  @Basic
  @Column(name = "Description", nullable = false, length = 2147483647)
  private String description;
  @Basic
  @Column(name = "Photo", nullable = true, length = 2147483647)
  private String photo;
  @Basic
  @Column(name = "ProductInfoId", nullable = false)
  private int productInfoId;
  @OneToMany(targetEntity = ProductInfo.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "Id", referencedColumnName = "ProductInfoId")
  private List productsInfo;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getCost() {
    return cost;
  }

  public void setCost(double cost) {
    this.cost = cost;
  }

  public int getMaxDiscountAmount() {
    return maxDiscountAmount;
  }

  public void setMaxDiscountAmount(int maxDiscountAmount) {
    this.maxDiscountAmount = maxDiscountAmount;
  }

  public int getCurrentDiscountAmount() {
    return currentDiscountAmount;
  }

  public void setCurrentDiscountAmount(int currentDiscountAmount) {
    this.currentDiscountAmount = currentDiscountAmount;
  }

  public int getQuantityInStock() {
    return quantityInStock;
  }

  public void setQuantityInStock(int quantityInStock) {
    this.quantityInStock = quantityInStock;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public int getProductInfoId() {
    return productInfoId;
  }

  public void setProductInfoId(int productInfoId) {
    this.productInfoId = productInfoId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return Double.compare(product.cost, cost) == 0 && maxDiscountAmount == product.maxDiscountAmount
        && currentDiscountAmount == product.currentDiscountAmount
        && quantityInStock == product.quantityInStock
        && productInfoId == product.productInfoId && Objects.equals(id, product.id)
        && Objects.equals(name, product.name) && Objects.equals(description,
        product.description) && Objects.equals(photo, product.photo);
  }

  @Override
  public String toString() {
    return String.format("%s %s %s %s %s %s %s %s", getId(), getName(), getCost(), getMaxDiscountAmount(),
        getCurrentDiscountAmount(), getQuantityInStock(), getDescription(), getPhoto());
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, cost, maxDiscountAmount, currentDiscountAmount, quantityInStock, description,
        photo,
        productInfoId);
  }
}
