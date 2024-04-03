package mediaPlayer;

import mediaPlayer.MP4.MP4;
import mediaPlayer.MP4.adapteur;
import mediaPlayer.MP3.MP3;


public class simulateur {

    public static void main(String[] args) {
        MP3 mp3 = new MP3();
        adapteur adapteur = new adapteur(new MP4());
        adapteur.lire("file.mp4");
        mp3.lire("file.mp3");
    }
    
}
