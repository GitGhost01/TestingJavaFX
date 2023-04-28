package com.example.testingjavafx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//See Product Class

public class Tableview extends Application {

    Stage window;
    Scene scene;
    TableView<Product> table;
    TextField nameInput, priceInput, amountInput;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Title of window");

        //Name column
        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Price column
        TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(200);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        //Amount column
        TableColumn<Product, Integer> amountColumn = new TableColumn<>("Amount");
        amountColumn.setMinWidth(200);
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));

        //Name input
        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);

        //Price input
        priceInput = new TextField();
        priceInput.setPromptText("Price");
        priceInput.setMinWidth(100);

        //Amount input
        amountInput = new TextField();
        amountInput.setPromptText("Amount");
        amountInput.setMinWidth(100);

        //Button
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());


        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, priceInput, amountInput, addButton, deleteButton);

        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn, priceColumn, amountColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);

        scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    public void addButtonClicked (){
        Product product = new Product();
        product.setName(nameInput.getText());
        product.setPrice(Double.parseDouble(priceInput.getText()));
        product.setAmount(Integer.parseInt(amountInput.getText()));
        table.getItems().add(product);
        nameInput.clear();
        priceInput.clear();
        amountInput.clear();
    }
    public void deleteButtonClicked(){
        ObservableList<Product> productSelected, allProducts;
        allProducts = table.getItems();
        productSelected = table.getSelectionModel().getSelectedItems();
        productSelected.forEach(allProducts::remove);
    }

    //Get all the products
    public ObservableList<Product> getProduct(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Laptop", 859.00, 20));
        products.add(new Product("Trampoline", 123.00, 3));
        products.add(new Product("Toilet", 67.00, 1));
        products.add(new Product("DVD", 19.00, 32));
        products.add(new Product("Notebook", 2.00, 50));
        return products;
    }

}
