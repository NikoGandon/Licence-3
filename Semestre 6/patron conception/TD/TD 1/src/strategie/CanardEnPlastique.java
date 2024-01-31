package strategie;

import strategie.comportementCancan.CancanMuet;
import strategie.comportementVol.NePasVoler;

public class CanardEnPlastique extends Canard {
    public CanardEnPlastique() {
        comportementCancan = new CancanMuet();
        comportementVol = new NePasVoler();
    }
    public void afficher() {
        System.out.println("Je suis un canard en plastique");
    }
}
