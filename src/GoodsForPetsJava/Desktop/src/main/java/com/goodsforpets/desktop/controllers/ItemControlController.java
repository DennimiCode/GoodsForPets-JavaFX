package com.goodsforpets.desktop.controllers;

import com.goodsforpets.desktop.App;
import com.goodsforpets.desktop.utils.Helper;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ItemControlController implements Initializable {

  @FXML
  private ImageView itemImageView;
  @FXML
  private Label itemNameLabel;
  @FXML
  private Label itemManufacturerLabel;
  @FXML
  private Label itemQuantityInStockLabel;
  @FXML
  private Label itemCostLabel;
  @FXML
  private Text itemDescriptionText;
  @FXML
  private HBox rootHBox;

  private String productId;
  private String photoPath;
  private String productName;
  private String productDescription;
  private String productManufacturer;
  private String productCategory;
  private String productSupplier;
  private double productCost;
  private int productQuantityInStock;
  private int productCurrentDiscountAmount;
  private int productMaxDiscountAmount;
  private int productManufacturerId;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    if (productQuantityInStock == 0) {
      rootHBox.setStyle("-fx-background-color: gray");
    }
    if (Helper.getUserRoleId() == 1) {
      rootHBox.setOnMouseClicked(this::onRootHBoxMouseClicked);
    }
    itemDescriptionText.setText(productDescription);
    itemCostLabel.setText(
        Double.toString(
            productCost != 0 ? productCost - (productCost * productCurrentDiscountAmount / 100) : productCost));
    itemQuantityInStockLabel.setText(Integer.toString(productQuantityInStock));
    itemManufacturerLabel.setText(productManufacturer);
    itemNameLabel.setText(productName);
    itemImageView.setImage(new Image(App.class.getResource("img/itemsImg/") + photoPath));
  }

  private void onRootHBoxMouseClicked(MouseEvent mouseEvent) {
    if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
      if (mouseEvent.getClickCount() == 2) {
        try {
          FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("scenes/ProductScene.fxml"));
          var productSceneController = new ProductSceneController();

          productSceneController.setIsEdit(true);
          productSceneController.setProductId(productId);
          productSceneController.setProductCost(productCost);
          productSceneController.setProductName(productName);
          productSceneController.setPhotoPath(photoPath);
          productSceneController.setProductDescription(productDescription);
          productSceneController.setProductManufacturer(productManufacturer);
          productSceneController.setProductCategory(productCategory);
          productSceneController.setProductSupplier(productSupplier);
          productSceneController.setProductQuantityInStock(productQuantityInStock);
          productSceneController.setProductCurrentDiscountAmount(productCurrentDiscountAmount);
          productSceneController.setProductMaxDiscountAmount(productMaxDiscountAmount);

          fxmlLoader.setController(productSceneController);
          Stage stage = new Stage();
          stage.getIcons().add(new Image(App.class.getResource("img/icon.png").toString()));
          stage.setMinWidth(715);
          stage.setMinHeight(595);
          stage.initModality(Modality.WINDOW_MODAL);
          stage.initOwner(((Node) (mouseEvent.getSource())).getScene().getWindow());
          Scene scene = new Scene(fxmlLoader.load());
          stage.setScene(scene);
          stage.setOnCloseRequest(windowEvent -> {
            windowEvent.consume();
            Helper.logout(stage);
          });
          stage.setTitle("ООО \"Товары для животных\" | Редактирование товара");
          stage.show();
        } catch (IOException e) {
          System.err.println(e);
          e.printStackTrace();
        }
      }
    }
  }

  public String getPhotoPath() {
    return photoPath;
  }

  public void setPhotoPath(String photoPath) {
    this.photoPath = photoPath;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getProductDescription() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }

  public String getProductManufacturer() {
    return productManufacturer;
  }

  public void setProductManufacturer(String productManufacturer) {
    this.productManufacturer = productManufacturer;
  }

  public double getProductCost() {
    return productCost;
  }

  public void setProductCost(double productCost) {
    this.productCost = productCost;
  }

  public int getProductQuantityInStock() {
    return productQuantityInStock;
  }

  public void setProductQuantityInStock(int productQuantityInStock) {
    this.productQuantityInStock = productQuantityInStock;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public int getProductCurrentDiscountAmount() {
    return productCurrentDiscountAmount;
  }

  public void setProductCurrentDiscountAmount(int productCurrentDiscountAmount) {
    this.productCurrentDiscountAmount = productCurrentDiscountAmount;
  }

  public int getProductMaxDiscountAmount() {
    return productMaxDiscountAmount;
  }

  public void setProductMaxDiscountAmount(int productMaxDiscountAmount) {
    this.productMaxDiscountAmount = productMaxDiscountAmount;
  }

  public String getProductCategory() {
    return productCategory;
  }

  public void setProductCategory(String productCategory) {
    this.productCategory = productCategory;
  }

  public String getProductSupplier() {
    return productSupplier;
  }

  public void setProductSupplier(String productSupplier) {
    this.productSupplier = productSupplier;
  }

  public int getProductManufacturerId() {
    return productManufacturerId;
  }

  public void setProductManufacturerId(int productManufacturerId) {
    this.productManufacturerId = productManufacturerId;
  }
}
