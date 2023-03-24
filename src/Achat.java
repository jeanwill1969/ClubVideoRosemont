import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Achat {

    private int id_transaction_achat;
    private String nomFournisseur;
    private String telFournisseur;
    private int id_produitReference;
    private int qte_produit;
    private float montantTransaction;

    public Achat(int id_transaction_achat, String nomFournisseur, String telFournisseur, int id_produitReference, int qte_produit, float montantTransaction) {
        this.id_transaction_achat = id_transaction_achat;
        this.nomFournisseur = nomFournisseur;
        this.telFournisseur = telFournisseur;
        this.id_produitReference = id_produitReference;
        this.qte_produit = qte_produit;
        this.montantTransaction = montantTransaction;
    }

    public int getId_transaction_achat() {
        return id_transaction_achat;
    }

    public void setId_transaction_achat(int id_transaction_achat) {
        this.id_transaction_achat = id_transaction_achat;
    }

    public String getNomFournisseur() {
        return nomFournisseur;
    }

    public void setNomFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }

    public String getTelFournisseur() {
        return telFournisseur;
    }

    public void setTelFournisseur(String telFournisseur) {
        this.telFournisseur = telFournisseur;
    }

    public int getId_produitReference() {
        return id_produitReference;
    }

    public void setId_produitReference(int id_produitReference) {
        this.id_produitReference = id_produitReference;
    }

    public int getQte_produit() {
        return qte_produit;
    }

    public void setQte_produit(int qte_produit) {
        this.qte_produit = qte_produit;
    }

    public float getMontantTransaction() {
        return montantTransaction;
    }

    public void setMontantTransaction(float montantTransaction) {
        this.montantTransaction = montantTransaction;
    }
}