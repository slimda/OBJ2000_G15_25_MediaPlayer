package group15.mediaplayer.controller.actions;

import group15.mediaplayer.controller.PlayerController;
import javafx.scene.media.MediaPlayer;

public class ShuffleButtonAction {
    private static boolean shuffle = false;
    public static void handle() {
        shuffle = !shuffle;
        // Placeholder: toggling shuffle state; actual playlist logic to be added
        System.out.println("Shuffle: " + shuffle);
    }
}

