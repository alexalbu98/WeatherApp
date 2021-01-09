package ro.mta.se.lab.Controller;

import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import ro.mta.se.lab.Singletons.AppLogger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import ro.mta.se.lab.Singletons.AppConfiguration;
import ro.mta.se.lab.Singletons.AppStage;

public class MainWindowController implements Initializable {

    public Button cityWeatherButton;
    public ChoiceBox<String> units;

    /**
     * 
     * @param fileName The file where the units are stored.
     * @return Array list containing all the units.
     */
    private ArrayList<String> getUnits(String fileName) {
        JSONParser jsonParser = new JSONParser();
        ArrayList<String> unitNames = new ArrayList<>();
        try (FileReader reader = new FileReader(fileName)) {
            Object obj = jsonParser.parse(reader);
            JSONArray unitsArray = (JSONArray) obj;
            for (int i = 0; i < unitsArray.size(); i++) {
                JSONObject unitElement = (JSONObject) unitsArray.get(i);
                String name = (String) unitElement.get("name");
                unitNames.add(name);
            }
            return unitNames;
        }    
        catch(Exception e){
            AppLogger logger = AppLogger.getInstance();
            logger.logMessage("Failed to get units!");
            return null;
        }
        
    }

    /**
     * handles when the city weather button is clicked
     */
    public void onCityWeatherButtonClicked() {
        AppStage app = AppStage.getInstance();
        app.setScene("../View/CityWeather.fxml");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        AppConfiguration conf = AppConfiguration.getInstance();
        ArrayList<String> unitNames =  getUnits(conf.getUnitsFile());
        if(unitNames == null){
            return;
        }
        ObservableList<String> unitsList = FXCollections.observableArrayList();
        unitsList.addAll(unitNames);
        units.getItems().addAll(unitsList);
        //listener for when a unit is selected
        units.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) ->
        {   
            String unit = newValue;
            conf.setUnits(unit);
        });

    }

    
    
}
