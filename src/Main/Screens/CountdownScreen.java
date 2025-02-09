package Main.Screens;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Main.Constants;
import Main.Window;

public class CountdownScreen extends Screen{
    int initialTime;
    JLabel label;
    double startTime;

    Window window;

    public CountdownScreen() {
        // Set the initial time that is desplayed in the begginging
        initialTime = 10;

        startTime = System.currentTimeMillis();
        label = new JLabel(String.valueOf(initialTime), SwingConstants.CENTER);
    }

    @Override
    public void constructWindow(JFrame frame, int width, int height) {
        label = new JLabel(String.valueOf(initialTime), SwingConstants.CENTER);
        label.setFont(new Font("Impact", Font.BOLD, 100));

        // Set size of the window
        frame.setSize(width, height);
        frame.add(label, SwingConstants.CENTER);
        
        // Close the application when the window is closed
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        Random random = new Random();

        frame.setLocation(random.nextInt(900), random.nextInt(600));
        // Make the window visible
        frame.setVisible(true);
    }

   public void updateWindow() {
        int timer = (int) (initialTime - (System.currentTimeMillis() - startTime) / 1000);
        this.label.setText(String.valueOf(timer));

        // Change color based on odd/even
        this.label.setForeground(timer % 2 == 0 ? Color.RED : Color.BLACK);

        if (timer <= 0) {
            this.startTime = System.currentTimeMillis();
            duplicate(); 
        }
    }

    public void duplicate() {
        Constants.windowCounter += 1;
        Window newWindow = new Window(300, 300, "WINDOW " + Constants.windowCounter, new CountdownScreen());

        // Add to unconstructed windows so it's handled in the main loop
        Constants.unconstructedWindows.add(newWindow);
    }
}
