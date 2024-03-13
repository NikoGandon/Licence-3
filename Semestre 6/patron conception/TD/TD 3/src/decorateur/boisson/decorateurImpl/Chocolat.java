package decorateur.boisson.decorateurImpl;

import decorateur.boisson.Boisson;

public class Chocolat extends Suplement {
    public Chocolat(Boisson b) {
        this.boisson = b;
    }

    public String getDescription() {
        return boisson.getDescription() + ", Chocolat";
    }

    public double getCout() {
        return .20 + boisson.getCout();
    }
}
