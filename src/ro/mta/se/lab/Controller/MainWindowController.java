package ro.mta.se.lab.Controller;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import ro.mta.se.lab.Singletons.AppStage;

public class MainWindowController {

    public Button cityWeatherButton;
    public VBox vbox;
    /**
     * handles when the city weather button is clicked
     */
    public void onCityWeatherButtonClicked() {
        AppStage app = AppStage.getInstance();
        app.setScene("../View/CityWeather.fxml");
    }

    
    
}
