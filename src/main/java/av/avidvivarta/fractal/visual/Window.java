package av.avidvivarta.fractal.visual;

import av.avidvivarta.fractal.input.listener.KeyBoardInput;
import av.avidvivarta.fractal.input.listener.MouseInput;
import av.avidvivarta.fractal.utils.Time;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame implements Runnable {

    private static Window window;
    private Thread windowThread;
    public Screen screen;
    private MouseInput mouseInput;
    private KeyBoardInput keyBoardInput;
    private boolean isRunning;

    private Window() {
        this.init();
        this.initWindowProperties();
    }


    public static Window getWindow() {
        return window == null ? Window.window = new Window() : Window.window;
    }

    private void init() {
        this.screen = new Screen(WindowProperties.getWidth(), WindowProperties.getHeight());
        this.keyBoardInput = new KeyBoardInput();
        this.mouseInput = new MouseInput();

    }

    private void initWindowProperties() {
        this.setResizable(false);
        this.setTitle(WindowProperties.getTitle());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(this.screen, BorderLayout.CENTER);
        this.pack();
        this.addKeyListener(this.keyBoardInput);
        this.addMouseListener(this.mouseInput);
        this.setFocusable(true);
        this.setLocationRelativeTo(null);
        this.isRunning = true;
        this.setVisible(true);
    }

    public void update(double dt){
//        System.out.println("update called");
        this.screen.update(dt, this.keyBoardInput);
    }
    public void render(){
        this.screen.paintComponent(getGraphics());

//        System.out.println("render called");
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
                this.update(delta);
                this.render();
                delta--;
            }
        }

    }

    public synchronized void start(){
        this.windowThread = new Thread(window, "window");
        this.windowThread.start();
    }
    public synchronized void stop(){
        try {
            this.windowThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
