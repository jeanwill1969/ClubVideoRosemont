import java.time.LocalDate;

public class Location {

    private Membres client;

    private LocalDate dateEmprunt;
    private LocalDate dateRetour;

    public Location(Membres client, LocalDate dateEmprunt, LocalDate dateRetour) {
        this.client = client;
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
    }


    public Membres getClient() {
        return client;
    }

    public void setClient(Membres client) {
        this.client = client;
    }

    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(LocalDate dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public LocalDate getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(LocalDate dateRetour) {
        this.dateRetour = dateRetour;
    }
}
