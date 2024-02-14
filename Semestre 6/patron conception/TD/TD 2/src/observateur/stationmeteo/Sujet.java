package observateur.stationmeteo;

public interface Sujet {
    public void enregistrerObservateur(Observateur o);

    public void supprimerObservateur(Observateur o);

    public void notifierObservateurs();

    public float getTemperature();

    public float getHumidite();

    public float getPression();
}
