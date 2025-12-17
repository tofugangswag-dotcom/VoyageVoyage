package projet.voyagevoyage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import projet.voyagevoyage.classes.Voyage;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientAppController implements Initializable {
    @FXML private TableView<Voyage> voyagesTable;
    @FXML private TableColumn<Voyage, Integer> idCol;
    @FXML private TableColumn<Voyage, String> titreCol, destCol, detailsCol;
    @FXML private TableColumn<Voyage, Double> prixCol;
    @FXML private TextField searchField;
    @FXML private Button addVoyageBtn, reserverBtn, refreshBtn;
    @FXML private Label totalLabel;

    private ObservableList<Voyage> voyagesData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Lier colonnes aux propriétés (ajoutez getId(), etc. dans Voyage si besoin)
        idCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleIntegerProperty(cell.getValue().getId()).asObject());
        titreCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getTitre()));
        destCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getDestination().getNomVille()));
        prixCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleDoubleProperty(cell.getValue().calculerPrixTotal()).asObject());
        detailsCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(
                "Vol: " + cell.getValue().getVol().getCompagnie() + ", Hôtel: " + cell.getValue().getHotel().getNom()));

        voyagesTable.setItems(voyagesData);
        chargerVoyagesExemple();  // Chargez depuis Main.java ou DB

        searchField.textProperty().addListener((obs, old, newVal) -> filtrerVoyages(newVal));
        refreshBtn.setOnAction(e -> chargerVoyagesExemple());
        reserverBtn.setOnAction(e -> reserverVoyage());
    }

    private void chargerVoyagesExemple() {
        // Exemple avec données de Main.java [file:2]
        voyagesData.clear();
        // Ajoutez vos instances Voyage ici, e.g., new Voyage(1, "Vroum Vroum", ...)
        totalLabel.setText("Total voyages: " + voyagesData.size());
    }

    private void filtrerVoyages(String query) {
        // Filtre ObservableList par titre/destination
        voyagesData.setAll(voyagesData.filtered(v ->
                v.getTitre().toLowerCase().contains(query.toLowerCase()) ||
                        v.getDestination().getNomVille().toLowerCase().contains(query.toLowerCase())));
    }

    private void reserverVoyage() {
        Voyage selected = voyagesTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Réservation pour " + selected.getTitre() + " à " + selected.calculerPrixTotal() + "€");
            alert.show();
        }
    }
}
