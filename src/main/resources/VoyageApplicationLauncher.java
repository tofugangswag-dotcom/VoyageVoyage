package projet.voyagevoyage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // ... existing code ...
        URL fxml = HelloApplication.class.getResource("client-app.fxml");
        System.out.println("FXML URL = " + fxml);

        if (fxml == null) {
            throw new IllegalStateException("client-app.fxml introuvable. Vérifie qu'il est bien dans src/main/resources/projet/voyagevoyage/");
        }

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(fxml);
            Scene scene = new Scene(fxmlLoader.load(), 1100, 720);
            stage.setTitle("VoyageVoyage");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        // ... existing code ...
    }
}
