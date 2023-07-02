package com.goodsforpets.desktop.controllers;

import com.goodsforpets.desktop.App;
import com.goodsforpets.desktop.models.Category;
import com.goodsforpets.desktop.models.Manufacturer;
import com.goodsforpets.desktop.models.Product;
import com.goodsforpets.desktop.models.ProductInfo;
import com.goodsforpets.desktop.models.Supplier;
import com.goodsforpets.desktop.utils.Helper;
import com.goodsforpets.desktop.utils.HibernateUtil;
import com.goodsforpets.desktop.utils.MessageBox;
import com.goodsforpets.desktop.utils.MessageBox.MessageType;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javax.imageio.ImageIO;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductSceneController implements Initializable {

  @FXML
  private TextField articleNumberTextField;
  @FXML
  private TextField productNameTextField;
  @FXML
  private TextField productCostTextField;
  @FXML
  private TextField maxDiscountTextField;
  @FXML
  private TextField currentDiscountTextField;
  @FXML
  private TextField quantityInStockTextField;
  @FXML
  private TextArea descriptionTextArea;
  @FXML
  private ComboBox<Category> categoriesComboBox;
  @FXML
  private ComboBox<Manufacturer> manufacturersComboBox;
  @FXML
  private ComboBox<Supplier> suppliersComboBox;
  @FXML
  private Button addEditButton;
  @FXML
  private Button deleteProductButton;
  @FXML
  private ImageView productImageView;

  private final String SELECT_ALL_MANUFACTURERS_QUERY_STR = "SELECT m FROM Manufacturer m";
  private final String SELECT_ALL_CATEGORIES_QUERY_STR = "SELECT c FROM Category c";
  private final String SELECT_ALL_SUPPLIERS_QUERY_STR = "SELECT s FROM Supplier s";
  private final String DELETE_PRODUCT_BY_ID_QUERY_STR = "DELETE Product WHERE id = :id";
  private final String DELETE_PRODUCT_INFO_BY_ID_QUERY_STR = "DELETE ProductInfo WHERE id = :id";
  private boolean isEdit;
  private String selectedProductImage = null;
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

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    var manufacturers = session.createQuery(SELECT_ALL_MANUFACTURERS_QUERY_STR, Manufacturer.class).getResultList();
    var categories = session.createQuery(SELECT_ALL_CATEGORIES_QUERY_STR, Category.class).getResultList();
    var suppliers = session.createQuery(SELECT_ALL_SUPPLIERS_QUERY_STR, Supplier.class).getResultList();
    session.close();

    manufacturersComboBox.setItems(FXCollections.observableArrayList(manufacturers));
    categoriesComboBox.setItems(FXCollections.observableArrayList(categories));
    suppliersComboBox.setItems(FXCollections.observableArrayList(suppliers));

    manufacturersComboBox.setConverter(new StringConverter<Manufacturer>() {
      @Override
      public String toString(Manufacturer manufacturer) {
        return manufacturer.getName();
      }

      @Override
      public Manufacturer fromString(String s) {
        return null;
      }
    });
    categoriesComboBox.setConverter(new StringConverter<Category>() {
      @Override
      public String toString(Category category) {
        return category.getName();
      }

      @Override
      public Category fromString(String s) {
        return null;
      }
    });
    suppliersComboBox.setConverter(new StringConverter<Supplier>() {
      @Override
      public String toString(Supplier supplier) {
        return supplier.getName();
      }

      @Override
      public Supplier fromString(String s) {
        return null;
      }
    });

    if (isEdit) {
      addEditButton.setText("Изменить");
      articleNumberTextField.setText(productId);
      productNameTextField.setText(productName);
      productCostTextField.setText(String.valueOf(productCost));
      maxDiscountTextField.setText(String.valueOf(productMaxDiscountAmount));
      currentDiscountTextField.setText(String.valueOf(productCurrentDiscountAmount));
      quantityInStockTextField.setText(String.valueOf(productQuantityInStock));
      descriptionTextArea.setText(productDescription);
      productImageView.setImage(new Image(App.class.getResource("img/itemsImg/") + photoPath));
      articleNumberTextField.setDisable(true);

      manufacturersComboBox.setValue(
          manufacturers.stream().filter(m -> m.getName().equals(productManufacturer)).findAny().get());
      categoriesComboBox.setValue(
          categories.stream().filter(c -> c.getName().equals(productCategory)).findAny().get());
      suppliersComboBox.setValue(
          suppliers.stream().filter(s -> s.getName().equals(productSupplier)).findAny().get());
    } else {
      addEditButton.setText("Добавить");
      deleteProductButton.setDisable(true);
    }
  }

  @FXML
  public void onAddCategoryButtonClick(ActionEvent event) {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("scenes/AddCategoryScene.fxml"));
      Stage stage = new Stage();
      stage.getIcons().add(new Image(App.class.getResource("img/icon.png").toString()));
      stage.setMinWidth(225);
      stage.setMinHeight(150);
      stage.setMaxWidth(225);
      stage.setMaxHeight(150);
      stage.initModality(Modality.WINDOW_MODAL);
      stage.initOwner(((Node) (event.getSource())).getScene().getWindow());
      Scene scene = new Scene(fxmlLoader.load());
      stage.setScene(scene);
      stage.setTitle("ООО \"Товары для животных\" | Добавление категории");
      stage.show();
    } catch (IOException e) {
      System.err.println(e);
      e.printStackTrace();
    }
  }

  @FXML
  public void onAddManufacturerButtonClick(ActionEvent event) {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("scenes/AddManufacturerScene.fxml"));
      Stage stage = new Stage();
      stage.getIcons().add(new Image(App.class.getResource("img/icon.png").toString()));
      stage.setMinWidth(225);
      stage.setMinHeight(150);
      stage.setMaxWidth(225);
      stage.setMaxHeight(150);
      stage.initModality(Modality.WINDOW_MODAL);
      stage.initOwner(((Node) (event.getSource())).getScene().getWindow());
      Scene scene = new Scene(fxmlLoader.load());
      stage.setScene(scene);
      stage.setTitle("ООО \"Товары для животных\" | Добавление производителя");
      stage.show();
    } catch (IOException e) {
      System.err.println(e);
      e.printStackTrace();
    }
  }

  @FXML
  public void onAddSupplierButtonClick(ActionEvent event) {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("scenes/AddSupplierScene.fxml"));
      Stage stage = new Stage();
      stage.getIcons().add(new Image(App.class.getResource("img/icon.png").toString()));
      stage.setMinWidth(225);
      stage.setMinHeight(150);
      stage.setMaxWidth(225);
      stage.setMaxHeight(150);
      stage.initModality(Modality.WINDOW_MODAL);
      stage.initOwner(((Node) (event.getSource())).getScene().getWindow());
      Scene scene = new Scene(fxmlLoader.load());
      stage.setScene(scene);
      stage.setTitle("ООО \"Товары для животных\" | Добавление поставщика");
      stage.show();
    } catch (IOException e) {
      System.err.println(e);
      e.printStackTrace();
    }
  }

  @FXML
  public void onSelectImageButtonClick(ActionEvent event) throws IOException {
    var noArticleNumberErrorError = MessageBox.create(
        "Ошибка",
        "Вы не ввели артикул!",
        "Перед выбором фото продукта, необходимо ввести артикул.",
        MessageType.ERROR
    );
    if (!articleNumberTextField.getText().isBlank()) {
      var imageSelectionErrorAlert = MessageBox.create(
          "Ошибка",
          "Вы не выбрали фото!",
          "Для изменения фотографии продукта нужно выбарть 1 фото, размером 300X200.",
          MessageType.ERROR
      );
      var fileChooser = new FileChooser();
      fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
      fileChooser.setTitle("Выбрать фото");
      fileChooser.getExtensionFilters().addAll(
          new ExtensionFilter("All images types (*.png,*.jpg,*.jpeg,*.bmp,*.gif)", "*.png", "*.jpg", "*.jpeg", "*.bmp",
              "*.gif"),
          new ExtensionFilter("PNG (*.png)", "*.png"),
          new ExtensionFilter("JPG (*.jpg)", "*.jpg"),
          new ExtensionFilter("JPEG (*.jpeg)", "*.jpeg"),
          new ExtensionFilter("BMP (*.bmp)", "*.bmp"),
          new ExtensionFilter("GIF (*.gif)", "*.gif")
      );
      File selectedFile = fileChooser.showOpenDialog(((Node) event.getSource()).getScene().getWindow());
      if (selectedFile == null) {
        imageSelectionErrorAlert.show();
      } else {
        var image = new Image(selectedFile.getPath());
        BufferedImage bufferedImage = ImageIO.read(selectedFile);
        if (!(bufferedImage.getWidth() > 300 || bufferedImage.getHeight() > 200)) {
          productImageView.setImage(image);
          selectedProductImage = selectedFile.getName();
          var destinationFile = new File(getClass().getResource("img/itemsImg/").toString());
          articleNumberTextField.setDisable(true);
          System.out.println(selectedFile.getPath());
          System.out.println(destinationFile.getPath());
          Files.copy(selectedFile.toPath(), destinationFile.toPath());
        } else {
          imageSelectionErrorAlert.show();
        }
      }
    } else {
      noArticleNumberErrorError.show();
    }
  }

  @FXML
  public void onSetDefaultImageButtonClick(ActionEvent event) {
    productImageView.setImage(new Image(App.class.getResource("img/itemsImg/emptyItem.png").toString()));
    selectedProductImage = null;
  }

  @FXML
  public void onDeleteProductButtonClick(ActionEvent event) {
    var warningAlert = MessageBox.create(
        "Внимание",
        "Вы действительно хотите удалить данный товар?",
        "Это действие нельзя отменить!",
        MessageType.WARNING
    );
    warningAlert.showAndWait().ifPresent(bt -> {
      if (bt == ButtonType.OK) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        var removeProduct = session.createQuery(DELETE_PRODUCT_BY_ID_QUERY_STR).setParameter("id", productId);
        int currentProductProductInfoId = session.find(Product.class, productId).getProductInfoId();
        var removeProductInfo = session.createQuery(DELETE_PRODUCT_INFO_BY_ID_QUERY_STR)
            .setParameter("id", currentProductProductInfoId);
        Transaction transaction = session.beginTransaction();
        removeProduct.executeUpdate();
        removeProductInfo.executeUpdate();
        transaction.commit();
        session.close();
        Helper.logoutWithoutPrompt(((Stage) ((Node) (event.getSource())).getScene().getWindow()));
      }
    });
  }

  @FXML
  public void onCancelButtonClick(ActionEvent event) {
    Helper.logout(((Stage) ((Node) (event.getSource())).getScene().getWindow()));
  }

  @FXML
  public void onAddEditProductButtonClick(ActionEvent event) {
    if (isEdit) {
      articleNumberTextField.setDisable(false);
      var successEditingProductAlert = MessageBox.create(
          "Информация",
          "Продукт обновлен",
          "Данные продукта успешно обновлены.",
          MessageType.INFO
      );
      Session secondSession = HibernateUtil.getSessionFactory().openSession();
      Transaction secondTransaction = secondSession.beginTransaction();
      Product product = secondSession.find(Product.class, productId);
      product.setName(productNameTextField.getText());
      product.setCost(Double.parseDouble(productCostTextField.getText()));
      product.setMaxDiscountAmount(Integer.parseInt(maxDiscountTextField.getText()));
      product.setCurrentDiscountAmount(Integer.parseInt(currentDiscountTextField.getText()));
      product.setQuantityInStock(Integer.parseInt(quantityInStockTextField.getText()));
      product.setDescription(descriptionTextArea.getText());
      product.setPhoto(selectedProductImage);
      secondSession.merge(product);
      secondTransaction.commit();
      secondSession.close();

      Session firstSession = HibernateUtil.getSessionFactory().openSession();
      Transaction firstTransaction = firstSession.beginTransaction();
      ProductInfo productInfo = firstSession.find(ProductInfo.class, product.getProductInfoId());
      productInfo.setSupplierId(suppliersComboBox.getSelectionModel().getSelectedItem().getId());
      productInfo.setManufacturerId(manufacturersComboBox.getSelectionModel().getSelectedItem().getId());
      productInfo.setCategoryId(categoriesComboBox.getSelectionModel().getSelectedItem().getId());
      firstSession.merge(productInfo);
      firstTransaction.commit();
      firstSession.close();

      articleNumberTextField.setDisable(true);
      successEditingProductAlert.showAndWait().ifPresent(
          buttonType -> Helper.logoutWithoutPrompt(((Stage) ((Node) (event.getSource())).getScene().getWindow())));
    } else {
      boolean checkFields = !articleNumberTextField.getText().isBlank() && !productNameTextField.getText().isBlank()
          && !productCostTextField.getText().isBlank() && !quantityInStockTextField.getText().isBlank()
          && !currentDiscountTextField.getText().isBlank() && !maxDiscountTextField.getText().isBlank()
          && !descriptionTextArea.getText().isBlank() && suppliersComboBox.getSelectionModel().getSelectedItem() != null
          && manufacturersComboBox.getSelectionModel().getSelectedItem() != null
          && categoriesComboBox.getSelectionModel().getSelectedItem() != null;
      if (checkFields) {
        var successAddingProductAlert = MessageBox.create(
            "Информация",
            "Продукт добавлен!",
            "Продук успешно добавлен.",
            MessageType.INFO
        );

        Session firstSession = HibernateUtil.getSessionFactory().openSession();
        Transaction firstTransaction = firstSession.beginTransaction();
        ProductInfo productInfo = new ProductInfo();
        productInfo.setSupplierId(suppliersComboBox.getSelectionModel().getSelectedItem().getId());
        productInfo.setManufacturerId(manufacturersComboBox.getSelectionModel().getSelectedItem().getId());
        productInfo.setCategoryId(categoriesComboBox.getSelectionModel().getSelectedItem().getId());
        firstSession.persist(productInfo);
        firstTransaction.commit();
        firstSession.close();

        Session secondSession = HibernateUtil.getSessionFactory().openSession();
        Transaction secondTransaction = secondSession.beginTransaction();
        Product product = new Product();
        String article = articleNumberTextField.getText();
        product.setId(article.trim());
        product.setName(productNameTextField.getText());
        product.setCost(Double.parseDouble(productCostTextField.getText().replace(",", ".")));
        product.setQuantityInStock(Integer.parseInt(quantityInStockTextField.getText()));
        product.setCurrentDiscountAmount(Integer.parseInt(currentDiscountTextField.getText()));
        product.setMaxDiscountAmount(Integer.parseInt(maxDiscountTextField.getText()));
        product.setDescription(descriptionTextArea.getText());
        product.setPhoto(selectedProductImage);
        product.setProductInfoId(productInfo.getId());
        secondSession.persist(product);
        secondTransaction.commit();
        secondSession.close();

        successAddingProductAlert.showAndWait().ifPresent(
            buttonType -> Helper.logoutWithoutPrompt(((Stage) ((Node) (event.getSource())).getScene().getWindow())));
      } else {
        var errorAddingProductAlert = MessageBox.create(
            "Ошибка",
            "Продукт не был добавлен!",
            "проверьте корректность введенных данных и повторите попытку.",
            MessageType.ERROR
        );
        errorAddingProductAlert.show();
      }
    }
  }

  public boolean getIsEdit() {
    return isEdit;
  }

  public void setIsEdit(boolean edit) {
    isEdit = edit;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public String getPhotoPath() {
    return photoPath;
  }

  public void setPhotoPath(String photoPath) {
    this.photoPath = photoPath;
  }

  public int getProductMaxDiscountAmount() {
    return productMaxDiscountAmount;
  }

  public void setProductMaxDiscountAmount(int productMaxDiscountAmount) {
    this.productMaxDiscountAmount = productMaxDiscountAmount;
  }

  public int getProductCurrentDiscountAmount() {
    return productCurrentDiscountAmount;
  }

  public void setProductCurrentDiscountAmount(int productCurrentDiscountAmount) {
    this.productCurrentDiscountAmount = productCurrentDiscountAmount;
  }

  public int getProductQuantityInStock() {
    return productQuantityInStock;
  }

  public void setProductQuantityInStock(int productQuantityInStock) {
    this.productQuantityInStock = productQuantityInStock;
  }

  public double getProductCost() {
    return productCost;
  }

  public void setProductCost(double productCost) {
    this.productCost = productCost;
  }

  public String getProductManufacturer() {
    return productManufacturer;
  }

  public void setProductManufacturer(String productManufacturer) {
    this.productManufacturer = productManufacturer;
  }

  public String getProductDescription() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getProductSupplier() {
    return productSupplier;
  }

  public void setProductSupplier(String productSupplier) {
    this.productSupplier = productSupplier;
  }

  public String getProductCategory() {
    return productCategory;
  }

  public void setProductCategory(String productCategory) {
    this.productCategory = productCategory;
  }
}
