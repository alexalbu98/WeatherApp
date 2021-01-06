package Model;

import java.net.URL;

public class WeatherForecast {

    private String apiKEY;
    private URL url;

    public WeatherForecast(URL url, String key) {

        this.url = url;
        this.apiKEY = key;

    }


   
}
