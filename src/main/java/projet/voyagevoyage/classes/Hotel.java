package projet.voyagevoyage.classes;

public class Hotel {
    private int id;
    private String nom;
    private String adresse;
    private double prixParNuit;

    public Hotel(int id, String nom, String adresse, double prixParNuit) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.prixParNuit = prixParNuit;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getAdresse() { return adresse; }
    public double getPrixParNuit() { return prixParNuit; }

    public void setPrixParNuit(double prixParNuit) { this.prixParNuit = prixParNuit; }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", prixParNuit=" + prixParNuit +
                '}';
    }
}