import java.util.List;

public class Film {
    private int id;
    private String titre;
    private int duree;
    private String genre;
    private String realisateur;
    private int anneeProduction;

    public Film(String titre, int duree, String genre, String realisateur, int anneeProduction) {
        this.titre = titre;
        this.duree = duree;
        this.genre = genre;
        this.realisateur = realisateur;
        this.anneeProduction = anneeProduction;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public int getanneeProduction() {
        return anneeProduction;
    }

    public void setanneeProduction(int anneeProduction) {
        this.anneeProduction = anneeProduction;
    }

}
