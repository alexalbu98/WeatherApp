package ro.mta.se.lab.Singletons;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AppLogger implements Logger {

    private String file;
    static private AppLogger instance = null;

    private AppLogger(String file) {
        this.file = file;
        PrintWriter writer;
        try {
            File fileObj = new File(file);
            try {
                fileObj.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            writer = new PrintWriter(file);
            writer.print("");
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
       
    }

    static public AppLogger getInstance(){
            return instance;
    }

    /**
     * 
     * @param file is the file where the logs will be kept
     * @return an instance of class AppLogger
     */
    static public AppLogger getInstance(String file){
        if(instance == null){
            instance = new AppLogger(file);
        }
        return instance;
    }

    @Override
    public void logMessage(String message) {

        FileWriter myWriter;
        try {
            myWriter = new FileWriter(this.file, true);
            myWriter.write(message+"\n");
            myWriter.close();
        } 
        
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    
}
