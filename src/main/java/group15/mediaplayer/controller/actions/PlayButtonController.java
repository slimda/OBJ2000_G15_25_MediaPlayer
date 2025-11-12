package group15.mediaplayer.controller.actions;

import group15.mediaplayer.controller.PlayerController;
import javafx.scene.media.MediaPlayer;

public class PlayButtonController {
    public static void handle() {
        MediaPlayer mp = PlayerController.mediaPlayer;
        if (mp != null) mp.play();
    }
}

/*if (mediaPlayer == null) {
mediaPlayer = playbackService.createMediaPlayerForCurrent();
            if (mediaPlayer == null) return;
        VolumeSliderController.configureVolumeSlider(volumeSlider, mediaPlayer);
        }
                mediaPlayer.play();

 */