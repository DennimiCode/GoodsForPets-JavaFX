package com.goodsforpets.desktop.models;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Sysdiagrams {

  @Basic
  @Column(name = "name", nullable = false)
  private Object name;
  @Basic
  @Column(name = "principal_id", nullable = false)
  private int principalId;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "diagram_id", nullable = false)
  private int diagramId;
  @Basic
  @Column(name = "version", nullable = true)
  private Integer version;
  @Basic
  @Column(name = "definition", nullable = true)
  private byte[] definition;

  public Object getName() {
    return name;
  }

  public void setName(Object name) {
    this.name = name;
  }

  public int getPrincipalId() {
    return principalId;
  }

  public void setPrincipalId(int principalId) {
    this.principalId = principalId;
  }

  public int getDiagramId() {
    return diagramId;
  }

  public void setDiagramId(int diagramId) {
    this.diagramId = diagramId;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public byte[] getDefinition() {
    return definition;
  }

  public void setDefinition(byte[] definition) {
    this.definition = definition;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Sysdiagrams that = (Sysdiagrams) o;
    return principalId == that.principalId && diagramId == that.diagramId && Objects.equals(name, that.name)
        && Objects.equals(version, that.version) && Arrays.equals(definition, that.definition);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(name, principalId, diagramId, version);
    result = 31 * result + Arrays.hashCode(definition);
    return result;
  }
}
