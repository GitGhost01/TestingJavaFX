package com.example.testingjavafx;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Choicebox extends Application {

    Stage window;
    Scene scene;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Title of window");

        ChoiceBox <String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().add("Apple");
        choiceBox.getItems().add("Banana");
        choiceBox.getItems().addAll("Mango", "Watermelon", "Pomegranate");

        choiceBox.setValue("Apple"); //sets default value

        button = new Button("Click me");
        button.setOnAction(e -> getChoice (choiceBox));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(choiceBox, button);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void getChoice (ChoiceBox<String> choiceBox){
        String food = choiceBox.getValue();
        System.out.println(food);
    }

}
