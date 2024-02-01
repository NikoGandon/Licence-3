package nonDir;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GrapheLoader<T> {

    public static Graphe<String> chargerChaine(String chemin) {

        Graphe<String> graphe = new GrapheImpl<String>();

        try (Scanner scanner = new Scanner(new File(chemin))) {
            while (scanner.hasNextLine()) {
                String ligne = scanner.nextLine();
                String[] etiquettes = ligne.split("\t");

                if (etiquettes.length == 2) {
                    Noeud<String> noeud1 = graphe.getNoeud(etiquettes[0]);
                    Noeud<String> noeud2 = graphe.getNoeud(etiquettes[1]);

                    if (noeud1 == null) {
                        noeud1 = new NoeudImpl<>(etiquettes[0]);
                        graphe.ajouterNoeud(noeud1);
                    }

                    if (noeud2 == null) {
                        noeud2 = new NoeudImpl<>(etiquettes[1]);
                        graphe.ajouterNoeud(noeud2);
                    }

                    graphe.ajouterArc(noeud1, noeud2);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();    
        }
        return graphe;
    }

    public static Graphe<Integer> chargerEntier(String chemin) {
        Graphe<Integer> graphe = new GrapheImpl<Integer>();
        try (Scanner scanner = new Scanner(new File(chemin))) {
            while (scanner.hasNextLine()) {
                String ligne = scanner.nextLine();
                String[] etiquettes = ligne.split("\t");

                if (etiquettes.length == 2) {
                    int label1 = Integer.parseInt(etiquettes[0]);
                    int label2 = Integer.parseInt(etiquettes[1]);

                    Noeud<Integer> noeud1 = graphe.getNoeud(label1);
                    Noeud<Integer> noeud2 = graphe.getNoeud(label2);

                    if (noeud1 == null) {
                        noeud1 = new NoeudImpl<>(label1);
                        graphe.ajouterNoeud(noeud1);
                    }

                    if (noeud2 == null) {
                        noeud2 = new NoeudImpl<>(label2);
                        graphe.ajouterNoeud(noeud2);
                    }

                    graphe.ajouterArc(noeud1, noeud2);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return graphe;
    }

    public static boolean enregistrer(Graphe<?> g, String chemin) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(chemin))) {
            for (Noeud<?> noeud : g.getNoeuds()) {
                for (Noeud<?> voisin : noeud.getVoisins()) {
                    writer.write(noeud.getLabel() + "\t" + voisin.getLabel());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
