package com.example.testingjavafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBoxes extends Application {

    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        primaryStage.setTitle("Title of the window");

        button = new Button("Click me");
        button.setOnAction(e -> display("Alert box", "Wow, here is an alert box"));

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void display(String title, String message){
        Stage displayWindow = new Stage();

        displayWindow.initModality(Modality.APPLICATION_MODAL);
        //This means you cannot click other windows whilst this alert box is on the screen

        displayWindow.setTitle(title);
        displayWindow.setMinWidth(250);

        Label label = new Label(message);

        Button closeButton = new Button("Close the window");
        closeButton.setOnAction(e -> displayWindow.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        displayWindow.setScene(scene);
        displayWindow.showAndWait();
    }

}
