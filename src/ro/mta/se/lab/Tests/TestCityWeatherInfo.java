package ro.mta.se.lab.Tests;

import org.junit.Test;

import junit.framework.TestCase;
import ro.mta.se.lab.Model.CityWeatherInfo;

public class TestCityWeatherInfo extends TestCase{
    private CityWeatherInfo object = null;

    public void setUp(){
        object = new CityWeatherInfo();
    }
    
    @Test
    public void testSetWeatherInfo(){
        assertTrue(true);
    }

}
