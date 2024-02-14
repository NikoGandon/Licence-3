package observateur.javautil;

import java.util.Observable;
import java.util.Observer;

public class AffichageConditions implements Observer {
    private float temperature;
    private float humidite;

    public AffichageConditions(Observable o) {
        o.addObserver(this);
    }

    public void afficher() {
        System.out.println("Affichage Conditions : " + temperature
                + " degrés C et " + humidite + " % d humidité");
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof DonneesMeteo) {
            DonneesMeteo donneesMeteo = (DonneesMeteo) o;
            this.temperature = donneesMeteo.getTemperature();
            this.humidite = donneesMeteo.getHumidite();
        }
        afficher();
    }
}
