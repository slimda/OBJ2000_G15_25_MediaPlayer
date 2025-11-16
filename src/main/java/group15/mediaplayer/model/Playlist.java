/**
 * Purpose: Represents a collection of Track objects.
 * Role: Supports adding/removing tracks, saving/loading playlists.
 */

package group15.mediaplayer.model;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private final List<Track> tracks = new ArrayList<>();
    private int currentIndex = -1;

    public void add(Track t) {
        if (t != null) tracks.add(t);
        if (currentIndex == -1 && !tracks.isEmpty()) currentIndex = 0;
    }

    public Track next() {
        if (tracks.isEmpty()) return null;
        currentIndex = (currentIndex + 1) % tracks.size();
        return tracks.get(currentIndex);
    }

    public Track previous() {
        if (tracks.isEmpty()) return null;
        currentIndex = (currentIndex - 1 + tracks.size()) % tracks.size();
        return tracks.get(currentIndex);
    }

    public Track current() {
        if (tracks.isEmpty() || currentIndex < 0) return null;
        return tracks.get(currentIndex);
    }

    public void setCurrent(Track track) {
        int index = tracks.indexOf(track);
        if (index >= 0) {
            currentIndex = index;
        }
    }

    public List<Track> getTracks() {
        return new ArrayList<>(tracks);
    }

    public int size() {
        return tracks.size();
    }

    public boolean isEmpty() {
        return tracks.isEmpty();
    }

    public void clear() {
        tracks.clear();
        currentIndex = -1;
    }

}
