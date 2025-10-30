/**
 * Purpose: Contains the public static void main(String[] args) method.
 *
 * Role: Starts the JavaFX application by calling Application.launch().
 *
 * Why separate: Avoids module system quirks and keeps bootstrapping logic clean.
 */

package group15.mediaplayer.launcher;

import group15.mediaplayer.app.MediaPlayerApp;
import javafx.application.Application;

public class Launcher {
    public static void main(String[] args) {
        Application.launch(MediaPlayerApp.class, args);
    }
}