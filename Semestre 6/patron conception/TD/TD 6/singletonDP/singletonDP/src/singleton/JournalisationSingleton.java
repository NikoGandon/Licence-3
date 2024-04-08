package singleton;

public class JournalisationSingleton {
    private static JournalisationSingleton instance = null;
    private String journal = "";

    private JournalisationSingleton() {
    }

    public static JournalisationSingleton getInstance() {
        if (instance == null) {
            instance = new JournalisationSingleton();
        }
        return instance;
    }

    public void ajouterJournal(String message) {
        String date = new java.util.Date().toString();
        journal += date + ": " + message + "\n";
    }

    public String terminerJournal() {
        return journal;
    }
}
