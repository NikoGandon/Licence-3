package nonDir;

import java.io.BufferedReader;

public class GrapheLoader<T> {
    public static Graphe<String> chargerChaine(String chemin){

        String fichier = "src/nonDir/ressources/" + chemin;  
        
        Graphe graphe = new GrapheImpl();

        return graphe;

    }

    public static Graphe<Integer> chargerEntier(String chemin){
        return null; // TODO charger le fichier vers une structure Graphe du bon type
    }

    public boolean enregistrer(Graphe<T> g, String chemin){
        return false; //TODO
    }
}
