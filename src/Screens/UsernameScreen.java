package Screens;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.Random;

public class UsernameScreen extends Screen {
    @Override
    public void constructWindow(JFrame frame, int width, int height) {
        JLabel label = new JLabel("HELLO \n" + System.getProperty("user.name").toUpperCase(), SwingConstants.CENTER);
        label.setFont(new Font("Impact", Font.BOLD, 30));

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

    @Override
    public void updateWindow() {}
 }
