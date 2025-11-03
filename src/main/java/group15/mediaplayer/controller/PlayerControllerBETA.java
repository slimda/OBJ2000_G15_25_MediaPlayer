package mediaplayer.controller;

import service.PlaybackService;
import utility.TimeFormatter;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.media.MediaView;
import javafx.scene.layout.BorderPane;

public class PlayerController {

    private PlaybackService playbackService;
    private ListView<String> playlistView;
    private Slider volumeSlider, progressSlider;
    private Label timeLabel, statusLabel;

    public PlayerController() {
        playbackService = new PlaybackService();

        //Spilleliste
        playlistView = new ListView<>();
        playlistView.getItems().addAll("test1.mp3", "test2.mp3", "video1.mp4"); //må byttes ut med ekte filer

        //Kontroller
        Button playBtn = new Button ("Play");
        Button pauseBtn = new Button ("Pause");
        Button stopBtn = new Button ("Stop");

        volumeSlider = new Slider(0,1,0.5);
        progressSlider = new Slider ();
        progressSlider.setMin(0);

        timeLabel = new Label("00:00 / 00:00");
        statusLabel = new Label("Velg et spor for å starte avspilling.");

        //Hendelser

        playBtn.setOnAction (e -> playbackService.play());
        pauseBtn.setOnAction (e -> playbackService.pause());
        stopBtn.setOnAction (e-> playbackService.stop());

        playlistView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            playbackService.loadMedia(newVal);
            statusLabel.setText("Spilles av nå: " + newVal);
            highlightCurrentTrack(newVal);
        });

        volumeSlider.valueProperty().addListener((obs, oldVal, newVal) ->
        playbackService.setVolume(newVal.doubleValue()));

        //Bindinger til fremdrift og tid
        playbackService.setProgressListener((current, total) -> {
            progressSlider.setMax(total);
            progressSlider.setValue(current);
            timeLabel.setText(TimeFormatter.format(current) + " / " + TimeFormatter.format(total));

        });
    }
    
}
