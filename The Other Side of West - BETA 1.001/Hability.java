import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Hability {

    int num;

    boolean immortal;

    boolean oneTimeOne = true;
    boolean oneTimeTwo = true;

    boolean passive, passiveCount;
    boolean hability1, hability1Count;
    boolean hability2, hability2Count;
    boolean ultimate, ultimateCount;

    int hability1Delay, hability1TotalDelay;
    int hability2Delay, hability2TotalDelay;
    int ultimateDelay, ultimateTotalDelay;

    int count1 = -1;
    int count2 = -1;
    int ult = -1;
    int ultPoints = 0;

    int countPress1 = -1;
    int countPress2 = -1;

    int speedX = 0;
    int speedY = 0;

    boolean goingUp;
    boolean goingDown;
    boolean goingLeft;
    boolean goingRight;

    int camb = 0;

    boolean perfEffect = false;

    int posBullet;

    boolean buffalo;

    BufferedImage hab1Arthur, hab2Arthur, hab1Jules, hab2Jules;
    Image hab1ArthurImage, hab2ArthurImage, hab1JulesImage, hab2JulesImage;
    Image finalHab1, finalHab2;

    BufferedImage letraE, letraM2;
    Image e, m2;

    float vidaVerde1 = 64, vidaVermelha1 = 64;
    float vidaVerde2 = 64, vidaVermelha2 = 64;

    float contarVerde1;
    float contarVermelho1;

    float contarVerde2;
    float contarVermelho2;

    Hability(int typeOfCharacter){

        this.num = typeOfCharacter;

            try {
                hab1Arthur = ImageIO.read(getClass().getResourceAsStream("assets\\tirosHabilidade.png"));
                hab1ArthurImage = hab1Arthur.getScaledInstance(64, 64, Image.SCALE_DEFAULT);

                hab2Arthur = ImageIO.read(getClass().getResourceAsStream("assets\\cambalhotaHabilidade.png"));
                hab2ArthurImage = hab2Arthur.getScaledInstance(64, 64, Image.SCALE_DEFAULT);

                hab1Jules = ImageIO.read(getClass().getResourceAsStream("assets\\tiraoHabilidade.png"));
                hab1JulesImage = hab1Jules.getScaledInstance(64, 64, Image.SCALE_DEFAULT);

                hab2Jules = ImageIO.read(getClass().getResourceAsStream("assets\\toroHabilidade.png"));
                hab2JulesImage = hab2Jules.getScaledInstance(64, 64, Image.SCALE_DEFAULT);

                letraE = ImageIO.read(getClass().getResourceAsStream("assets\\letraEV2.png"));
                e = letraE.getScaledInstance(32, 32, Image.SCALE_DEFAULT);
                letraM2 = ImageIO.read(getClass().getResourceAsStream("assets\\letraM2V2.png"));
                m2 = letraM2.getScaledInstance(32, 32, Image.SCALE_DEFAULT);
            } catch (IOException e) {
            }

    }

    public void update(TheKey key, TheMouse mouse, Player player, ArrayList<Enemy> enemy){

        if(num == 0){
            //? COWBOY 1

            if(oneTimeOne){
                finalHab1 = hab1ArthurImage;
                finalHab2 = hab2ArthurImage;

                contarVerde1 = vidaVerde1/240;
                contarVermelho1 = vidaVermelha1/240;

                contarVerde2 = vidaVerde2/40;
                contarVermelho2 = vidaVermelha2/80;
                oneTimeOne = false;
            }

            hability1Delay = 240;
            hability1TotalDelay = 480;

            hability2Delay = 40;
            hability2TotalDelay = 120;

            if(hability1){
                player.multDelay = 0;
                if(count1 >= hability1Delay){
                    player.multDelay = 1;
                }
            } else if(hability1 == false){
                player.multDelay = 1;
            }

            if(hability2){
                player.canMoveUp = false;
                player.canMoveDown = false;
                player.canMoveLeft = false;
                player.canMoveRight = false;
                player.cambalhota = true;
                immortal = true;
                if(key.upPressed){
                    speedY = -7;
                    goingUp = true;
                }
                if(key.downPressed){
                    speedY = 7;
                    goingDown = true;
                }
                if(key.leftPressed){
                    speedX = -7;
                    goingLeft = true;
                }
                if(key.rightPressed){
                    speedX = 7;
                    goingRight = true;
                }

                if(player.cambalhota){
                    camb++;
                    if(player.right){
                        if(camb >= 0 && camb < 10){
                            player.finalImage = player.image7Done;
                        } else if(camb >= 10 && camb < 20){
                            player.finalImage = player.image7Dtwo;
                        } else if(camb >= 20 && camb < 30){
                            player.finalImage = player.image7Dthree;
                        } else if(camb >= 30){
                            player.finalImage = player.image7Dfour;
                        }
                    } else if(player.left){
                        if(camb >= 0 && camb < 10){
                            player.finalImage = player.image8Eone;
                        } else if(camb >= 10 && camb < 20){
                            player.finalImage = player.image8Etwo;
                        } else if(camb >= 20 && camb < 30){
                            player.finalImage = player.image8Ethree;
                        } else if(camb >= 30){
                            player.finalImage = player.image8Efour;
                        }
                    }
                }

                if(count2 >= hability2Delay){
                    player.cambalhota = false;
                    camb = 0;
                    immortal = false;
                    goingUp = false;
                    goingDown = false;
                    goingLeft = false;
                    goingRight = false;
                    speedX = 0;
                    speedY = 0;
                    player.canMoveUp = true;
                    player.canMoveDown = true;
                    player.canMoveLeft = true;
                    player.canMoveRight = true;
                    hability2 = false;
                }
                player.playerY += speedY;
                player.playerX += speedX;
            } else if(hability2 == false){
                player.cambalhota = false;
                camb = 0;
                immortal = false;
                goingUp = false;
                goingDown = false;
                goingLeft = false;
                goingRight = false;
                speedX = 0;
                speedY = 0;
                player.canMoveUp = true;
                player.canMoveDown = true;
                player.canMoveLeft = true;
                player.canMoveRight = true;
            }

        } else if(num == 1){
            //? COWBOY 2

            if(oneTimeTwo){
                finalHab1 = hab1JulesImage;
                finalHab2 = hab2JulesImage;

                contarVerde1 = vidaVerde1/1;
                contarVermelho1 = vidaVermelha1/459;

                contarVerde2 = vidaVerde2/180;
                contarVermelho2 = vidaVermelha2/420;
                oneTimeTwo = false;
            }

            hability1Delay = 1;
            hability1TotalDelay = 480;

            hability2Delay = 180;
            hability2TotalDelay = 600;

            if(hability1){
                perfEffect = true;
                hability1 = false;
            }

            if(hability2){
                player.speed = 8;
                speedX = 8;
                speedY = 8;
                immortal = true;
                buffalo = true;
            } else{
                player.speed = 5;
                speedX = 5;
                speedY = 5;
                immortal = false;
                buffalo = false;
            }

            if(count2 >= hability2Delay){
                hability2 = false;
            }

        }

        if(count1 == -1){
            if(mouse.buttonLeft){
                hability1 = true;
                hability1Count = true;
                mouse.buttonLeft = false;
                countPress1++;
                count1++;
            } else{
                hability1 = false;
            }
        }

        if(count2 == -1){
            if(key.letterE){
                //! FAZER QUE NO "COWBOY 1", SEJA A TECLA "SHIFT"
                hability2 = true;
                hability2Count = true;
                key.letterE = false;
                countPress2++;
                count2++;
            } else{
                hability2 = false;
            }
        }

        if(ult == -1){
            if(key.letterQ){
                ultimate = true;
                ultimateCount = true;
                key.letterQ = false;
                ult++;
            }
        }

        if(count1 > -1){
            if(count1 <= hability1Delay){
                vidaVerde1 -= contarVerde1;
            } else if(count1 > hability1Delay && count1 <= hability1TotalDelay){
                vidaVermelha1 -= contarVermelho1;
            }
        } else if(count1 == -1){
            vidaVerde1 = 64;
            vidaVermelha1 = 64;
        }

        if(count2 > -1){
            if(count2 <= hability2Delay){
                vidaVerde2 -= contarVerde2;
            }else if(count2 > hability2Delay && count2 <= hability2TotalDelay){
                vidaVermelha2 -= contarVermelho2;
            }
        } else if(count2 == -1){
            vidaVerde2 = 64;
            vidaVermelha2 = 64;
        }

        if(count1 > -1){
            count1++;
            countPress1++;
            if(count1 >= hability1TotalDelay){
                count1 = -1;
                countPress1 = -1;
                vidaVerde1 = 64;
                vidaVermelha1 = 64;
            }
        }

        if(count2 > -1){
            count2++;
            countPress2++;
            if(count2 >= hability2TotalDelay){
                count2 = -1;
                countPress2 = -1;
                vidaVerde2 = 64;
                vidaVermelha2 = 64;
            }
        }

        if(ult > -1){
            ult++;
            if(ult >= 120){
                ult = -1;
            }
        }

        if(hability1Count){
            countPress1++;
            hability1Count = false;
        }
        if(hability2Count){
            countPress2++;
            hability2Count = false;
        }
        if(ultimateCount){
            System.out.println("ULTIMATE");
            ultimateCount = false;
        }

    }

    public void draw(Graphics2D g2){

        // if(countPress1 == -1){
        //     g2.setColor(Color.GREEN);
        // } else if(countPress1 > -1 && countPress1 <= 30){
        //     g2.setColor(Color.BLUE);
        // } else if(countPress1 > hability1Delay){
        //     g2.setColor(Color.RED);
        // } else if(30 <= countPress1){
        //     g2.setColor(Color.pink);
        // }
        // // g2.fillRect(690, 470, 75, 75);
        // if(countPress2 == -1){
        //     g2.setColor(Color.GREEN);
        // } else if(countPress2 > -1 && countPress2 <= 30){
        //     g2.setColor(Color.BLUE);
        // } else if(countPress2 > hability2Delay){
        //     g2.setColor(Color.RED);
        // } else if(30 <= countPress2){
        //     g2.setColor(Color.PINK);
        // }
        // // g2.fillRect(790, 470, 75, 75);
        g2.setColor(Color.RED);
        g2.fillRect(690, 440, (int) vidaVermelha1, 10);
        g2.setColor(Color.GREEN);
        g2.fillRect(690, 440, (int) vidaVerde1, 10);
        g2.drawImage(finalHab1, 690, 460, null);
        g2.drawImage(m2, 706, 524, null);

        g2.setColor(Color.RED);
        g2.fillRect(790, 440, (int) vidaVermelha2, 10);
        g2.setColor(Color.GREEN);
        g2.fillRect(790, 440, (int) vidaVerde2, 10);
        g2.drawImage(finalHab2, 790, 460, null);
        g2.drawImage(e, 806, 524, null);

    }

}
