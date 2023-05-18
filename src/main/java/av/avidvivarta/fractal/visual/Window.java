package av.avidvivarta.fractal.visual;

import javax.swing.*;

public class Window extends JFrame implements Runnable {

    private static Window window;
    private Screen screen;

    private boolean isRunning;
    private Window() {
        this.initWindowProperties();
        this.init();
    }


    public static Window getWindow() {
        return window == null ? Window.window = new Window() : Window.window;
    }

    private void init(){
        this.setTitle(WindowProperties.getTitle());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(this.screen);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.isRunning =true;

    }

    private void initWindowProperties() {
        this.screen = new Screen(WindowProperties.getWidth(), WindowProperties.getHeight());
    }
    @Override
    public void run() {

    }
}
