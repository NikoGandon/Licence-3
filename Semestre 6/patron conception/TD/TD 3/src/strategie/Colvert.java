package strategie;

import strategie.comportementCancan.Cancan;
import strategie.comportementVol.VolerAvecDesAiles;

public class Colvert extends Canard {
    public Colvert() {
        this.comportementCancan = new Cancan();
        this.comportementVol = new VolerAvecDesAiles();
    }
    public void afficher() {
        System.out.println("Je suis un Colvert");
    }
}
