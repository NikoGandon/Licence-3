package observateur.javautil;

import java.util.Observable;
import java.util.Observer;

public class AffichageStats implements Observer {
    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float somTemp = 0.0f;
    private int nbrLecture;

    public AffichageStats(Observable observable) {
        observable.addObserver(this);
    }

    public void afficher() {

        System.out.println("Affichage Stats Temperature Moy/Max/Min= " + (somTemp / nbrLecture)
                + "/" + maxTemp + "/" + minTemp);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof DonneesMeteo) {
            DonneesMeteo donneesMeteo = (DonneesMeteo) o;
            float temperature = donneesMeteo.getTemperature();
            nbrLecture++;
            somTemp += ((DonneesMeteo) o).getTemperature();
            
            if (temperature > maxTemp) {
                maxTemp = temperature;
            }

            if (temperature < minTemp) {
                minTemp = temperature;
            }
        }
    }

}
