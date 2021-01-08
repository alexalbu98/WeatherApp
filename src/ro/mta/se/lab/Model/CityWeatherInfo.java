package ro.mta.se.lab.Model;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import ro.mta.se.lab.Singletons.AppLogger;


public class CityWeatherInfo implements Info {

    private double temp;
    private double wind_speed;
    private String description;
    private double feels_like_temp;
    private double humidity;
    private double pressure;

    /**
     * 
     * @param weather is a json object containing the weather data from the response
     */
    private void getWeatherData(JSONArray weather){
        JSONObject object = (JSONObject)weather.get(0);        
        this.description = (String)object.get("description");
    }

    private void getMainData(JSONObject main){
        this.temp = Double.valueOf(String.valueOf(main.get("temp")));
        this.feels_like_temp = Double.valueOf(String.valueOf(main.get("feels_like")));
        this.pressure = Double.valueOf(String.valueOf(main.get("pressure")));
        this.humidity = Double.valueOf(String.valueOf(main.get("humidity")));
    }

    private void getWindData(JSONObject wind){
        this.wind_speed = Double.valueOf(String.valueOf(wind.get("speed")));
    }

    /**
     * This function gets all the data about the weather from a json string.
     * 
     * @param data is a json string containing the weather information received from
     *             a WeatherForecast object.
     */
    public void setWeatherInfo(String data) {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(data);
            JSONObject weatherInfo = (JSONObject) obj;
            JSONArray weather = (JSONArray)weatherInfo.get("weather");
            JSONObject main = (JSONObject)weatherInfo.get("main");
            JSONObject wind = (JSONObject)weatherInfo.get("wind");
            getWeatherData(weather);
            getMainData(main);
            getWindData(wind);
        } catch (ParseException e) {
            AppLogger logger = AppLogger.getInstance();
            logger.logMessage("Failed to parse weather data from json");
        }
    }

    @Override
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        String description = "Description: " + this.description + "\n";
        String temp = "Temperature: " + String.valueOf(this.temp) + "\n";
        String feels_like = "Feels like: " + String.valueOf(this.feels_like_temp) + "\n";
        String wind = "Wind: " + String.valueOf(this.wind_speed)  + "\n";
        String pressure = "Pressure: " + String.valueOf(this.pressure) + "\n";
        String humidity = "Humidity: " + String.valueOf(this.humidity) + "\n";
        info.append(description);
        info.append(temp);
        info.append(feels_like);
        info.append(wind);
        info.append(pressure);
        info.append(humidity);
        return info.toString();
    }
    
}
