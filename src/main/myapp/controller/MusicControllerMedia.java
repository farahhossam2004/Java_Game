package src.main.myapp.controller;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicControllerMedia {

    private static MediaPlayer mediaPlayer;

    static {
        String path = MusicControllerMedia.class.getResource("/src/main/resources/Sound/BackGroundMusic.mp3").toString();
        Media backGroundMusic = new Media(path);
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

