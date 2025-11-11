package group15.mediaplayer.controller.actions;

import group15.mediaplayer.controller.PlayerController;
import javafx.scene.media.MediaPlayer;

public class PreviousButtonAction {
    public static void handle() {
        // Placeholder: implement playlist logic later
        MediaPlayer mp = PlayerController.mediaPlayer;
        if (mp != null) {
            mp.stop();
            mp.play();
        }
    }
}

