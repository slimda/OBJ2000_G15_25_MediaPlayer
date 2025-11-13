package group15.mediaplayer.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/* 
 * Håndterer alt med fremdrifttslinjen til sangen: ProgressSliderController
 * Denne klassen må kobles til fra PlayerController
 * @Author: Tonje
 */


public class ProgressSliderController {

    @FXML
    private Slider progressSlider;

    private Media media;
    private MediaPlayer mediaPlayer;

    public void initializeProgress(Media media, MediaPlayer mediaPlayer) {
        this.media = media;
        this.mediaPlayer = mediaPlayer;
        setupSlider();
    }

    private void setupSlider() {
        mediaPlayer.setOnReady(() -> {
            progressSlider.setMax(media.getDuration().toSeconds());
        });
        // Oppdaterer verdien til slideren under avspilling
        mediaPlayer.currentTimeProperty().addListener((observable, oldTime, newTime) -> {
            if (!progressSlider.isValueChanging()) {
                progressSlider.setValue(newTime.toSeconds());
            }
        });

        //Når bruker drar i slideren, hopp til den nye posisjonen
        progressSlider.valueChangingProperty().addListener((observable, wasChanging, isChanging) -> {
            if (!isChanging) {
                mediaPlayer.seek(Duration.seconds(progressSlider.getValue()));
            }
        });

        //Klikk direkte på slideren for å hoppe til en posisjon
        progressSlider.setOnMousePressed(event -> {
            mediaPlayer.seek(Duration.seconds(progressSlider.getValue()));

        });

    }
}