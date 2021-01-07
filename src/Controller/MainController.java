package Controller;

import java.io.IOException;

import Singletons.AppStage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MainController {

    public Button cityWeatherButton;
    public VBox vbox;

    public void onCityWeatherButtonClicked() {
        AppStage app = AppStage.getInstance();
        app.setStage("../View/CityWeather.fxml");
    }

    
    
}
