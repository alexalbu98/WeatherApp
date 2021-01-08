package ro.mta.se.lab.Tests;


import org.junit.Test;

import junit.framework.TestCase;
import ro.mta.se.lab.Model.ApiCityWeatherRequest;

public class TestApiRequest extends TestCase{
    

    @Test
    public void testSend(){
        ApiCityWeatherRequest request = new ApiCityWeatherRequest("http://api.openweathermap.org/data/2.5/weather?q=Cosbuc&units=metric&lang=ro&appid=1f811bcd144afbd814c2b4f5f02dfa0a");
        String response = request.send();
        assertNotNull(response);
    }


}
