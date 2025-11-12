/**
 * Purpose: Handles file I/O — loading media files, saving playlists.
 *
 * Role: Abstracts file system access, supports drag-and-drop or file chooser.
 */

package group15.mediaplayer.service;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    public static String getMediaUrl(String filename) {
        URL resource = FileService.class.getResource("/audio/" + filename);
        if (resource != null) {
            return resource.toExternalForm();
        } else {
            throw new IllegalArgumentException("Finner ikke filen: " + filename);
        }
    }

    public static List<String> getAudioFiles() {
        List<String> audioFiles = new ArrayList<>();
        URL resource = FileService.class.getResource("/audio");
        if (resource != null) {
            try {
                URI uri = resource.toURI();
                File folder = new File(uri);
                File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".mp3"));
                if (files != null) {
                    for (File file : files) {
                        audioFiles.add(file.getName());
                    }
                }
            } catch (Exception ex) {
                // fallback: try using resource.getPath()
                File folder = new File(resource.getPath());
                File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".mp3"));
                if (files != null) {
                    for (File file : files) {
                        audioFiles.add(file.getName());
                    }
                }
            }
        }
        return audioFiles;
    }
}