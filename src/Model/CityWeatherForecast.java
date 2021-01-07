package Model;

import Singletons.AppLogger;

public class CityWeatherForecast implements WeatherForecast {

    private String apiKEY;
    private String url;

    public CityWeatherForecast(String url, String key) {

        this.url = url;
        this.apiKEY = key;
    }

    @Override
    public String getWeatherInfo(String query){

        String url = this.url+"?" + "q=" + query + "&" + "appid=" + this.apiKEY;
        ApiRequest request = new ApiCityWeatherRequest(url);
        String response = request.send();
        if (response == null){
            AppLogger logger = AppLogger.getInstance();
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
