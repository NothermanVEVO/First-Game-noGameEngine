import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Player {

    int playerX = 0;
    int playerY = 0;
    int playerWidth = 100;
    int playerHeight = 100;
    int playerSpeed = 6;
    Rectangle rectangle = new Rectangle(playerX, playerY, playerWidth, playerHeight);
    ArrayList<Bullet> bullets = new ArrayList<>();

    Player(){

    }

    public void update(TelaGame telaGame){

        if(telaGame.key.upPressed){
            playerY -= playerSpeed;
        }
        if(telaGame.key.downPressed){
            playerY += playerSpeed;
        }
        if(telaGame.key.leftPressed){
            playerX -= playerSpeed;
        }
        if(telaGame.key.rightPressed){
            playerX += playerSpeed;
        }

        if(telaGame.key.upPressed && telaGame.key.rightPressed){
            playerSpeed = 4;
        } else if(telaGame.key.upPressed && telaGame.key.leftPressed){
            playerSpeed = 4;
        } else if(telaGame.key.downPressed && telaGame.key.rightPressed){
            playerSpeed = 4;
        } else if(telaGame.key.downPressed && telaGame.key.leftPressed){
            playerSpeed = 4;
        } else{
            playerSpeed = 6;
        }

        if(telaGame.mouse.click){
            float angulo = (float) Math.atan2(telaGame.mouse.mouseY - (playerY + (playerHeight/2)), telaGame.mouse.mouseX - (playerX + (playerWidth/2)));
            bullets.add(new Bullet((playerX + (playerWidth/2)), (playerY + (playerHeight/2)), 25, 25, angulo));
            telaGame.mouse.click = false;
        }

        for(int i = 0; i < bullets.size(); i++){
            bullets.get(i).update();
        }

        rectangle.x = playerX;
        rectangle.y = playerY;
        rectangle.width = playerWidth;
        rectangle.height = playerHeight;

    }

    public void draw(Graphics2D g2){

        g2.setColor(Color.PINK);
        g2.fillRect(playerX, playerY, playerWidth, playerHeight);
        g2.setColor(Color.BLACK);
        g2.draw(rectangle);
        for(int i = 0; i < bullets.size(); i++){
            bullets.get(i).draw(g2);
        }

    }

}
