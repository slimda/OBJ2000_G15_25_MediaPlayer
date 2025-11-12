package group15.mediaplayer.controller.actions;

import group15.mediaplayer.controller.PlayerController;
import javafx.scene.media.MediaPlayer;


public class StopButtonController {
    public static void handle() {
        MediaPlayer mediaPlayer = PlayerController.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }
}

