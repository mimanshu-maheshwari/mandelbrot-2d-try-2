package av.avidvivarta.fractal.visual;

import av.avidvivarta.fractal.input.listener.KeyBoardInput;
import av.avidvivarta.fractal.input.listener.MouseInput;
import av.avidvivarta.fractal.utils.Time;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Window extends JFrame implements Runnable {

    private static Window window;
    private Thread windowThread;
    public Screen screen;
    private MouseInput mouseInput;
    private KeyBoardInput keyBoardInput;
    private boolean isRunning;
    private BufferedImage bufferedImage;

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
        this.setPreferredSize(new Dimension(WindowProperties.getWidth(), WindowProperties.getHeight()));
        this.setResizable(false);
        this.setTitle(WindowProperties.getTitle());
        this.add(this.screen, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.addKeyListener(this.keyBoardInput);
        this.addMouseListener(this.mouseInput);
        this.setFocusable(true);
        this.setVisible(true);
        this.isRunning = true;
        this.bufferedImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
    }

    public void update(double dt){
        this.screen.updateScreenData(dt, this.keyBoardInput);
    }
    public void render(){
        BufferStrategy bs = getBufferStrategy();
        if (bs == null){
            createBufferStrategy(3);
            return ;
        }
        Graphics g = bs.getDrawGraphics();
        this.screen.paintComponent(g);
        bs.show();
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
