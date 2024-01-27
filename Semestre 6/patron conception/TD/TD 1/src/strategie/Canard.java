package strategie;

import strategie.comportementCancan.ComportementCancan;
import strategie.comportementVol.ComportementVol;

public abstract class Canard implements ComportementVol, ComportementCancan{


    public Canard() {
    }

    public abstract void afficher();


    public void nager() {
    }

    public abstract void voler();
    public abstract void cancaner();
}
