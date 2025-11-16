/**
 * Purpose: Converts milliseconds to mm:ss format.
 *
 * Role: Used in UI to display track duration or current playback time.
 */

 package group15.mediaplayer.utility;

 public class TimeFormatter {

     /**
     * Konverterer millisekunder til mm:ss-format.
     *
     * @param milliseconds Varighet i millisekunder.
     * @return String i formatet mm:ss.
     */
    public static String formatTime(long milliseconds) {
        long totalSeconds = milliseconds / 1000;
        long minutes = totalSeconds / 60;
        long seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    /**
     * Konverterer sekunder til mm:ss-format.
     *
     * @param totalSeconds Varighet i sekunder.
     * @return String i formatet mm:ss.
     */
    public static String formatSeconds(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    public static String formatRemaining(int elapsedSeconds, int totalSeconds) {
        int remaining = Math.max(totalSeconds - elapsedSeconds, 0);
        return formatSeconds(remaining);
    }
}