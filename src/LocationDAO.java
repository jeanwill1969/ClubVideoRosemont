import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LocationDAO {
    private Connection conn;

    public LocationDAO(Connection conn) {
        this.conn = conn;
    }

    public void ajouterLocation(Location location) throws SQLException {
        // Créer une requête SQL pour ajouter la location dans la table "locations"
        String sql = "INSERT INTO locations (client_id, date_emprunt, date_retour) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setInt(1, location.getClient().getId());
        pstmt.setDate(2, Date.valueOf(location.getDateEmprunt()));
        pstmt.setDate(3, Date.valueOf(location.getDateRetour()));

        // Exécuter la requête SQL pour ajouter la location
        int nbLignesAffectees = pstmt.executeUpdate();

        // Récupérer l'ID généré automatiquement pour la location
        ResultSet rs = pstmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            System.out.println(nbLignesAffectees + " location(s) ajoutée(s) à la base de données. ID de la location : " + id);
        }
    }
}

