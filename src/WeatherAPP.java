import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WeatherAPP extends Application {

    Stage window;
    Scene cityWeatherWindow;
    Scene mainMenu;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("View/MainMenu.fxml"));
        mainMenu = new Scene(root, 1000, 500);
        window.setTitle("WeatherApp");
        window.setScene(mainMenu);
        primaryStage.show();
    }

    public static void main(String[] args) {      
        Application.launch(args);
    }

}

