// MP4Player.java

public class MP4Player implements AdvancedMediaPlayer {
    @Override
    public void playVLC(String fileName) {
        // Do nothing
    }

    @Override
    public void playMP4(String fileName) {
        System.out.println("Playing MP4 file: " + fileName);
    }
}
