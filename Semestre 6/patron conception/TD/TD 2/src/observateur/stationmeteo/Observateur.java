package observateur.stationmeteo;

public interface Observateur {

    public void actualiser(float temperature, float humidite, float pression);

    public void afficher();

}
