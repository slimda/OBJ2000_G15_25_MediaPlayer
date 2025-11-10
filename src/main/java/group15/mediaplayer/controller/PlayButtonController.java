package group15.mediaplayer.controller;

import group15.mediaplayer.service.FileService;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class PlayButtonController {
    public static void handlePlay() {
        PlayerController.mediaPlayer.play();
    }
}
