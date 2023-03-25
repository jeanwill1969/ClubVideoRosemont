/*
Technique de développement de système - Implémentation Java Club Vidéo
Auteur : Jean-François Trudel
Date : Mars 2023
Description 1: Programme d'entrée du menu général Main.
Description 2: Simulation Commis ou Client.
Description 3: Connexion base de données MySQL Java JDBC MySQL.
 */

import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Créer une connexion à la base de données

        String url = "jdbc:mysql://localhost:3306/javavideo";
        String user = "root";
        String password = "";
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connexion réussie à la base de données.");
            // Demander à l'utilisateur son rôle
            Scanner scanner = new Scanner(System.in);
            System.out.println("Êtes-vous un client ou un employé ?");
            System.out.println("1 - Client");
            System.out.println("2 - Employé");
            int role = scanner.nextInt();

            // Vérifier le rôle de l'utilisateur et afficher le menu correspondant
            if (role == 1) {
                // Menu expérience client
                System.out.println("Menu expérience client :");
                System.out.println("1 - Ajouter un film à une location");

                int choix = scanner.nextInt();
                MembresDAO membresDAO = new MembresDAO(conn);
                FilmDAO filmDAO = new FilmDAO(conn);
                LocationDAO locationDAO = new LocationDAO(conn);

                switch (choix) {
                    case 1:
                        System.out.println("Entrez l'ID de la location :");
                        int locationId = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Entrez l'ID du film loué :");
                        int filmId = scanner.nextInt();
                        scanner.nextLine();
                        Locations_filmsDAO locations_filmsDAO = new Locations_filmsDAO(conn);

                        Locations_films location2 = new Locations_films(locationId, filmId);
                        locations_filmsDAO.create(location2);

                        System.out.println("La location a été modifiée !");
                        break;

                    default:
                        System.out.println("Choix invalide.");
                        break;
                }

            } else if (role == 2) {
                // Menu expérience employé
                System.out.println("Menu expérience employé :");
                System.out.println("1 - Ajouter un client / gestionnaire");
                System.out.println("2 - Ajouter un film au catalogue / commis");
                System.out.println("3 - Ajouter une location / client");
                System.out.println("4 - Liste des clients");
                System.out.println("5 - Liste des locations");
                System.out.println("6 - Liste des films au catalogue");

                int choix = scanner.nextInt();

                MembresDAO membresDAO = new MembresDAO(conn);
                FilmDAO filmDAO = new FilmDAO(conn);
                LocationDAO locationDAO = new LocationDAO(conn);

                switch (choix) {
                    case 1:
                        // Ajouter un client
                        scanner.nextLine();
                        System.out.print("Entrez le nom du client : ");
                        String nom = scanner.nextLine();
                        System.out.print("Entrez le prénom du client : ");
                        String prenom = scanner.nextLine();
                        System.out.print("Entrez l'adresse du client : ");
                        String adresse = scanner.nextLine();
                        System.out.print("Entrez l'email du client : ");
                        String email = scanner.nextLine();
                        System.out.print("Entrez le téléphone du client : ");
                        String telephone = scanner.nextLine();

                        Membres client = new Membres(nom, prenom, adresse, email, telephone);
                        membresDAO.ajouterClient(client);

                        System.out.println("Liste des clients dans la base de données :");
                        for (Membres c : membresDAO.getAllClients()) {
                            System.out.println(c.getNom() + " " + c.getPrenom());
                        }
                        break;

                    case 2:

                        // Ajouter un film au catalogue / commis
                        scanner.nextLine(); // Consommer le retour de ligne après le choix
                        System.out.print("Entrez le titre du film : ");
                        String titre = scanner.nextLine();
                        System.out.print("Entrez la durée du film en minutes : ");
                        int duree = scanner.nextInt();
                        scanner.nextLine(); // Consommer le retour de ligne après la saisie de l'entier
                        System.out.print("Entrez le genre du film : ");
                        String genre = scanner.nextLine();
                        System.out.print("Entrez le nom du réalisateur : ");
                        String realisateur = scanner.nextLine();
                        System.out.print("Entrez l'année de production du film : ");
                        int annee = scanner.nextInt();

                        // Créer un objet Film à partir des informations saisies
                        Film film = new Film(titre, duree, genre, realisateur, annee);

                        // Ajouter le film à la base de données en utilisant la classe FilmDAO
                        filmDAO.ajouterFilm(film);
                        break;

                    case 3:

                        // Ajouter une location / client

                        scanner.nextLine(); // Consommer le retour de ligne après le choix
                        System.out.print("Entrez l'ID du client : ");
                        int idClient = scanner.nextInt();
                        scanner.nextLine(); // Consommer le retour de ligne après la saisie de l'entier
                        System.out.print("Entrez la date d'emprunt (format AAAA-MM-JJ) : ");
                        LocalDate dateEmprunt = LocalDate.parse(scanner.nextLine());
                        System.out.print("Entrez la date de retour (format AAAA-MM-JJ) : ");
                        LocalDate dateRetour = LocalDate.parse(scanner.nextLine());

                        // Récupérer le client à partir de son ID en utilisant la classe ClientDAO

                        Membres client2 = membresDAO.getClientById(idClient);

                        // Créer un objet Location à partir des informations saisies et du client récupéré

                        Location location = new Location(client2, dateEmprunt, dateRetour);

                        // Ajouter la location à la base de données en utilisant la classe LocationDAO

                        try {
                            locationDAO.ajouterLocation(location);
                        } catch (SQLException e) {
                            System.out.println("Erreur lors de l'ajout de la location dans la base de données : " + e.getMessage());
                        }
                        break;

                    case 4:
                        // Afficher la liste des clients dans la base de données

                        List<Membres> membres = membresDAO.getAllClients();
                        System.out.println("Liste des clients dans la base de données :");
                        for (Membres c : membres) {
                            System.out.println(c.getId() + " - " + c.getNom() + " " + c.getPrenom());
                        }
                        break;

                    case 5:
                        // Lister les locations

                        System.out.println("Liste des locations dans la base de données :");
                      //  LocationDAO locationDAO = new LocationDAO(conn);
                        for (Location locations : locationDAO.getAllLocations()) {
                            System.out.println(locations);
                        }
                        break;

                    case 6:
                        // Liste de tous les films

                        System.out.println("Liste de tous les films :");
                        for (Film f : filmDAO.getAllFilms()) {
                            System.out.println(f.getId() + " - " + f.getTitre() + " (" + f.getDuree() + " min) - " + f.getRealisateur() + " - " + f.getanneeProduction());
                        }
                        break;

                }
            }

        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion à la base de données : " + e.getMessage());

        }
    }
}





