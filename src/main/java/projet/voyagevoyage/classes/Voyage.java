package projet.voyagevoyage.classes;

import projet.voyagevoyage.interfaces.Tarifable;

public class Voyage implements Tarifable {
    private int id;
    private String titre;
    private String description;
    private Destination destination;
    private Vol vol;
    private Hotel hotel;

    public Voyage(int id, String titre, String description,
                  Destination destination, Vol vol, Hotel hotel) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.destination = destination;
        this.vol = vol;
        this.hotel = hotel;
    }

    public int getId() { return id; }
    public String getTitre() { return titre; }
    public String getDescription() { return description; }
    public Destination getDestination() { return destination; }
    public Vol getVol() { return vol; }
    public Hotel getHotel() { return hotel; }

    @Override
    public double calculerPrixTotal() {
        // TODO: adapter plus tard (vol + hôtel + activités)
        double prixVol = (vol != null) ? vol.getPrix() : 0.0;
        double prixHotel = (hotel != null) ? hotel.getPrixParNuit() : 0.0;
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
                '}';
    }
}
