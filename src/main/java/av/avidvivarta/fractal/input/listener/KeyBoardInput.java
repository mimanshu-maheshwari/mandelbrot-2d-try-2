package av.avidvivarta.fractal.input.listener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardInput extends KeyAdapter implements KeyListener {

    boolean[] keyPressed = new boolean[128];

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code <= 128) {
            this.keyPressed[code] = true;
        }
        System.out.println("Key Pressed: " + e.getExtendedKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code <= 128) {
            this.keyPressed[code] = false;
        }
        System.out.println("Key Released: " + e.getExtendedKeyCode());
    }

    public boolean isUpPressed(){
        return keyPressed[KeyEvent.VK_UP];
    }
    public boolean isDownPressed(){
        return keyPressed[KeyEvent.VK_DOWN];
    }
    public boolean isLeftPressed(){
        return keyPressed[KeyEvent.VK_LEFT];
    }
    public boolean isRightPressed(){
        return keyPressed[KeyEvent.VK_RIGHT];
    }
}
