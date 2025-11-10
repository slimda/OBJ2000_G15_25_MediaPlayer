/**
 * Purpose: Handles file I/O — loading media files, saving playlists.
 *
 * Role: Abstracts file system access, supports drag-and-drop or file chooser.
 */

package group15.mediaplayer.service;

import javafx.scene.media.Media;

import java.nio.file.Paths;

public class FileService {
    private static final String MEDIA_URL =
            Paths.get("src/main/resources/audio/Rick Astley - Never Gonna Give You Up (Official Video) (4K Remaster).mp3")
                    .toUri()
                    .toString();

    public static String getMediaUrl() {
        return MEDIA_URL;
    }
}
