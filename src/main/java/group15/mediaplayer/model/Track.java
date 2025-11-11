/**
 * Purpose: Represents a single media file (e.g., MP3, AVI).
 *
 * Fields: title, artist, duration, filePath, metadata
 *
 * Role: Core data structure used by UI and services.
 */

package group15.mediaplayer.model;

import javafx.collections.MapChangeListener;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Track {

    private String title;
    private String artist;
    private String album;
    private String genre;
    private String year;
    private double duration;
    private String filePath;

    public Track(String filePath) {
        this.filePath = filePath;

        Media media = new Media(filePath);
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        media.getMetadata().addListener((MapChangeListener<String, Object>) change -> {
            if (change.wasAdded()) {
                String key = change.getKey();
                Object value = change.getValueAdded();
                System.out.println("Metadata: " + key + "=" + value);
            }
        });

        mediaPlayer.setOnReady(() -> {
            this.duration = media.getDuration().toSeconds();
        });
    }

    // ✅ Legg til disse setter-metodene
    public void setTitle(String title) { this.title = title; }
    public void setArtist(String artist) { this.artist = artist; }
    public void setAlbum(String album) { this.album = album; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setYear(String year) { this.year = year; }
    public void setDuration(double duration) { this.duration = duration; }

    // Gettere
    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public String getAlbum() { return album; }
    public String getGenre() { return genre; }
    public String getYear() { return year; }
    public double getDuration() { return duration; }
    public String getFilePath() { return filePath; }
}

