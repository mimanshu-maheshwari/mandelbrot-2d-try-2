package av.avidvivarta.fractal.visual;

import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel {
    private int screenWidth ;
    private int screenHeight;

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
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(Color.white);
        graphics2D.fillRect(100, 100, 20, 20);
        graphics2D.dispose();
    }
}
