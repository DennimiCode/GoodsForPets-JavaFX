module goodsforpets.goodsforpetsjava {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires org.hibernate.orm.core;


    opens goodsforpets.goodsforpetsjava to javafx.fxml;
    exports goodsforpets.goodsforpetsjava;
    exports goodsforpets.goodsforpetsjava.utils;
    opens goodsforpets.goodsforpetsjava.utils to javafx.fxml;
    exports goodsforpets.goodsforpetsjava.controllers;
    opens goodsforpets.goodsforpetsjava.controllers to javafx.fxml;
}