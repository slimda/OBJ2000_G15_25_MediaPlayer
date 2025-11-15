/*
 * Purpose: Handles playback controls (Play, Pause, Stop, Volume).
  * Role: Responds to button clicks and slider changes in player.fxml.
  * Typical logic: Connects to MediaPlayer, updates UI state, handles events.
 */

package group15.mediaplayer.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import group15.mediaplayer.controller.actions.*;
import group15.mediaplayer.service.PlaybackService;
import group15.mediaplayer.model.Track;

public class PlayerController {

    private final PlaybackService playbackService = new PlaybackService();
    public static Media media;
    public static MediaPlayer mediaPlayer;

    @FXML
    public void initialize() {
        try {
            // Load audio files into playlist
            playbackService.loadAudioFolder();

            // Create a MediaPlayer for the first (current) track
            mediaPlayer = playbackService.createMediaPlayerForCurrent();
            initMediaPlayer(mediaPlayer);
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
    @FXML private TextField playerMeta;

    @FXML private TextArea playerDisplay;
    @FXML private Slider volumeSlider;

    @FXML private Button equalizerButton;
    @FXML private Button playlistButton;
    @FXML private Slider progressSlider;

    @FXML private Button previousButton;
    @FXML
    public void handlePreviousAction(ActionEvent e) {
        Track t = playbackService.getPlaylist().previous();
        if (t != null) {
            if (mediaPlayer != null) mediaPlayer.stop();
            mediaPlayer = playbackService.createMediaPlayerForTrack(t);
            //kaller på initmediaplayer får å telle tid
            initMediaPlayer(mediaPlayer);
            mediaPlayer.play();
            playerMeta.setText("Spilles nå: " + t.getTitle());
            VolumeSliderController.configureVolumeSlider(volumeSlider, mediaPlayer);
        }
    }

    @FXML private Button playButton;
    @FXML
    public void handlePlayAction(ActionEvent e) {
        if (mediaPlayer == null) {
            mediaPlayer = playbackService.createMediaPlayerForCurrent();
            if (mediaPlayer == null) return;
            VolumeSliderController.configureVolumeSlider(volumeSlider, mediaPlayer);
        }
        mediaPlayer.play();
    }

    @FXML private Button pauseButton;
    @FXML
    public void handlePauseAction(ActionEvent e) {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    @FXML private Button stopButton;
    @FXML
    public void handleStopAction(ActionEvent e) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    @FXML private Button nextButton;
    @FXML
    public void handleNextAction(ActionEvent e) {
        Track t = playbackService.getPlaylist().next();
        if (t != null) {
            if (mediaPlayer != null) mediaPlayer.stop();
            mediaPlayer = playbackService.createMediaPlayerForTrack(t);
            // Kall initMediaPlayer her
            initMediaPlayer(mediaPlayer);
            mediaPlayer.play();
            playerMeta.setText("Spilles nå: " + t.getTitle());
            VolumeSliderController.configureVolumeSlider(volumeSlider, mediaPlayer);
        }
    }

    @FXML private Button shuffleButton;
    @FXML
    public void handleShuffleAction(ActionEvent e) {
        System.out.println("Shuffle function is not implemented");
    }

    @FXML private Button repeatButton;
    @FXML
    public void handleRepeatAction(ActionEvent e) {
        System.out.println("Repeat function is not implemented");
    }

    public void initMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer; // bruk instansvariabel

        mediaPlayer.currentTimeProperty().addListener((obs, oldTime, newTime) -> {
            int seconds = (int) newTime.toSeconds();
            int minutes = seconds / 60;
            seconds = seconds % 60;

            playerDisplay.setText(String.format("%02d:%02d", minutes, seconds));
        });
    }
}