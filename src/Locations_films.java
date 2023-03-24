public class Locations_films {
    private int locationId;
    private int filmId;

    public Locations_films(int locationId, int filmId) {
        this.locationId = locationId;
        this.filmId = filmId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }
}
