package av.avidvivarta.fractal.visual;

import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel {
    private int screenWidth = WindowProperties.getWidth();
    private int screenHeight = WindowProperties.getHeight();
    private double zoomFactor = WindowProperties.getZoom();

    public Screen(int screenWidth, int screenHeight){
       this.screenWidth = screenWidth;
       this.screenHeight = screenHeight;
       this.init();
    }

    public void init(){
        this.setPreferredSize(new Dimension(this.screenWidth, this.screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
    }
}
