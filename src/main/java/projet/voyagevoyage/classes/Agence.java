package projet.voyagevoyage.classes;

import java.util.ArrayList;
import java.util.List;

public class Agence {
    private String nom;
    private List<Client> clients = new ArrayList<>();
    private List<Voyage> voyages = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();

    public Agence(String nom) {
        this.nom = nom;
    }

    public void ajouterClient(Client client) {
        clients.add(client);
    }

    public void ajouterVoyage(Voyage voyage) {
        voyages.add(voyage);
    }

    public void ajouterReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public List<Client> getClients() { return clients; }
    public List<Voyage> getVoyages() { return voyages; }
    public List<Reservation> getReservations() { return reservations; }

    @Override
    public String toString() {
        return "Agence{" +
                "nom='" + nom + '\'' +
                ", clients=" + clients.size() +
                ", voyages=" + voyages.size() +
                ", reservations=" + reservations.size() +
                '}';
    }
}