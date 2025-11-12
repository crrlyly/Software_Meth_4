package com.example.software_meth_4;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {

    private static Stage stage;      // keep a Stage reference
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

    /**
     * Navigates to another FXML page safely, with optional controller initialization
     * and a window title (page name) displayed at the top.
     *
     * @param fxmlPath   the FXML file path (e.g. "/com/example/software_meth_4/coffee-view.fxml")
     * @param init       an optional Consumer to initialize the controller (can be null)
     * @param pageTitle  the name of the page to display in the window title bar
     */
    public static void goTo(String fxmlPath, Consumer<Object> init, String pageTitle) {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxmlPath));
            Parent root = loader.load();
            Object controller = loader.getController();

            if (init != null) {
                init.accept(controller);
            }

            Platform.runLater(() -> {
                try {
                    Scene scene = stage.getScene();
                    if (scene == null) {
                        scene = new Scene(root, 600, 620);
                        stage.setScene(scene);
                    } else {
                        scene.setRoot(root);
                    }

                    stage.setTitle("RU Cafe - " + pageTitle);
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
