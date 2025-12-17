package projet.voyagevoyage.classes;

import projet.voyagevoyage.interfaces.Tarifable;

import java.time.LocalDate;

public class Reservation implements Tarifable {
    private int id;
    private Client client;
    private Voyage voyage;
    private LocalDate dateReservation;
    private int nbPersonnes;
    private double montantTotal;

    public Reservation(int id, Client client, Voyage voyage,
                       LocalDate dateReservation, int nbPersonnes) {
        this.id = id;
        this.client = client;
        this.voyage = voyage;
        this.dateReservation = dateReservation;
        this.nbPersonnes = nbPersonnes;
    }

    public int getId() { return id; }
    public Client getClient() { return client; }
    public Voyage getVoyage() { return voyage; }
    public LocalDate getDateReservation() { return dateReservation; }
    public int getNbPersonnes() { return nbPersonnes; }
    public double getMontantTotal() { return montantTotal; }

    @Override
    public double calculerPrixTotal() {
        if (voyage == null) return 0.0;
        double prixVoyage = voyage.calculerPrixTotal();
        montantTotal = prixVoyage * nbPersonnes;
        return montantTotal;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", client=" + client +
                ", voyage=" + voyage +
                ", dateReservation=" + dateReservation +
                ", nbPersonnes=" + nbPersonnes +
                ", montantTotal=" + montantTotal +
                '}';
    }
}
