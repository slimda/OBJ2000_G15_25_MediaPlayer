import java.util.ArrayList;
import java.util.List;

public class PlayList {

    private List <Track> tracks = new ArrayList<>();

    public void addTrack(Track track) {
        tracks.add(track);

    }
    public List <Track> getTracks() {
        return tracks;
    }
    
}
