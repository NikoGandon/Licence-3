package decorateur.DecorateurCanard;


import strategie.Canard;
import strategie.CanardEnPlastique;
import strategie.Colvert;

public class SimulateurCanardDecorateur {

    public static  void main(String[] args){
        Canard colvert;
        Canard canardEnPlastique;

        System.out.println("Avant mise en place de decorateur made in");
        colvert= new Colvert();
        colvert.afficher();

        canardEnPlastique=new CanardEnPlastique();
        canardEnPlastique.afficher();

        System.out.println();
        System.out.println("Apres mise en place de decorateur made in");
        //todo


    }
}
