/**
 * Purpose: Stores extracted metadata (e.g., ID3 tags, resolution).
 *
 * Role: Used by UI to display track info and by services for sorting/filtering.
 */

package group15.mediaplayer.model;

public class Metadata {

        // Felter for metadata
        private String title;
        private String artist;
        private String album;
        private String genre;
        private double duration; // Varighet i sekunder
        private String filePath;
        private String resolution; // For video: f.eks. "1920x1080"

        // Konstruktør(er)
        public Metadata(String title, String artist, String album, String genre, double duration, String filePath, String resolution) {
            this.title = title;
            this.artist = artist;
            this.album = album;
            this.genre = genre;
            this.duration = duration;
            this.filePath = filePath;
            this.resolution = resolution;
        }

        // Gettere og settere
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

        public String getAlbum() {
            return album;
        }

        public void setAlbum(String album) {
            this.album = album;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
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

        public String getResolution() {
            return resolution;
        }

        public void setResolution(String resolution) {
            this.resolution = resolution;
        }

        // ToString-metode for enkel visning av metadata
        @Override
        public String toString() {
            return "Metadata{" +
                    "title='" + title + '\'' +
                    ", artist='" + artist + '\'' +
                    ", album='" + album + '\'' +
                    ", genre='" + genre + '\'' +
                    ", duration=" + duration +
                    ", filePath='" + filePath + '\'' +
                    ", resolution='" + resolution + '\'' +
                    '}';
        }
    }
