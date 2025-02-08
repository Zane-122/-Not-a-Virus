import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Screens.*;

public class App {
    public static void main(String[] args) throws Exception {
        List<Window> windows = new ArrayList<Window>();
        Screen[] screens = new Screen[] {new CountdownScreen(), new UsernameScreen()};
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            windows.add(new Window(300, 300, "WINDOW " + i, screens[random.nextInt(screens.length)]));
            windows.get(i).constructWindow();
        }

        while (true) {
            for (Window window : windows) {
                window.updateWindow();
            }
            Thread.sleep( 10);
        }
    }
}
