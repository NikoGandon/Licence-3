package mediaPlayer.MP4;

public class adapteur implements mediaPlayer.MP3.MediaPlayerInterface{
    private MediaPackageInterface mediaPackage;

    public adapteur(MediaPackageInterface mediaPackage) {
        this.mediaPackage = mediaPackage;
    }

    public void lire(String fileName) {
        mediaPackage.readFichier(fileName);
    }
}
