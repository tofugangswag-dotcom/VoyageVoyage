package projet.voyagevoyage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // ... existing code ...
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("client-app.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 720);
        stage.setTitle("VoyageVoyage");
        stage.setScene(scene);
        stage.show();
        // ... existing code ...
    }
}
