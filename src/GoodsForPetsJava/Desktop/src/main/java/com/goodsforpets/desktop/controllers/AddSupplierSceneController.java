package com.goodsforpets.desktop.controllers;

import com.goodsforpets.desktop.models.Supplier;
import com.goodsforpets.desktop.utils.Helper;
import com.goodsforpets.desktop.utils.HibernateUtil;
import com.goodsforpets.desktop.utils.MessageBox;
import com.goodsforpets.desktop.utils.MessageBox.MessageType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AddSupplierSceneController {

  @FXML
  private TextField supplierNameTextField;

  @FXML
  public void onAddSupplierButtonClick(ActionEvent event) {
    if (!supplierNameTextField.getText().isBlank()) {
      var successAddingSupplierAlert = MessageBox.create(
          "Информация",
          "Новый поставщик добавлен!",
          "Поставщик успешно добавлен в базу данных.",
          MessageType.ERROR
      );
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction transaction = session.beginTransaction();
      Supplier supplier = new Supplier();
      supplier.setName(supplierNameTextField.getText());
      session.persist(supplier);
      transaction.commit();
      session.close();
      successAddingSupplierAlert.show();
      successAddingSupplierAlert.show();
      Helper.logoutWithoutPrompt(((Stage) ((Node) (event.getSource())).getScene().getWindow()));
    } else {
      var errorAddingSupplierAlert = MessageBox.create(
          "Ошибка",
          "Не удалось добавить поставщика!",
          "Необходимо указать наименование поставщика.",
          MessageType.ERROR
      );
      errorAddingSupplierAlert.show();
    }
  }
}
