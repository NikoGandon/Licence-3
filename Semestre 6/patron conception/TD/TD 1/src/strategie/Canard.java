package strategie;

import strategie.comportementCancan.ComportementCancan;
import strategie.comportementVol.ComportementVol;

public abstract class Canard implements ComportementVol, ComportementCancan{

    protected ComportementVol comportementVol;
    protected ComportementCancan comportementCancan;

    public Canard() {
    }

    public abstract void afficher();


    public void nager() {
    }

    public void voler(){
        comportementVol.voler();
    }
    public void cancaner(){
        comportementCancan.cancaner();
    }

    public void changerComportementVol(ComportementVol cv){
        comportementVol = cv;
    }

    public void changerComportementCancan(ComportementCancan cc){
        comportementCancan = cc;
    }
}
