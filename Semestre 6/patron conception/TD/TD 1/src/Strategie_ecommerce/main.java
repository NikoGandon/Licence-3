package Strategie_ecommerce;

import Strategie_ecommerce.ComportementPaie.Article;
import Strategie_ecommerce.ComportementPaie.PaiementBancaire;
import Strategie_ecommerce.ComportementPaie.PaiementPaypal;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello world");

        Article article1 = new Article("Article 1", 10);
        Article article2 = new Article("Article 2", 20);

        article1.payer(new PaiementBancaire(123456789, 123, "12/12/2020"));

        article2.payer(new PaiementPaypal(123456789, "123"));

    }

}
