package group15.mediaplayer.controller;

import group15.mediaplayer.model.Playlist;
import group15.mediaplayer.model.Track;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class PlaylistController {

    @FXML
    private ListView<String> playlistView;

    private Playlist playlist;

    // Called from PlayerController when opening the playlist window
    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
        refresh();
    }

    private void refresh() {
        playlistView.getItems().clear();
        if (playlist != null) {
            playlist.getTracks().forEach(t -> playlistView.getItems().add(t.getTitle()));

            Track current = playlist.current();
            if (current != null) {
                playlistView.getSelectionModel().select(current.getTitle());
            }
        }
    }

    public void highlightCurrentTrack() {
        if (playlist != null) {
            Track current = playlist.current();
            if (current != null) {
                playlistView.getSelectionModel().select(current.getTitle());
                playlistView.scrollTo(current.getTitle()); // optional: auto-scroll into view
            }
        }
    }

    @FXML
    public void initialize() {
        // Handle double‑click or single click
        playlistView.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) {
                String selectedTitle = playlistView.getSelectionModel().getSelectedItem();
                if (selectedTitle != null && playlist != null) {
                    Track selectedTrack = playlist.getTracks().stream()
                            .filter(t -> t.getTitle().equals(selectedTitle))
                            .findFirst()
                            .orElse(null);

                    if (selectedTrack != null) {
                        // Update the playlist's current pointer
                        playlist.setCurrent(selectedTrack);

                        // Now let PlayerController switch to it
                        PlayerController.instance.switchTrack(selectedTrack);
                    }
                }
            }
        });


    }


}
