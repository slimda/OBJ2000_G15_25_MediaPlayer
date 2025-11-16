package group15.mediaplayer.controller;

import javafx.scene.control.Slider;
import javafx.scene.media.MediaPlayer;

/**
 * Purpose: Manages a volume slider UI component.
 * Role: Allows users to adjust the media player's volume and displays the current volume level.
 */
public class VolumeSliderController {

    // Setter opp slider og kobler den til MediaPlayer
    public static void configureVolumeSlider(Slider volumeSlider, MediaPlayer mediaPlayer) {
        if (volumeSlider == null || mediaPlayer == null) return;

        volumeSlider.setMin(0);
        volumeSlider.setMax(100);
        volumeSlider.setValue(50);
        volumeSlider.setShowTickLabels(true);
        volumeSlider.setShowTickMarks(true);
        volumeSlider.setMajorTickUnit(10);
        volumeSlider.setMinorTickCount(5);
        volumeSlider.setSnapToTicks(true);

        // Oppdaterer volum når slider endres
        volumeSlider.valueProperty().addListener((observable, oldVal, newVal) -> {
            mediaPlayer.setVolume(newVal.doubleValue() / 100.0);
        });

        // Setter initialt volum
        mediaPlayer.setVolume(volumeSlider.getValue() / 100.0);
    }

    // Setter volum direkte til 50%
    public static void handleVolume(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(0.5);
        }
    }

    // Toggle equalizer-like behavior: here we toggle mute as a simple placeholder
    public static void handleEqualizerAction() {
        MediaPlayer mp = PlayerController.mediaPlayer;
        if (mp == null) {
            System.out.println("Ingen MediaPlayer tilgjengelig for equalizer-handling.");
            return;
        }
        boolean currentlyMuted = mp.isMute();
        mp.setMute(!currentlyMuted);
        System.out.println("Equalizer action: mute set to " + !currentlyMuted);
    }
}