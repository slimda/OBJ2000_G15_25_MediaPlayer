/**
 * Purpose: Extracts metadata from media files.
 *
 * Role: Uses libraries or built-in JavaFX features to read tags, duration, etc.
 *  Laster metadata fra en mediefil og returnerer et Track-objekt via callback.
 * @ param mediaUrl URL til mediefilen (fra FileService)
 *  @ param onReady Callback som mottar ferdig utfylt Track
 *
 */

package group15.mediaplayer.service;

import group15.mediaplayer.model.Track;
import javafx.application.Platform;
import javafx.collections.MapChangeListener;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.Map;
import java.util.function.Consumer;

public class MetadataService {


    public static void loadTrack(String mediaUrl, Consumer<Track> onReady) {
        Media media = new Media(mediaUrl);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        Track track = new Track(mediaUrl);

        media.getMetadata().addListener((MapChangeListener<String, Object>) change -> {
            if (change.wasAdded()) {
                Map<String, Object> metadata = media.getMetadata();
                track.setTitle((String) metadata.getOrDefault("title", "Ukjent tittel"));
                track.setArtist((String) metadata.getOrDefault("artist", "Ukjent artist"));
                track.setAlbum((String) metadata.getOrDefault("album", "Ukjent album"));
                track.setGenre((String) metadata.getOrDefault("genre", "Ukjent sjanger"));
                track.setYear((String) metadata.getOrDefault("year", "Ukjent år"));
            }
        });

        mediaPlayer.setOnReady(() -> {
            track.setDuration(media.getDuration().toSeconds());
            Platform.runLater(() -> onReady.accept(track));
        });
    }
}
