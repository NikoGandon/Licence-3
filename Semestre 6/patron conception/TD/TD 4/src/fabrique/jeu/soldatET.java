package fabrique.jeu;

import java.util.ArrayList;

public class soldatET extends unite{
    public soldatET() {
        ArrayList<String> equipments = new ArrayList<String>();
        equipments.add("Acide");
        equipments.add("Peau");
        creerUnite("Alien", 6, 2, 1);
    }

    public void afficher() {
        System.out.println("Je suis un soldat ET");
    }
}
