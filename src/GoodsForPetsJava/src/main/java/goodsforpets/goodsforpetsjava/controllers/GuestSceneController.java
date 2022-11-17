package goodsforpets.goodsforpetsjava.controllers;

import goodsforpets.goodsforpetsjava.GoodsForPetsApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class GuestSceneController {
    @FXML
    private ToggleGroup pricingToggleGroup;
    @FXML
    protected void onExitButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GoodsForPetsApplication.class.getResource("scenes/loginScene.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("ООО \"Товары для животных\" | Авторизация");
        stage.setScene(scene);
        stage.show();
    }
}
