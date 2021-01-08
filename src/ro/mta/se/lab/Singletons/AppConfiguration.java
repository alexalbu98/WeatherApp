package ro.mta.se.lab.Singletons;

public class AppConfiguration {
    private String language;
    private String apiURL;
    private String apiKEY;
    private String units;
    private String citiesFile;
    static private AppConfiguration instance;

    private AppConfiguration(){}

    private AppConfiguration(String citiesFile,String apiURL, String apiKEY, String units, String language){

        this.apiURL = apiURL;
        this.apiKEY = apiKEY;
        this.units = units;
        this.language = language;
        this.citiesFile = citiesFile;

    }
    /**
     * 
     * @return AppConfiguration object
     */
    public static AppConfiguration getInstance(){
        return instance;   
    }
    /**
     * 
     * @param citiesFile is the file where the cities info is stored
     * @param apiURL is the api url for open weather 
     * @param apiKEY is the api key for open weather
     * @param units is the units in which data will be displayed
     * @param language is the language in which data to be displayed
     * @return an instance of AppConfiguration singleton class
     */
    public static AppConfiguration getInstance(String citiesFile, String apiURL, String apiKEY, String units, String language){
        if (instance == null){
            instance = new AppConfiguration(citiesFile, apiURL, apiKEY, units, language);
        }
        return instance;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getApiURL() {
        return apiURL;
    }


    public String getApiKEY() {
        return apiKEY;
    }


    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getCitiesFile() {
        return citiesFile;
    }
    

}
