package Screens;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CountdownScreen extends Screen{
    int initialTime;
    JLabel label;
    double startTime;
    public CountdownScreen() {
        // Set the initial time that is desplayed in the begginging
        initialTime = 255;

        startTime = System.currentTimeMillis();
        label = new JLabel(String.valueOf(initialTime), SwingConstants.CENTER);
    }

    @Override
    public void constructWindow(JFrame frame, int width, int height) {
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

    // This will update the timer
    public void updateWindow() {
        // crete a timer that subtracts the current time by the starting time and gets it in seconds
        int timer = (int) (initialTime - (System.currentTimeMillis() - startTime)/1000);
        label.setText(String.valueOf(timer));

        // Changes the color based on odd or even number
        if (timer % 2 == 0) {
            label.setForeground(Color.red);
        } else {
            label.setForeground(Color.black);
        }
    }
}
