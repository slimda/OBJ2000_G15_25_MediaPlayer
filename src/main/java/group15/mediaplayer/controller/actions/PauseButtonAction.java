package group15.mediaplayer.controller.actions;

import group15.mediaplayer.controller.PlayerController;
import javafx.scene.media.MediaPlayer;

public class PauseButtonAction {
    public static void handle() {
        MediaPlayer mp = PlayerController.mediaPlayer;
        if (mp != null) {
            mp.pause();
        }
    }
}

