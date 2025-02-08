package Screens;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CountdownScreen extends Screen{
    int time;
    JLabel label;
    double startTime;
    public CountdownScreen() {
        this.time = 255;
        startTime = System.currentTimeMillis();
        label = new JLabel(String.valueOf(time), SwingConstants.CENTER);
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

    public void updateWindow() {
        int timer = (int) (time - (System.currentTimeMillis() - startTime)/1000);
        label.setText(String.valueOf(timer));
        if (timer % 2 == 0) {
            label.setForeground(Color.red);
        } else {
            label.setForeground(Color.black);
        }
        System.out.println((System.currentTimeMillis() - startTime));
    }
}
