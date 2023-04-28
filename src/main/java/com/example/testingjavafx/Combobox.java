package com.example.testingjavafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Combobox extends Application {

    Stage window;
    Scene scene;
    Button button;
    ComboBox comboBox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Title of window");

        comboBox = new ComboBox();
        comboBox.getItems().addAll(
                "Good Will Hunting",
                "GoodFellas",
                "Shutter Island"
        );

        //Sets default text to prompt user
        comboBox.setPromptText("What is your favourite movie?");

        button = new Button("Click me");
        button.setOnAction(e -> printMovie());

        comboBox.setOnAction(e -> System.out.println("User selected: " + comboBox.getValue()));
        comboBox.setEditable(true);

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(comboBox, button);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void printMovie (){
        System.out.println(comboBox.getValue());
    }

}
