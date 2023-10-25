import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Bullet {

    int x;
    int y;
    float speedX;
    float speedY;
    int width;
    int height;
    float angulo;

    Rectangle rectangle;
    
    Bullet(int x, int y, int width, int height, float angulo){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.angulo = angulo;
        
        rectangle = new Rectangle(x, y, width, height);
    }

    public void update(){
        speedX = (float) (10 * Math.cos(angulo));
        speedY = (float) (10 * Math.sin(angulo));
        x += speedX;
        y += speedY;

        rectangle.x = x;
        rectangle.y = y;
        rectangle.width = width;
        rectangle.height = height;

    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.red);
        g2.fillRect(x, y, width, height);
        g2.setColor(Color.blue);
        g2.draw(rectangle);
    }

}
