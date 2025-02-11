package Main;
import java.awt.MouseInfo;
import java.util.Random;

import javax.swing.JFrame;

import Main.Screens.Screen;

public class Window {
    // Dimensions
    int width;
    int height;

    // Stuff to create window
    String name;
    JFrame frame;
    Screen screen;

    // Points
    int x;
    int y;

    // Get a random speed for the speedFactor
    Random random = new Random();
    double maxNumerator;
    double minNumerator;
    double randNumerator;

    public Window(int width, int height, String name, Screen screen) {
        this.width = width;
        this.height = height;
        this.name = name;
        this.screen = screen;

        this.maxNumerator = 6;
        this.minNumerator = 2;
        this.randNumerator = random.nextDouble((maxNumerator - minNumerator) + 1) + minNumerator;
        System.out.println(randNumerator);

        frame = new JFrame(name);
    }
    
    // Add a screen to the window
    public void constructWindow() {
        screen.constructWindow(frame, width, height);
    }

    // Contains everything that must run in main update loop
    public void updateWindow() {
        if (!frame.isDisplayable()) {
            Constants.constructedWindows.remove(Constants.constructedWindows.indexOf(this));
        }
            
        // Get mouse positions
        x = (int) MouseInfo.getPointerInfo().getLocation().getX();
        y = (int) MouseInfo.getPointerInfo().getLocation().getY();

        // Run things to update
        screen.updateWindow();
        moveAwayFrom(x, y, 250);
        setBorder(100, 600, 100, 1100);
    }

    // Will move away from provided position
    public void moveAwayFrom(int x, int y, int maxSpeed) {
        // get the current pos
        int thisX = frame.getX();
        int thisY = frame.getY();
        
        // Find the distance between x&y values of the two points
        int dx = thisX - x;
        int dy = thisY - y;

        // Finding the distance between the two points on a 2d plane
        double distance = Math.sqrt(dx * dx + dy * dy);
        
        if (distance < 1) return; // No 0 division
        
        // Make sure speed stays below max speed
        double speedFactor = Math.min(maxSpeed, maxSpeed * (randNumerator / distance));
        
        // Find how much the x and y values of the window should move by
        int moveX = (int) (dx / distance * speedFactor);
        int moveY = (int) (dy / distance * speedFactor);
        
        frame.setLocation(thisX + moveX, thisY + moveY);
    }

    // Litterly just sets borders with if statements
    public void setBorder(int xBorderLeft, int yBorderBottom, int yBorderTop, int xBorderRight) {
        if (frame.getLocation().getX() < xBorderLeft) 
            {frame.setLocation(xBorderLeft + 5, frame.getY());}
        if (frame.getLocation().getY() > yBorderBottom) 
            {frame.setLocation(frame.getX(), yBorderBottom - 5);}
        if (frame.getLocation().getX() > xBorderRight) 
            {frame.setLocation(xBorderRight - 5, frame.getY());}
        if (frame.getLocation().getY() < yBorderTop) 
            {frame.setLocation(frame.getX(), yBorderTop + 5);}
    }
}
