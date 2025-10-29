module group15.mediaplayer {
    requires javafx.controls;
    requires javafx.fxml;


    opens group15.mediaplayer to javafx.fxml;
    exports group15.mediaplayer;
}