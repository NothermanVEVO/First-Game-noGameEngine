import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class TheMouse implements MouseListener, MouseMotionListener{

    boolean mouseClicked;
    boolean mouseReleased;
    boolean buttonLeft;
    boolean inThere;
    int codeX;
    int codeY;
    int movCodeX;
    int movCodeY;

    boolean leftButton;
    boolean rightButton;

    Cursor cursor = new Cursor(Cursor.HAND_CURSOR); 
    Cursor cursor0 = new Cursor(Cursor.DEFAULT_CURSOR);

    TheMouse(){

        // MouseListener.super.mousePressed(MouseEvent e){}

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        // System.out.println("Click");
        // codeX = e.getX();
        // codeY = e.getY();

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // System.out.println("CLICKED");
        int code = e.getButton();

        if(code == 3){
            buttonLeft = true;
        }

        if(inThere){
            if(code == 1){
                mouseClicked = true;
            }
        } else{
            mouseClicked = false;
        }
        mouseReleased = false;
        leftButton = true;
        rightButton = true;

        codeX = e.getX();
        codeY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        int code = e.getButton();

        if(code == 3){
            buttonLeft = false;
        }

        mouseClicked = false;
        if(inThere){
            if(code == 1){
                mouseReleased = true;
            }
        } else{
            mouseReleased = false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        inThere = true;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        inThere = false;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {

        movCodeX = e.getX();
        movCodeY = e.getY();

    }

}
