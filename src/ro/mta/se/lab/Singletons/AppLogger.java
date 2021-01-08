package ro.mta.se.lab.Singletons;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class AppLogger implements Logger {

    static private AppLogger instance = null;

    private AppLogger() {}
        
     
    static public AppLogger getInstance(){
        if(instance == null){
            instance = new AppLogger();
        }
        return instance;
    }

    @Override
    public void logMessage(String message) {

        Alert alert = new Alert(AlertType.ERROR, message, ButtonType.CLOSE);
        alert.showAndWait();
    }

    
    
}
