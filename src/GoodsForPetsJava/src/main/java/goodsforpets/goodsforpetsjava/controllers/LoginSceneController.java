package goodsforpets.goodsforpetsjava.controllers;

import goodsforpets.goodsforpetsjava.GoodsForPetsApplication;
import goodsforpets.goodsforpetsjava.utils.MessageBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginSceneController {
    @FXML
    private TextField userLoginTextField;
    @FXML
    private PasswordField userPasswordField;

    @FXML
    protected void onLoginButtonClick(ActionEvent event) throws IOException {
        int userRoleId = 1;

        Alert successAlert = MessageBox.create(
                "Информация",
                "Успешная авторизация",
                "Вы успешно авторизовались!",
                MessageBox.MessageType.Info
        );

        Alert errorAlert = MessageBox.create(
                "Ошибка",
                "Пользователь не найден",
                "Возможно вы ввели не верный логин или пароль!",
                MessageBox.MessageType.Error
        );

        if (Objects.equals(userLoginTextField.getText(), "") && Objects.equals(userPasswordField.getText(), "")) {
            Parent root = switch (userRoleId) {
                case 1 -> FXMLLoader.load(Objects.requireNonNull(GoodsForPetsApplication.class.getResource("scenes/adminScene.fxml")));
                case 2 -> FXMLLoader.load(Objects.requireNonNull(GoodsForPetsApplication.class.getResource("scenes/guestScene.fxml")));
                default -> null;
            };
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("ООО \"Товары для животных\" | Панель администратора");
            stage.setScene(scene);
        }
        else {
            errorAlert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) userPasswordField.setText("");
            });
        }
    }

    @FXML
    protected void onGuestButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GoodsForPetsApplication.class.getResource("scenes/guestScene.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("ООО \"Товары для животных\" | Гостевой режим");
        stage.setScene(scene);
        stage.show();
    }
}