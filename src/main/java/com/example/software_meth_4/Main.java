package com.example.software_meth_4;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {

    private static Stage stage;
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    @Override
    public void start(Stage stage) throws IOException {
        Main.stage = stage;

        FXMLLoader fxmlLoader = new FXMLLoader(
                Main.class.getResource("/com/example/software_meth_4/main-view.fxml")
        );
        Scene mainScene = new Scene(fxmlLoader.load(), 600, 620);
        stage.setTitle("RU Cafe");
        stage.setScene(mainScene);
        stage.show();
    }

    public static void goTo(String fxmlPath, String pageTitle) {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxmlPath));
            Parent root = loader.load();

            Platform.runLater(() -> {
                try {
                    Scene scene = stage.getScene();
                    if (scene == null) {
                        scene = new Scene(root, 600, 620);
                        stage.setScene(scene);
                    } else {
                        scene.setRoot(root);
                    }

                    stage.setTitle(pageTitle);
                    stage.show();
                } catch (Exception e) {
                    LOGGER.log(Level.SEVERE, "Error switching to page: " + pageTitle, e);
                }
            });
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Failed to load FXML: " + fxmlPath, ex);
        }
    }
}
