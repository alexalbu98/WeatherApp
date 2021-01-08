package Singletons;

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

    public static AppConfiguration getInstance(){
        return instance;   
    }

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
