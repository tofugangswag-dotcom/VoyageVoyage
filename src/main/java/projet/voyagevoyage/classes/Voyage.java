package projet.voyagevoyage.classes;

import projet.voyagevoyage.interfaces.Tarifable;

public class Voyage implements Tarifable {

    private int id;
    private String titre;
    private String description;
    private Destination destination;
    private Vol vol;
    private Hotel hotel;

    // 🔹 Durée du séjour en jours
    private int dureeSejour;

    /**
     * Constructeur COMPLET (recommandé)
     */
    public Voyage(int id,
                  String titre,
                  String description,
                  Destination destination,
                  Vol vol,
                  Hotel hotel,
                  int dureeSejour) {

        this.id = id;
        this.titre = titre;
        this.description = description;
        this.destination = destination;
        this.vol = vol;
        this.hotel = hotel;
        this.dureeSejour = dureeSejour > 0 ? dureeSejour : 1;
    }

    /**
     * 🔹 Constructeur de compatibilité (ancien code)
     * Par défaut : 1 jour de séjour
     */
    public Voyage(int id,
                  String titre,
                  String description,
                  Destination destination,
                  Vol vol,
                  Hotel hotel) {

        this(id, titre, description, destination, vol, hotel, 1);
    }

    // ================= GETTERS / SETTERS =================

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public Destination getDestination() {
        return destination;
    }

    public Vol getVol() {
        return vol;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public int getDureeSejour() {
        return dureeSejour;
    }

    public void setDureeSejour(int dureeSejour) {
        if (dureeSejour > 0) {
            this.dureeSejour = dureeSejour;
        }
    }

    // ================= LOGIQUE MÉTIER =================

    @Override
    public double calculerPrixTotal() {
        double prixVol = (vol != null) ? vol.getPrix() : 0.0;
        double prixHotel = (hotel != null)
                ? hotel.getPrixParNuit() * dureeSejour
                : 0.0;

        return prixVol + prixHotel;
    }

    @Override
    public String toString() {
        return "Voyage{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", destination=" + destination +
                ", vol=" + vol +
                ", hotel=" + hotel +
                ", dureeSejour=" + dureeSejour +
                '}';
    }
}
