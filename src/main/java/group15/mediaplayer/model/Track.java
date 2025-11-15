/**
 * Purpose: Represents a single media file (e.g., MP3, AVI).
 * Fields: title, artist, duration, filePath, metadata
 * Role: Core data structure used by UI and services.
 */
package group15.mediaplayer.model;

public class Track {
    private String title;       // Sangens tittel
    private String artist;      // Artistens navn
    private double duration;    // Varighet i sekunder
    private String filePath;    // Filsti til mediefilen
    private Metadata metadata;  // Ekstra metadata (f.eks. album, år, sjanger)

    // Konstruktører
    public Track() {
        this.title = "Unknown Title";
        this.artist = "Unknown Artist";
        this.duration = 0;
        this.filePath = "";
        this.metadata = new Metadata();
    }

    public Track(String title, String artist, double duration, String filePath, Metadata metadata) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.filePath = filePath;
        this.metadata = metadata;
    }

    // Getters og Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    // toString-metode for å vise informasjon om sporet
    @Override
    public String toString() {
        return "Title: " + title +
                "\nArtist: " + artist +
                "\nDuration: " + duration + " seconds" +
                "\nFile Path: " + filePath +
                "\nMetadata: " + metadata;
    }
}

