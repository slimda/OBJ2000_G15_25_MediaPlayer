package group15.mediaplayer.controller;

import javafx.scene.control.Slider;
import javafx.scene.control.Tooltip;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import javafx.util.StringConverter;

public class ProgressSliderController {

    public static void setup(Slider slider, MediaPlayer player) {

        if (slider == null || player == null) return;

        slider.setMin(0);
        slider.setValue(0);

        // Sett maks når sangen er klar
        player.setOnReady(() -> {
            double totalSeconds = player.getTotalDuration().toSeconds();
            slider.setMax(totalSeconds);
        });

        // Tooltip – viser nåtid / totaltid
        Tooltip tip = new Tooltip("00:00 / 00:00");
        Tooltip.install(slider, tip);

        slider.valueProperty().addListener((o, oldV, newV) -> {
            int now = newV.intValue();
            int total = (int) slider.getMax();

            String nowStr = String.format("%02d:%02d", now / 60, now % 60);
            String totalStr = String.format("%02d:%02d", total / 60, total % 60);

            tip.setText(nowStr + " / " + totalStr);
        });

        // Tick formatert til å vise tid i mm:ss
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(30);
        slider.setMinorTickCount(5);

        slider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double d) {
                int sec = d.intValue();
                return String.format("%02d:%02d", sec / 60, sec % 60);
            }
            @Override
            public Double fromString(String s) {
                return 0.0;
            }
        });

        // Oppdater slider mens sangen spiller
        player.currentTimeProperty().addListener((o, old, time) -> {
            if (!slider.isValueChanging()) {
                slider.setValue(time.toSeconds());
            }
        });

    //metode for å klikke på slideren til ny posisjon 
    slider.setOnMousePressed(e -> {
    double value = (e.getX() / slider.getWidth()) * slider.getMax();
    slider.setValue(value);
    player.seek(Duration.seconds(value));
});
    //metode for å dra på slideren til ny posisjon
    slider.setOnMouseDragged(e -> {
    double value = (e.getX() / slider.getWidth()) * slider.getMax();
    slider.setValue(value);
});
    //metode for å slippe musa på slideren til en ny posisjon
    slider.setOnMouseReleased(e -> {
    double value = slider.getValue();
    player.seek(Duration.seconds(value));
});
}
}