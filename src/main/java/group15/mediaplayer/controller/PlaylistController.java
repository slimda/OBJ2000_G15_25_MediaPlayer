/**
 * Purpose: Manages playlist interactions (add/remove tracks, reorder).
 *
 * Role: Binds to a ListView or TableView, updates the model, handles selection.
 */
package group15.mediaplayer.controller;

import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import static group15.mediaplayer.utility.TimeFormatter.formatTime;

public class PlaylistController {
    @FXML
    private Label timeLabel;
    public void initialize() {
        MediaPlayer mp = PlayerController.mediaPlayer;
        if (mp == null) return;

        mp.currentTimeProperty().addListener((obs, oldTime, newTime) -> {
            Duration total = mp.getTotalDuration();
            Duration current = mp.getCurrentTime();
            Duration remaining = total.subtract(current);

            String r = formatTime(remaining);
            timeLabel.setText(r);   // viser tiden som er igjen
        });
    }
    private String formatTime(Duration d) {
        int minutes = (int) d.toMinutes();
        int seconds = (int) d.toSeconds() % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

}
