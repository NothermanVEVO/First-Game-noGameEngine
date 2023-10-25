import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Cutscene {

    BufferedImage luzAlem1, luzAlem2, luzAlem3, luzAlem4, luzAlem5, luzAlem6, luzAlem7;
    Image luz1, luz2, luz3, luz4, luz5, luz6, luz7;

    Image finalImage;

    int moment;
    Player player = new Player(null, 0, 0);

    int starAbdu = 0;
    int abdu = -1;

    int xLuz = -1000000000;
    int yLuz = -1000000000;

    boolean oneTime;

    float bilu = 0;

    int goOp = 0;

    int bang = -1;

    int ani = 0;

    int showLightMoment = 9;
    int startAbduMoment = 10;

    boolean stopThis;

    int playerXtemp;
    int playerYtemp;

    Cutscene(){

        try {
            luzAlem1 = ImageIO.read(getClass().getResourceAsStream("assets\\luzDoAlem1.png"));
            luz1 = luzAlem1.getScaledInstance(300, 600, Image.SCALE_DEFAULT);

            luzAlem2 = ImageIO.read(getClass().getResourceAsStream("assets\\luzDoAlem2.png"));
            luz2 = luzAlem2.getScaledInstance(300, 600, Image.SCALE_DEFAULT);

            luzAlem3 = ImageIO.read(getClass().getResourceAsStream("assets\\luzDoAlem3.png"));
            luz3 = luzAlem3.getScaledInstance(300, 600, Image.SCALE_DEFAULT);

            luzAlem4 = ImageIO.read(getClass().getResourceAsStream("assets\\luzDoAlem4.png"));
            luz4 = luzAlem4.getScaledInstance(300, 600, Image.SCALE_DEFAULT);

            luzAlem5 = ImageIO.read(getClass().getResourceAsStream("assets\\luzDoAlem5.png"));
            luz5 = luzAlem5.getScaledInstance(300, 600, Image.SCALE_DEFAULT);

            luzAlem6 = ImageIO.read(getClass().getResourceAsStream("assets\\luzDoAlem6.png"));
            luz6 = luzAlem6.getScaledInstance(300, 600, Image.SCALE_DEFAULT);

            luzAlem7 = ImageIO.read(getClass().getResourceAsStream("assets\\luzDoAlem7.png"));
            luz7 = luzAlem7.getScaledInstance(300, 600, Image.SCALE_DEFAULT);

            finalImage = luz7;
        } catch (Exception e) {
        }

    }

    public void update(int moment, Player player){

        this.moment = moment;
        this.player = player;

        if(oneTime){
            playerXtemp = player.playerX;
            playerYtemp = player.playerY;
            xLuz = player.playerX - 100;
            yLuz = player.playerY - 400;
            oneTime = false;
        }

        if(moment == showLightMoment){
            ani++;
            if(ani >= 0 && ani < 5){
                finalImage = luz1;
            } else if(ani >= 5 && ani < 10){
                finalImage = luz2;
            } else if(ani >= 10 && ani < 15){
                finalImage = luz3;
            } else if(ani >= 15 && ani < 20){
                finalImage = luz4;
            } else if(ani >= 20 && ani < 25){
                finalImage = luz5;
            } else if(ani >= 25 && ani < 30){
                finalImage = luz6;
            } else if(ani >= 30 && ani < 35){
                finalImage = luz7;
                ani = 30;
            }
            oneTime = true;
            player.notHere = true;
        }

        if(moment == startAbduMoment){
            player.cutscene = true;
            if(abdu == -1){
                oneTime = true;
                abdu = 0;
            }
            if(starAbdu >= 0){
                starAbdu++;
                if(starAbdu >= 60){
                    abdu = 0;
                    starAbdu = -1;
                }
            }
            if(abdu >= 0){
                abdu++;
                player.playerY -= 1;
            }
        } else {
            abdu = -1;
        }

    }

    public void draw(Graphics2D g2){

        if(moment == showLightMoment){
            g2.drawImage(finalImage, xLuz, yLuz, null);
            g2.drawImage(player.finalImage, player.playerX, player.playerY, null);
        }

        if(moment == startAbduMoment){
            bilu += 0.05;
            g2.drawImage(finalImage, xLuz, yLuz, null);
            g2.rotate(bilu, player.playerX + 50, player.playerY + 50);
            g2.drawImage(player.finalImage, player.playerX, player.playerY, null);
            g2.rotate(-bilu, player.playerX + 50, player.playerY + 50);
            // g2.rotate(0, player.playerX + 25, player.playerY + 25);
            g2.setColor(new Color(255, 255, 255, goOp));
            stopThis = true;

            if(abdu >= 120){
                goOp += 1;
                if(goOp >= 255){
                    goOp = 255;
                }
            }
            g2.fillRect(0, 0, 1000, 1000);
            // g2.fillRect(-200, -200, 1400, 1400);
        }

        if(moment != startAbduMoment){
            if(stopThis){
                player.playerY = 200;
                player.notHere = false;
                player.cutscene = false;
                player.ocorreu = true;
                player.playerX = playerXtemp;
                player.playerY = playerYtemp;
                stopThis = false;
            }
        }

    }

}
