package com.goodsforpets.desktop.models;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "SubProducts", schema = "dbo")
public class SubProduct {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
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
  @Column(name = "Photo", nullable = false, length = 2147483647)
  private String photo;
  @Basic
  @Column(name = "BaseMaterialId", nullable = false)
  private int baseMaterialId;
  @Basic
  @Column(name = "ProductInfoId", nullable = false)
  private int productInfoId;

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

  public int getBaseMaterialId() {
    return baseMaterialId;
  }

  public void setBaseMaterialId(int baseMaterialId) {
    this.baseMaterialId = baseMaterialId;
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
    SubProduct subProduct = (SubProduct) o;
    return Double.compare(subProduct.cost, cost) == 0 && maxDiscountAmount == subProduct.maxDiscountAmount
        && currentDiscountAmount == subProduct.currentDiscountAmount
        && quantityInStock == subProduct.quantityInStock
        && baseMaterialId == subProduct.baseMaterialId && productInfoId == subProduct.productInfoId
        && Objects.equals(
        id, subProduct.id) && Objects.equals(name, subProduct.name) && Objects.equals(description,
        subProduct.description) && Objects.equals(photo, subProduct.photo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, cost, maxDiscountAmount, currentDiscountAmount, quantityInStock, description,
        photo,
        baseMaterialId, productInfoId);
  }
}
