import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Locations_filmsDAO {
    private Connection conn;

    public Locations_filmsDAO(Connection conn) {
        this.conn = conn;
    }

    public void create(Locations_films location) throws SQLException {
        String sql = "INSERT INTO locations_films (location_id, film_id) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, location.getLocationId());
            pstmt.setInt(2, location.getFilmId());
            pstmt.executeUpdate();
        }
    }

    public Locations_films read(int locationId) throws SQLException {
        String sql = "SELECT * FROM locations_films WHERE location_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, locationId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int filmId = rs.getInt("film_id");
                    return new Locations_films(locationId, filmId);
                } else {
                    return null;
                }
            }
        }
    }

    public void update(Locations_films location) throws SQLException {
        String sql = "UPDATE locations_films SET film_id = ? WHERE location_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, location.getFilmId());
            pstmt.setInt(2, location.getLocationId());
            pstmt.executeUpdate();
        }
    }

    public void delete(int locationId) throws SQLException {
        String sql = "DELETE FROM locations_films WHERE location_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, locationId);
            pstmt.executeUpdate();
        }
    }
}
