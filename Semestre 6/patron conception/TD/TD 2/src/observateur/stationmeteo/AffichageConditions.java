package observateur.stationmeteo;

public class AffichageConditions implements Observateur {
    private float temperature;
    private float humidite;
    private Sujet donneesMeteo;

    public AffichageConditions(Sujet donneesMeteo) {
        this.donneesMeteo = donneesMeteo;

        this.temperature = temperature;
        this.humidite = humidite;

        afficher();

    }

    public void afficher() {
        System.out.println("Affichage Conditions : " + temperature
                + " degrés C et " + humidite + " % d humidité");
    }

    @Override
    public void actualiser(float temperature, float humidite, float pression) {
        this.temperature = temperature;
        this.humidite = humidite;
        afficher();
    }

}
