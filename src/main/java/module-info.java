module projet.voyagevoyage {
    requires javafx.controls;
    requires javafx.fxml;


    opens projet.voyagevoyage to javafx.fxml;
    exports projet.voyagevoyage;
}