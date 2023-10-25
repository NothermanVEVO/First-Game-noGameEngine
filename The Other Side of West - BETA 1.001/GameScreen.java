import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameScreen extends JPanel{

    EnemySpawner enemySpawner = new EnemySpawner();
    boolean canSpawn = true;

    int speedX = 5;
    int speedY = 5;

    int lua = 0;
    int sol = 0;

    int x = 0;
    int y = 0;
    int nume = 0;

    int pX;
    int pY;

    int tPlayerX;
    int tPlayerY;

    Player player = new Player(null, 0, 1);

    Rectangle rectangleP;

    ArrayList <CheckEnemyHit> checkEnemyHit = new ArrayList<CheckEnemyHit>();
    ArrayList <Enemy> enemy = new ArrayList<Enemy>();
    
    Random random = new Random();

    int direction;
    int quantEnemy;
    ArrayList<Integer> typeOfEnemy = new ArrayList<Integer>();

    int confere;

    boolean dont;

    int moment = 0;

    GamePanel gamePanel;

    TheClock clock = new TheClock();

    Hability hability = new Hability(0);

    TheMouse mouse = new TheMouse();

    int bala = -1;

    boolean oneTime = true;

    boolean stop;

    Cutscene cutscene = new Cutscene();

    BufferedImage hearts, floor;
    Image heart, chao;

    int xFloor1 = 0, xFloor2 = 900, xFloor3 = 900, xFloor4 = 0;
    int yFloor1 = 0, yFloor2 = 600, yFloor3 = 0, yFloor4 = 600;

    GameScreen(){

        /*this.setSize(900, 600);
        this.setBackground(Color.WHITE);
        this.setOpaque(true);*/

        try {
            hearts = ImageIO.read(getClass().getResourceAsStream("assets\\theHeart.png"));
            floor = ImageIO.read(getClass().getResourceAsStream("assets\\Chao.png"));
            heart = hearts.getScaledInstance(64, 76, Image.SCALE_DEFAULT);
        } catch (IOException e) {
        }

        for(int i = 0; i < enemy.size(); i++){
            if(direction == 1){
                enemy.get(i).y -= 300;
            } else if(direction == 2){
                enemy.get(i).y += 400;
            } else if(direction == 3){
                enemy.get(i).x += 500;
            } else if(direction == 4){
                enemy.get(i).x -= 500;
            } else{
                System.out.println("ERRO!!!!");
            }
        }

    }

    public void update(int theX, int theY, TheKey key, Rectangle rectanglePlayer, Player player,
    GamePanel gamePanel, TheMouse mouse){

        clock.createClock();

        hability.num = player.num;

        this.pX = theX;
        this.pY = theY;
        this.rectangleP = rectanglePlayer;
        this.player = player;
        this.gamePanel = gamePanel;

        this.mouse = mouse;

        if(hability.num == 0){
            if(hability.hability2){
                speedX = Math.abs(hability.speedX);
                speedY = Math.abs(hability.speedY);
            } else if(hability.hability2 == false){
                speedX = 5;
                speedY = 5;
            }
        } else if(hability.num == 1){
            if(hability.hability2){
                speedX = hability.speedX;
                speedY = hability.speedY;
            } else if(hability.hability2 == false){
                speedX = 5;
                speedY = 5;
            }
        }

        if((pX <= 300 && key.leftPressed && player.cutscene == false) || 
            (pX <= 300 && player.kbTimer > 0) || (pX <= 300 && hability.goingLeft)){
            x += speedX;
        } if((pX >= 500 && key.rightPressed && player.cutscene == false) || 
            (pX >= 500 && player.kbTimer > 0) || (pX >= 500 && hability.goingRight)){
            x -= speedX;
        } if((pY <= 150 && key.upPressed && player.cutscene == false) || 
            (pY <= 150 && player.kbTimer > 0) || (pY <= 150 && hability.goingUp)){
            y += speedY;
        } if((pY >= 350 && key.downPressed && player.cutscene == false) || 
            (pY >= 350 && player.kbTimer > 0) || (pY >= 350 && hability.goingDown)){
            y -= speedY;
        }

        rectangleP.x -= x;
        rectangleP.y -= y;
        for(int i = 0; i < player.bullets.size(); i++){
            player.bullets.get(i).rectangle.x -= x;
            player.bullets.get(i).rectangle.y -= y;
            if(player.bullets.size() == bala){
                player.bullets.get(bala - 1).perfurante = true;
            }
        }
        tPlayerX = pX - x;
        tPlayerY = pY - y;

        for(int i = 0; i < enemy.size(); i++){
            enemy.get(i).update(tPlayerX, tPlayerY, key, player);
            checkEnemyHit.get(i).update(enemy.get(i), player, this, hability);
            if(enemy.get(i).hittedBullet){
                enemy.get(i).life--;
            }
            if(enemy.get(i).life <= 0){
                enemy.remove(i);
                player.combo++;
                checkEnemyHit.remove(i);
            }
        }

        if(lua > 0){
            lua++;
                if(lua >= 60){
                    lua = 0;
                }
        }

        // for(int i = 0; i < enemy.size(); i++){
        //     for(int j = 0; j < enemy.size(); j++){
        //         if(!(j == i)){
        //             if(enemy.get(i).rectangle.intersects(enemy.get(j).rectangle)){
        //                 enemy.get(i).fuckCollision = true;
        //                 enemy.get(j).fuckCollision = true;
        //             }
        //         }
        //     }
        // }

        if(clock.uSegundo == 0 && clock.dSegundo == 0 && clock.uMinuto == 0 && clock.timer == 1){
            moment = 1; //1
            System.out.println("MOMENTO 1");
        } else if(clock.uSegundo == 5 && clock.dSegundo == 1 && clock.uMinuto == 0 
            && clock.dMinuto == 0 && clock.timer == 1){
            moment = 2; //9 //2
            System.out.println("MOMENTO 2");
        } else if(clock.uSegundo == 0 && clock.dSegundo == 3 && clock.uMinuto == 0 
            && clock.dMinuto == 0 && clock.timer == 1){
            moment = 3; //10 //3
            System.out.println("MOMENTO 3");
        } else if(clock.uSegundo == 0 && clock.dSegundo == 5 && clock.uMinuto == 0 
            && clock.dMinuto == 0 && clock.timer == 1){
            moment = 4; //4
            System.out.println("MOMENTO 4");
        } else if(clock.uSegundo == 0 && clock.dSegundo == 5 && clock.uMinuto == 1 
            && clock.dMinuto == 0 && clock.timer == 1){
            moment = 5; //5
            System.out.println("MOMENTO 5");
        }else if(clock.uSegundo == 0 && clock.dSegundo == 5 && clock.uMinuto == 2 
            && clock.dMinuto == 0 && clock.timer == 1){
            moment = 9; //9
            System.out.println("MOMENTO 9");
        }else if(clock.uSegundo == 0 && clock.dSegundo == 0 && clock.uMinuto == 3 
            && clock.dMinuto == 0 && clock.timer == 1){
            moment = 10; //10
            System.out.println("MOMENTO 10");
        }else if(clock.uSegundo == 0 && clock.dSegundo == 1 && clock.uMinuto == 3 
            && clock.dMinuto == 0 && clock.timer == 1){
            moment = 6; //6
            System.out.println("MOMENTO 6");
        }else if(clock.uSegundo == 0 && clock.dSegundo == 1 && clock.uMinuto == 4 
            && clock.dMinuto == 0 && clock.timer == 1){
            moment = 100; //100
            System.out.println("MOMENTO 100");
        }

        if(clock.uSegundo % 5 == 0 && clock.timer == 1 && stop == false){
            enemySpawner.update(enemy, checkEnemyHit, tPlayerX, tPlayerY, moment);
        }

        if(moment == 100){
            stop = true;
        }

        if(stop){
            for(int i = 0; i < enemy.size(); i++){
                if(enemy.get(i).boss == false){
                    enemy.remove(i);
                    checkEnemyHit.remove(i);
                }
            }
        }

        // if(oneTime){
        //     moment = 100;
        //     enemySpawner.update(enemy, checkEnemyHit, tPlayerX, tPlayerY, moment);
        //     oneTime = false;
        // }

        for(int i = 0; i < enemy.size(); i++){
            for(int j = 0; j < enemy.size(); j++){
                int temp = j;
                if(j == i){
                    dont = true;
                } else{
                    dont = false;
                }
                if(enemy.get(i).rectangle.intersects(enemy.get(j).rectangle) && dont == false){
                    // System.out.println("AINNNN ZÉ DA MAAÃNGA");
                    if(enemy.get(i).x == enemy.get(j).x){
                        int xOy;
                        xOy = random.nextInt(2) + 1;
                        if(xOy == 1){
                            enemy.get(i).y += 120;
                        } else if(xOy == 2){
                            enemy.get(i).x += 120;
                        } else{
                            System.out.println("ERRO");
                        }
                    }
                }
                // if((enemy.get(i).enemyCollision.intersects(enemy.get(j).enemyCollision)) 
                //     && dont == false){
                // }
                dont = false;
                j = temp;
            }
            // if(yago==lindão) {
            //     System.out.println("iiiiiiiiii");
            // }
        }

        hability.update(key, mouse, player, enemy);

        if(hability.perfEffect){
            bala = player.bullets.size() + 1;
            hability.perfEffect = false;
        }

        cutscene.update(moment, player);
        if(player.cutscene){
            for(int i = 0; i < enemy.size(); i++){
                enemy.remove(i);
            }
        }

        // System.out.println(bala);
        // System.out.println(player.bullets.size());

    }

    public void draw(Graphics2D g2){

        g2.translate(x, y);
        // System.out.println("X: " + player.playerX + " Y: " + player.playerY);
        // g2.setColor(Color.DARK_GRAY);
        // g2.fillRect(0, 0, 900, 600);
        // g2.drawImage(chao, -4500, -3000, null);
        g2.setBackground(new Color(236, 198, 160));
        // g2.drawImage(floor, xFloor1, yFloor1, null);
        // g2.drawImage(floor, xFloor2, yFloor2, null);
        // g2.drawImage(floor, xFloor3, yFloor3, null);
        // g2.drawImage(floor, xFloor4, yFloor4, null);
        // if(player.playerY >= (yFloor1 + 300)){
        //     System.out.println("OI");
        // }

        Rectangle drawScene = new Rectangle(-x - 50, -y - 50, 983, 660);
        g2.setColor(Color.red);
        g2.draw(drawScene);

        for(int i = 0; i < enemy.size(); i++){
            // if(drawScene.intersects(enemy.get(i).rectangle)){
                enemy.get(i).draw(g2);
                // g2.draw(enemy.get(i).enemyCollision);
            // }
        }
        g2.setColor(Color.PINK);
        // g2.draw(enemy.bullet.rectangle);
        // g2.draw(enemy.rectangle);
        // g2.draw(rectangleP);
        g2.translate(-x, -y);

        hability.draw(g2);

        g2.setColor(Color.PINK);

        if(player.vida > 0){
            // g2.fillRect(10, 10, 50, 50);
            g2.drawImage(heart, 10, 10, null);
        }
        if(player.vida > 1){
            // g2.fillRect(80, 10, 50, 50);
            g2.drawImage(heart, 80, 10, null);
        }
        if(player.vida > 2){
            // g2.fillRect(150, 10, 50, 50);
            g2.drawImage(heart, 150, 10, null);
        }

        if(player.vida == 0){
            // System.exit(0);
        }

        player.draw(g2);

        cutscene.draw(g2);

    }

}
