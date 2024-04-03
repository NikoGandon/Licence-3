package mediaPlayer.MP3;

public class MP3 implements MediaPlayerInterface{
    public MP3() {
    }

    public void lire(String fileName) {
        System.out.println("Lecture du fichier MP3 " + fileName);
    }
}
