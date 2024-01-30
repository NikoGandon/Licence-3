package nonDir;

import java.util.Set;

public interface Graphe<T> {

    public Set<Noeud<T>> getNoeuds();
    public Noeud<T> getNoeud(T label);

    public int compterArcs();
    public int compterNoeuds();
    public int degreMax();
    
    public boolean ajouterNoeud(Noeud<T> v);
    public boolean supprimerNoeud(Noeud<T> v);
    public boolean ajouterArc(Noeud<T> v, Noeud<T> w);
    public boolean supprimerArc(Noeud<T> v, Noeud<T> w);

    // public boolean ajouterNoeud(T label);              Pas demandé
    // public boolean supprimerNoeud(T label);            Pas demandé
    // public boolean ajouterArc(T vLabel, T wLabel);     Pas demandé        
    // public boolean supprimerArc(T vLabel, T wLabel);   Pas demandé        

}
