package ro.mta.se.lab.Tests;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import ro.mta.se.lab.Model.CityWeatherInfo;

public class TestCityWeatherInfo extends TestCase{
    private CityWeatherInfo object = null;

    @Before
    public void setUp(){
        object = new CityWeatherInfo();
    }
    
    @Test
    public void testSetWeatherInfo(){
      String data = "";
      object.setInfo(data);
      String info = object.getInfo();
      assertEquals(null, info);    
    }

}
