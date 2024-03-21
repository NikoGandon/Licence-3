package fabrique.jeu;

import java.util.ArrayList;

public class commandantET extends unite {
    public commandantET() {
        ArrayList<String> equipments = new ArrayList<String>();
        equipments.add("Mitraillette à plasma");
        equipments.add("Peau");
        creerUnite("Predateur", 10, 3, 3, equipments);
    }

    public void afficher() {
        System.out.println("Je suis un commandant ET");
    }
}
