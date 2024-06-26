package av.avidvivarta.fractal.visual;

import av.avidvivarta.fractal.input.listener.KeyBoardInput;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Screen extends JPanel implements Runnable {

    private BufferedImage bufferedImage;
    public double angle = 0;

    public Screen() {
        bufferedImage = new BufferedImage(WindowProperties.getWidth(), WindowProperties.getHeight(), BufferedImage.TYPE_INT_RGB);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHints(rh);
        drawBackground(g2d, Color.darkGray);

        drawImage(g2d);

//         draw rotating circle
//        drawRotatingCircle(g2d);

    }

    private void drawBackground(Graphics2D g2d, Color c) {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(0, 0);
        path.lineTo(getWidth(), 0);
        path.lineTo(getWidth(), getHeight());
        path.lineTo(0, getHeight());
        path.closePath();
        g2d.setColor(c);
        g2d.fill(path);
    }

    public void updateScreenData(double dt, KeyBoardInput keyBoardInput) {
//        update values for rotating circle
//        updateScreenDataForRotatingCircle(dt, keyBoardInput);
    }

    private void drawImage(Graphics2D g2d){
        g2d.drawImage(bufferedImage, 0,0, getWidth(), getHeight(), null);
    }
    public void updateImagePixals(int[] data){
        for(int y = 0; y < getHeight(); y++){
            for(int x = 0; x < getWidth(); x++){
                bufferedImage.setRGB(x, y, 334954432);
            }
        }
    }
    private void updateScreenDataForRotatingCircle(double dt, KeyBoardInput keyBoardInput) {

        if (keyBoardInput.isUpPressed()) {
            this.angle += 2 * dt;
        }
        if (keyBoardInput.isDownPressed()) {
            this.angle -= 2 * dt;
        }
        if (keyBoardInput.isLeftPressed()) {
            this.angle -= 90 * dt;
        }
        if (keyBoardInput.isRightPressed()) {
            this.angle += 90 * dt;
        }
    }

    public void drawRotatingCircle(Graphics2D g2d) {
        // create a border cirle
        int pcr = 150, pcx = getWidth() / 2 - pcr, pcy = getHeight() / 2 - pcr;
        // center of path Circle;
        int pcxc = pcx + pcr, pcyc = pcy + pcr;
        Ellipse2D.Double pathCircle = new Ellipse2D.Double(pcx, pcy, 2 * pcr, 2 * pcr);
        g2d.setColor(Color.white);
        g2d.draw(pathCircle);

        // create a small circle at center of path circle
        int pccr = 5;
        Ellipse2D.Double pathCircleCenter = new Ellipse2D.Double(pcxc - pccr, pcyc - pccr, 2 * pccr, 2 * pccr);
        g2d.setColor(Color.white);
        g2d.fill(pathCircleCenter);

        // create a circle on the path of radius 20 px;
        int mcr = 10, mcx = (int) (Math.cos(Math.toRadians(angle)) * pcr + pcxc - mcr), mcy = (int) (Math.sin(Math.toRadians(angle)) * pcr + pcyc - mcr);
        // create center of moving circle
        int mcxc = mcx + mcr, mcyc = mcy + mcr;

        // create a line from center fo path circle to center of moving circle
        Path2D.Double radiusLine = new Path2D.Double();
        radiusLine.moveTo(pcxc, pcyc);
        radiusLine.lineTo(mcxc, mcyc);
        g2d.setColor(Color.white);
        g2d.draw(radiusLine);

        // create a circle at path
        Ellipse2D.Double movingCircle = new Ellipse2D.Double(mcx, mcy, 2 * mcr, 2 * mcr);
        g2d.setColor(Color.red);
        g2d.fill(movingCircle);

    }

    @Override
    public void run() {
    }
}
