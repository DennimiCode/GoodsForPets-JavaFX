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
@Table(name = "Users", schema = "dbo")
public class User {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "Id", nullable = false)
  private int id;
  @Basic
  @Column(name = "Name", nullable = false, length = 100)
  private String name;
  @Basic
  @Column(name = "Surname", nullable = false, length = 100)
  private String surname;
  @Basic
  @Column(name = "Patronymic", nullable = false, length = 100)
  private String patronymic;
  @Basic
  @Column(name = "Login", nullable = false, length = 2147483647)
  private String login;
  @Basic
  @Column(name = "Password", nullable = false, length = 2147483647)
  private String password;
  @Basic
  @Column(name = "RoleId", nullable = false)
  private int roleId;

  @OneToMany(targetEntity = Role.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "Id", referencedColumnName = "RoleId")
  private List roles;

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

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getPatronymic() {
    return patronymic;
  }

  public void setPatronymic(String patronymic) {
    this.patronymic = patronymic;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getRoleId() {
    return roleId;
  }

  public void setRoleId(int roleId) {
    this.roleId = roleId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return id == user.id && roleId == user.roleId && Objects.equals(name, user.name)
        && Objects.equals(surname, user.surname) && Objects.equals(patronymic,
        user.patronymic) && Objects.equals(login, user.login) && Objects.equals(password,
        user.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, surname, patronymic, login, password, roleId);
  }
}
