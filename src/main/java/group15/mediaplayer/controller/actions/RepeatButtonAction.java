package group15.mediaplayer.controller.actions;

import group15.mediaplayer.controller.PlayerController;
import javafx.scene.media.MediaPlayer;

public class RepeatButtonAction {
    private static boolean repeat = false;
    public static void handle() {
        repeat = !repeat;
        System.out.println("Repeat: " + repeat);
        // Placeholder: actual repeat handling should be integrated with playlist/MediaPlayer
    }
}

