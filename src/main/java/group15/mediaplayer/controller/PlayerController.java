/**
 * Purpose: Handles playback controls (Play, Pause, Stop, Volume).
 *
 * Role: Responds to button clicks and slider changes in player.fxml.
 *
 * Typical logic: Connects to MediaPlayer, updates UI state, handles events.
 */

package group15.mediaplayer.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PlayerController {
    @FXML private TextArea playerDisplay;
    @FXML private TextField playerMeta;

    @FXML private TextField userField;
    @FXML private TextField passwordField;

    @FXML
    private void handleOk() {
        if (userField.getText().equals("") || passwordField.getText().equals("")) {
            System.out.println("Please write both username and password");
        }
        else {
            System.out.println("Username: " + userField.getText());
            System.out.println("Password: " + passwordField.getText());
        }
    }

    @FXML
    private void handleCancel() {
        userField.setText("");
        passwordField.setText("");
    }
}