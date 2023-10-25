import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Bullet {

    int num = 0;

    // float angle;
    float x = 0;
    float y = 0;
    float velX = 0;
    float velY = 0;

    boolean click = false;

    int speed;

    Rectangle rectangle = new Rectangle((int) x, (int) y, 10, 10);

    boolean perfurante = false;

    boolean speedEffect;
    int theSpeed = 0;

    boolean die;
    int dieCount = 0;

    Bullet(float x2, float y2){

        this.x = x2;
        this.y = y2;

    }

    public void update(float angle, int speed){

        this.speed = speed;

        if(speedEffect){
            speed = theSpeed;
        }

        velX = (float) ((speed) * Math.cos(angle));
        velY = (float) ((speed) * Math.sin(angle));

        x += velX;
        y += velY;

        dieCount++;
        if(dieCount >= 720){
            die = true;
        }

    }

    public void draw(Graphics2D g2){

        g2.setColor(Color.black);
        g2.fillRect((int) x, (int) y, 10, 10);
        rectangle = new Rectangle((int) x, (int) y, 10, 10);
        // g2.draw(rectangle);

    }

}
