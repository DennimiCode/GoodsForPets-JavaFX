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
@Table(name = "Mixtures", schema = "dbo")
public class Mixture {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "Id", nullable = false)
  private int id;
  @Basic
  @Column(name = "BaseMaterialId", nullable = false)
  private int baseMaterialId;
  @Basic
  @Column(name = "RawMaterialId", nullable = false)
  private int rawMaterialId;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getBaseMaterialId() {
    return baseMaterialId;
  }

  public void setBaseMaterialId(int baseMaterialId) {
    this.baseMaterialId = baseMaterialId;
  }

  public int getRawMaterialId() {
    return rawMaterialId;
  }

  public void setRawMaterialId(int rawMaterialId) {
    this.rawMaterialId = rawMaterialId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Mixture mixture = (Mixture) o;
    return id == mixture.id && baseMaterialId == mixture.baseMaterialId
        && rawMaterialId == mixture.rawMaterialId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, baseMaterialId, rawMaterialId);
  }
}
