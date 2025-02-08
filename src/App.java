import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Screens.*;

public class App {
    public static void main(String[] args) throws Exception {
        // Create a List of windows which we can add more to
        List<Window> windows = new ArrayList<Window>();

        // Create an array of screens which has a set number
        Screen[] screens = new Screen[] {new CountdownScreen(), new UsernameScreen()};
        Random random = new Random();
        
        // Generate all windows first
        for (int i = 0; i < 1; i++) {
            windows.add(new Window(300, 300, "WINDOW " + i, screens[random.nextInt(screens.length)]));
            windows.get(i).constructWindow();
        }
        
        // Main loop that will run with a delay
        while (true) {
            for (Window window : windows) {
                window.updateWindow();
            }

            // Decides how fast frames will run
            Thread.sleep( 10);
        }
    }
}
