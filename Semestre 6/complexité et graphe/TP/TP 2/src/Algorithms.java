import nonDir.Graphe;
import nonDir.GrapheImpl;
import nonDir.Noeud;
import nonDir.NoeudImpl;
import utils.Pair;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Algorithms {

    public static <T> List<Noeud<T>> arbreProfondeur(Graphe<T> g, Noeud<T> depart) {

        List<Noeud<T>> noeuds = new ArrayList<>();

        Stack<Noeud<T>> pile = new Stack<>();

        pile.push(depart);

        while (!pile.isEmpty()) {
            Noeud<T> n = pile.peek();
            if (!noeuds.contains(n)) {
                pile.pop();
            }
            for (Noeud<T> voisin : n.getVoisins()) {
                if (!noeuds.contains(voisin)) {
                    pile.pop();
                    noeuds.add(voisin);
                    System.out.println(voisin.getLabel());
                    break;
                }
            }
        }

        return noeuds;
    }

    public static <T> List<Noeud<T>> arbreLargeur(Graphe<T> g, Noeud<T> depart) {
        List<Noeud<T>> noeuds = new ArrayList<>();

        Queue<Noeud<T>> F = new LinkedList<>();

        F.add(depart);

        System.out.println(depart.getLabel());

        while (!F.isEmpty()) {
            Noeud<T> n = F.poll();
            for (Noeud<T> voisin : n.getVoisins()) {
                if (!noeuds.contains(voisin)) {
                    F.add(voisin);
                    noeuds.add(voisin);
                    System.out.println(voisin.getLabel());
                }
            }
        }

        return noeuds;
    }

    public static <T> List<Set<Noeud<T>>> composantesConnexes(Graphe<T> g) {
        List<Set<Noeud<T>>> composantes = new ArrayList<>();
    
        Set<Noeud<T>> ensemble = new HashSet<>();
        Set<Noeud<T>> visite = new HashSet<>();
        Set<Noeud<T>> noeuds = g.getNoeuds();

        for (Noeud<T> noeud : noeuds) {
            if (!visite.contains(noeud)){
                ensemble = new HashSet<>(arbreLargeur(g, noeud));
                for (Noeud<T> noeudAMarquer : ensemble){
                    visite.add(noeudAMarquer);
                }
                composantes.add(ensemble);
            }
        }
        return composantes;
    }

    /**
     * Produit une coupe aléatoire par fusion successive de nœuds
     * 
     * @param g   le graphe à couper
     * @param <T> Type des labels du graphe
     * @return une paire contenant l'ensemble S et le nombre d'arcs coupés
     */
    public static <T> Pair<Set<Noeud<T>>, Integer> coupeAlea(Graphe<T> g) {
        Set<Noeud<T>> S = new HashSet<>();
        int nbArcs = 0;


        

        return new Pair<>(S, nbArcs);
    }
}