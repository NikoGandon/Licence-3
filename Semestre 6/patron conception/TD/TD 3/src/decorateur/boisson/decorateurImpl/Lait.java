package decorateur.boisson.decorateurImpl;

import decorateur.boisson.Boisson;

public class Lait extends Suplement {
    Boisson boisson;

    public Lait(Boisson b) {
        this.boisson = b;
    }

    public String getDescription() {
        return boisson.getDescription() + ", Lait";
    }

    public double getCout() {
        return .10 + boisson.getCout();
    }

}
