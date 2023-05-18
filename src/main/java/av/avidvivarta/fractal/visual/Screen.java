package av.avidvivarta.fractal.visual;

import av.avidvivarta.fractal.input.listener.KeyBoardInput;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Screen extends JPanel {
    public int x = 100, y = 100, rectSize = 40, speed = 10;

    public Screen(){

       this.init();
    }

    public void init(){
        this.setBackground(Color.blue);
//        this.setDoubleBuffered(true);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(Color.white);
        graphics2D.fillRect(x, y, rectSize, rectSize);
        graphics2D.dispose();
    }

    public void updateScreenData(double dt, KeyBoardInput keyBoardInput){
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
//        System.out.println("x: " + x + ", y: " + y );
    }
}
