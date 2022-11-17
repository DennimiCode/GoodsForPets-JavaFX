package goodsforpets.goodsforpetsjava;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class GoodsForPetsApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GoodsForPetsApplication.class.getResource("scenes/loginScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setMinWidth(700);
        stage.setMinHeight(550);
        stage.setTitle("ООО \"Товары для животных\" | Авторизация");
        stage.getIcons().add(new Image(Objects.requireNonNull(GoodsForPetsApplication.class.getResource("img/icon.png")).toString()));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}