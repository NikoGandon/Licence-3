package mediaPlayer.MP4;

public class VLC implements MediaPackageInterface {
    public VLC() {
    }

    public void readFichier(String fileName) {
        System.out.println("Lecture du fichier VLC " + fileName);
    }
}
