package decorateur.boisson.decorateurImpl;

import decorateur.boisson.Boisson;

public class Chantilly extends Suplement {
    public Chantilly(Boisson b) {
        this.boisson = b;
    }

    public String getDescription() {
        return boisson.getDescription() + ", Chantilly";
    }

    public double getCout() {
        return .10 + boisson.getCout();
    }
}
