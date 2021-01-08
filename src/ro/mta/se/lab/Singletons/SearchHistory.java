package ro.mta.se.lab.Singletons;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class SearchHistory {

    private String file;
    private static SearchHistory instance;

    private SearchHistory(String file){
        this.file = file;
        try {
            File myObj = new File(this.file);
            myObj.createNewFile();           
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
    
    static public SearchHistory getInstance(){
        return instance;
    }

    static public SearchHistory getInstance(String file){
        if(instance == null){
            instance = new SearchHistory(file);
        }
        return instance;
    }

    public void logSearch(String search){
        Date date = new Date();  
        FileWriter fr;
        try {
            fr = new FileWriter(this.file, true);
            fr.write(String.valueOf(date) + " : " + search + "\n");
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}
