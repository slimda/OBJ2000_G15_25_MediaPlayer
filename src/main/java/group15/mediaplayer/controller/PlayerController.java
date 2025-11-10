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
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class PlayerController {

    static Media media = new Media(FileService.getMediaUrl());
    static MediaPlayer mediaPlayer = new MediaPlayer(media);

    @FXML private TextArea playerDisplay;
    @FXML private TextField playerMeta;

    @FXML private Button equalizerButton;
    @FXML private Button playlistButton;
    @FXML private Slider progressSlider;
    @FXML private Button previousButton;
    @FXML private Button playButton;
    @FXML private Button pauseButton;
    @FXML private Button stopButton;
    @FXML private Button nextButton;
    @FXML private Button shuffleButton;
    @FXML private Button repeatButton;


    @FXML private Slider volumeSlider;

    @FXML
    public void initialize() {
        VolumeSliderController.configureVolumeSlider(volumeSlider, mediaPlayer);
    }



    @FXML
    public void handlePreviousAction(ActionEvent e) {
//        PreviousButtonController.handlePlay();
    }

    @FXML
    public void handlePlayAction(ActionEvent e) {
        PlayButtonController.handlePlay();
    }

    @FXML
    public void handlePauseAction(ActionEvent e) {
        PauseButtonController.handlePause();
    }

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