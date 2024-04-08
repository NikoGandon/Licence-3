package singleton;

import fabrique.canard.FabriqueDeCanards;
import fabrique.canard.FabriqueDeCanardsAbstraite;
import strategie.CanardInterface;


public class SimulateurCanardSingleton {

    public static void main(String[] args) {

        FabriqueDeCanardsAbstraite fabriqueDeCanards = new FabriqueDeCanards();


        CanardInterface colvert1 = fabriqueDeCanards.creerCanard("colvert");
        colvert1.afficher();
        JournalisationSingleton.getInstance().ajouterJournal("Colvert 1 créé");
        
        
        CanardInterface colvert2 =  fabriqueDeCanards.creerCanard("colvert");
        colvert2.afficher();
        JournalisationSingleton.getInstance().ajouterJournal("Colvert 2 créé");
        
        
        CanardInterface canardEnPlastique = fabriqueDeCanards.creerCanard("canardEnPlastique");
        canardEnPlastique.afficher();
        JournalisationSingleton.getInstance().ajouterJournal("Canard en plastique créé");

        System.out.println(JournalisationSingleton.getInstance().terminerJournal());


    }
}
