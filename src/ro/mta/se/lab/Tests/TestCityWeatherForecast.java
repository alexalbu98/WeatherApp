package ro.mta.se.lab.Tests;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import ro.mta.se.lab.Model.CityWeatherForecast;

public class TestCityWeatherForecast extends TestCase {

    private CityWeatherForecast object = null;

    @Before
    public void setUp() {
       object = new CityWeatherForecast("http://api.openweathermap.org/data/2.5/weather", "1f811bcd144afbd814c2b4f5f02dfa0a");
    }

    @Test
    public void testGetWeatherInfo() {
        String data = object.getWeatherInfo("Craiova", "metric", "en");
        assertNotNull(data);
    }


}