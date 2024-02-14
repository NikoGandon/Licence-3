package observateur.stationmeteo;

public class AffichagePrevisions implements Observateur {
    private float actuellePression = 29.92f;
    private float anciennePression;
    private Sujet donneesMeteo;

    public AffichagePrevisions(Sujet donneesMeteo) {
        this.donneesMeteo = donneesMeteo;

        anciennePression = actuellePression;
        actuellePression = donneesMeteo.getPression();
        afficher();

    }

    public void afficher() {

        System.out.print("Affichage previsions : ");
        if (actuellePression > anciennePression) {
            System.out.println("Amélioration de la météo");
        } else if (actuellePression == anciennePression) {
            System.out.println("Pas de changement");
        } else if (actuellePression < anciennePression) {
            System.out.println("Temps frais et pluvieux");
        }
    }

    @Override
    public void actualiser(float temperature, float humidite, float pression) {
        anciennePression = actuellePression;
        actuellePression = pression;
        afficher();
    }
}
