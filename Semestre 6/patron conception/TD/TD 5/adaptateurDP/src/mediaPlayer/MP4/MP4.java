package mediaPlayer.MP4;

public class MP4 implements MediaPackageInterface{
    public MP4() {
    }

    public void readFichier(String fileName) {
        System.out.println("Lecture du fichier MP4 " + fileName);
    }
}
