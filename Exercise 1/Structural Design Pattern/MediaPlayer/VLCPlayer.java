// VLCPlayer.java

public class VLCPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVLC(String fileName) {
        System.out.println("Playing VLC file: " + fileName);
    }

    @Override
    public void playMP4(String fileName) {
        // Do nothing
    }
}
