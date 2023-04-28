package com.example.testingjavafx;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import java.awt.*;

public class GridPanes extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Title of the window");

        GridPane grid = new GridPane();
        //grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(10);

        window.show();
    }
}
