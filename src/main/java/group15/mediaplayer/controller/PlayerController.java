/**
 * Purpose: Handles playback controls (Play, Pause, Stop, Volume).
 *
 * Role: Responds to button clicks and slider changes in player.fxml.
 *
 * Typical logic: Connects to MediaPlayer, updates UI state, handles events.
 */

package group15.mediaplayer.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PlayerController {
    @FXML private TextArea playerDisplay;
    @FXML private TextField playerMeta;
    @FXML private Slider volumeSlider;
    @FXML private Button equalizerButton;
    @FXML private Button playlistButton;
    @FXML private Slider progressSlider;
    @FXML private Button previousButton;
    @FXML private Button playButton;
    @FXML private Button pauseButton;
    @FXML private Button stopButton;
    @FXML private Button nextButton;
    @FXML private Button shuffleButton;
    @FXML private Button repeatbutton;
}