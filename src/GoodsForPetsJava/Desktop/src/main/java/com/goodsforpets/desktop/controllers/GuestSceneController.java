package com.goodsforpets.desktop.controllers;

import com.goodsforpets.desktop.App;
import com.goodsforpets.desktop.models.Manufacturer;
import com.goodsforpets.desktop.utils.Helper;
import com.goodsforpets.desktop.utils.HibernateUtil;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import org.hibernate.Session;

public class GuestSceneController implements Initializable {

  @FXML
  private TextField searchTextField;
  @FXML
  private Label allElementsCountLabel;
  @FXML
  private Label currentElementsCountLabel;
  @FXML
  private Label userFullName;
  @FXML
  private VBox productsVBox;
  @FXML
  private ComboBox<Manufacturer> manufacturerComboBox;
  @FXML
  private RadioButton SortByAscendingCostRadioButton;
  @FXML
  private RadioButton SortByDescCostRadioButton;

  private final String SELECT_ALL_MANUFACTURERS_QUERY_STR = "SELECT a FROM Manufacturer a";
  private final String SELECT_ALL_PRODUCTS_INFO_QUERY_STR = "SELECT p.id, p.name, p.cost, p.quantityInStock, p.description, p.currentDiscountAmount, p.maxDiscountAmount, p.photo, m.name, c.name, s.name, pi.manufacturerId FROM Product p JOIN p.productsInfo pi JOIN pi.categories c JOIN pi.manufacturers m JOIN pi.suppliers s";
  private List<Manufacturer> manufacturers;
  private ArrayList<String> searchProducts = new ArrayList<>();

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    manufacturers = session.createQuery(SELECT_ALL_MANUFACTURERS_QUERY_STR, Manufacturer.class).getResultList();
    // TODO: add search by all products information
    var joinedList = session.createQuery(SELECT_ALL_PRODUCTS_INFO_QUERY_STR).getResultList();
    var it = joinedList.iterator();
    while (it.hasNext()) {
      Object row[] = (Object[]) it.next();
      System.out.printf("%s %s %s %s %s %s %s %s %s %s %s %s%n", row[0], row[1], row[2], row[3], row[4], row[5], row[6],
          row[7], row[8], row[9], row[10], row[11]);
      var fxmlLoader = new FXMLLoader(App.class.getResource("customControls/ItemControl.fxml"));
      var itemControlController = new ItemControlController();

      itemControlController.setProductId(row[0].toString());
      itemControlController.setProductName(row[1].toString());
      itemControlController.setProductCost(Double.parseDouble(row[2].toString()));
      itemControlController.setProductQuantityInStock(Integer.parseInt(row[3].toString()));
      itemControlController.setProductDescription(row[4].toString());
      itemControlController.setProductCurrentDiscountAmount(Integer.parseInt(row[5].toString()));
      itemControlController.setProductMaxDiscountAmount(Integer.parseInt(row[6].toString()));
      itemControlController.setPhotoPath(row[7] == null ? "emptyItem.png" : row[7].toString());
      itemControlController.setProductManufacturer(row[8].toString());
      itemControlController.setProductCategory(row[9].toString());
      itemControlController.setProductSupplier(row[10].toString());
      itemControlController.setProductManufacturerId(Integer.parseInt(row[11].toString()));

      fxmlLoader.setController(itemControlController);
      try {
        Node node = fxmlLoader.load();
        productsVBox.getChildren().add(node);
      } catch (IOException e) {
        System.err.println(e);
        e.printStackTrace();
      }
    }
    session.close();
    allElementsCountLabel.setText(Integer.toString(productsVBox.getChildren().size()));
    currentElementsCountLabel.setText(Integer.toString(productsVBox.getChildren().size()));
    for (var item : productsVBox.getChildren()) {
      ItemControlController itemControlController = (ItemControlController) item.getProperties().get("ctrl");
      String product = String.format("%s %s %s %s %s %s%n", itemControlController.getProductId(),
          itemControlController.getProductName(), itemControlController.getProductCost(),
          itemControlController.getProductManufacturer(), itemControlController.getProductDescription(),
          itemControlController.getProductQuantityInStock());
      searchProducts.add(product);
    }

