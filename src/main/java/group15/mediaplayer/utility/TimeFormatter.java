public class TimeFormatter {

    public static String format(double seconds) {
        int totalSeconds = (int) seconds;
        int mins = totalSeconds / 60;
        int secs = totalSeconds % 60;
        return String.format("%2d:%02d", mins, secs);
    }
    
}
