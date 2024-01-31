package nonDir;

import java.util.HashSet;

public class NoeudImpl<T> extends Noeud<T> {

    public NoeudImpl(T label) {
        super(label);
        this.voisins = new HashSet<>();
    }

    @Override
    public int degre() {
        return voisins.size();
    }

    public String toString() {
        return label.toString() + " : Voisins " + voisins.toString();
    }

}
