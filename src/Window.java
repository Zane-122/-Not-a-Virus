import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.JFrame;

import Screens.Screen;

public class Window {
    int width;
    int height;
    String name;
    JFrame frame;
    Screen screen;
    int x;
    int y;

    public Window(int width, int height, String name, Screen screen) {
        this.width = width;
        this.height = height;
        this.name = name;
        this.screen = screen;

        frame = new JFrame(name);
    }
    
    public void constructWindow() {
        screen.constructWindow(frame, width, height);
    }

    public void updateWindow() {
        x = (int) MouseInfo.getPointerInfo().getLocation().getX();
        y = (int) MouseInfo.getPointerInfo().getLocation().getY();

        screen.updateWindow();
        moveAwayFrom(x, y, 250);
        setBorder(100, 600, 100, 1100);
    }

    public void moveAwayFrom(int x, int y, int maxSpeed) {
        int thisX = frame.getX();
        int thisY = frame.getY();
    
        int dx = thisX - x;
        int dy = thisY - y;
        
        double distance = Math.sqrt(dx * dx + dy * dy);
    
        if (distance < 1) return;
    
        double speedFactor = Math.min(maxSpeed, maxSpeed * (5.0 / distance));
    
        int moveX = (int) (dx / distance * speedFactor);
        int moveY = (int) (dy / distance * speedFactor);
    
        frame.setLocation(thisX + moveX, thisY + moveY);
    }

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

    public Point getPosition() {
        return new Point(frame.getX(), frame.getY());
    }
}
