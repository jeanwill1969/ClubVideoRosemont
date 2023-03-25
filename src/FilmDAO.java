import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO {
    private Connection conn;

    public FilmDAO(Connection conn) {
        this.conn = conn;
    }

    public void ajouterFilm(Film film) throws SQLException {
        // Créer une requête SQL paramétrée pour ajouter un nouveau film dans la table "films"
        String sql = "INSERT INTO films (titre, duree, genre, realisateur, anneeProduction) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, film.getTitre());
        pstmt.setInt(2, film.getDuree());
        pstmt.setString(3, film.getGenre());
        pstmt.setString(4, film.getRealisateur());
        pstmt.setInt(5, film.getanneeProduction());

        // Exécuter la requête SQL pour ajouter le film et récupérer les clés générées
        int nbLignesAffectees = pstmt.executeUpdate();
        ResultSet rs = pstmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            film.setId(id);
        }

        System.out.println("Le film a été ajouté à la base de données.");

    }


    public Film getFilmById(int id) throws SQLException {
        // Créer une requête SQL paramétrée pour récupérer un film par son ID
        String sql = "SELECT * FROM films WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);

        // Exécuter la requête SQL et récupérer le film correspondant
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            String titre = rs.getString("titre");
            int duree = rs.getInt("duree");
            String genre = rs.getString("genre");
            String realisateur = rs.getString("realisateur");
            int anneeProduction = rs.getInt("anneeProduction");
            Film film = new Film(titre, duree, genre, realisateur, anneeProduction);
            film.setId(id);
            return film;
        }
        return null;
    }

    public List<Film> getAllFilms() throws SQLException {
        List<Film> films = new ArrayList<>();
        // Créer une requête SQL pour récupérer tous les films de la table "films"
        String sql = "SELECT * FROM films";
        Statement stmt = conn.createStatement();

        // Exécuter la requête SQL et parcourir les résultats pour créer les objets Film correspondants
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            int film_id = rs.getInt("film_id");
            String titre = rs.getString("titre");
            int duree = rs.getInt("duree");
            String genre = rs.getString("genre");
            String realisateur = rs.getString("realisateur");
            int anneeProduction = rs.getInt("anneeProduction");
            Film film = new Film(titre, duree, genre, realisateur, anneeProduction);
            film.setId(film_id);
            films.add(film);
        }

        return films;
    }

}

