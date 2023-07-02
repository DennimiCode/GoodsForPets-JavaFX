package com.goodsforpets.desktop.controllers;

import com.goodsforpets.desktop.models.Manufacturer;
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

public class AddManufacturerSceneController {

  @FXML
  private TextField manufacturerNameTextField;

  @FXML
  public void onAddManufacturerButtonClick(ActionEvent event) {
    if (!manufacturerNameTextField.getText().isBlank()) {
      var successAddingManufacturerAlert = MessageBox.create(
          "Информация",
          "Новый производитель добавлен!",
          "Производитель успешно добавлен в базу данных.",
          MessageType.INFO
      );
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction transaction = session.beginTransaction();
      Manufacturer manufacturer = new Manufacturer();
      manufacturer.setName(manufacturerNameTextField.getText());
      session.persist(manufacturer);
      transaction.commit();
      session.close();
      successAddingManufacturerAlert.show();
      Helper.logoutWithoutPrompt(((Stage) ((Node) (event.getSource())).getScene().getWindow()));
    } else {
      var errorAddingManufacturerAlert = MessageBox.create(
          "Ошибка",
          "Не удалось добавить производителя!",
          "Необходимо указать наименование производителя.",
          MessageType.ERROR
      );
      errorAddingManufacturerAlert.show();
    }
  }
}
