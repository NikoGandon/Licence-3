package observateur.javautil;

import java.util.ArrayList;
import java.util.Observable;

public class DonneesMeteo extends Observable {

    private float temperature;
    private float humidite;
    private float pression;

    public void notiferObservateurs() {
        setChanged();
        notifyObservers();
    }

    public void setMesures(float temperature, float humidite, float pression) {
        this.temperature = temperature;
        this.humidite = humidite;
        this.pression = pression;
        notiferObservateurs();
    }

    public float getHumidite() {
        return humidite;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getPression() {
        return pression;
    }

}
