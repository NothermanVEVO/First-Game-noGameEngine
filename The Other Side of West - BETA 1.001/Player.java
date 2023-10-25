import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class Player extends JLabel{

    int playerX = 400;
    int playerY = 250;
    int speed = 5;

    //correndo
    int go = 0;
    int bro = 0;

    //parado
    int stop = 0;
    int sister = 0;

    //cambalhota
    boolean cambalhota;

    boolean right = true;
    boolean left;

    TheKey key = new TheKey();

    BufferedImage playerParadoDireita1;
    BufferedImage playerParadoDireita2;
    BufferedImage playerParadoEsquerda1;
    BufferedImage playerParadoEsquerda2;
    BufferedImage playerCorrendoDireita;
    BufferedImage playerCorrendoEsquerda;
    BufferedImage playerCambalhotaDireita1;
    BufferedImage playerCambalhotaDireita2;
    BufferedImage playerCambalhotaDireita3;
    BufferedImage playerCambalhotaDireita4;
    BufferedImage playerCambalhotaEsquerda1;
    BufferedImage playerCambalhotaEsquerda2;
    BufferedImage playerCambalhotaEsquerda3;
    BufferedImage playerCambalhotaEsquerda4;
    Image image1, image2, image3, image4, image5, image6;
    Image image7Done, image7Dtwo, image7Dthree, image7Dfour;
    Image image8Eone, image8Etwo, image8Ethree, image8Efour;
    Image finalImage;

    BufferedImage sombra;
    Image sSombra;

    Rectangle rectangle = new Rectangle(playerX + 25, playerY + 40, 50, 60);

    float theAngle;

    float hitAngle;
    float hittedAngle;
    int kbTimer = 0;
    boolean hittedBullet;
    boolean hittedEnemy;
    float vX = 0;
    float vY = 0;

    boolean knockback = true;

    ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    ArrayList<Float> angles = new ArrayList<Float>();

    boolean canMoveUp = true, canMoveDown = true, canMoveRight = true, canMoveLeft = true;

    int vida = 3;

    int shootDelay = 0;
    boolean canShoot = true;

    int multDelay = 1;

    int num;

    int reload = 0;

    boolean notReloading = true;
    boolean autoReload;

    boolean cutscene;

    int munit;

    boolean notHere;

    int combo = 0;
    int highestCombo = combo;
    boolean levouDano;

    boolean ocorreu;
    boolean endGame;
    boolean lose;
    boolean won;

    boolean resetar;

    Player(TheKey key, int num, int type){

        if(type == 1){
            munit = 6;
        }

        this.num = num;

        this.key = key;
        this.addKeyListener(key);
        try {
            if(num == 0){

                sombra = ImageIO.read(getClass().getResourceAsStream("assets\\Sombra.png"));
                sSombra = sombra.getScaledInstance(85, 85, Image.SCALE_DEFAULT);

                playerParadoDireita1 = ImageIO.read(getClass().getResourceAsStream("assets\\Comboy1OneParadoDireita1.png"));
                image1 = playerParadoDireita1.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                finalImage = image1;

                playerParadoDireita2 = ImageIO.read(getClass().getResourceAsStream("assets\\Comboy1OneParadoDireita2.png"));
                image2 = playerParadoDireita2.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                playerParadoEsquerda1 = ImageIO.read(getClass().getResourceAsStream("assets\\Comboy1OneParadoEsquerda1.png"));
                image3 = playerParadoEsquerda1.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                playerParadoEsquerda2 = ImageIO.read(getClass().getResourceAsStream("assets\\Comboy1OneParadoEsquerda2.png"));
                image4 = playerParadoEsquerda2.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                playerCorrendoDireita = ImageIO.read(getClass().getResourceAsStream("assets\\Comboy1OneCorrendoDireita.png"));
                image5 = playerCorrendoDireita.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                playerCorrendoEsquerda = ImageIO.read(getClass().getResourceAsStream("assets\\Comboy1OneCorrendoEsquerda.png"));
                image6 = playerCorrendoEsquerda.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                //cambalhota direita

                playerCambalhotaDireita1 = ImageIO.read(getClass().getResourceAsStream("assets\\Comboy1OneCambalhota1Direita.png"));
                image7Done = playerCambalhotaDireita1.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                playerCambalhotaDireita2 = ImageIO.read(getClass().getResourceAsStream("assets\\Comboy1OneCambalhota2Direita.png"));
                image7Dtwo = playerCambalhotaDireita2.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                playerCambalhotaDireita3 = ImageIO.read(getClass().getResourceAsStream("assets\\Comboy1OneCambalhota3Direita.png"));
                image7Dthree = playerCambalhotaDireita3.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                playerCambalhotaDireita4 = ImageIO.read(getClass().getResourceAsStream("assets\\Comboy1OneCambalhota4Direita.png"));
                image7Dfour = playerCambalhotaDireita4.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                //cambalhota esquerda

                playerCambalhotaEsquerda1 = ImageIO.read(getClass().getResourceAsStream("assets\\Comboy1OneCambalhota1Esquerda.png"));
                image8Eone = playerCambalhotaEsquerda1.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                playerCambalhotaEsquerda2 = ImageIO.read(getClass().getResourceAsStream("assets\\Comboy1OneCambalhota2Esquerda.png"));
                image8Etwo = playerCambalhotaEsquerda2.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                playerCambalhotaEsquerda3 = ImageIO.read(getClass().getResourceAsStream("assets\\Comboy1OneCambalhota3Esquerda.png"));
                image8Ethree = playerCambalhotaEsquerda3.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                playerCambalhotaEsquerda4 = ImageIO.read(getClass().getResourceAsStream("assets\\Comboy1OneCambalhota4Esquerda.png"));
                image8Efour = playerCambalhotaEsquerda4.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

            } else if(num == 1){
                sombra = ImageIO.read(getClass().getResourceAsStream("assets\\Sombra.png"));
                sSombra = sombra.getScaledInstance(85, 85, Image.SCALE_DEFAULT);

                playerParadoDireita1 = ImageIO.read(getClass().getResourceAsStream("assets\\Comboy2OneParadoDireita1.png"));
                image1 = playerParadoDireita1.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                finalImage = image1;

                playerParadoDireita2 = ImageIO.read(getClass().getResourceAsStream("assets\\Comboy2OneParadoDireita2.png"));
                image2 = playerParadoDireita2.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                playerParadoEsquerda1 = ImageIO.read(getClass().getResourceAsStream("assets\\Comboy2OneParadoEsquerda1.png"));
                image3 = playerParadoEsquerda1.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                playerParadoEsquerda2 = ImageIO.read(getClass().getResourceAsStream("assets\\Comboy2OneParadoEsquerda2.png"));
                image4 = playerParadoEsquerda2.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                playerCorrendoDireita = ImageIO.read(getClass().getResourceAsStream("assets\\Comboy2OneCorrendoDireita.png"));
                image5 = playerCorrendoDireita.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                playerCorrendoEsquerda = ImageIO.read(getClass().getResourceAsStream("assets\\Comboy2OneCorrendoEsquerda.png"));
                image6 = playerCorrendoEsquerda.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            }
        } catch (Exception e) {
        }

    }

    public void update(int num, TheMouse mouse){

        if(resetar){
            playerX = 400;
            playerY = 250;
            combo = 0;
            highestCombo = 0;
            vida = 3;
            munit = 6;
            endGame = false;
            lose = false;
            won = false;
            resetar = false;
        }

        if(key.upPressed && canMoveUp && cutscene == false){
            playerY -= speed;
        }
        if(key.downPressed && canMoveDown && cutscene == false){
            playerY += speed;
        }
        if(key.leftPressed && canMoveLeft && cutscene == false){
            left = true;
            right = false;
            playerX -= speed;
            // finalImage = image3;
        }
        if(key.rightPressed && canMoveRight && cutscene == false){
            right = true;
            left = false;
            playerX += speed;
            // finalImage = image1;
        }

        if(key.upPressed || key.downPressed || key.leftPressed || key.rightPressed){
            stop = 0;
            sister = 0;
            if(right){
                if(cambalhota == false){
                    go++;
                    if(go > 10){
                        if(bro == 0){
                            bro = 1;
                            go = 0;
                        } else {
                            bro = 0;
                            go = 0;
                        }
                    }
                    if(bro == 0){
                        finalImage = image1;
                    } else if (bro == 1){
                        finalImage = image5;
                    }
                }
            } else if(left){
                if(cambalhota == false){
                    go++;
                    if(go > 10){
                        if(bro == 0){
                            bro = 1;
                            go = 0;
                        } else {
                            bro = 0;
                            go = 0;
                        }
                    }
                    if(bro == 0){
                        finalImage = image3;
                    } else if(bro == 1){
                        finalImage = image6;
                    }
                }
            }
        } else {
            go = 0;
            if(right){
                // sister = 0;
                if(cambalhota == false){
                    stop++;
                    if(stop > 20){
                        if(sister == 0){
                            sister = 1;
                                stop = 0;
                        } else {
                            sister = 0;
                            stop = 0;
                        }
                    }
                    if(sister == 0){
                        finalImage = image1;
                    } else if (sister == 1){
                        finalImage = image2;
                    }
                }
            } else if(left){
                // sister = 0;
                if(cambalhota == false){
                    stop++;
                    if(stop > 20){
                        if(sister == 0){
                            sister = 1;
                            stop = 0;
                        } else {
                            sister = 0;
                            stop = 0;
                        }
                    }
                    if(sister == 0){
                        finalImage = image3;
                    } else if (sister == 1){
                        finalImage = image4;
                    }
                }
            }
        }

        if(playerX < 300){
            playerX = 300;
        } if(playerX > 500){
            playerX = 500;
        } if(playerY < 150 && cutscene == false){
            playerY = 150;
        } if(playerY > 350){
            playerY = 350;
        }

        // System.out.println("X: " + playerX + " Y: " + playerY);

        if(mouse.mouseClicked && canShoot && notReloading && munit > 0 && cutscene == false){
            bullets.add(new Bullet(playerX + 50, playerY + 50));
            angles.add((float) Math.atan2(mouse.codeY - (playerY + 50), 
                mouse.codeX - (playerX + 50)));
            munit--;
            mouse.mouseClicked = false;
            canShoot = false;
        }

        if(canShoot == false){
            shootDelay++;
            if(shootDelay >= (15 * multDelay)){
                canShoot = true;
                shootDelay = 0;
            }
        }

        if(munit == 0){
            autoReload = true;
        }

        if(munit < 6){
            if(key.reloading){
                notReloading = false;
                key.reloading = false;
            }
        }

        if(mouse.mouseClicked){
            if(notReloading == false && munit > 0){
                notReloading = true;
                reload = 0;
            }
        }

        if(notReloading == false || autoReload){
            reload++;
            // System.out.println("reloading");
            if(reload >= 45){
                notReloading = true;
                autoReload = false;
                munit = 6;
                reload = 0;
            }
        }

        for(int i = 0; i < bullets.size(); i++){
            bullets.get(i).update(angles.get(i), 10);
        }

        if(hittedBullet){
            vX = (float) ((5) * (Math.cos(hitAngle) / 2));
            vY = (float) ((5) * (Math.sin(hitAngle) / 2));
            hittedBullet = false;
        }

        if(hittedEnemy){
            if(knockback){
                vX = (float) ((5) * Math.cos(hittedAngle));
                vY = (float) ((5) * Math.sin(hittedAngle));
                hittedEnemy = false;
            }
        }

        if(vX != 0 || vY != 0){
            kbTimer++;
            playerX += vX;
            playerY += vY;
            canMoveUp = false;
            canMoveDown = false;
            canMoveRight = false;
            canMoveLeft = false;
            if(kbTimer > 15){
                vX = 0;
                vY = 0;
                canMoveUp = true;
                canMoveDown = true;
                canMoveRight = true;
                canMoveLeft = true;
                kbTimer = 0;
            }
        }


        if(vida == 0){
            // System.out.println("!!!!!GAME OVER!!!!!");
            endGame = true;
            lose = true;
        } else{
            // System.out.println(vida);
        }

        // if(vida < 0){
        //     vida = 3;
        // }

        if(combo > highestCombo){
            highestCombo = combo;
        }

        if(levouDano){
            combo = 0;
            levouDano = false;
        }

    }

    public void draw(Graphics2D g2){

        g2.setColor(Color.BLACK);
        g2.setFont(new Font("MV Boli", Font.PLAIN, 20));
        g2.drawString("Ammo: " + munit + "/ 6", 0, 200);
        g2.setFont(new Font("MV Boli", Font.PLAIN, 40));
        g2.drawString("Combo: " + combo, 620, 50);
        if(notReloading == false || autoReload){
            g2.setColor(Color.red);
            g2.fillRect(playerX + 5, playerY - 16, 90, 10);
        }
        g2.setColor(Color.GREEN);
        g2.fillRect(playerX + 5, playerY - 16, reload * 2, 10);
        g2.setColor(Color.CYAN); //sus?
        if(cutscene == false && notHere == false){
            g2.drawImage(sSombra, playerX + 5, playerY + 25, null);
        }
        for(int i = 0; i < bullets.size(); i++){
            bullets.get(i).draw(g2);
        }
        if(cutscene == false && notHere == false){
            g2.drawImage(finalImage, playerX, playerY, null);
        }
        rectangle = new Rectangle(playerX + 25, playerY + 40, 50, 60);
        // g2.draw(rectangle);

    }

}
