package com.goodsforpets.desktop;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("scenes/LoginScene.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    stage.setMinWidth(715);
    stage.setMinHeight(595);
    stage.setTitle("ООО \"Товары для животных\" | Авторизация");
    stage.getIcons().add(new Image(App.class.getResource("img/icon.png").toString()));
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
