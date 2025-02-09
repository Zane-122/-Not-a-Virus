package Main.Screens;

import javax.swing.JFrame;

public abstract class Screen {
    // All things that extend screen must contain these methods
    public abstract void constructWindow(JFrame frame, int width, int height);
    public abstract void updateWindow();
}
