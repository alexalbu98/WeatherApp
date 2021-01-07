package Controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Model.City;
import Model.CityWeatherForecast;
import Model.Country;
import Model.WeatherForecast;
import Singletons.AppLogger;
import Singletons.AppStage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class CityWeatherWindowController implements Initializable {

    private ArrayList<Country> countries;
    private WeatherForecast forecast;

    public Button goBack;
    public VBox vbox;
    public ChoiceBox<String> country;
    public ChoiceBox<String> city;
    public Text result;

    private ArrayList<String> getCountries(String fileName) {
        JSONParser jsonParser = new JSONParser();
        ArrayList<String> countryNames = new ArrayList<>();
        try (FileReader reader = new FileReader(fileName)) {
            Object obj = jsonParser.parse(reader);
            JSONArray countryArray = (JSONArray) obj;
            for (int i = 0; i < countryArray.size(); i++) {
                JSONObject countryElement = (JSONObject) countryArray.get(i);
                String countryName = (String) countryElement.get("country");
                countryNames.add(countryName);
                Country newCountry = new Country(countryName);
                JSONArray cityArray = (JSONArray) countryElement.get("cities");
                for (int j = 0; j < cityArray.size(); j++) {
                    JSONObject cityElement = (JSONObject) cityArray.get(j);
                    String cityName = (String) cityElement.get("name");
                    City newCity = new City(cityName);
                    newCountry.addCity(newCity);
                }
                countries.add(newCountry);
            }
            return countryNames;

        } catch (FileNotFoundException e) {
            AppLogger logger = AppLogger.getInstance();
            logger.logMessage("Failed to get cities data");
            return null;
        } catch (IOException e) {
            AppLogger logger = AppLogger.getInstance();
            logger.logMessage("Failed to get cities data");
            return null;
        } catch (org.json.simple.parser.ParseException e) {
            AppLogger logger = AppLogger.getInstance();
            logger.logMessage("Failed to get cities data");
            return null;
        }

    }

    public void onGoBackClicked() {
        AppStage app = AppStage.getInstance();
        app.setStage("../View/MainMenu.fxml");
    }

    public void onFindWeatherClicked() {
        String cityName = city.getValue();
        String countryName = country.getValue();
        if (cityName != null && countryName != null) {
            try {
                String jsonInfo = forecast.getWeatherInfo(cityName);
                if(jsonInfo == null){
                    throw new RuntimeException("Failed to get weather info form server!");
                }
                JSONParser jsonParser = new JSONParser();
                Object obj = jsonParser.parse(jsonInfo);
                JSONArray infoArray = (JSONArray) obj;
                
            } catch (Exception e) {
                AppLogger logger = AppLogger.getInstance();
                logger.logMessage("Failed to display weather info");
            }
        }

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
            forecast = new CityWeatherForecast("http://api.openweathermap.org/data/2.5/weather", "1f811bcd144afbd814c2b4f5f02dfa0a");
            countries = new ArrayList<>();
            ArrayList<String> countryNames = getCountries("src/Resources/Cities.json");
            ObservableList<String> countryList = FXCollections.observableArrayList();
            countryList.addAll(countryNames);
            country.getItems().addAll(countryList);
            country.getSelectionModel().selectedIndexProperty().addListener((v, oldValue, newValue)->
            {
                city.getItems().clear();
                int index = (int)newValue;
                ArrayList<String> cityNames = countries.get(index).getCities();
                ObservableList<String> cityList = FXCollections.observableArrayList();
                cityList.addAll(cityNames);
                city.getItems().addAll(cityList);
            });
    }

}
