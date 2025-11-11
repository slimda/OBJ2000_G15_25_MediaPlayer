/*
 * Purpose: Stores extracted metadata (e.g., ID3 tags, resolution).
 * Role: Used by UI to display track info and by services for sorting/filtering.
 */

package group15.mediaplayer.model;

public class Metadata {

    private String title;
    private String artist;
    private double duration; // sekunder

    // Konstruktør
    public Metadata(String title, String artist, double duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
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

    @Override
    public String toString() {
        return "Title: " + title + "\nArtist: " + artist + "\nDuration: " + duration + " seconds";
    }
}
