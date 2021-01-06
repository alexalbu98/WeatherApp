package Model;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ApiCityWeatherRequest implements ApiRequest{

    private URL apiURL;

    public ApiCityWeatherRequest(String url) {
        try {
            this.apiURL = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String send() {
        try {
            HttpURLConnection conn = (HttpURLConnection) this.apiURL.openConnection();
            conn.setRequestMethod("GET");
            conn.connect(); 
            int responsecode = conn.getResponseCode(); 
            if (responsecode == 200){
                StringBuilder response = new StringBuilder();
                Scanner scanner = new Scanner(this.apiURL.openStream());
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
                e.getMessage();
                return null;
        }
    }

}
