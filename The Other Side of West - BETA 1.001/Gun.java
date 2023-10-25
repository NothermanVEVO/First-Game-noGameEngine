import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Gun {

    BufferedImage gun;
    BufferedImage hand;
    Image image1;
    Image image2;

    int escolha = 1;

    float x = 0;
    float y = 0;

    Gun(){

        try {
            gun = ImageIO.read(getClass().getResourceAsStream("assets\\GunDireita.png"));
            hand = ImageIO.read(getClass().getResourceAsStream("assets\\HandComboy1Direita.png"));
        } catch (IOException e) {
        }

        image1 = gun.getScaledInstance(75, 75, Image.SCALE_DEFAULT);
        image2 = hand.getScaledInstance(75, 75, Image.SCALE_DEFAULT);

    }

    public void update(int num, int escolha){

        try {
            ////hand = ImageIO.read(getClass().getResourceAsStream("HandComboy1.png"));
            // if(num == 1){
            //     hand = ImageIO.read(getClass().getResourceAsStream("assets\\HandComboy2Direita.png"));
            //     image2 = hand.getScaledInstance(75, 75, Image.SCALE_DEFAULT);
            // } else if(num == 0){
            //     hand = ImageIO.read(getClass().getResourceAsStream("assets\\HandComboy1Direita.png"));
            //     image2 = hand.getScaledInstance(75, 75, Image.SCALE_DEFAULT);
            // }

            if(escolha == 1 && num == 0){
                gun = ImageIO.read(getClass().getResourceAsStream("assets\\GunDireita.png"));
                image1 = gun.getScaledInstance(75, 75, Image.SCALE_DEFAULT);
                hand = ImageIO.read(getClass().getResourceAsStream("assets\\HandComboy1Direita.png"));
                image2 = hand.getScaledInstance(75, 75, Image.SCALE_DEFAULT);
            } else if(escolha == -1 && num == 0){
                gun = ImageIO.read(getClass().getResourceAsStream("assets\\GunEsquerda.png"));
                image1 = gun.getScaledInstance(75, 75, Image.SCALE_DEFAULT);
                hand = ImageIO.read(getClass().getResourceAsStream("assets\\HandComboy1Esquerda.png"));
                image2 = hand.getScaledInstance(75, 75, Image.SCALE_DEFAULT);
            }

            if(escolha == 1 && num == 1){
                gun = ImageIO.read(getClass().getResourceAsStream("assets\\GunDireita.png"));
                image1 = gun.getScaledInstance(75, 75, Image.SCALE_DEFAULT);
                hand = ImageIO.read(getClass().getResourceAsStream("assets\\HandComboy2Direita.png"));
                image2 = hand.getScaledInstance(75, 75, Image.SCALE_DEFAULT);
            } else if(escolha == -1 && num == 1){
                gun = ImageIO.read(getClass().getResourceAsStream("assets\\GunEsquerda.png"));
                image1 = gun.getScaledInstance(75, 75, Image.SCALE_DEFAULT);
                hand = ImageIO.read(getClass().getResourceAsStream("assets\\HandComboy2Esquerda.png"));
                image2 = hand.getScaledInstance(75, 75, Image.SCALE_DEFAULT);
            }
        } catch (Exception e) {
        }

    }

    public void draw(Graphics2D g2){

        g2.setColor(Color.pink);
        //g2.fillRect((int) x, (int) y, 50, 50);
        g2.drawImage(image1, (int) x + 25, (int) y - 15, null);
        g2.drawImage(image2, (int) x + 25, (int) y - 15, null);

    }

}
