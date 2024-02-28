package decorateur.boisson.decorateurImpl;

import decorateur.boisson.Boisson;

public class Suplement {
    Boisson boisson;

    public String getDescription() {
        return boisson.getDescription();
    }

    public double getCout() {
        return boisson.getCout();
    }
}
