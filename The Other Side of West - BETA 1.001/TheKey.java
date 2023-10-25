import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TheKey implements KeyListener{

    boolean upPressed;
    boolean downPressed;
    boolean rightPressed;
    boolean leftPressed;

    boolean letterE, letterQ;

    boolean pause;

    boolean reloading;

    boolean checkPause = true;

    TheKey(){
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            upPressed = true;
        } else if(code == KeyEvent.VK_S){
            downPressed = true;
        } else if(code == KeyEvent.VK_A){
            leftPressed = true;
        } else if(code == KeyEvent.VK_D){
            rightPressed = true;
        }

        if(code == 27 && checkPause){
            if(pause == false){
                pause = true;
                checkPause = false;
            } else{
                pause = false;
                checkPause = false;
            }
        }

        if(code == 69){
            letterE = true;
        }

        if(code == 81){
            letterQ = true;
        }

        if(code == 82){
            reloading = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            upPressed = false;
        } else if(code == KeyEvent.VK_S){
            downPressed = false;
        } else if(code == KeyEvent.VK_A){
            leftPressed = false;
        } else if(code == KeyEvent.VK_D){
            rightPressed = false;
        }

        if(code == 69){
            letterE = false;
        }
        if(code == 81){
            letterQ = false;
        }
        if(code == 82){
            reloading = false;
        }
        if(code == 27){
            checkPause = true;
        }

    }

}
