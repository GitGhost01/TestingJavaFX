package com.example.testingjavafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Checkbox extends Application {

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

        CheckBox box1 = new CheckBox("Bacon");
        CheckBox box2 = new CheckBox("Cheese");

        box2.setSelected(true);
        //will auto select the box (but can still be unchecked if the user wishes)

        button = new Button("Order Now");
        button.setOnAction(e -> handleOptions(box1, box2));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(box1, box2, button);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void handleOptions(CheckBox box1, CheckBox box2){
        String message = "User's order: \n";

        if (box1.isSelected()) {
            message += "Bacon";
        }
        else if (box1.isSelected()) {
            message += "Tuna";
        }
        else if (box1.isSelected() && box2.isSelected()){
            message += "Bacon \n Tuna";
        }
        System.out.println(message);
    }

}