package Controller;


import Singletons.AppStage;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MainWindowController {

    public Button cityWeatherButton;
    public VBox vbox;

    public void onCityWeatherButtonClicked() {
        AppStage app = AppStage.getInstance();
        app.setStage("../View/CityWeather.fxml");
    }

    
    
}
