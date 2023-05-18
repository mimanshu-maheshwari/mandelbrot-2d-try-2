package av.avidvivarta.fractal.visual;

import av.avidvivarta.fractal.input.listener.KeyBoardInput;

import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel {
    private int screenWidth ;
    private int screenHeight;
    public int x = 100, y = 100, rectSize = 40, speed = 10;

    public Screen(int screenWidth, int screenHeight){
       this.screenWidth = screenWidth;
       this.screenHeight = screenHeight;
       this.init();
    }

    public void init(){
        this.setPreferredSize(new Dimension(this.screenWidth, this.screenHeight));
//        this.setBackground(Color.blue);
        this.setDoubleBuffered(true);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(Color.white);
        graphics2D.fillRect(x, y, rectSize, rectSize);
        graphics2D.dispose();
    }

    public void update(double dt, KeyBoardInput keyBoardInput){
        if (keyBoardInput.isUpPressed()){
            y -= speed * dt;
            y = y > 0 ? y : 0;
        }
        if (keyBoardInput.isDownPressed()){
            y += speed* dt;
            y =  y < getHeight()  ? y : getHeight() - rectSize;
        }
        if (keyBoardInput.isLeftPressed()){
            x -= speed* dt;
            x = x > 0 ? x : 0;
        }
        if (keyBoardInput.isRightPressed()){
            x += speed* dt;
            x = x < getWidth() - rectSize ? x :  getWidth() - rectSize;
        }
        System.out.println("x: " + x + ", y: " + y );
    }
}
