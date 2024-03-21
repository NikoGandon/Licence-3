package fabrique.jeu;

public abstract class usine {
    public static unite creerUnite(String type) {
        if (type.equals("soldatHumain")) {
            return new soldatHumain();
        } else if (type.equals("commandantHumain")) {
            return new commandantHumain();
        } else if (type.equals("soldatET")) {
            return new soldatET();
        } else if (type.equals("commandantET")) {
            return new commandantET();
        } else {
            return null;
        }
    }
}