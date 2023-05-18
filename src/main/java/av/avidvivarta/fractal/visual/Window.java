package av.avidvivarta.fractal.visual;

import av.avidvivarta.fractal.utils.Time;

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

    private void init() {
        this.setTitle(WindowProperties.getTitle());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(this.screen);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.isRunning = true;

    }

    private void initWindowProperties() {
        this.screen = new Screen(WindowProperties.getWidth(), WindowProperties.getHeight());
    }

    public void update(){
        System.out.println("update called");
    }
    public void render(){
        System.out.println("render called");
    }
    @Override
    public void run() {
        double drawInterval = Time.OneSecondInNanoSecond / WindowProperties.getFps();
        double delta = 0;
        long lastTime = Time.getCurrentTimeInNano();
        long currentTime ;
        while(isRunning){
            currentTime = Time.getCurrentTimeInNano();
            delta += (currentTime - lastTime)/ drawInterval;
            lastTime = currentTime;
            while(delta >= 1){
                this.update();
                this.render();
                delta--;
            }
        }

    }
}
