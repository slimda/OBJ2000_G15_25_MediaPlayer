/*
 * Purpose: Handles playback controls (Play, Pause, Stop, Volume).
  * Role: Responds to button clicks and slider changes in player.fxml.
  * Typical logic: Connects to MediaPlayer, updates UI state, handles events.
 */

package group15.mediaplayer.controller;

import group15.mediaplayer.utility.TimeFormatter;
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
    private boolean showRemaining = false;

    @FXML
    public void initialize() {
        try {
            playbackService.loadAudioFolder();
            mediaPlayer = playbackService.createMediaPlayerForCurrent();

            if (mediaPlayer == null) {
                playerMeta.setText("No files found");
                return;
            }

            setupMediaPlayer(mediaPlayer);
            configureUI(mediaPlayer);

        } catch (Exception e) {
            playerMeta.setText("Could not read files");
            e.printStackTrace();
        }
    }

    private void setupMediaPlayer(MediaPlayer mp) {
        initMediaPlayer(mp);
        mp.setOnReady(() -> updateTrackMeta(playbackService.getPlaylist().current()));
        mp.setOnEndOfMedia(() -> switchTrack(playbackService.getPlaylist().next()));
    }

    private void configureUI(MediaPlayer mp) {
        VolumeSliderController.configureVolumeSlider(volumeSlider, mp);
        ProgressSliderController.setup(progressSlider, mp);
    }

    private void switchTrack(Track t) {
        if (t == null) return;

        if (mediaPlayer != null) mediaPlayer.stop();
        mediaPlayer = playbackService.createMediaPlayerForTrack(t);

        setupMediaPlayer(mediaPlayer);
        configureUI(mediaPlayer);

        mediaPlayer.play();
        updateTrackMeta(t);
    }

    private void updateTrackMeta(Track t) {
        if (t != null) {
            playerMeta.setText(t.getTitle());
        }
    }

    @FXML private TextArea playerDisplay;
    @FXML
    private void handlePlayerDisplayClick() {
        showRemaining = !showRemaining;
    }

    @FXML private TextField playerMeta;
    @FXML private Slider volumeSlider;

    @FXML private Button equalizerButton;
    @FXML private Button playlistButton;
    @FXML private Slider progressSlider;

    @FXML private Button previousButton;
    @FXML
    public void handlePreviousAction(ActionEvent e) {
        switchTrack(playbackService.getPlaylist().previous());
    }

    @FXML private Button playButton;
    @FXML
    public void handlePlayAction(ActionEvent e) {
        if (mediaPlayer == null) {
            mediaPlayer = playbackService.createMediaPlayerForCurrent();
            if (mediaPlayer == null) return;

            setupMediaPlayer(mediaPlayer);
            configureUI(mediaPlayer);
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
        switchTrack(playbackService.getPlaylist().next());
    }

    @FXML private Button shuffleButton;
    @FXML
    public void handleShuffleAction(ActionEvent e) {
        playerDisplay.setText("Shuffle not implemented");
    }

    @FXML private Button repeatButton;
    @FXML
    public void handleRepeatAction(ActionEvent e) {
        playerDisplay.setText("Repeat not implemented");
    }

    public void initMediaPlayer(MediaPlayer mediaPlayer) {
        PlayerController.mediaPlayer = mediaPlayer; // bruk instansvariabel

        mediaPlayer.currentTimeProperty().addListener((obs, oldTime, newTime) -> {
            int elapsedSeconds = (int) newTime.toSeconds();
            int totalSeconds = (int) mediaPlayer.getTotalDuration().toSeconds();

            String displayText = showRemaining
                    ? "-" + TimeFormatter.formatRemaining(elapsedSeconds, totalSeconds)
                    : TimeFormatter.formatSeconds(elapsedSeconds);

            playerDisplay.setText(displayText);
        });
    }

}