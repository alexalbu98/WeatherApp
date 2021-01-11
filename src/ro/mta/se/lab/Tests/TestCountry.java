package ro.mta.se.lab.Tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import ro.mta.se.lab.Model.Country;
import ro.mta.se.lab.Model.City;

public class TestCountry {

    private Country country = null;

    @Before
    public void setUp(){
        country = new Country("Test", "1");
    }

    @Test
    public void testGetCities(){

        City firstCity = mock(City.class);
        when(firstCity.getName()).thenReturn("Test");

        country.addCity(firstCity);
        
        ArrayList<String> cities = country.getCities();
        for(String name : cities){
            assertEquals("Test", name);
        }

    }
    
}
