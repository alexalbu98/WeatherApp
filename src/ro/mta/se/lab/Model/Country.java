package ro.mta.se.lab.Model;
import java.util.ArrayList;

public class Country {

    private String name;
    private ArrayList<City> cities;
    private String countryCode;

    public Country(String name, String code){
        this.name = name;
        this.cities = new ArrayList<City>();
        this.countryCode = code;
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

    

    public ArrayList<String> getCities(){
        ArrayList<String> cityNames = new ArrayList<>();
        for(City city: cities){
            cityNames.add(city.getName());
        }
        return cityNames;
    }

    public String getCountryCode() {
        return countryCode;
    }

}
