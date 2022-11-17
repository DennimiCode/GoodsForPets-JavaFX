package goodsforpets.goodsforpetsjava.controllers;

import goodsforpets.goodsforpetsjava.GoodsForPetsApplication;
import goodsforpets.goodsforpetsjava.models.User;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AdminSceneController {
    @FXML
    private TextField searchTextField;
    @FXML
    private ComboBox<User> manufacturerComboBox;
    AdminSceneController() {
    }

    public void onExitButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GoodsForPetsApplication.class.getResource("scenes/loginScene.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("ООО \"Товары для животных\" | Авторизация");
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    public void onAddNewProductButtonClick(ActionEvent event) {

    }

    public void onUpdateProductsListButtonClick(ActionEvent event) {

    }

    public void onSearchTextFieldTextChange(ObservableValue observableValue, String oldValue, String newValue) {
        System.out.println(searchTextField.getText());
    }

    public void onManufacturerComboBoxSelectionChanged(ActionEvent event) {
        System.out.println(manufacturerComboBox.getValue() + "asa");
    }
}
