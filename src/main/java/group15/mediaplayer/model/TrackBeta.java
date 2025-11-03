package group15.mediaplayer.model;


public class Track {
    private String title;
    private String artist;
    private String album;
    private String filePath;
    private double duration; // i sekunder

    //konstruktør 
    public Track(String title, String artist, String album, double duration) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.filePath = filePath;
        this.duration = duration; //i sekunder
    }

    //gettere og settere
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist (String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }
    public void String setAlbum(String album) {
        this.album = album;
    }
    public String getFilePath() {
        return filePath;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public double getDuration() {
        return duration;
    }

    public void public void setDuration(double duration) {
        this.duration = duration;
    }
    
}
