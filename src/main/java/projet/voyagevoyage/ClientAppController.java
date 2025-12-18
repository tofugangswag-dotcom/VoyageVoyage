package projet.voyagevoyage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import projet.voyagevoyage.classes.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ClientAppController implements Initializable {

    @FXML private TableView<Voyage> voyagesTable;
    @FXML private TableColumn<Voyage, Integer> idCol;
    @FXML private TableColumn<Voyage, String> titreCol;
    @FXML private TableColumn<Voyage, String> destCol;
    @FXML private TableColumn<Voyage, String> detailsCol;
    @FXML private TableColumn<Voyage, Double> prixCol;

    @FXML private TextField searchField;
    @FXML private Button addVoyageBtn, reserverBtn, refreshBtn;
    @FXML private Label totalLabel;

    private ObservableList<Voyage> voyagesData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        idCol.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleIntegerProperty(
                        cell.getValue().getId()).asObject());

        titreCol.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(
                        cell.getValue().getTitre()));

        destCol.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(
                        cell.getValue().getDestination().getNomVille()));

        prixCol.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleDoubleProperty(
                        cell.getValue().calculerPrixTotal()).asObject());

        detailsCol.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(
                        "Durée: " + cell.getValue().getDureeSejour() + " jours | " +
                                "Vol: " + cell.getValue().getVol().getCompagnie() +
                                " | Hôtel: " + cell.getValue().getHotel().getNom()
                ));

        voyagesTable.setItems(voyagesData);

        chargerVoyagesExemple();

        searchField.textProperty().addListener(
                (obs, oldVal, newVal) -> filtrerVoyages(newVal));

        refreshBtn.setOnAction(e -> chargerVoyagesExemple());
        reserverBtn.setOnAction(e -> reserverVoyage());
        addVoyageBtn.setOnAction(e -> ajouterVoyageSimple());
    }

    private void chargerVoyagesExemple() {
        voyagesData.clear();

        Destination dest1 = new Destination(1, "Bangladesh", "Bordeaux City");
        Vol vol1 = new Vol(1, "InchallaSaVol",
                LocalDate.now(),
                LocalDate.now().plusDays(37),
                800);
        Hotel hotel1 = new Hotel(1, "Hotel Ynoved",
                "23 rue de la POO",
                1400);

        Voyage voyage1 = new Voyage(
                1,
                "Gotham City",
                "Séjour complet",
                dest1, vol1, hotel1,
                7 // 🔹 durée du séjour
        );
        voyagesData.add(voyage1);

        Destination dest2 = new Destination(2, "France", "Paris");
        Vol vol2 = new Vol(2, "AirPOO",
                LocalDate.now().plusDays(10),
                LocalDate.now().plusDays(17),
                250);
        Hotel hotel2 = new Hotel(2, "Hotel Eiffel",
                "5 avenue de la JavaFX",
                600);

        Voyage voyage2 = new Voyage(
                2,
                "Week-end à Paris",
                "City trip",
                dest2, vol2, hotel2,
                3
        );
        voyagesData.add(voyage2);

        totalLabel.setText("Total voyages: " + voyagesData.size());
        voyagesTable.refresh();
    }

    private void filtrerVoyages(String query) {
        if (query == null || query.isBlank()) {
            voyagesTable.setItems(voyagesData);
            return;
        }
        String lower = query.toLowerCase();
        ObservableList<Voyage> filtered =
                voyagesData.filtered(v ->
                        v.getTitre().toLowerCase().contains(lower) ||
                                v.getDestination().getNomVille().toLowerCase().contains(lower));
        voyagesTable.setItems(filtered);
    }

    private void reserverVoyage() {
        Voyage selected = voyagesTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            new Alert(Alert.AlertType.WARNING,
                    "Sélectionne d'abord un voyage.").showAndWait();
            return;
        }

        TextInputDialog dureeDialog =
                new TextInputDialog(String.valueOf(selected.getDureeSejour()));
        dureeDialog.setTitle("Durée du séjour");
        dureeDialog.setHeaderText("Modifier la durée du séjour");
        dureeDialog.setContentText("Nombre de jours :");

        dureeDialog.showAndWait().ifPresent(dureeStr -> {
            try {
                int duree = Integer.parseInt(dureeStr);
                selected.setDureeSejour(duree);
                voyagesTable.refresh();

                TextInputDialog nbDialog = new TextInputDialog("1");
                nbDialog.setTitle("Réservation");
                nbDialog.setHeaderText("Nombre de personnes");
                nbDialog.setContentText("Personnes :");

                nbDialog.showAndWait().ifPresent(nbStr -> {
                    int nb = Integer.parseInt(nbStr);

                    Client client = new Client(
                            1,
                            "Matteo",
                            "Hypolite-Eude",
                            "john@exemple.com"
                    );

                    Reservation res = new Reservation(
                            1, client, selected,
                            LocalDate.now(), nb);

                    double prix = res.calculerPrixTotal();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Réservation confirmée");
                    alert.setHeaderText("Réservation enregistrée");
                    alert.setContentText(
                            "Voyage: " + selected.getTitre() +
                                    "\nDurée: " + selected.getDureeSejour() + " jours" +
                                    "\nPersonnes: " + nb +
                                    "\nTotal: " + prix + " €"
                    );
                    alert.showAndWait();
                });

            } catch (NumberFormatException e) {
                new Alert(Alert.AlertType.ERROR,
                        "Valeur invalide.").showAndWait();
            }
        });
    }

    private void ajouterVoyageSimple() {
        TextInputDialog dialog = new TextInputDialog("Voyage personnalisé");
        dialog.setTitle("Ajouter un voyage");
        dialog.setHeaderText("Créer un voyage simple");
        dialog.setContentText("Titre du voyage :");

        dialog.showAndWait().ifPresent(titre -> {

            Destination dest = new Destination(99, "France", "Bordeaux");
            Vol vol = new Vol(99, "CompagnieX",
                    LocalDate.now(),
                    LocalDate.now().plusDays(7),
                    300);
            Hotel hotel = new Hotel(99, "Hotel Simple",
                    "Adresse inconnue",
                    500);

            Voyage v = new Voyage(
                    voyagesData.size() + 1,
                    titre,
                    "Voyage ajouté depuis l'UI",
                    dest, vol, hotel,
                    5
            );

            voyagesData.add(v);
            totalLabel.setText("Total voyages: " + voyagesData.size());
            voyagesTable.refresh();
        });
    }
}
