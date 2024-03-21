package fabrique.jeu;

public class usineET {
    public static unite creerUnite(String type) {
        if (type.equals("soldatET")) {
            return new soldatET();
        } else if (type.equals("commandantET")) {
            return new commandantET();
        } else {
            return null;
        }
    }
}
