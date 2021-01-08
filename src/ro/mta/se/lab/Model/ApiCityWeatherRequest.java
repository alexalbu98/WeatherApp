package ro.mta.se.lab.Model;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import ro.mta.se.lab.Singletons.AppLogger;


public class ApiCityWeatherRequest implements ApiRequest{

    private URL url;

    public ApiCityWeatherRequest(String url) {
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            this.url = null;
        }

    }

    @Override
    public String send() {
        if(this.url == null){
            return null;
        }
        try {
            HttpURLConnection conn = (HttpURLConnection) this.url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect(); 
            int responsecode = conn.getResponseCode(); 
            if (responsecode == 200){
                StringBuilder response = new StringBuilder();
                Scanner scanner = new Scanner(this.url.openStream());
                String line;
                while(scanner.hasNext())
                {
                   line =  scanner.nextLine();
                   response.append(line);
                }
                scanner.close();
                return response.toString();
            }else{
                throw new RuntimeException("Failed to get resource from url.");
            }
        } catch (IOException e) {
                AppLogger logger = AppLogger.getInstance();
                logger.logMessage("Failed to get response from " + this.url.toString());
                return null;
        }
    }

}
