package group15.mediaplayer.controller.mediaplayer.controller;

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

    private final Media media;
    private final MediaPlayer mediaPlayer;
    private final Slider progressSlider;

    public ProgressSliderController(Media media, MediaPlayer mediaPlayer, Slider progressSlider) {
        this.media = media;
        this.mediaPlayer = mediaPlayer;
        this.progressSlider = progressSlider;
        setupSlider();
    }
    private void setupSlider() {

        // Når mediaen er klar, sett slider til maksverdi
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

/*
 * Dette legges til i PlayerController for å koble til ProgressSliderController
 */

 private ProgressSliderController progressSliderController;


 @FXML
 private void initialize() {
    //Oppretter og kobler til slider-kontrolleren
    progressController = new ProgressSliderController(media,mediaPlayer, progressSlider);

 }
