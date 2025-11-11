/*
Purpose: Extracts metadata from media files.
 * Role: Uses libraries or built-in JavaFX features to read tags, duration, etc
 */
package group15.mediaplayer.service;

import group15.mediaplayer.model.Metadata;
import javafx.collections.MapChangeListener;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MetadataService {

    // Metode for å hente metadata fra en Media-fil
    public static Metadata extractMetadata(Media media, MediaPlayer mediaPlayer) {
        // Opprett et Metadata-objekt med standardverdier
        Metadata metadata = new Metadata("Unknown Title", "Unknown Artist", 0);

        // Lytt til metadata-endringer (tittel, artist, album osv.)
        media.getMetadata().addListener((MapChangeListener<String, Object>) change -> {
            if (change.wasAdded()) {
                String key = change.getKey();
                Object value = change.getValueAdded();

                // Sjekk hvilken type metadata som er tilgjengelig
                switch (key.toLowerCase()) {
                    case "title":
                        metadata.setTitle(value.toString());
                        break;
                    case "artist":
                        metadata.setArtist(value.toString());
                        break;
                }
            }
        });

        // Lytt til statusen til MediaPlayer for å få varigheten
        mediaPlayer.statusProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == MediaPlayer.Status.READY) {
                metadata.setDuration(media.getDuration().toSeconds());
            }
        });

        return metadata;
    }
}