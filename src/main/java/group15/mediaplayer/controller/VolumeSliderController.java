package group15.mediaplayer.controller;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.*;

public class VolumeSliderController {

    public void start(Stage stage){

    //slider
    Slider slider = new Slider();
    slider.setMin(0);       // minste verdi
    slider.setMax(100);     //max verdier
    slider.setValue(50);    //value
    slider.setShowTickLabels(true); //viser markeringer
    slider.setShowTickMarks(true);  //viser hakker
    slider.setMajorTickUnit(10); //afstanden mellom større hakker
    slider.setMinorTickCount(5); // antallet af mindre hakker mellom
    slider.setSnapToTicks(true); //Snapper til hakkerne

    //Opretter en label til at vise sliderens verdi
    Label valueLabel = new Label("Verdi" + slider.getValue());

    //tilføere en lytter til at viser sliderens verdie
    slider.valueProperty().addListener((observable, oldValue, newValue)->
    {valueLabel.setText("Verdi" + newValue.intValue());
    });
// tilføer slideren og labelen til layoutet
        VBox vbox = new VBox(10, slider, valueLabel);
        vbox.setStyle("-fx-padding: 20; -fx-alignment: center;");


}}
