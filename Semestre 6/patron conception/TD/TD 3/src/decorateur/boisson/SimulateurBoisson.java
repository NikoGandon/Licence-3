package decorateur.boisson;

public class SimulateurBoisson {

    public static void main(String[] args) {
        Boisson boisson = new Espresso();
    System.out.println(boisson.getDescription()+ " € "+ boisson.getCout());


    }


}
