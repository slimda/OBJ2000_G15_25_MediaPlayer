package group15.mediaplayer.controller;

import javafx.scene.control.ListView;

public class PlaylistController {
    public static void setup(ListView<String> listView) {
        listView.getItems().addAll("Song 1", "Song 2", "Song 3");
    }
}
