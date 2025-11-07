Oppsett for classene

Mappe
OBJ2000_G15_25_MediaPlayer
.idea
.mvn
-src
main er under src
--main
java er under main
-java
	-group15
		- mediaplayer
app
MediaPlayerApp.java
* Purpose: Subclass of javafx.application.Application.
* Role: Sets up the primary Stage, loads the main FXML layout, and initializes the UI.

cofig
AppConfig.java
* Purpose: Loads and stores app settings (e.g., theme, volume, last playlist).
* Role: Reads from app.properties, provides access to config values.

controller
PlayButtonController.java

PlayerController.java
* Purpose: Handles playback controls (Play, Pause, Stop, Volume).
* Role: Responds to button clicks and slider changes in player.fxml.
* Typical logic: Connects to MediaPlayer, updates UI state, handles events.

PlaylistController.java
* Purpose: Manages playlist interactions (add/remove tracks, reorder)
* Role: Binds to a ListView or TableView, updates the model, handles selection.

VideoController.java

launcher
Lanucher.java
* Purpose: Contains the public static void main(String[] args) method.
* Role: Starts the JavaFX application by calling Application.launch().
* Why separate: Avoids module system quirks and keeps bootstrapping logic clean.

model
Metadata.java
* Purpose: Stores extracted metadata (e.g., ID3 tags, resolution).
* Role: Used by UI to display track info and by services for sorting/filtering.

Playlist.java
* Purpose: Represents a collection of Track objects.
* Role: Supports adding/removing tracks, saving/loading playlists.

Track.java
* Purpose: Represents a single media file (e.g., MP3, AVI).
* Fields: title, artist, duration, filePath, metadata
* Role: Core data structure used by UI and services.

service
FileService.java
* Purpose: Handles file I/O — loading media files, saving playlists.
 * Role: Abstracts file system access, supports drag-and-drop or file chooser.

MetadataService.java
* Purpose: Extracts metadata from media files.
* Role: Uses libraries or built-in JavaFX features to read tags, duration, etc.
  
PlaybackService.java
* Purpose: Wraps MediaPlayer logic.
* Role: Provides play/pause/stop methods, handles media lifecycle, notifies UI.

utility
Logger.java
* Purpose: Centralized logging utility.
* Role: Writes logs to console or file, used across services and controllers.

Timeformatter.java
* Purpose: Converts milliseconds to mm:ss format.
* Role: Used in UI to display track duration or current playback time.

resources
er under main mappen
audio
config
css
fxml
groupe15/mediaplayer

-target
