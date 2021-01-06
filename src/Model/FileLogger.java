package Model;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger implements Logger {

    private String file;

    public FileLogger(String file) {
        this.file = file;
    }

    public void setFile(String file) {
        this.file = file;
        PrintWriter writer;
        try {
            writer = new PrintWriter(file);
            writer.print("");
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void logMessage(String message) {

        FileWriter myWriter;
        try {
            myWriter = new FileWriter(this.file);
            myWriter.write(message);
            myWriter.close();
        } 
        
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    
}
