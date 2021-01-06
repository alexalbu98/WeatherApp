import Controller.CityWeatherForecast;
import Controller.WeatherForecast;
import Model.FileLogger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class WeatherAPP extends Application {

    private WeatherForecast forecast;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("WeatherApp");
        Button button = new Button("City Weather");
        
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 1000, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        FileLogger logger = new FileLogger("loger.txt");
        WeatherForecast forecast = new CityWeatherForecast("http://api.openweathermap.org/data/2.5/weather", "1f811bcd144afbd814c2b4f5f02dfa0a", logger);       
        Application.launch(args);
    }

}

