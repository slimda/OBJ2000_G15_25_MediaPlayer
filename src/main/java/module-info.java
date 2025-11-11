module group15usn.mediaplayer {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.media;

    exports group15.mediaplayer.app to javafx.graphics;
    exports group15.mediaplayer.config to javafx.graphics;
    exports group15.mediaplayer.controller to javafx.graphics;
    opens group15.mediaplayer.controller to javafx.fxml;
    exports group15.mediaplayer.launcher to javafx.graphics;
    exports group15.mediaplayer.model to javafx.graphics;
    exports group15.mediaplayer.service to javafx.graphics;
    exports group15.mediaplayer.utility to javafx.graphics;
    exports group15.mediaplayer.controller.actions to javafx.graphics;
    opens group15.mediaplayer.controller.actions to javafx.fxml;

}