package group15.mediaplayer.controller.actions;

public class RepeatButtonController {
    private static boolean repeat = false;
    public static void handle() {
        repeat = !repeat;
        System.out.println("Repeat: " + repeat);
    }
}

