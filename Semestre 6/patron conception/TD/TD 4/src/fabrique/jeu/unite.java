package fabrique.jeu;

import java.util.ArrayList;

public abstract class unite {
    private String nom;
    private int coutConstruction;
    private float attaque;
    private float defense;
    private ArrayList<String> equipments;

    public void creerUnite(String nom, int coutConstruction, float attaque, float defense) {
        this.nom = nom;
        this.coutConstruction = coutConstruction;
        this.attaque = attaque;
        this.defense = defense;
        this.equipments = new ArrayList<String>();
    }

    public void creerUnite(String nom, int coutConstruction, float attaque, float defense, ArrayList<String> equipments) {
        this.nom = nom;
        this.coutConstruction = coutConstruction;
        this.attaque = attaque;
        this.defense = defense;
        this.equipments = equipments;
    }

    public void equiper(String equipement) {
        this.equipments.add(equipement);
    }
}
