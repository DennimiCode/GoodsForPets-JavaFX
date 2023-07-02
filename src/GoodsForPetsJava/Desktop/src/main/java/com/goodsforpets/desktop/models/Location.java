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
@Table(name = "Locations", schema = "dbo")
public class Location {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "Id", nullable = false)
  private int id;
  @Basic
  @Column(name = "PostCode", nullable = false)
  private int postCode;
  @Basic
  @Column(name = "HouseNumber", nullable = false)
  private int houseNumber;
  @Basic
  @Column(name = "AddressId", nullable = false)
  private int addressId;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getPostCode() {
    return postCode;
  }

  public void setPostCode(int postCode) {
    this.postCode = postCode;
  }

  public int getHouseNumber() {
    return houseNumber;
  }

  public void setHouseNumber(int houseNumber) {
    this.houseNumber = houseNumber;
  }

  public int getAddressId() {
    return addressId;
  }

  public void setAddressId(int addressId) {
    this.addressId = addressId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Location location = (Location) o;
    return id == location.id && postCode == location.postCode && houseNumber == location.houseNumber
        && addressId == location.addressId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, postCode, houseNumber, addressId);
  }
}
