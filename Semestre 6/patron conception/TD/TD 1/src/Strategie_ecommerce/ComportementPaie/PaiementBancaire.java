package Strategie_ecommerce.ComportementPaie;

public class PaiementBancaire implements PaiementStrategie{

    protected int numCarte;
    protected int codeSecret;
    protected String dateExpiration;

    public PaiementBancaire(int numCarte, int codeSecret, String dateExpiration) {
        this.numCarte = numCarte;
        this.codeSecret = codeSecret;
        this.dateExpiration = dateExpiration;
    }

    public void payer(int montant) {
        System.out.println("Paiement de " + montant + "€ par carte bancaire");
    }
}

