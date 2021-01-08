package ro.mta.se.lab.Controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import ro.mta.se.lab.Model.City;
import ro.mta.se.lab.Model.CityWeatherForecast;
import ro.mta.se.lab.Model.CityWeatherInfo;
import ro.mta.se.lab.Model.Country;
import ro.mta.se.lab.Model.WeatherForecast;
import ro.mta.se.lab.Singletons.AppConfiguration;
import ro.mta.se.lab.Singletons.AppLogger;
import ro.mta.se.lab.Singletons.AppStage;
import ro.mta.se.lab.Singletons.SearchHistory;

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
        app.setScene("../View/MainMenu.fxml");
    }

    public void onFindWeatherClicked() {
        String cityName = city.getValue();
        String countryName = country.getValue();
        SearchHistory history = SearchHistory.getInstance();
        AppConfiguration conf = AppConfiguration.getInstance();
        if (cityName != null && countryName != null) {
            try {
                String jsonInfo = forecast.getWeatherInfo(cityName, conf.getUnits(), conf.getLanguage());
                if (jsonInfo == null) {
                    throw new RuntimeException("Failed to get weather info form server!");
                }
                history.logSearch(jsonInfo);
                CityWeatherInfo info = new CityWeatherInfo();
                info.setWeatherInfo(jsonInfo);
                result.setText(info.getInfo());
                
            } catch (Exception e) {
                AppLogger logger = AppLogger.getInstance();
                logger.logMessage("Failed to display weather info");
            }
        }

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
            AppConfiguration conf = AppConfiguration.getInstance();
            forecast = new CityWeatherForecast(conf.getApiURL(), conf.getApiKEY());
            countries = new ArrayList<>();
            ArrayList<String> countryNames = getCountries(conf.getCitiesFile());
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
