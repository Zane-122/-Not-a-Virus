package Main;

import java.util.Random;

import java.util.Iterator;

import Main.Screens.*;

public class App {
    public static void main(String[] args) throws Exception {
        Random random = new Random();
        
        for (int i = 0; i < 3; i++) {
            int rand = random.nextInt(2);
            Screen screen;
            
            // We'll have to manually add onto this for now
            if (rand == 0) {
                screen = new CountdownScreen();
            } else {
                screen = new UsernameScreen();
            }

            Constants.windowCounter += 1;
            Constants.unconstructedWindows.add(new Window(300, 300, 
                "WINDOW " + Constants.windowCounter, screen));
        }

        // Main loop 
        while (true) {

            // Construct all unconstructed windows in one pass
            Iterator<Window> iterator = Constants.unconstructedWindows.iterator();
            while (iterator.hasNext()) {
                Window window = iterator.next();
                window.constructWindow();
                Constants.constructedWindows.add(window);
                iterator.remove(); // Remove safely while iterating
            }
        
            // Update all windows
            for (Window window : Constants.constructedWindows) {
                window.updateWindow();
            }

            Thread.sleep(10); // Controls frame rate
        }
    }
}
