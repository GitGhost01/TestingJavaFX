package com.example.testingjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MakingMenu extends Application {

    Stage window;
    Scene scene;
    BorderPane layout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Title of window");

        //File Menu
        Menu fileMenu = new Menu("File");

        //File Menu Items
        MenuItem newFile = new MenuItem("New...");
        newFile.setOnAction(e -> System.out.println("New file created"));
        fileMenu.getItems().add(newFile);

        fileMenu.getItems().add(new MenuItem("Open..."));
        fileMenu.getItems().add(new MenuItem("Save..."));

        fileMenu.getItems().add(new SeparatorMenuItem()); //separator

        fileMenu.getItems().add(new MenuItem("Settings..."));

        fileMenu.getItems().add(new SeparatorMenuItem());

        fileMenu.getItems().add(new MenuItem("Exit"));

        //Edit Menu
        Menu editMenu = new Menu("_Edit"); //Doing ALT E will open this

        //Edit Menu Items
        editMenu.getItems().add(new MenuItem("Cut"));
        editMenu.getItems().add(new MenuItem("Copy"));

        MenuItem paste = new MenuItem("Paste");
        paste.setOnAction(e -> System.out.println("Pasting stuff"));
        paste.setDisable(true); //disables button from user
        editMenu.getItems().add(paste);

        //Help Menu
        Menu helpMenu = new Menu("Help");
        CheckMenuItem showLines = new CheckMenuItem("Show Line Numbers");
        showLines.setOnAction(e -> {
            if (showLines.isSelected())
                System.out.println("Program will now display line numbers");
            else
                System.out.println("Hiding line numbers");
        });
        CheckMenuItem autoSave = new CheckMenuItem("Enable auto save");
        autoSave.setSelected(true); //auto checks option
        helpMenu.getItems().addAll(showLines, autoSave);

        //Difficulty RadioMenuItems
        Menu difficultyMenu = new Menu("Difficulty");
        ToggleGroup difficultyToggle = new ToggleGroup();

        RadioMenuItem easy = new RadioMenuItem("Easy");
        RadioMenuItem medium = new RadioMenuItem("Medium");
        RadioMenuItem hard = new RadioMenuItem("Hard");

        easy.setToggleGroup(difficultyToggle);
        medium.setToggleGroup(difficultyToggle);
        hard.setToggleGroup(difficultyToggle);

        difficultyMenu.getItems().addAll(easy,medium,hard);

        //Main Menu Bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu, difficultyMenu);

        layout = new BorderPane();
        layout.setTop(menuBar);
        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

}