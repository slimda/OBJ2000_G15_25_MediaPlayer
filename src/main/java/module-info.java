module group15usn.mediaplayer {
    requires javafx.controls;
    requires javafx.fxml;


    opens group15.mediaplayer to javafx.fxml;
    exports group15.mediaplayer;
    exports group15.mediaplayer.ui;
    opens group15.mediaplayer.ui to javafx.fxml;
    exports group15.mediaplayer.launcher;
    opens group15.mediaplayer.launcher to javafx.fxml;
}