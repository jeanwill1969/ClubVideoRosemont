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

    public void ajouterClient(Membres client) throws SQLException {
        // Créer une requête SQL pour ajouter le client dans la table "clients"
        String sql = "INSERT INTO clients (nom, prenom, adresse, email, telephone) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, client.getNom());
        pstmt.setString(2, client.getPrenom());
        pstmt.setString(3, client.getAdresse());
        pstmt.setString(4, client.getEmail());
        pstmt.setString(5, client.getTelephone());

        // Exécuter la requête SQL pour ajouter le client
        int nbLignesAffectees = pstmt.executeUpdate();

        // Récupérer l'ID généré automatiquement pour le client
        ResultSet rs = pstmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            client.setId(id);
        }

        System.out.println(nbLignesAffectees + " client(s) ajouté(s) à la base de données.");
    }

    public void modifierClient(Membres client) throws SQLException {
        // Créer une requête SQL pour modifier le client dans la table "clients"
        String sql = "UPDATE clients SET nom = ?, prenom = ?, adresse = ?, email = ?, telephone = ? WHERE client_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, client.getNom());
        pstmt.setString(2, client.getPrenom());
        pstmt.setString(3, client.getAdresse());
        pstmt.setString(4, client.getEmail());
        pstmt.setString(5, client.getTelephone());
        pstmt.setInt(6, client.getId());

        // Exécuter la requête SQL pour modifier le client
        int nbLignesAffectees = pstmt.executeUpdate();

        System.out.println(nbLignesAffectees + " client(s) modifié(s) dans la base de données.");
    }

    public void supprimerClient(int id) throws SQLException {
        // Créer une requête SQL pour supprimer le client dans la table "clients"
        String sql = "DELETE FROM clients WHERE client_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);

        // Exécuter la requête SQL pour supprimer le client
        int nbLignesAffectees = pstmt.executeUpdate();

        System.out.println(nbLignesAffectees + " client(s) supprimé(s) de la base de données.");
    }

    public List<Membres> getAllClients() throws SQLException {
        // Créer une requête SQL pour récupérer tous les clients dans la table "clients"
        String sql = "SELECT * FROM clients";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // Exécuter la requête SQL pour récupérer tous les clients
        ResultSet rs = pstmt.executeQuery();

        // Parcourir les résultats de la requête SQL et créer une liste de clients
        List<Membres> clients = new ArrayList<>();
        while (rs.next()) {

            int id = rs.getInt("client_id");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            String adresse = rs.getString("adresse");
            String email = rs.getString("email");
            String telephone = rs.getString("telephone");
            Membres client = new Membres(id, nom, prenom, adresse, email, telephone);
            clients.add(client);
        }

        return clients;
    }

    public Membres getClientById(int id) throws SQLException {
        // Créer une requête SQL pour récupérer le client avec l'ID spécifié dans la table "clients"
        String sql = "SELECT * FROM clients WHERE client_id = ?";
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
            Membres client = new Membres(id, nom, prenom, adresse, email, telephone);
            return client;
        } else {
            return null;
        }
    }
}