package observateur.stationmeteo;

import java.util.ArrayList;
import java.util.List;

public class DonneesMeteo implements Sujet {
    private List<Observateur> observateurs = new ArrayList();
    private float temperature;
    private float humidite;
    private float pression;

    public void setMesures(float temperature, float humidite, float pression) {
        this.temperature = temperature;
        this.humidite = humidite;
        this.pression = pression;
        notifierObservateurs();
    }

    @Override
    public void enregistrerObservateur(Observateur o) {
        try {
            observateurs.add(o);
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }

    @Override
    public void supprimerObservateur(Observateur o) {
        try {
            observateurs.remove(o);
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }

    @Override
    public void notifierObservateurs() {
        for (Observateur observateur : observateurs) {
            observateur.actualiser(temperature, humidite, pression);
        }
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidite() {
        return humidite;
    }

    public float getPression() {
        return pression;
    }

}
