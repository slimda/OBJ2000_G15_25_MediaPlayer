package group15.mediaplayer.service;

import group15.mediaplayer.model.Playlist;
import group15.mediaplayer.model.Track;
import group15.mediaplayer.model.Metadata;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.List;

/**
 * Simple playback manager: builds a playlist from resources/audio and creates MediaPlayer for tracks.
 */
public class PlaybackService {
    private final Playlist playlist = new Playlist();

    public Playlist getPlaylist() {
        return playlist;
    }

    public void loadAudioFolder() {
        playlist.clear();
        List<String> files = FileService.getAudioFiles();
        for (String filename : files) {
            // basic Track creation: use filename as title
            Track t = new Track();
            t.setTitle(filename);
            t.setFilePath(filename);
            t.setArtist("Unknown Artist");
            t.setMetadata(new Metadata());
            playlist.add(t);
        }
    }

    public MediaPlayer createMediaPlayerForCurrent() {
        Track t = playlist.current();
        if (t == null) return null;
        String url = FileService.getMediaUrl(t.getFilePath());
        Media media = new Media(url);
        MediaPlayer mp = new MediaPlayer(media);
        return mp;
    }

    public MediaPlayer createMediaPlayerForTrack(Track t) {
        if (t == null) return null;
        String url = FileService.getMediaUrl(t.getFilePath());
        Media media = new Media(url);
        MediaPlayer mp = new MediaPlayer(media);
        return mp;
    }
}

