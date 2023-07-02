package com.goodsforpets.desktop.utils;

import javafx.scene.control.Alert;

public class MessageBox {

  public enum MessageType {
    ERROR,
    INFO,
    WARNING,
    CONFIRMATION,
  }

  public static Alert create(String messageTitle, String messageHeader, String messageText, MessageType messageType) {
    Alert alert = switch (messageType) {
      case ERROR -> new Alert(Alert.AlertType.ERROR);
      case INFO -> new Alert(Alert.AlertType.INFORMATION);
      case WARNING -> new Alert(Alert.AlertType.WARNING);
      case CONFIRMATION -> new Alert(Alert.AlertType.CONFIRMATION);
    };

    alert.setTitle(messageTitle);
    alert.setHeaderText(messageHeader);
    alert.setContentText(messageText);

    return alert;
  }
}
