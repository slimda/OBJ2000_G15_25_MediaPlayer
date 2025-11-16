package group15.mediaplayer.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class PlaylistController {

    @FXML
    private ListView<String> playlistView;

    public void initialize() {
        playlistView.getItems().addAll(
                "Liquid Tension Experiment - Acid Rain.mp3",
                "Metallica - Enter Sandman.mp3",
                "Myrath - Believer.mp3",
                "Nightwish - Over the Hills and Far Away.mp3",
                "Rick Astley - Never Gonna Give You Up (Official Video) (4K Remaster).mp3"
        // + ev. sample.mp3 hvis den fortsatt er der
        );

        playlistView.setOnMouseClicked(e -> {
            String file = playlistView.getSelectionModel().getSelectedItem();
            if (file != null) {
                PlayerController.instance.playSong(file);
            }
        });
    }
}
