package strategie;

import strategie.comportementCancan.Cancan;
import strategie.comportementCancan.CancanMuet;
import strategie.comportementVol.NePasVoler;
import strategie.comportementVol.VolerAvecDesAiles;

public class Leurre extends Canard{
    public Leurre() {
        comportementCancan = new CancanMuet();
        comportementVol = new NePasVoler();
    }
    public void afficher() {
        System.out.println("Je suis un leurre");
        voler();
        cancaner();
    }   
}
