package mediaplayer.service;

import javafx.scene.media.*;
import javafx.scene.media.MediaView;
import java.io.File;
import java.util.function.BiConsumer;


public class PlaybackService {

    private MediaPlayer mediaPlayer;
    private MediaView mediaView;
    private BiConsumer<Double, Double> progressListener; //biConsumer tar inn to verdier og bruker den i progressListener

    public PlaybackService() {
        mediaView = new MediaView();
    }

    public void loadMedia (String filename) {
        stop();
        try {
            String path  = new File("src/mediaplayer/resources/audio/" + filename).toURI().toString(); //må oppdateres med riktig path
            Media media = new Media(path);
            mediaPlayer = new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaPlayer);

            //Fremdrift og tid oppdatering 
            mediaPlayer.currentTimeProperty().addListener((obs, oldTime, newTime) -> {
                if (progressListener !=null) {
                    double current = newTime.toSeconds();
                    double total = media.getDuration().toSeconds();
                    progressListener.accept(current, total);

                }
            });

    } catch (Exception e) {
        System.out.println("Feil ved lasting av media:" + filename);
         
    }
    
}
  //metoder for play, stop, pause og setVolume i tillegg progressListener (for å vise tidslinje på sangen)
 public void play() {
    if (mediaPlayer != null) mediaPlayer.play();
 }

 public void pause() {
    if (mediaPlayer != null) mediaPlayer.pause();
 }

    public void stop() {
        if (mediaPlayer != null) mediaPlayer.stop();
    }
    public void setVolume(double value) {
        if (mediaPlayer != null) mediaPlayer.setVolume(value);
    }

    public MediaView getMediaView() {
        return mediaView;
    }

    public void setProgressListener(BiConsumer<Double, Double> listener) {
        this.progressListener = listener;
    }
}
