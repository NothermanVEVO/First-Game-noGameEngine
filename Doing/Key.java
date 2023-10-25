import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Key implements KeyListener{

    boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == 87){
            upPressed = true;
        }
        if(code == 65){
            leftPressed = true;
        }
        if(code == 83){
            downPressed = true;
        }
        if(code == 68){
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == 87){
            upPressed = false;
        }
        if(code == 65){
            leftPressed = false;
        }
        if(code == 83){
            downPressed = false;
        }
        if(code == 68){
            rightPressed = false;
        }
    }
    
}
