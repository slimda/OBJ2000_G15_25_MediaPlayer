/**
 * Purpose: Handles playback controls (Play, Pause, Stop, Volume).
 *
 * Role: Responds to button clicks and slider changes in player.fxml.
 *
 * Typical logic: Connects to MediaPlayer, updates UI state, handles events.
 */

package group15.mediaplayer.controller;

import group15.mediaplayer.service.FileService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class PlayerController {
    public static PlayerController instance;

    public PlayerController() {
        instance = this;
    }

    static Media media = new Media(FileService.getMediaUrl());
    static MediaPlayer mediaPlayer = new MediaPlayer(media);

    @FXML
    private TextArea playerDisplay;
    @FXML
    private TextField playerMeta;
    @FXML
    private Slider volumeSlider;
    @FXML
    private Button equalizerButton;
    @FXML
    private Button playlistButton;
    @FXML
    private Slider progressSlider;
    @FXML
    private Button previousButton;
    @FXML
    private Button playButton;
    @FXML
    private Button pauseButton;
    @FXML
    private Button stopButton;
    @FXML
    private Button nextButton;
    @FXML
    private Button shuffleButton;
    @FXML
    private Button repeatButton;

    @FXML
    public void handlePreviousAction(ActionEvent e) {
        // PreviousButtonController.handlePlay();
    }

    @FXML
    public void handlePlayAction(ActionEvent e) {
        PlayButtonController.handlePlay();
    }

    @FXML
    public void handlePauseAction(ActionEvent e) {
        // PauseButtonController.handlePause();
    }

    @FXML
    public void handleStopAction(ActionEvent e) {
        // StopButtonController.handleStop();
    }

    @FXML
    public void handlePlaylistAction(ActionEvent e) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/playlist.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Playlist");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void handleNextAction(ActionEvent e) {
        // NextButtonController.handleNext();
    }

    @FXML
    public void handleShuffleAction(ActionEvent e) {
        // ShuffleButtonController.handleShuffle();
    }

    @FXML
    public void handleRepeatAction(ActionEvent e) {
        // RepeatButtonController.handleRepeat();
    }

    public void setSongFromPlaylist(String song) {
        playerMeta.setText("Playing: " + song);

    }

    public void playSong(String fileName) {

        var url = getClass().getResource("/audio/" + fileName);
        if (url == null) {
            System.out.println("Fant ikke fil: " + fileName);
            return;
        }

        if (mediaPlayer != null)
            mediaPlayer.stop();

        mediaPlayer = new MediaPlayer(new Media(url.toExternalForm()));
        mediaPlayer.play();

        playerMeta.setText("Playing: " + fileName);
    }

}
