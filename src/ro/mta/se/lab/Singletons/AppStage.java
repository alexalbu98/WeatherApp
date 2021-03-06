package ro.mta.se.lab.Singletons;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppStage {

    private static AppStage instance = null;
    private Stage window;

    private AppStage() {
    };

    private AppStage(Stage primaryWindow) {
        window = primaryWindow;
        window = new Stage();
        window.setTitle("WeatherApp");
    };

    static public AppStage getInstance() {

        return instance;
    }

    static public AppStage getInstance(Stage primaryStage) {

        if (instance == null) {
            instance = new AppStage(primaryStage);
        }
        return instance;
    }

    /**
     * 
     * @param location the location of the scene that will be loaded in the stage 
     */
    public void setScene(String location) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(location));
            Scene scene = new Scene(root, 1000, 500);
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            AppLogger logger = AppLogger.getInstance();
            logger.logMessage("Failed to load window "+location);
        }
        
    }

}
