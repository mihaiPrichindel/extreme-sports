package com.sda.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    BorderPane layout;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("Extreme Sports - The Who And Where");


        layout = new BorderPane();
        Scene scene = new Scene(layout, 400, 300);
        window.setScene(scene);
        window.show();

    }
}
