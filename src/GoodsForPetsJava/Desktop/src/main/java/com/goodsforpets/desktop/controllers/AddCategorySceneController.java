package com.goodsforpets.desktop.controllers;

import com.goodsforpets.desktop.models.Category;
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

public class AddCategorySceneController {

  @FXML
  private TextField unitNameTextField;
  @FXML
  private TextField CategoryNameTextField;

  @FXML
  public void onAddCategoryButtonClick(ActionEvent event) {
    if (!CategoryNameTextField.getText().isBlank() && !unitNameTextField.getText().isBlank()) {
      var successAddingCategoryAlert = MessageBox.create(
          "Информация",
          "Новая категория добавлена!",
          "Категория успешно добавлена в базу данных.",
          MessageType.ERROR
      );
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction transaction = session.beginTransaction();
      Category category = new Category();
      category.setName(CategoryNameTextField.getText());
      category.setUnit(unitNameTextField.getText());
      session.persist(category);
      transaction.commit();
      session.close();
      successAddingCategoryAlert.show();
      Helper.logoutWithoutPrompt(((Stage) ((Node) (event.getSource())).getScene().getWindow()));
    } else {
      var errorAddingSupplierAlert = MessageBox.create(
          "Ошибка",
          "Не удалось добавить категорию!",
          "Необходимо указать наименование категории и единицу измерения.",
          MessageType.ERROR
      );
      errorAddingSupplierAlert.show();
    }
  }
}
