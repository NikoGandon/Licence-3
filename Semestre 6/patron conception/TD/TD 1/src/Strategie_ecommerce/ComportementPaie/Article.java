package Strategie_ecommerce.ComportementPaie;

public class Article {

    private String nom;
    private int prix;

    public Article(String nom, int prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public void payer(PaiementStrategie paiementStrategie) {
        paiementStrategie.payer(prix);
    }

    public String getNom() {
        return nom;
    }

    public int getPrix() {
        return prix;
    }

}
