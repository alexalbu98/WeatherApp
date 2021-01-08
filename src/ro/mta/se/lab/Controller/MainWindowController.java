package ro.mta.se.lab.Controller;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import ro.mta.se.lab.Singletons.AppStage;

public class MainWindowController {

    public Button cityWeatherButton;
    public VBox vbox;

    public void onCityWeatherButtonClicked() {
        AppStage app = AppStage.getInstance();
        app.setScene("../View/CityWeather.fxml");
    }

    
    
}
