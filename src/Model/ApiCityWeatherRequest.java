package Model;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

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
                return null;
        }
    }

}
