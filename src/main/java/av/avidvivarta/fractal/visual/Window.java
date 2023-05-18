package av.avidvivarta.fractal.visual;

import javax.swing.*;

public class Window extends JFrame implements Runnable {

    private Window window;

    private boolean isRunning;
    private Window() {
        this.init();
    }

    public Window getWindow() {
        return window == null ? this.window = new Window() : this.window;
    }

    private void init(){
        this.isRunning =true;
    }

    @Override
    public void run() {

    }
}
