import Singletons.AppConfiguration;
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
        AppConfiguration configuration = AppConfiguration.getInstance("src/Resources/Cities.json",
        "http://api.openweathermap.org/data/2.5/weather", "1f811bcd144afbd814c2b4f5f02dfa0a", "metric", "ro");
        AppLogger logger = AppLogger.getInstance("log.txt");
        logger.logMessage("Logs on errors will be kept here!\n");
        Application.launch(args);
    }

}

