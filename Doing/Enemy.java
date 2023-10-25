import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Enemy {

    int enemyX = 700;
    int enemyY = 300;
    float enemyVx;
    float enemyVy;
    int enemyWidth = 100;
    int enemyHeight = 100;
    Rectangle rectangle = new Rectangle(enemyX, enemyY, enemyWidth, enemyHeight);

    Enemy(){

    }

    public void update(Player player){

        float angulo = (float) Math.atan2(player.playerY - enemyY, player.playerX - enemyX);

        enemyVx = 4 * (float) Math.cos(angulo);
        enemyVy = 4 * (float) Math.sin(angulo);

        enemyX += enemyVx;
        enemyY += enemyVy;

        rectangle.x = enemyX;
        rectangle.y = enemyY;
        rectangle.width = enemyWidth;
        rectangle.height = enemyHeight;
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.lightGray);
        g2.fillRect(enemyX, enemyY, enemyWidth, enemyHeight);
        g2.setColor(Color.red);
        g2.draw(rectangle);
    }
    
}
