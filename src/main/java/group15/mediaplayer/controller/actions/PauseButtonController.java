package group15.mediaplayer.controller.actions;

import group15.mediaplayer.controller.PlayerController;
import javafx.scene.media.MediaPlayer;

/**
 * Controller for the Pause button.
 * Provides a single static entry point used by the UI: handlePause().
 */
public class PauseButtonController {
    public static void handlePause() {
        MediaPlayer mp = PlayerController.mediaPlayer;
        if (mp != null) {
            mp.pause();
        }
    }
}
