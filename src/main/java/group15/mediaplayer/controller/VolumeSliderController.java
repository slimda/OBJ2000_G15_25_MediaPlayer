package group15.mediaplayer.controller;

/**
 * Purpose: Manages a volume slider UI component.
 *
 * Role: Allows users to adjust the media player's volume and displays the current volume level.
 */


import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;

public class VolumeSliderController {

    private Slider volumeSlider;
    private Label volumeLabel;
    private VBox volumeControl;

    public static void configureVolumeSlider(Slider volumeSlider, MediaPlayer mediaPlayer) {

        volumeSlider.setMin(0);
        volumeSlider.setMax(100);
        volumeSlider.setValue(50);
        volumeSlider.setShowTickLabels(true);
        volumeSlider.setShowTickMarks(true);
        volumeSlider.setMajorTickUnit(10);
        volumeSlider.setMinorTickCount(5);
        volumeSlider.setSnapToTicks(true);

        volumeSlider.valueProperty().addListener((observable, oldVal, newVal) -> {
            mediaPlayer.setVolume(newVal.doubleValue() / 100.0);
        });

        mediaPlayer.setVolume(volumeSlider.getValue() / 100.0);
    }
}
