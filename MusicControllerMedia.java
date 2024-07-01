import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicControllerMedia {

    private static MediaPlayer mediaPlayer;

    static {
        Media backGroundMusic = new Media(new File("Sound/BackGroundMusic.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(backGroundMusic);
    }

    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public static void playMedia() {
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    public static void pauseMedia() {
        mediaPlayer.pause();
    }
}

