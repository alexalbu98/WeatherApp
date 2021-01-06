import Model.ApiCityWeatherRequest;
import Model.ApiRequest;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class WeatherAPP extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("My First JavaFX App");
        Button button = new Button("Click me please!");
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        ApiRequest request = new ApiCityWeatherRequest("http://api.openweathermap.org/data/2.5/weather?q=Craiova&appid=1f811bcd144afbd814c2b4f5f02dfa0a");
        String response  = request.send();
        System.out.println(response);
        Application.launch(args);
    }

}

