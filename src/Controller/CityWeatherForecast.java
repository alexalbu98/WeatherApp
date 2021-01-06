package Controller;

import Model.ApiCityWeatherRequest;
import Model.ApiRequest;
import Model.Logger;

public class CityWeatherForecast implements WeatherForecast {

    private String apiKEY;
    private String url;
    private Logger logger;

    public CityWeatherForecast(String url, String key, Logger logger) {

        this.url = url;
        this.apiKEY = key;
        this.logger = logger;

    }

    public void setLogger(Logger logger){
        this.logger = logger;
    }

    @Override
    public String getWeatherInfo(String query){

        String url = this.url+"?" + "q=" + query + "&" + "appid=" + this.apiKEY;
        ApiRequest request = new ApiCityWeatherRequest(url);
        String response = request.send();
        if (response == null){
            logger.logMessage("Failed to get results for search" + query);
        }
        return response;
    }

    
    public void setApiKEY(String apiKEY) {
        this.apiKEY = apiKEY;
    }

   
    public void setUrl(String url) {
        this.url = url;
    }


   
}
