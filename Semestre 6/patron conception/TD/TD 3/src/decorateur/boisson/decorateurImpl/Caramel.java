package decorateur.boisson.decorateurImpl;

import decorateur.boisson.Boisson;

/**
 * Caramel
 */
public class Caramel extends Suplement {

    public Caramel(Boisson b) {
        this.boisson = b;
    }

    public String getDescription() {
        return boisson.getDescription() + ", Caramel";
    }

    public double getCout() {
        return .15 + boisson.getCout();
    }

}