package group15.mediaplayer.controller.actions;

public class ShuffleButtonController {
    private static boolean shuffle = false;
    public static void handle() {
        shuffle = !shuffle;
        System.out.println("Shuffle: " + shuffle);
    }
}

