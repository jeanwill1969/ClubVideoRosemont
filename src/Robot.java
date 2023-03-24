
public class Robot {
    private int id_numeroRobot;
    private String fournisseur;
    private String modele;
    private String noSerie;
    private String garantie;
    private String interfaceServeur;
    private String telephoneSupport;

    public Robot(int id_numeroRobot, String fournisseur, String modele, String noSerie, String garantie, String interfaceServeur, String telephoneSupport) {
        this.id_numeroRobot = id_numeroRobot;
        this.fournisseur = fournisseur;
        this.modele = modele;
        this.noSerie = noSerie;
        this.garantie = garantie;
        this.interfaceServeur = interfaceServeur;
        this.telephoneSupport = telephoneSupport;
    }

    public int getId_numeroRobot() {
        return id_numeroRobot;
    }

    public void setId_numeroRobot(int id_numeroRobot) {
        this.id_numeroRobot = id_numeroRobot;
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getNoSerie() {
        return noSerie;
    }

    public void setNoSerie(String noSerie) {
        this.noSerie = noSerie;
    }

    public String getGarantie() {
        return garantie;
    }

    public void setGarantie(String garantie) {
        this.garantie = garantie;
    }

    public String getInterfaceServeur() {
        return interfaceServeur;
    }

    public void setInterfaceServeur(String interfaceServeur) {
        this.interfaceServeur = interfaceServeur;
    }

    public String getTelephoneSupport() {
        return telephoneSupport;
    }

    public void setTelephoneSupport(String telephoneSupport) {
        this.telephoneSupport = telephoneSupport;
    }
}