    orderProductsVBoxByAscending();
    var allManufacturers = new Manufacturer();
    allManufacturers.setName("Все производители");
    allManufacturers.setId(0);
    manufacturerComboBox.getItems().add(allManufacturers);
    manufacturerComboBox.getItems().addAll(FXCollections.observableArrayList(manufacturers));
    manufacturerComboBox.setConverter(new StringConverter<>() {

      @Override
      public String toString(Manufacturer object) {
        return object.getName();
      }

      @Override
      public Manufacturer fromString(String string) {
        return null;
      }
    });
  }

  private void reloadProductsWithSort(int manufacturerId) {
    productsVBox.getChildren().clear();
    Session session = HibernateUtil.getSessionFactory().openSession();
    var joinedList = session.createQuery(SELECT_ALL_PRODUCTS_INFO_QUERY_STR).getResultList();
    var it = joinedList.iterator();
    while (it.hasNext()) {
      Object row[] = (Object[]) it.next();
      System.out.printf("%s %s %s %s %s %s %s %s %s %s %s %s%n", row[0], row[1], row[2], row[3], row[4], row[5], row[6],
          row[7], row[8], row[9], row[10], row[11]);
      var fxmlLoader = new FXMLLoader(App.class.getResource("customControls/ItemControl.fxml"));
      var itemControlController = new ItemControlController();

      itemControlController.setProductId(row[0].toString());
      itemControlController.setProductName(row[1].toString());
      itemControlController.setProductCost(Double.parseDouble(row[2].toString()));
      itemControlController.setProductQuantityInStock(Integer.parseInt(row[3].toString()));
      itemControlController.setProductDescription(row[4].toString());
      itemControlController.setProductCurrentDiscountAmount(Integer.parseInt(row[5].toString()));
      itemControlController.setProductMaxDiscountAmount(Integer.parseInt(row[6].toString()));
      itemControlController.setPhotoPath(row[7] == null ? "emptyItem.png" : row[7].toString());
      itemControlController.setProductManufacturer(row[8].toString());
      itemControlController.setProductCategory(row[9].toString());
      itemControlController.setProductSupplier(row[10].toString());
      itemControlController.setProductManufacturerId(Integer.parseInt(row[11].toString()));

      fxmlLoader.setController(itemControlController);
      try {
        if (itemControlController.getProductManufacturerId() == manufacturerId) {
          Node node = fxmlLoader.load();
          productsVBox.getChildren().add(node);
        } else if (manufacturerId == 0) {
          Node node = fxmlLoader.load();
          productsVBox.getChildren().add(node);
        }
      } catch (IOException e) {
        System.err.println(e);
        e.printStackTrace();
      }
    }
    session.close();

    for (var item : productsVBox.getChildren()) {
      ItemControlController itemControlController = (ItemControlController) item.getProperties().get("ctrl");
      String product = String.format("%s %s %s %s %s %s%n", itemControlController.getProductId(),
          itemControlController.getProductName(), itemControlController.getProductCost(),
          itemControlController.getProductManufacturer(), itemControlController.getProductDescription(),
          itemControlController.getProductQuantityInStock());
      searchProducts.add(product);
    }
    if (SortByAscendingCostRadioButton.isSelected()) {
      orderProductsVBoxByAscending();
    } else if (SortByDescCostRadioButton.isSelected()) {
      orderProductsVBoxByDesc();
    }
    currentElementsCountLabel.setText(Integer.toString(productsVBox.getChildren().size()));
  }

  private void orderProductsVBoxByAscending() {
    FXCollections.sort(productsVBox.getChildren(), (o1, o2) -> {
      double fNode = ((ItemControlController) o1.getProperties().get("ctrl")).getProductCost();
      double sNode = ((ItemControlController) o2.getProperties().get("ctrl")).getProductCost();

      if (fNode > sNode) {
        return 1;
      } else if (fNode < sNode) {
        return -1;
      }
      return 0;
    });
  }

  private void orderProductsVBoxByDesc() {
    FXCollections.sort(productsVBox.getChildren(), (o1, o2) -> {
      double fNode = ((ItemControlController) o1.getProperties().get("ctrl")).getProductCost();
      double sNode = ((ItemControlController) o2.getProperties().get("ctrl")).getProductCost();

      if (fNode > sNode) {
        return -1;
      } else if (fNode < sNode) {
        return 1;
      }
      return 0;
    });
  }

  @FXML
  public void onExitButtonClick(ActionEvent event) throws IOException {
    Helper.exitButtonClick(event);
  }

  @FXML
  public void onPricingRadioButtonClick(ActionEvent event) {
    var radioButton = ((RadioButton) event.getSource());
    if (radioButton.getId().equals("Ascending")) {
      orderProductsVBoxByAscending();
    } else if (radioButton.getId().equals("Desc")) {
      orderProductsVBoxByDesc();
    }
  }

  @FXML
  public void onSearchTextFieldTextChange(ObservableValue observableValue, String oldValue, String newValue) {
    var searchResult = Helper.doSearch(newValue != null ? newValue : "", searchProducts);
    for (String line : searchResult) {
      System.out.println(line);
    }
    currentElementsCountLabel.setText(Integer.toString(productsVBox.getChildren().size()));
  }

  @FXML
  public void onManufacturerComboBoxSelectionChanged(ActionEvent event) {
    reloadProductsWithSort(manufacturerComboBox.getSelectionModel().getSelectedItem().getId());
  }
}
