package fabrique.jeu;

public class usineHumain {
    public static unite creerUnite(String type) {
        if (type.equals("soldatHumain")) {
            return new soldatHumain();
        } else if (type.equals("commandantHumain")) {
            return new commandantHumain();
        } else {
            return null;
        }
    }
}
