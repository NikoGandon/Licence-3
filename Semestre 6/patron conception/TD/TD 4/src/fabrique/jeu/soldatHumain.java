package fabrique.jeu;

import java.util.ArrayList;

public class soldatHumain extends unite {
    public soldatHumain() {
        ArrayList<String> equipments = new ArrayList<String>();
        equipments.add("Pisotlet laser");
        equipments.add("Bouclier");

        creerUnite("Soldat humain",5, 1, 2, equipments);
    }

    public void afficher() {
        System.out.println("Je suis un soldat humain");
    }
}
