package projet.voyagevoyage.classes;

import java.time.LocalDate;

public class Vol {
    private int id;
    private String compagnie;
    private LocalDate dateDepart;
    private LocalDate dateRetour;
    private double prix;

    public Vol(int id, String compagnie, LocalDate dateDepart, LocalDate dateRetour, double prix) {
        this.id = id;
        this.compagnie = compagnie;
        this.dateDepart = dateDepart;
        this.dateRetour = dateRetour;
        this.prix = prix;
    }

    public int getId() { return id; }
    public String getCompagnie() { return compagnie; }
    public LocalDate getDateDepart() { return dateDepart; }
    public LocalDate getDateRetour() { return dateRetour; }
    public double getPrix() { return prix; }

    public void setPrix(double prix) { this.prix = prix; }

    @Override
    public String toString() {
        return "Vol{" +
                "id=" + id +
                ", compagnie='" + compagnie + '\'' +
                ", dateDepart=" + dateDepart +
                ", dateRetour=" + dateRetour +
                ", prix=" + prix +
                '}';
    }
}