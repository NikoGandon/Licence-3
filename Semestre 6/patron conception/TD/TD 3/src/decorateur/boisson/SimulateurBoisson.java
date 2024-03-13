package decorateur.boisson;

import decorateur.boisson.decorateurImpl.Caramel;
import decorateur.boisson.decorateurImpl.Lait;

public class SimulateurBoisson {

    public static void main(String[] args) {
        Boisson boisson = new Espresso();
        System.out.println(boisson.getDescription() + " € " + boisson.getCout());
        new Lait(boisson);
        System.out.println(boisson.getDescription() + " € " + boisson.getCout());
        new Caramel(boisson);
        System.out.println(boisson.getDescription() + " € " + boisson.getCout());
    }
}
