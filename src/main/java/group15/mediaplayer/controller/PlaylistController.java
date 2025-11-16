package group15.mediaplayer.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class PlaylistController {

    @FXML
    private ListView<String> playlistView;

    public void initialize() {

        // Navn som vises i lista
        playlistView.getItems().addAll(
                "Rick",
                "sample");

        // Klikk på en sang → spill den
        playlistView.setOnMouseClicked(e -> {
            String song = playlistView.getSelectionModel().getSelectedItem();

            if (song == null || PlayerController.instance == null)
                return;

            if (song.equals("Rick")) {
                PlayerController.instance
                        .playSong("Rick Astley - Never Gonna Give You Up (Official Video) (4K Remaster).mp3");
            } else if (song.equals("Sample")) {
                PlayerController.instance.playSong("sample.mp3");
            }
        });

    }
}
