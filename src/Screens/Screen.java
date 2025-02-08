package Screens;

import javax.swing.JFrame;

public abstract class Screen {
    public abstract void constructWindow(JFrame frame, int width, int height);
    public abstract void updateWindow();
}
