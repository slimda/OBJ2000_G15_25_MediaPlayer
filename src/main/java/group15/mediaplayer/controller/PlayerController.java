/*
 * Purpose: Handles playback controls (Play, Pause, Stop, Volume).
  * Role: Responds to button clicks and slider changes in player.fxml.
  * Typical logic: Connects to MediaPlayer, updates UI state, handles events.
 */

package group15.mediaplayer.controller;

import group15.mediaplayer.service.FileService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import group15.mediaplayer.model.Metadata;
import group15.mediaplayer.service.MetadataService;


public class PlayerController {

    @FXML private Button equalizerButton;
    @FXML private Button playlistButton;
    @FXML private Slider progressSlider;
    @FXML private Button previousButton;
    @FXML private Button playButton;
    @FXML private Button nextButton;
    @FXML private Button shuffleButton;
    @FXML private Button repeatButton;

    // koble til sånn kan se hvilken sang som spiller
    @FXML private TextField playerMeta;

    @FXML private TextArea playerDisplay;
    @FXML private Slider volumeSlider;

    public static Media media;
    public static MediaPlayer mediaPlayer;

        @FXML
    public void initialize() {
            // Initialiser Media og MediaPlayer
            media = new Media(FileService.getMediaUrl("Rick Astley - Never Gonna Give You Up (Official Video) (4K Remaster).mp3"));
            mediaPlayer = new MediaPlayer(media);
            // Prøv å laste inn en lydfil og oppdater metadata
            try {
                // Hent URL til en lydfil
                String mediaUrl = FileService.getMediaUrl("sample.mp3");
                Media media = new Media(mediaUrl);

                // Opprett MediaPlayer

                // Hent metadata når MediaPlayer er klar
                Metadata metadata = MetadataService.extractMetadata(media, mediaPlayer);

                // Lytt til statusendringer i MediaPlayer
                mediaPlayer.statusProperty().addListener((observable, oldValue, newValue) -> {
                    if (newValue == MediaPlayer.Status.READY) {
                        // Oppdater UI med metadata
                        playerMeta.setText("Spilles nå: " + metadata.getTitle() + " av " + metadata.getArtist());
                        System.out.println("Spilles nå: " + metadata.getTitle() + " av " + metadata.getArtist());
                    }
                });

            } catch (Exception e) {
                // Håndter feil
                playerMeta.setText("Kunne ikke laste inn lydfilen.");
                e.printStackTrace();
            // Konfigurer volum-slider
            VolumeSliderController.configureVolumeSlider(volumeSlider, mediaPlayer);
        }}

         @FXML
    public void handlePreviousAction(ActionEvent e) {
//        PreviousButtonController.handlePlay();
    }

    @FXML
    public void handlePlayAction(ActionEvent e) {
        PlayButtonController.handlePlay();
    }

    @FXML private Button pauseButton;
    @FXML
    public void handlePauseAction(ActionEvent e) {
        PauseButtonController.handlePause();
    }

    @FXML private Button stopButton;
    @FXML
    public void handleStopAction(ActionEvent e) {
     StopButtonController.handleStop();
    }

    @FXML
    public void handleNextAction(ActionEvent e) {
//        NextButtonController.handleNext();
    }

    @FXML
    public void handleShuffleAction(ActionEvent e) {
//        ShuffleButtonController.handleShuffle();
    }

    @FXML
    public void handleRepeatAction(ActionEvent e) {
//        RepeatButtonController.handleRepeat();
    }

    @FXML
    public void handleEqualizerAction(ActionEvent e) {

    }

}