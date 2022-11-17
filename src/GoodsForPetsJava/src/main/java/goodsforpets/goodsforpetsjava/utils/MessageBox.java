package goodsforpets.goodsforpetsjava.utils;

import javafx.scene.control.Alert;

public class MessageBox {
    public enum MessageType {
        Error,
        Info,
        Warning,
        Confirmation
    }
    
    public static Alert create(String messageTitle, String messageHeader, String messageText, MessageType messageType) {
        Alert alert = switch (messageType) {
            case Error -> new Alert(Alert.AlertType.ERROR);
            case Info -> new Alert(Alert.AlertType.INFORMATION);
            case Warning -> new Alert(Alert.AlertType.WARNING);
            case Confirmation -> new Alert(Alert.AlertType.CONFIRMATION);
            default -> new Alert(Alert.AlertType.NONE);
        };
        
        alert.setTitle(messageTitle);
        alert.setHeaderText(messageHeader);
        alert.setContentText(messageText);
        
        return alert;
    }
}
