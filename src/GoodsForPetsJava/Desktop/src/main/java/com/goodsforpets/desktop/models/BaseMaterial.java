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
@Table(name = "BaseMaterials", schema = "dbo")
public class BaseMaterial {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "Id", nullable = false)
  private int id;
  @Basic
  @Column(name = "Name", nullable = false, length = 200)
  private String name;
  @Basic
  @Column(name = "Unit", nullable = false, length = 20)
  private String unit;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BaseMaterial baseMaterial = (BaseMaterial) o;
    return id == baseMaterial.id && Objects.equals(name, baseMaterial.name) && Objects.equals(unit,
        baseMaterial.unit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, unit);
  }
}
