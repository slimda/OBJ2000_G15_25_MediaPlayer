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
import group15.mediaplayer.controller.actions.*;
import group15.mediaplayer.service.PlaybackService;
import group15.mediaplayer.model.Track;



public class PlayerController {

    @FXML private Button equalizerButton;
    @FXML private Button playlistButton;
 
    @FXML private Button previousButton;
    @FXML private Button playButton;
    @FXML private Button nextButton;
    @FXML private Button shuffleButton;
    @FXML private Button repeatButton;

    // koble til sånn kan se hvilken sang som spiller
    @FXML private TextField playerMeta;

    @FXML private TextArea playerDisplay;
    @FXML private Slider volumeSlider;

    @FXML private Slider progressSlider;
   

    public static Media media;
    public static MediaPlayer mediaPlayer;

    private final PlaybackService playbackService = new PlaybackService();
    


    @FXML
    public void initialize() {
        try {
            // Load audio files into playlist
            playbackService.loadAudioFolder();

            // Create a MediaPlayer for the first (current) track
            mediaPlayer = playbackService.createMediaPlayerForCurrent();
            
          ProgressSliderController.setup(progressSlider, mediaPlayer);

            if (mediaPlayer != null) {
                mediaPlayer.setOnReady(() -> {
                    Track t = playbackService.getPlaylist().current();
                    if (t != null) {
                        playerMeta.setText("Spilles nå: " + t.getTitle());
                    }
                });

                // Lytt til statusendringer i MediaPlayer
                mediaPlayer.statusProperty().addListener((observable, oldValue, newValue) -> {
                    if (newValue == MediaPlayer.Status.READY) {
                        Track t = playbackService.getPlaylist().current();
                        if (t != null) {
                            playerMeta.setText("Spilles nå: " + t.getTitle());
                        }
                    }
                });
    
                
               
                // Konfigurer volum-slider
                VolumeSliderController.configureVolumeSlider(volumeSlider, mediaPlayer);
            } else {
                playerMeta.setText("Fant ingen lydfiler i audio-mappen.");
            }

        } catch (Exception e) {
            // Håndter feil
            playerMeta.setText("Kunne ikke laste inn lydfilene.");
            e.printStackTrace();
        }
    }

    @FXML
    public void handlePreviousAction(ActionEvent e) {
        Track t = playbackService.getPlaylist().previous();
        if (t != null) {
            if (mediaPlayer != null) mediaPlayer.stop();
            mediaPlayer = playbackService.createMediaPlayerForTrack(t);
            ProgressSliderController.setup(progressSlider, mediaPlayer);
            mediaPlayer.play();
            playerMeta.setText("Spilles nå: " + t.getTitle());
            VolumeSliderController.configureVolumeSlider(volumeSlider, mediaPlayer);
        }
    }

    @FXML
    public void handlePlayAction(ActionEvent e) {
        if (mediaPlayer == null) {
            mediaPlayer = playbackService.createMediaPlayerForCurrent();
            ProgressSliderController.setup(progressSlider, mediaPlayer);
            if (mediaPlayer == null) return;
            VolumeSliderController.configureVolumeSlider(volumeSlider, mediaPlayer);
        }
        mediaPlayer.play();
    }

    @FXML private Button pauseButton;
    @FXML
    public void handlePauseAction(ActionEvent e) {
        PauseButtonController.handlePause();
    }

    @FXML private Button stopButton;
    @FXML
    public void handleStopAction(ActionEvent e) {
        StopButtonController.handle();
    }

    @FXML
    public void handleNextAction(ActionEvent e) {
        Track t = playbackService.getPlaylist().next();
        if (t != null) {
            if (mediaPlayer != null) mediaPlayer.stop();
            mediaPlayer = playbackService.createMediaPlayerForTrack(t);
            ProgressSliderController.setup(progressSlider, mediaPlayer);
            mediaPlayer.play();
            playerMeta.setText("Spilles nå: " + t.getTitle());
            VolumeSliderController.configureVolumeSlider(volumeSlider, mediaPlayer);
        }
    }

    @FXML
    public void handleShuffleAction(ActionEvent e) {
        ShuffleButtonController.handle();
    }

    @FXML
    public void handleRepeatAction(ActionEvent e) {
        RepeatButtonController.handle();
    }

    @FXML
    public void handleEqualizerAction(ActionEvent e) {
        // Use VolumeSliderController to handle equalizer toggle (mute toggle as placeholder)
        VolumeSliderController.handleEqualizerAction();
    }
       
}

