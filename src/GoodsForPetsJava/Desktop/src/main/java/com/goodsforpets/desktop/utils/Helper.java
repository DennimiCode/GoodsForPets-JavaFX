package com.goodsforpets.desktop.utils;

import com.goodsforpets.desktop.App;
import com.goodsforpets.desktop.utils.MessageBox.MessageType;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public final class Helper {

  private static final int SEARCH_ACCURACY = 3;

  private static int userRoleId;

  public static void exitButtonClick(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(App.class.getResource("scenes/LoginScene.fxml"));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Scene scene = new Scene(root);
    stage.setTitle("ООО \"Товары для животных\" | Авторизация");
    stage.setMinWidth(715);
    stage.setMinHeight(595);
    stage.setScene(scene);
    stage.show();
  }

  public static void logout(Stage stage) {
    Alert infoAlert = MessageBox.create(
        "Информация",
        "Вы действительно хотите закрыть окно?",
        "Если вы закроете окно, то все введенные вами данные будут потеряны!",
        MessageType.CONFIRMATION
    );
    infoAlert.showAndWait().ifPresent(bt -> {
      if (bt == ButtonType.OK) {
        stage.close();
      }
    });
  }

  public static void logoutWithoutPrompt(Stage stage) {
    stage.close();
  }

  public static ArrayList<String> doSearch(String searchQuery, ArrayList<String> searchRange) {
    var result = new ArrayList<String>();
    if (searchQuery == null) {
      throw new IllegalArgumentException("searchQuery is null");
    }
    if (searchRange == null) {
      throw new IllegalArgumentException("searchRange is null");
    }
    for (String searchLine : searchRange) {
      if (Helper.searchAlgorithm(searchQuery, searchLine) >= SEARCH_ACCURACY) {
        result.add(searchLine);
      }
    }
    return result;
  }

  private static int searchAlgorithm(String firstString, String secondString) {
    if (firstString == null) {
      throw new IllegalArgumentException("firstString is null");
    }
    if (secondString == null) {
      throw new IllegalArgumentException("secondString is null");
    }

    int difference;

    int[][] map = new int[firstString.length() + 1][secondString.length() + 1];

    for (int i = 0; i < firstString.length(); i++) {
      map[i][0] = i;
    }
    for (int j = 0; j < secondString.length(); j++) {
      map[0][j] = j;
    }

    for (int i = 1; i <= firstString.length(); i++) {
      for (int j = 1; j <= secondString.length(); j++) {
        difference = (firstString.toCharArray()[i - 1] == secondString.toCharArray()[j - 1]) ? 0 : 1;
        map[i][j] = Math.min(Math.min(map[i - 1][j] + 1, map[i][j - 1] + 1), map[i - 1][j - 1] + difference);
      }
    }

    return map[firstString.length()][secondString.length()];
  }

  public static int getUserRoleId() {
    return userRoleId;
  }

  public static void setUserRoleId(int userRoleId) {
    Helper.userRoleId = userRoleId;
  }
}
