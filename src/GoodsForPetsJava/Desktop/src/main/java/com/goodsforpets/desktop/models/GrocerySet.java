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
@Table(name = "GrocerySets", schema = "dbo")
public class GrocerySet {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "Id", nullable = false)
  private int id;
  @Basic
  @Column(name = "ProductId", nullable = false, length = 100)
  private String productId;
  @Basic
  @Column(name = "SubProductId", nullable = false, length = 100)
  private String subProductId;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public String getSubProductId() {
    return subProductId;
  }

  public void setSubProductId(String subProductId) {
    this.subProductId = subProductId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GrocerySet grocerySet = (GrocerySet) o;
    return id == grocerySet.id && Objects.equals(productId, grocerySet.productId) && Objects.equals(
        subProductId, grocerySet.subProductId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, productId, subProductId);
  }
}
