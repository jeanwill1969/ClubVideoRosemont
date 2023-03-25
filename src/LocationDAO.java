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

    public List<Location> getAllLocations() throws SQLException {
        // Créer une requête SQL pour récupérer toutes les locations dans la table "locations"
        String sql = "SELECT * FROM locations";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // Exécuter la requête SQL pour récupérer toutes les locations
        ResultSet rs = pstmt.executeQuery();

        // Parcourir les résultats de la requête SQL et créer une liste de locations
        List<Location> locations = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("location_id");
            int clientId = rs.getInt("client_id");
            LocalDate dateEmprunt = rs.getDate("date_emprunt").toLocalDate();
            LocalDate dateRetour = rs.getDate("date_retour").toLocalDate();

            // Récupérer le client associé à la location
            MembresDAO membresDAO = new MembresDAO(conn);
            Membres client = membresDAO.getClientById(clientId);

            // Créer un objet Location à partir des données de la base de données
            Location location = new Location(client, dateEmprunt, dateRetour);
            locations.add(location);
        }

        return locations;

    }

}