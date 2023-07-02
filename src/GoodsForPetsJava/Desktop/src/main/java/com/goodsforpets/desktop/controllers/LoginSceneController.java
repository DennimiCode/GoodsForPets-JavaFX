package com.goodsforpets.desktop.controllers;

import com.goodsforpets.desktop.App;
import com.goodsforpets.desktop.models.User;
import com.goodsforpets.desktop.utils.Helper;
import com.goodsforpets.desktop.utils.HibernateUtil;
import com.goodsforpets.desktop.utils.MessageBox;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Session;

public class LoginSceneController implements Initializable {

  @FXML
  private TextField userLoginTextField;
  @FXML
  private PasswordField userPasswordField;
  private List<User> users;

  private final String ALL_USERS_QUERY_STR = "SELECT a FROM User a";

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    users = session.createQuery(ALL_USERS_QUERY_STR, User.class).getResultList();
    session.close();
  }

  @FXML
  public void onLoginButtonClick(ActionEvent event) throws IOException {
    int userRoleId;
    FXMLLoader fxmlLoader = null;

    Alert successAlert = MessageBox.create(
        "Информация",
        "Успешная авторизация",
        "Вы успешно авторизовались!",
        MessageBox.MessageType.INFO
    );

    Alert errorAlert = MessageBox.create(
        "Ошибка",
        "Пользователь не найден",
        "Возможно вы ввели не верный логин или пароль!",
        MessageBox.MessageType.ERROR
    );

    if (users.stream().anyMatch(u -> Objects.equals(userLoginTextField.getText(), u.getLogin()) && Objects.equals(
        userPasswordField.getText(), u.getPassword()))) {
      userRoleId = users.stream()
          .filter(u -> Objects.equals(userLoginTextField.getText(), u.getLogin()) && Objects.equals(
              userPasswordField.getText(), u.getPassword())).map(User::getRoleId).findFirst().get();
      Helper.setUserRoleId(userRoleId);
      switch (userRoleId) {
        case 1:
          fxmlLoader = new FXMLLoader(
              Objects.requireNonNull(App.class.getResource("scenes/AdministratorScene.fxml")));
          break;
        case 2:
          fxmlLoader = new FXMLLoader(App.class.getResource("scenes/UserScene.fxml"));
          break;
        case 3:
          fxmlLoader = new FXMLLoader(App.class.getResource("scenes/ManagerScene.fxml"));
          break;
      }
      Parent root = Objects.requireNonNull(fxmlLoader).load();
      if (root == null) {
        MessageBox.create(
            "Ошибка",
            "Внутренняя ошибка",
            "Не удалось перейти на нужную страницу!\nПопробуйте перезапустить приложение.",
            MessageBox.MessageType.ERROR
        ).show();
        return;
      }
      String userFullName = String.format("%s %s %s", users.stream()
              .filter(u -> Objects.equals(userLoginTextField.getText(), u.getLogin()) && Objects.equals(
                  userPasswordField.getText(), u.getPassword())).map(User::getSurname).findFirst().get(),
          users.stream()
              .filter(u -> Objects.equals(userLoginTextField.getText(), u.getLogin()) && Objects.equals(
                  userPasswordField.getText(), u.getPassword())).map(User::getName).findFirst().get(),
          users.stream()
              .filter(u -> Objects.equals(userLoginTextField.getText(), u.getLogin()) && Objects.equals(
                  userPasswordField.getText(), u.getPassword())).map(User::getPatronymic).findFirst()
              .get());
      switch (userRoleId) {
        case 1:
          ((AdministratorSceneController) fxmlLoader.getController()).updateUserFullName(userFullName);
          break;
        case 2:
          ((UserSceneController) fxmlLoader.getController()).updateUserFullName(userFullName);
          break;
        case 3:
          ((ManagerSceneController) fxmlLoader.getController()).updateUserFullName(userFullName);
          break;
      }
      Scene scene = new Scene(root);
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      stage.setTitle(switch (userRoleId) {
        case 1 -> "ООО \"Товары для животных\" | Панель администратора";
        case 2 -> "ООО \"Товары для животных\" | Авторизованный клиент";
        case 3 -> "ООО \"Товары для животных\" | Панель менеджера";
        default -> "ООО \"Товары для животных\"";
      });
      stage.setMinWidth(715);
      stage.setMinHeight(595);
      stage.setScene(scene);
    } else {
      errorAlert.showAndWait().ifPresent(rs -> {
        if (rs == ButtonType.OK) {
          userPasswordField.setText("");
        }
      });
    }
  }

  @FXML
  public void onGuestButtonClick(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(App.class.getResource("scenes/GuestScene.fxml"));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Scene scene = new Scene(root);
    stage.setTitle("ООО \"Товары для животных\" | Гостевой режим");
    stage.setMinWidth(715);
    stage.setMinHeight(595);
    stage.setScene(scene);
    stage.show();
  }
}
