package observateur.javautil;

import java.util.Observable;
import java.util.Observer;

public class AffichagePrevisions implements Observer {
    private float actuellePression = 29.92f;
    private float anciennePression;

    public AffichagePrevisions(Observable o) {
        o.addObserver((Observer) this);
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
    public void update(Observable o, Object arg) {
        if (o instanceof DonneesMeteo) {
            anciennePression = actuellePression;
            actuellePression = ((DonneesMeteo) o).getPression();
        }
        afficher();
    }

}
