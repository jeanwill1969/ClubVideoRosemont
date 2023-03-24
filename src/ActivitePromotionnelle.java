import java.sql.*;
import java.time.LocalDate;

public class ActivitePromotionnelle {
    private int id_noEvennement;
    private LocalDate date;
    private String nomAmuseur;
    private String telephone;
    private String typeActivite;
    private int nbHeures;
    private float montantFacture;

    public ActivitePromotionnelle(int id_noEvennement, LocalDate date, String nomAmuseur, String telephone, String typeActivite, int nbHeures, float montantFacture) {
        this.id_noEvennement = id_noEvennement;
        this.date = date;
        this.nomAmuseur = nomAmuseur;
        this.telephone = telephone;
        this.typeActivite = typeActivite;
        this.nbHeures = nbHeures;
        this.montantFacture = montantFacture;
    }

    public int getId_noEvennement() {
        return id_noEvennement;
    }

    public void setId_noEvennement(int id_noEvennement) {
        this.id_noEvennement = id_noEvennement;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNomAmuseur() {
        return nomAmuseur;
    }

    public void setNomAmuseur(String nomAmuseur) {
        this.nomAmuseur = nomAmuseur;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTypeActivite() {
        return typeActivite;
    }

    public void setTypeActivite(String typeActivite) {
        this.typeActivite = typeActivite;
    }

    public int getNbHeures() {
        return nbHeures;
    }

    public void setNbHeures(int nbHeures) {
        this.nbHeures = nbHeures;
    }

    public float getMontantFacture() {
        return montantFacture;
    }

    public void setMontantFacture(float montantFacture) {
        this.montantFacture = montantFacture;
    }
}