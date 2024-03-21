package fabrique.jeu;

import java.util.ArrayList;

public class commandantHumain extends unite {
    commandantHumain(){
        ArrayList<String> equipments = new ArrayList<String>();
        equipments.add("Pistolet mitrailleur");
        equipments.add("Bouclier");

        creerUnite("Lieutenant", 14, 5, 2, equipments);
    }
}
