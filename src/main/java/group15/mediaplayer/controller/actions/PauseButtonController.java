package group15.mediaplayer.controller.actions;

import group15.mediaplayer.controller.PlayerController;

public class PauseButtonController {

    public static void handlePause() {
        PlayerController.mediaPlayer.pause();
    }
}
