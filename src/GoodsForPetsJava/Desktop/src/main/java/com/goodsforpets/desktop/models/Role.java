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
@Table(name = "Roles", schema = "dbo")
public class Role {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "Id", nullable = false)
  private int id;
  @Basic
  @Column(name = "Name", nullable = false, length = 100)
  private String name;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Role role = (Role) o;
    return id == role.id && Objects.equals(name, role.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }
}
