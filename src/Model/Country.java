package Model;
import java.util.ArrayList;

public class Country {

    private String name;
    private ArrayList<City> cities;

    public Country(String name){
        this.name = name;
        this.cities = new ArrayList<City>();
    }

    public String getName(){

        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public void addCity(City city){
        this.cities.add(city);
    }

}