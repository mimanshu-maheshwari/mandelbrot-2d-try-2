package av.avidvivarta.fractal.visual;
import av.avidvivarta.fractal.input.listener.KeyBoardInput;
import av.avidvivarta.fractal.input.listener.MouseInput;
import av.avidvivarta.fractal.utils.Time;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

public class Window extends JFrame implements Runnable {

    private static Window window;
    private Thread windowThread;
    public Screen screen;
    public Thread screenThread;
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
        this.screen = new Screen();
        this.keyBoardInput = new KeyBoardInput();
        this.mouseInput = new MouseInput();
    }

    private void initWindowProperties() {
        this.setSize(new Dimension(WindowProperties.getWidth(), WindowProperties.getHeight()));
        this.setTitle(WindowProperties.getTitle());
        this.setResizable(true);
        this.add(this.screen);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.addKeyListener(this.keyBoardInput);
        this.addMouseListener(this.mouseInput);
        this.setFocusable(true);
        this.setVisible(true);
        this.isRunning = true;
    }

    public void update(double dt){
        int[] data = new int[getWidth() * getHeight()];
        for(int y = 0; y < getHeight(); y++){
            for(int x = 0; x < getWidth(); x++){
                data[y * getWidth() + x] = 2342;
            }
        }
        this.screen.updateImagePixals(data);
        this.screen.updateScreenData(dt, this.keyBoardInput);
    }
    public void render(){
        this.screen.repaint();
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
        this.screenThread = new Thread(screen, "screen");
        this.screenThread.start();
    }
    public synchronized void stop(){
        try {
            this.windowThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
