import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MembresDAO {
    private Connection conn;

    public MembresDAO(Connection conn) {
        this.conn = conn;
    }

    public void ajouterClient(Membres membre) throws SQLException {
        // Créer une requête SQL pour ajouter le client dans la table "clients"
        String sql = "INSERT INTO membres (nom, prenom, adresse, email, telephone) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, membre.getNom());
        pstmt.setString(2, membre.getPrenom());
        pstmt.setString(3, membre.getAdresse());
        pstmt.setString(4, membre.getEmail());
        pstmt.setString(5, membre.getTelephone());

        // Exécuter la requête SQL pour ajouter le client
        int nbLignesAffectees = pstmt.executeUpdate();

        // Récupérer l'ID généré automatiquement pour le client
        ResultSet rs = pstmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            membre.setId(id);
        }

        System.out.println(nbLignesAffectees + " client(s) ajouté(s) à la base de données.");
    }


    public List<Membres> getAllClients() throws SQLException {
        // Créer une requête SQL pour récupérer tous les clients dans la table "clients"
        String sql = "SELECT * FROM membres";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // Exécuter la requête SQL pour récupérer tous les clients
        ResultSet rs = pstmt.executeQuery();

        // Parcourir les résultats de la requête SQL et créer une liste de clients
        List<Membres> membre = new ArrayList<>();
        while (rs.next()) {

            int id = rs.getInt("client_id");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            String adresse = rs.getString("adresse");
            String email = rs.getString("email");
            String telephone = rs.getString("telephone");
            Membres membres = new Membres(id, nom, prenom, adresse, email, telephone);
            membre.add(membres);
        }

        return membre;
    }

    public Membres getClientById(int id) throws SQLException {
        // Créer une requête SQL pour récupérer le client avec l'ID spécifié dans la table "clients"
        String sql = "SELECT * FROM membres WHERE client_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);

        // Exécuter la requête SQL pour récupérer le client avec l'ID spécifié
        ResultSet rs = pstmt.executeQuery();

        // Si un client est trouvé, créer un objet Client à partir des données de la base de données
        if (rs.next()) {
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            String adresse = rs.getString("adresse");
            String email = rs.getString("email");
            String telephone = rs.getString("telephone");
            Membres membre = new Membres(id, nom, prenom, adresse, email, telephone);
            return membre;
        } else {
            return null;
        }
    }
}