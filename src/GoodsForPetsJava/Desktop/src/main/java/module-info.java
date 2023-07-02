module com.goodsforpets.desktop {
  requires javafx.controls;
  requires javafx.fxml;
  requires org.hibernate.orm.core;
  requires jakarta.persistence;
  requires java.naming;
  requires java.desktop;
  requires org.apache.commons.io;

  opens com.goodsforpets.desktop to javafx.fxml;
  opens com.goodsforpets.desktop.controllers to javafx.fxml;
  opens com.goodsforpets.desktop.models to org.hibernate.orm.core;

  exports com.goodsforpets.desktop;
  exports com.goodsforpets.desktop.controllers;
  exports com.goodsforpets.desktop.models;
}