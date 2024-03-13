import nonDir.*;
import nonDir.*;

public class TP1 {
    public static void main(String[] args) {
        // Graphe<String> graphe = new GrapheImpl<String>();
        Graphe<String> graphe = GrapheLoader.chargerChaine("./data/test_parcours.graphe");

        // Noeud<String> noeud1 = new NoeudImpl<String>("A");
        // Noeud<String> noeud2 = new NoeudImpl<String>("B");
        // Noeud<String> noeud3 = new NoeudImpl<String>("C");
        // Noeud<String> noeud4 = new NoeudImpl<String>("D");
// 
        // graphe.ajouterNoeud(noeud1);
        // graphe.ajouterNoeud(noeud2);
        // graphe.ajouterNoeud(noeud3);
        // graphe.ajouterNoeud(noeud4);
// 
        // graphe.ajouterArc(noeud1, noeud2);
        // graphe.ajouterArc(noeud1, noeud3);
        // graphe.ajouterArc(noeud1, noeud4);
        // graphe.ajouterArc(noeud2, noeud3);
        // graphe.ajouterArc(noeud2, noeud4);
// 

        // System.out.println("Nombre de noeuds : " + graphe.compterNoeuds());
        // System.out.println("Nombre d'arcs : " + graphe.compterArcs());
        // System.out.println("Degré max : " + graphe.degreMax());

        // GrapheLoader.enregistrer(graphe, "./data/here.graphe");

        Algorithms a = new Algorithms();
        // a.arbreLargeur(graphe, graphe.getNoeud("1"));
        Noeud<String> noeud1 = graphe.getNoeud("1");
        System.out.println(noeud1.getLabel());
        // a.arbreProfondeur(graphe, graphe.getNoeud("1"));
    }
}
