package com.example.testingjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SceneSwitcher extends Application {

    Scene scene1, scene2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create the first scene, with a button that switches to the second scene
        Label label = new Label("Welcome to scene 1");
        Button switchButton = new Button("Switch to Scene 2");
        switchButton.setOnAction(e -> primaryStage.setScene(scene2));

        VBox scene1Layout = new VBox(10);
        scene1Layout.getChildren().addAll(label, switchButton);

        scene1 = new Scene(scene1Layout, 400, 300);

        // Create the second scene, with a button that switches to the first scene
        Button switchBackButton = new Button("Switch to Scene 1");
        switchBackButton.setOnAction(e -> primaryStage.setScene(scene1));

        StackPane scene2Layout = new StackPane();
        scene2Layout.getChildren().add(switchBackButton);

        scene2 = new Scene(scene2Layout, 400, 300);


        // Set the initial scene and show the stage
        primaryStage.setTitle("Scene Switcher");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }
}
