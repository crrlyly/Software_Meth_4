package com.example.software_meth_4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Scene mainScene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-view.fxml"));
        mainScene = new Scene(fxmlLoader.load(), 600, 620);
        stage.setTitle("RU Cafe");
        stage.setScene(mainScene);
        stage.show();
    }

    public static void switchRoot(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxml));
        mainScene.setRoot(loader.load());
    }
}
