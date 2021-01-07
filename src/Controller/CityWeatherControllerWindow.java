package Controller;

import Singletons.AppStage;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class CityWeatherControllerWindow {
 
    public Button goBack;
    public VBox vbox;

    public void onGoBackClicked(){
        AppStage app = AppStage.getInstance();
        app.setStage("../View/MainMenu.fxml");
    }

}
