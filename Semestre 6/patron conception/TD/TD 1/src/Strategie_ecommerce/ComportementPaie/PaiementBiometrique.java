package Strategie_ecommerce.ComportementPaie;

/**
 * PaiementBiometrique
 */
public class PaiementBiometrique implements PaiementStrategie {

    String biometriqueInfo;
    public PaiementBiometrique(String biometriqueInfo){
        this.biometriqueInfo = biometriqueInfo;
    }

    public void payer(int montant){
        System.out.println("Paiement de " + montant + "€ par biometrie");
    }

}