package projet.voyagevoyage.classes;

public class Destination {
    private final int id;
    private String pays;
    private String ville;

    public Destination(int id, String pays, String ville) {
        this.id = id;
        this.pays = pays;
        this.ville = ville;
    }

    public int getId() { return id; }
    public String getPays() { return pays; }
    public String getVille() { return ville; }

    public void setPays(String pays) { this.pays = pays; }
    public void setVille(String ville) { this.ville = ville; }

    @Override
    public String toString() {
        return "Destination{" +
                "id=" + id +
                ", pays='" + pays + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }

    public String getNomVille() {
        return "";
    }
}