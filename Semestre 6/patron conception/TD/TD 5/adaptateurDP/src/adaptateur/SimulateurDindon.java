package adaptateur;

import strategie.CanardInterface;

public class SimulateurDindon {

    public static void main(String[] args) {
        Dindon dindon = new DindonSauvage();
        CanardInterface dindonAdapte = new DindonAdapte(dindon);
        System.out.println("Le dindon dit...");
        dindon.glouglouter();
        dindon.voler();
        System.out.println("Le canard dit...");
        dindonAdapte.effectuerCancan();
        dindonAdapte.effectuerVol();
    }
}