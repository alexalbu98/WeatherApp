import Singletons.AppLogger;
import Singletons.AppStage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WeatherAPP extends Application {

    Stage window;
    Scene cityWeatherWindow;
    Scene mainMenu;

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        AppStage app = AppStage.getInstance(primaryStage);
        app.setStage("../View/MainMenu.fxml");
        
    }

    public static void main(String[] args) {   
        AppLogger logger = AppLogger.getInstance("log.txt");
        logger.logMessage("Logs on errors will be kept here!\n");
        Application.launch(args);
    }

}

