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
@Table(name = "ProductsInfo", schema = "dbo")
public class ProductInfo {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "Id", nullable = false)
  private int id;
  @Basic
  @Column(name = "CategoryId", nullable = false)
  private int categoryId;
  @Basic
  @Column(name = "ManufacturerId", nullable = false)
  private int manufacturerId;
  @Basic
  @Column(name = "SupplierId", nullable = false)
  private int supplierId;
  @OneToMany(targetEntity = Category.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "Id", referencedColumnName = "CategoryId")
  private List categories;
  @OneToMany(targetEntity = Manufacturer.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "Id", referencedColumnName = "ManufacturerId")
  private List manufacturers;
  @OneToMany(targetEntity = Supplier.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "Id", referencedColumnName = "SupplierId")
  private List suppliers;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }

  public int getManufacturerId() {
    return manufacturerId;
  }

  public void setManufacturerId(int manufacturerId) {
    this.manufacturerId = manufacturerId;
  }

  public int getSupplierId() {
    return supplierId;
  }

  public void setSupplierId(int supplierId) {
    this.supplierId = supplierId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductInfo productInfo = (ProductInfo) o;
    return id == productInfo.id && categoryId == productInfo.categoryId
        && manufacturerId == productInfo.manufacturerId
        && supplierId == productInfo.supplierId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, categoryId, manufacturerId, supplierId);
  }
}
