/**
 * Purpose: Subclass of javafx.application.Application.
 *
 * Role: Sets up the primary Stage, loads the main FXML layout, and initializes the UI.
 */

package group15.mediaplayer.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MediaPlayerApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/player.fxml"));
        stage.setScene(new Scene(root, 300, 200));
        stage.setTitle("Media Player");
        stage.setResizable(false);
        stage.show();
    }
}
