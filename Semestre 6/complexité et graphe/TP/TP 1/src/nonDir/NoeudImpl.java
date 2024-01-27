package nonDir;

public class NoeudImpl<T> extends Noeud<T>{


    public NoeudImpl(T label) {
        super(label);
    }

    @Override
    public int degre(){
        return voisins.size();
    }

    public String toString(){
        return label.toString() + " : " + voisins.toString();
    }


}
