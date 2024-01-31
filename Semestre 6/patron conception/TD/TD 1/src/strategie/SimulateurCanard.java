package strategie;

import strategie.Leurre;
import strategie.comportementVol.VolerAvecUnReacteur;

public class SimulateurCanard {

    public static void main(String[] args) {
        Leurre leurre = new Leurre();

        leurre.afficher();
        leurre.voler();
        leurre.cancaner();

        CanardEnPlastique canardEnPlastique = new CanardEnPlastique();

        canardEnPlastique.afficher();
        canardEnPlastique.voler();
        canardEnPlastique.changerComportementVol(new VolerAvecUnReacteur());
        canardEnPlastique.voler();
        canardEnPlastique.cancaner();

        Mandarin mandarin = new Mandarin();

        mandarin.afficher();
        
    }
}
