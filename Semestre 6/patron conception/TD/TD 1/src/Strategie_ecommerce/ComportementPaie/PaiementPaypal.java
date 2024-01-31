package Strategie_ecommerce.ComportementPaie;

public class PaiementPaypal implements PaiementStrategie{
    protected int id;
    protected String mdp;

    public PaiementPaypal(int id, String mdp) {
        this.id = id;
        this.mdp = mdp;
    }

    public void payer(int montant) {
        System.out.println("Paiement de " + montant + "€ par Paypal");
    }
}
