import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class Enemy {

    int countdown = 0;


    int go = 0;
    int stop = 0;
    int bro = 0;
    int sister = 0;
    boolean left;
    boolean right;
    boolean up;
    boolean down;
    boolean moving;
    boolean waiting;

    int spawn = 0;

    float theAngle;
    float theta;

    int typeEnemy;

    BufferedImage bandidoParado1Direita, bandidoParado1Esquerda, bandidoCorrendoDireita,
        bandidoCorrendoEsquerda, bandidoParado2Direita, bandidoParado2Esquerda;
    Image image1, image2, image3, image4, image5, image6;
    Image finalImage;

    BufferedImage sombra;
    Image sSombra;

    float goX;
    float goY;

    float vX = 0;
    float vY = 0;

    float x = 400;
    float y = 250;

    float speed = 5;

    boolean hitted = false;

    boolean fuckCollision;

    int keep = 0;

    float dX;
    float dY;

    int wait = 0;
    int chill = 0;

    Rectangle rectangle = new Rectangle((int) x + 25, (int) y + 10, 50, 90);

    ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    ArrayList<Float> angles = new ArrayList<Float>();

    ArrayList<Integer> dontFuckinSpawnClose = new ArrayList<Integer>();

    boolean hittedPlayer;
    boolean hittedBullet;
    int zero = 0;
    int one = 1;
    int timer = 0;
    int time = 0;
    float anglinho;

    boolean indoPraEsquerda;
    boolean indoPraDireita;

    int life = 2;

    Rectangle enemyCollision = new Rectangle((int) x + 25, (int) y + 10, 50, 90);

    int realSpeed = 2;

    int moment;

    BufferedImage boss1DireitaParado1, boss1DireitaParado2, boss1EsquerdaParado1, boss1EsquerdaParado2, 
        boss1DireitaCorrendo, boss1EsquerdaCorrendo;
    Image imageB1, imageB2, imageB3, imageB4, imageB5, imageB6;

    BufferedImage boss1DireitaDying1, boss1DireitaDying2, boss1DireitaDying3, boss1DireitaFinish1,
        boss1DireitaFinish2, boss1DireitaFinish3;
    Image imageB1dD1, imageB1dD2, imageB1dD3, imageB1dF1, imageB1dF2, imageB1dF3;

    BufferedImage boss1EsquerdaDying1, boss1EsquerdaDying2, boss1EsquerdaDying3, boss1EsquerdaFinish1,
        boss1EsquerdaFinish2, boss1EsquerdaFinish3;
    Image imageB1eD1, imageB1eD2, imageB1eD3, imageB1eF1, imageB1eF2, imageB1eF3;

    BufferedImage bossHand;
    Image imageHand;

    Image finalGun, finalGunDireita, finalGunEsquerda;

    BufferedImage foiceDireita, foiceEsquerda, glockDireita, glockEsquerda, cajadoDireita, cajadoEsquerda, 
        bookDireita, bookEsquerda;
    Image imageFoiceDireita, imageFoiceEsquerda, imageGlockDireita, imageGlockEsquerda, 
        imageCajadoDireita, imageCajadoEsquerda, imageBookDireita, imageBookEsquerda;

    boolean finishState, deadState;
    int finishCount = 0, deadCount = 0;

    boolean boss;

    int bossMoments = 1;

    boolean bossMove;
    boolean bossStop;

    int bossTimer = 0;

    //!
    boolean shotEspiralBullets = false;
    float[] arrayX = new float[16];
    float[] arrayY = new float[16];
    //!

    //! TO MAKE
    boolean shotEspiralBulletsDelay = false;
    float[] arrayXd = new float[32];
    float[] arrayYd = new float[32];
    int possin = 0;
    int delayZin = 0;
    //!

    //!
    boolean shotEspiralBulletsDelayTwoTimes = false;
    float[] arrayXd2 = new float[64];
    float[] arrayYd2 = new float[64];
    int possin2 = 0;
    int delayZin2 = 0;
    //!

    //!
    boolean shotRandomDirectShots = false;
    int shotRandomX;
    int shotRandomY;
    int shotRandomDirectDelay = 0;
    int randomGo = 0;
    boolean canshotRandomDirectShots = false;
    int valueX;
    int valueY;
    //!

    //!
    boolean shot1SecFollow = false;
    boolean canShot1SecFollow = false;
    int shot1SecFollowDelay = 0;
    int theBulletFollower = 0;
    int followTime = 0;
    //!

    //!
    boolean shotPredictShot = false;
    boolean canShootPredictShot = false;
    int predictDelay = 0;
    //!

    //!
    boolean shotMeteors = false;
    boolean canShotMeteors = false;
    int meteorsDelay = 0;
    int meteorsQuant = 0;
    int meteorsX = -400;
    int pOn = 0;
    //!

    //!
    boolean spawnEye = true;
    boolean spawnTheEye = true;

    BufferedImage eye, eyeBall;
    Image imageEye, imageEyeBall;

    int eyeX = 400, eyeY = -50;
    int eyeBallX = 400, eyeBallY = -60;
    //!

    boolean useFoice, useGlock, useCajado, useBook;

    boolean armaBranca, armaDeFogo;

    int ultDelay = 0;

    Random random = new Random();

    boolean spawnTheBoss = true;

    Enemy(int typeEnemy, int skin, int moment){

        this.typeEnemy = typeEnemy;
        this.moment = moment;

        try {
            if(typeEnemy == 1 && skin == 1 && moment <= 3){

                bandidoParado1Direita = ImageIO.read(getClass().getResourceAsStream("assets\\bandidoDireita.png"));
                image1 = bandidoParado1Direita.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                bandidoParado1Esquerda = ImageIO.read(getClass().getResourceAsStream("assets\\bandidoEsquerda.png"));
                image2 = bandidoParado1Esquerda.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                bandidoCorrendoDireita = ImageIO.read(getClass().getResourceAsStream("assets\\bandidoDireitaCorrendo.png"));
                image3 = bandidoCorrendoDireita.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                bandidoCorrendoEsquerda = ImageIO.read(getClass().getResourceAsStream("assets\\bandidoEsquerdaCorrendo.png"));
                image4 = bandidoCorrendoEsquerda.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                finalImage = image1;

            } else if(typeEnemy == 2 && moment <= 3){

                bandidoParado1Direita = ImageIO.read(getClass().getResourceAsStream("assets\\bandidoArmadoParadoDireita1.png"));
                image1 = bandidoParado1Direita.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                bandidoParado1Esquerda = ImageIO.read(getClass().getResourceAsStream("assets\\bandidoArmadoParadoEsquerda1.png"));
                image2 = bandidoParado1Esquerda.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                bandidoCorrendoDireita = ImageIO.read(getClass().getResourceAsStream("assets\\bandidoArmadoCorrendoDireita1.png"));
                image3 = bandidoCorrendoDireita.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                bandidoCorrendoEsquerda = ImageIO.read(getClass().getResourceAsStream("assets\\bandidoArmadoCorrendoEsquerda.png"));
                image4 = bandidoCorrendoEsquerda.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                bandidoParado2Direita = ImageIO.read(getClass().getResourceAsStream("assets\\bandidoArmadoParadoDireita2.png"));
                image5 = bandidoParado2Direita.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                bandidoParado2Esquerda = ImageIO.read(getClass().getResourceAsStream("assets\\bandidoArmadoParadoEsquerda2.png"));
                image6 = bandidoParado2Esquerda.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                finalImage = image1;

            } else if(typeEnemy == 1 && skin == 2 && moment <= 3){
                bandidoParado1Direita = ImageIO.read(getClass().getResourceAsStream("assets\\bandido2Direita.png"));
                image1 = bandidoParado1Direita.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                bandidoParado1Esquerda = ImageIO.read(getClass().getResourceAsStream("assets\\bandido2Esquerda.png"));
                image2 = bandidoParado1Esquerda.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                bandidoCorrendoDireita = ImageIO.read(getClass().getResourceAsStream("assets\\bandido2CorrendoDireita.png"));
                image3 = bandidoCorrendoDireita.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                bandidoCorrendoEsquerda = ImageIO.read(getClass().getResourceAsStream("assets\\bandido2CorrendoEsquerda.png"));
                image4 = bandidoCorrendoEsquerda.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                finalImage = image1;

            } else if(typeEnemy == 1 && moment == 4){
                //ZOMBIE

                bandidoParado1Direita = ImageIO.read(getClass().getResourceAsStream("assets\\zombie1Direita.png"));
                image1 = bandidoParado1Direita.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                bandidoParado1Esquerda = ImageIO.read(getClass().getResourceAsStream("assets\\zombie1Esquerda.png"));
                image2 = bandidoParado1Esquerda.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                bandidoCorrendoDireita = ImageIO.read(getClass().getResourceAsStream("assets\\zombie1DireitaCorrendo.png"));
                image3 = bandidoCorrendoDireita.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                bandidoCorrendoEsquerda = ImageIO.read(getClass().getResourceAsStream("assets\\zombie1EsquerdaCorrendo.png"));
                image4 = bandidoCorrendoEsquerda.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                finalImage = image1;

            } else if(typeEnemy == 1 && moment == 5){
                //ROBOT

                bandidoParado1Direita = ImageIO.read(getClass().getResourceAsStream("assets\\robo1Direita.png"));
                image1 = bandidoParado1Direita.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                bandidoParado1Esquerda = ImageIO.read(getClass().getResourceAsStream("assets\\robo1Esquerda.png"));
                image2 = bandidoParado1Esquerda.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                bandidoCorrendoDireita = ImageIO.read(getClass().getResourceAsStream("assets\\robo1DireitaCorrendo.png"));
                image3 = bandidoCorrendoDireita.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                bandidoCorrendoEsquerda = ImageIO.read(getClass().getResourceAsStream("assets\\robo1EsquerdaCorrendo.png"));
                image4 = bandidoCorrendoEsquerda.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                finalImage = image1;

            } else if(typeEnemy == 1 && moment == 6){
                //ALIEN

                bandidoParado1Direita = ImageIO.read(getClass().getResourceAsStream("assets\\alienDireita.png"));
                image1 = bandidoParado1Direita.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                bandidoParado1Esquerda = ImageIO.read(getClass().getResourceAsStream("assets\\alienEsquerda.png"));
                image2 = bandidoParado1Esquerda.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                bandidoCorrendoDireita = ImageIO.read(getClass().getResourceAsStream("assets\\alienDireitaCorrendo.png"));
                image3 = bandidoCorrendoDireita.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                bandidoCorrendoEsquerda = ImageIO.read(getClass().getResourceAsStream("assets\\alienEsquerdaCorrendo.png"));
                image4 = bandidoCorrendoEsquerda.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

                finalImage = image1;

            } else if(typeEnemy == 100 && moment == 100){

                life = 50;
                boss = true;

                boss1DireitaParado1 = ImageIO.read(getClass().getResourceAsStream("assets\\theBoss1DireitaParado1.png"));
                imageB1 = boss1DireitaParado1.getScaledInstance(200, 200, Image.SCALE_DEFAULT);

                boss1DireitaParado2 = ImageIO.read(getClass().getResourceAsStream("assets\\theBoss1DireitaParado2.png"));
                imageB2 = boss1DireitaParado2.getScaledInstance(200, 200, Image.SCALE_DEFAULT);

                boss1EsquerdaParado1 = ImageIO.read(getClass().getResourceAsStream("assets\\theBoss1EsquerdaParado1.png"));
                imageB3 = boss1EsquerdaParado1.getScaledInstance(200, 200, Image.SCALE_DEFAULT);

                boss1EsquerdaParado2 = ImageIO.read(getClass().getResourceAsStream("assets\\theBoss1EsquerdaParado2.png"));
                imageB4 = boss1EsquerdaParado2.getScaledInstance(200, 200, Image.SCALE_DEFAULT);

                boss1DireitaCorrendo = ImageIO.read(getClass().getResourceAsStream("assets\\theBoss1DireitaCorrendo.png"));
                imageB5 = boss1DireitaCorrendo.getScaledInstance(200, 200, Image.SCALE_DEFAULT);

                boss1EsquerdaCorrendo = ImageIO.read(getClass().getResourceAsStream("assets\\theBoss1EsquerdaCorrendo.png"));
                imageB6 = boss1EsquerdaCorrendo.getScaledInstance(200, 200, Image.SCALE_DEFAULT);

                //
                boss1DireitaFinish1 = ImageIO.read(getClass().getResourceAsStream("assets\\theBoss1Finish1.png"));
                imageB1dF1 = boss1DireitaFinish1.getScaledInstance(200, 200, Image.SCALE_DEFAULT);

                boss1DireitaFinish2 = ImageIO.read(getClass().getResourceAsStream("assets\\theBoss1Finish2.png"));
                imageB1dF2 = boss1DireitaFinish2.getScaledInstance(200, 200, Image.SCALE_DEFAULT);

                boss1DireitaFinish3 = ImageIO.read(getClass().getResourceAsStream("assets\\theBoss1Finish4.png"));
                imageB1dF3 = boss1DireitaFinish3.getScaledInstance(200, 200, Image.SCALE_DEFAULT);

                boss1DireitaDying1 = ImageIO.read(getClass().getResourceAsStream("assets\\theBoss1Dying1.png"));
                imageB1dD1 = boss1DireitaDying1.getScaledInstance(200, 200, Image.SCALE_DEFAULT);

                boss1DireitaDying2 = ImageIO.read(getClass().getResourceAsStream("assets\\theBoss1Dying2.png"));
                imageB1dD2 = boss1DireitaDying2.getScaledInstance(200, 200, Image.SCALE_DEFAULT);

                boss1DireitaDying3 = ImageIO.read(getClass().getResourceAsStream("assets\\theBoss1Dying3.png"));
                imageB1dD3 = boss1DireitaDying3.getScaledInstance(200, 200, Image.SCALE_DEFAULT);

                //
                boss1EsquerdaFinish1 = ImageIO.read(getClass().getResourceAsStream("assets\\theBoss1Finish1E.png"));
                imageB1eF1 = boss1EsquerdaFinish1.getScaledInstance(200, 200, Image.SCALE_DEFAULT);

                boss1EsquerdaFinish2 = ImageIO.read(getClass().getResourceAsStream("assets\\theBoss1Finish2E.png"));
                imageB1eF2 = boss1EsquerdaFinish2.getScaledInstance(200, 200, Image.SCALE_DEFAULT);

                boss1EsquerdaFinish3 = ImageIO.read(getClass().getResourceAsStream("assets\\theBoss1Finish4E.png"));
                imageB1eF3 = boss1EsquerdaFinish3.getScaledInstance(200, 200, Image.SCALE_DEFAULT);

                boss1EsquerdaDying1 = ImageIO.read(getClass().getResourceAsStream("assets\\theBoss1Dying1E.png"));
                imageB1eD1 = boss1EsquerdaDying1.getScaledInstance(200, 200, Image.SCALE_DEFAULT);

                boss1EsquerdaDying2 = ImageIO.read(getClass().getResourceAsStream("assets\\theBoss1Dying2E.png"));
                imageB1eD2 = boss1EsquerdaDying2.getScaledInstance(200, 200, Image.SCALE_DEFAULT);

                boss1EsquerdaDying3 = ImageIO.read(getClass().getResourceAsStream("assets\\theBoss1Dying3E.png"));
                imageB1eD3 = boss1EsquerdaDying3.getScaledInstance(200, 200, Image.SCALE_DEFAULT);

                //!ARMAS
                foiceDireita = ImageIO.read(getClass().getResourceAsStream("assets\\FoiceDireita.png"));
                imageFoiceDireita = foiceDireita.getScaledInstance(150, 150, Image.SCALE_DEFAULT);

                foiceEsquerda = ImageIO.read(getClass().getResourceAsStream("assets\\FoiceEsquerda.png"));
                imageFoiceEsquerda = foiceEsquerda.getScaledInstance(150, 150, Image.SCALE_DEFAULT);

                glockDireita = ImageIO.read(getClass().getResourceAsStream("assets\\GlockDireita.png"));
                imageGlockDireita = glockDireita.getScaledInstance(125, 125, Image.SCALE_DEFAULT);

                glockEsquerda = ImageIO.read(getClass().getResourceAsStream("assets\\GlockEsquerda.png"));
                imageGlockEsquerda = glockEsquerda.getScaledInstance(125, 125, Image.SCALE_DEFAULT);

                cajadoDireita = ImageIO.read(getClass().getResourceAsStream("assets\\Cajado.png"));
                imageCajadoDireita = cajadoDireita.getScaledInstance(150, 150, Image.SCALE_DEFAULT);

                cajadoEsquerda = ImageIO.read(getClass().getResourceAsStream("assets\\CajadoEsquerda.png"));
                imageCajadoEsquerda = cajadoEsquerda.getScaledInstance(150, 150, Image.SCALE_DEFAULT);

                bookDireita = ImageIO.read(getClass().getResourceAsStream("assets\\Book.png"));
                imageBookDireita = bookDireita.getScaledInstance(150, 150, Image.SCALE_DEFAULT);

                bookEsquerda = ImageIO.read(getClass().getResourceAsStream("assets\\BookEsquerda.png"));
                imageBookEsquerda = bookEsquerda.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
                //!ARMAS

                bossHand = ImageIO.read(getClass().getResourceAsStream("assets\\theBoss1HandDef.png"));
                imageHand = bossHand.getScaledInstance(150, 150, Image.SCALE_DEFAULT);

                finalImage = imageB1;

            } else if(typeEnemy == 101 && moment == 101){

                boss = true;
                life = 20;

                eye = ImageIO.read(getClass().getResourceAsStream("assets\\Eye.png"));
                imageEye = eye.getScaledInstance(100, 115, Image.SCALE_DEFAULT);

                eyeBall = ImageIO.read(getClass().getResourceAsStream("assets\\EyeBall.png"));
                imageEyeBall = eyeBall.getScaledInstance(100, 115, Image.SCALE_DEFAULT);
            }

            //! ESPIRAL BULLETS WITHOUT DELAY
            float circX = 90;
            float circY = 0;

            for(int i = 0; i < 16; i++){
                arrayX[i] = circX;
                arrayY[i] = circY;
                if(i < 4){
                    circY += 22.5;
                    circX -= 22.5;
                } else if(i < 8){
                    circY -= 22.5;
                    circX -= 22.5;
                } else if(i < 12){
                    circY -= 22.5;
                    circX += 22.5;
                } else if(i < 16){
                    circY += 22.5;
                    circX += 22.5;
                }
            }

            //! ESPIRAL BULLETS WITH DELAY
            circX = 90;
            circY = 0;

            for(int i = 0; i < 32; i++){
                arrayXd[i] = circX;
                arrayYd[i] = circY;
                if(i < 8){
                    circY += 11.25;
                    circX -= 11.25;
                } else if(i < 16){
                    circY -= 11.25;
                    circX -= 11.25;
                } else if(i < 24){
                    circY -= 11.25;
                    circX += 11.25;
                } else if(i < 32){
                    circY += 11.25;
                    circX += 11.25;
                }
            }

            //! ESPIRAL BULLETS WITH DELAY TWO TIMES
            circX = 90;
            circY = 0;

            for(int i = 0; i < 64; i++){
                arrayXd2[i] = circX;
                arrayYd2[i] = circY;
                if(i < 16){
                    circY += 5.625;
                    circX -= 5.625;
                } else if(i < 32){
                    circY -= 5.625;
                    circX -= 5.625;
                } else if(i < 48){
                    circY -= 5.625;
                    circX += 5.625;
                } else if(i < 64){
                    circY += 5.625;
                    circX += 5.625;
                }
            }

            sombra = ImageIO.read(getClass().getResourceAsStream("assets\\Sombra.png"));
            if(typeEnemy == 100){
                sSombra = sombra.getScaledInstance(135, 135, Image.SCALE_DEFAULT);
            } else {
                sSombra = sombra.getScaledInstance(85, 85, Image.SCALE_DEFAULT);
            }
        } catch (IOException e) {
        }

    }

    public void update(float goX, float goY, TheKey key, Player player){

        this.goX = goX;
        this.goY = goY;

        if(typeEnemy == 1 || typeEnemy == 3){
            theta = (float) Math.atan2(goY - y, goX - x);

            vX = (float) ((realSpeed) * Math.cos(theta));
            vY = (float) ((realSpeed) * Math.sin(theta));

            if(hittedPlayer){
                zero = 1;
                timer = 0;
                hittedPlayer = false;
            }

            if(hittedBullet){
                one = 0;
                time = 0;
                hittedBullet = false;
            }

            if(zero == 1){
                timer++;
                vX *= -1;
                vY *= -1;
                if(timer > 30){
                    vX = 0;
                    vY = 0;
                    zero = 0;
                }
            }

            if(one == 0){
                time++;
                vX = (float) ((realSpeed) * Math.cos(anglinho));
                vY = (float) ((realSpeed) * Math.sin(anglinho));
                if(time > 15){
                    vX = 0;
                    vY = 0;
                    one = 1;
                }
            }

            if(indoPraDireita){
                vX = 0;
            }

            if(x < goX){
                right = true;
                left = false;
            } else {
                left = true;
                right = false;
            }

            if(right){
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
                } else if(bro == 1){
                    finalImage = image3;
                }
            } else if(left){
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
                    finalImage = image2;
                } else if(bro == 1){
                    finalImage = image4;
                }
            }

            if(fuckCollision){
                vX = 0;
                vY = 0;
                fuckCollision = false;
            }

        } else if(typeEnemy == 2){
            dX = goX - x;
            dY = goY - y;
            // System.out.println("dX: " + dX + " dY: " + dY);

            theta = (float) Math.atan2(dY, dX);

            if(Math.abs(dX) < 300 && Math.abs(dY) < 300){
                waiting = true;
                moving = false;
                chill = 0;
                vX = 0;
                vY = 0;
                wait++;
                if(wait > 50){
                    bullets.add(new Bullet((int) x + 50, (int) y + 50));
                    angles.add((float) Math.atan2(dY, dX));
                    wait = 0;
                    spawn = 1;
                }
            } else {
                waiting = true;
                moving = false;
                wait = 0;
                chill++;
                if(chill > 35){
                    moving = true;
                    vX = (float) ((realSpeed) * Math.cos(theta));
                    vY = (float) ((realSpeed) * Math.sin(theta));
                }
            }

            if(x < goX){
                right = true;
                left = false;
            } else {
                left = true;
                right = false;
            }

            if(right){
                if(moving){
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
                    } else if(bro == 1){
                        finalImage = image3;
                    }
                } else if (waiting){
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
                    } else if(sister == 1){
                        finalImage = image5;
                    }
                }
            } else if(left){
                if(moving){
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
                        finalImage = image2;
                    } else if(bro == 1){
                        finalImage = image4;
                    }
                } else if (waiting){
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
                        finalImage = image2;
                    } else if(sister == 1){
                        finalImage = image6;
                    }
                }
            }

            if(spawn != 0){
                for(int i = 0; i < bullets.size(); i++){
                    bullets.get(i).update(angles.get(i), 5);
                }
            }

            if(indoPraDireita){
                vX = 0;
            }

        } else if(typeEnemy == 100){

            //!!!!!!!!!!!!! BOSS !!!!!!!!!!!!!

            // System.out.println("X: " + x + " Y: " + y);

            // if(spawnTheBoss){
            //     x = player.playerX + 400;
            //     y = player.playerY;
            //     spawnTheBoss = false;
            // }

            theta = (float) Math.atan2(goY - y - 75, goX - x - 75);

            if(finishState == false && deadState == false){
                if(x < goX - 50){
                    right = true;
                    finalGun = finalGunDireita;
                    left = false;
                } else {
                    left = true;
                    finalGun = finalGunEsquerda;
                    right = false;
                }

                if(y < goY - 50){
                    up = false;
                    down = true;
                } else {
                    down = false;
                    up = true;
                }
            }

            if(life == 45 && bossMoments <= 2){
                bossMoments = 2;
            } else if(life == 15 && bossMoments <= 4){
                bossMoments = 4;
            } else if(life == 2 && bossMoments <= 100){
                bossMoments = 100;
            }

            if(bossMoments == 1){
                bossMove = true;
                bossStop = false;
            } else if(bossMoments == 2){
                bossStop = true;
                bossMove = false;
                ultDelay++;
                if(ultDelay == 60){
                    shotEspiralBullets = true;
                } else if(ultDelay == 300){
                    shotEspiralBulletsDelay = true;
                } else if(ultDelay == 600){
                    shotEspiralBulletsDelayTwoTimes = true;
                } else if(ultDelay == 840){
                    ultDelay = 0;
                    bossMoments = 3;
                } else if(ultDelay > 840) {
                    bossMoments = 500;
                    ultDelay = 0;
                }
            } else if(bossMoments == 3){
                ultDelay++;
                if(ultDelay >= 90){
                    shotRandomDirectShots = true;
                    canshotRandomDirectShots = true;
                    ultDelay = 0;
                }
            } else if(bossMoments == 4){
                shotRandomDirectShots = false;
                    canshotRandomDirectShots = false;
                ultDelay++;
                if(ultDelay >= 90){
                    shot1SecFollow = true;
                    canShot1SecFollow = true;
                    ultDelay = 0;
                }
            } else if(bossMoments == 100){
                shot1SecFollow = false;
                canShot1SecFollow = false;
                bossStop = true;
                bossMove = false;
            }

            if(bossMove){
                vX = (float) ((realSpeed) * Math.cos(theta));
                vY = (float) ((realSpeed) * Math.sin(theta));
            }

            if(spawnEye){
                if(hittedPlayer){
                    zero = 1;
                    timer = 0;
                    hittedPlayer = false;
                }

                if(hittedBullet){
                    one = 0;
                    time = 0;
                    hittedBullet = false;
                }

            if(zero == 1){
                    timer++;
                    vX *= -1;
                    vY *= -1;
                    if(timer > 30){
                        vX = 0;
                        vY = 0;
                        zero = 0;
                    }
                }
            }

            if(shotEspiralBullets){
                for(int i = 0; i < 16; i++){
                    bullets.add(new Bullet((int) x + 100, (int) y + 100));
                    angles.add((float) Math.atan2((y - arrayY[i]) - y, (x + arrayX[i]) - x));
                    if(i == 15){
                        shotEspiralBullets = false;
                    }
                }
            }

            if(shotEspiralBulletsDelay){
                bullets.add(new Bullet((int) x + 100, (int) y + 100));
                angles.add((float) Math.atan2((y - arrayYd[possin]) - y, (x + arrayXd[possin]) - x));
                possin++;
                if(possin == 32){
                    possin = 0;
                    shotEspiralBulletsDelay = false;
                }
            }

            if(shotEspiralBulletsDelayTwoTimes){
                if(delayZin2 == 0){
                    bullets.add(new Bullet((int) x + 100, (int) y + 100));
                    angles.add((float) Math.atan2((y - arrayYd2[possin]) - y, (x + arrayXd2[possin]) - x));
                    bullets.add(new Bullet((int) x + 100, (int) y + 100));
                    angles.add((float) Math.atan2((y + arrayYd2[possin]) - y, (x - arrayXd2[possin]) - x));
                    possin++;
                    if(possin == 64){
                        possin = 0;
                        shotEspiralBulletsDelayTwoTimes = false;
                    }
                    delayZin2++;
                } else {
                    delayZin2++;
                    if(delayZin2 == 4){
                        delayZin2 = 0;
                    }
                }
            }

            if(shotRandomDirectShots && canshotRandomDirectShots){
                for(int i = 0; i < 30; i++){
                    valueX = random.nextInt(2) + 1;
                    valueY = random.nextInt(2) + 1;
                    if(valueX == 1){
                        shotRandomX = random.nextInt(180);
                    } else {
                        shotRandomX = random.nextInt(180) * -1;
                    }
                    if(valueY == 1){
                        shotRandomY = random.nextInt(180);
                    } else {
                        shotRandomY = random.nextInt(180) * -1;
                    }
                    bullets.add(new Bullet((int) x + 100, (int) y + 100));
                    angles.add((float) Math.atan2((goY - shotRandomY) - y - 60, (goX + shotRandomX) - x - 60));
                }
                shotRandomDirectDelay = 30;
            }

            if(shotRandomDirectDelay >= 30){
                canshotRandomDirectShots = false;
                randomGo++;
                if(randomGo >= 120){
                    shotRandomDirectDelay = 0;
                    canshotRandomDirectShots = true;
                    randomGo = 0;
                }
            }

            if(shot1SecFollow && canShot1SecFollow){
                bullets.add(new Bullet((int) x + 100, (int) y + 100));
                angles.add((float) Math.atan2(goY - y - 75, goX - x - 75));
                shot1SecFollow = false;
            }

            if(shot1SecFollow == false && canShot1SecFollow){
                shot1SecFollowDelay++;
                followTime++;
                if(followTime >= 0){
                    theBulletFollower = bullets.size() - 1;
                    if(theBulletFollower > 0){
                        bullets.get(theBulletFollower).speedEffect = true;
                        bullets.get(theBulletFollower).theSpeed = 5;
                        angles.set(theBulletFollower, (float) Math.atan2(goY - 
                            bullets.get(theBulletFollower).y + 50, goX - bullets.get(theBulletFollower).x + 50));
                    }
                    followTime = 0;
                }
                if(shot1SecFollowDelay >= 120){
                    shot1SecFollow = true;
                    shot1SecFollowDelay = 0;
                }
            }

            if(shotPredictShot && canShootPredictShot){
                bullets.add(new Bullet((int) x + 100, (int) y + 100));
                if(player.key.upPressed){
                    angles.add((float) Math.atan2((goY - 135)- y - 100, (goX + 135) - x - 100));
                    System.out.println("OI");
                } else if(player.key.downPressed) {
                    angles.add((float) Math.atan2((goY + 135)- y - 100, (goX + 135) - x - 100));
                } else if(player.key.leftPressed) {
                    angles.add((float) Math.atan2((goY - 135)- y - 100, (goX - 135) - x - 100));
                } else if(player.key.rightPressed) {
                    angles.add((float) Math.atan2((goY - 135)- y - 100, (goX + 135) - x - 100));
                } else {
                    angles.add((float) Math.atan2(goY - y - 50, goX - x - 50));
                }
                shotPredictShot = false;
            }

            if(shotPredictShot == false && canShootPredictShot){
                predictDelay++;
                theBulletFollower = bullets.size() - 1;
                if(theBulletFollower > 0){
                    bullets.get(theBulletFollower).speedEffect = true;
                    bullets.get(theBulletFollower).theSpeed = 5;
                }
                if(predictDelay >= 60){
                    shotPredictShot = true;
                    predictDelay = 0;
                }
            }

            if(shotMeteors && canShotMeteors){
                int whereSpawn = random.nextInt(400);
                pOn = random.nextInt(2) + 1;
                meteorsX += whereSpawn;
                meteorsQuant++;
                if(pOn == 1){
                    meteorsX *= -1;
                } else if(pOn == 2){
                    meteorsX *= 1;
                } else {
                    System.out.println("ERRO");
                }
                bullets.add(new Bullet((int) x + meteorsX, (int) y - 500));
                // angles.add((float) Math.atan2(goY - y + 550, goX - x - 50));
                angles.add((float) 1.55);
                if(meteorsQuant >= 8){
                    canShotMeteors = false;
                    meteorsQuant = 0;
                    meteorsX = 0;
                }
            }

            if(canShotMeteors == false){
                meteorsDelay++;
                if(meteorsDelay >= 120){
                    canShotMeteors = true;
                    meteorsDelay = 0;
                }
            }

            if(life == 2){
                finishState = true;
            } else if(life == 1){
                deadState = true;
                finishState = false;
                rectangle.x = 100000000;
                rectangle.y = 100000000;
                countdown++;
                if(countdown >= 240){
                    player.endGame = true;
                    player.won = true;
                }
            }

            if(finishState){
                finishCount++;
                if(right){
                    if(finishCount >= 0 && finishCount < 30){
                        finalImage = imageB1dF1;
                    } else if(finishCount >= 30 && finishCount < 60){
                        finalImage = imageB1dF2;
                    } else if(finishCount >= 60 && finishCount < 90){
                        finalImage = imageB1dF1;
                    } else if(finishCount >= 90 && finishCount < 120){
                        finalImage = imageB1dF3;
                    } else if(finishCount >= 120){
                        finishCount = 0;
                    }
                } else if(left){
                    if(finishCount >= 0 && finishCount < 30){
                        finalImage = imageB1eF1;
                    } else if(finishCount >= 30 && finishCount < 60){
                        finalImage = imageB1eF2;
                    } else if(finishCount >= 60 && finishCount < 90){
                        finalImage = imageB1eF1;
                    } else if(finishCount >= 90 && finishCount < 120){
                        finalImage = imageB1eF3;
                    } else if(finishCount >= 120){
                        finishCount = 0;
                    }
                }
            } else if(deadState){
                deadCount++;
                if(right){
                    if(deadCount >= 0 && deadCount < 15){
                        finalImage = imageB1dF1;
                    } else if(deadCount >= 15 && deadCount < 30){
                        finalImage = imageB1dD1;
                    } else if(deadCount >= 30 && deadCount < 45){
                        finalImage = imageB1dD2;
                    } else if(deadCount >= 45){
                        finalImage = imageB1dD3;
                    }
                } else if(left){
                    if(deadCount >= 0 && deadCount < 15){
                        finalImage = imageB1eF1;
                    } else if(deadCount >= 15 && deadCount < 30){
                        finalImage = imageB1eD1;
                    } else if(deadCount >= 30 && deadCount < 45){
                        finalImage = imageB1eD2;
                    } else if(deadCount >= 45){
                        finalImage = imageB1eD3;
                    }
                }
            }

            for(int i = 0; i < bullets.size(); i++){
                bullets.get(i).update(angles.get(i), 2);
            }

            if(bossStop){
                vX = 0;
                vY = 0;
            }

            if(hittedPlayer){
                zero = 1;
                timer = 0;
                hittedPlayer = false;
            }

            if(hittedBullet){
                one = 0;
                time = 0;
                hittedBullet = false;
            }

            if(zero == 1){
                timer++;
                vX *= -1;
                vY *= -1;
                if(timer > 30){
                    vX = 0;
                    vY = 0;
                    zero = 0;
                }
            }

            if(right && finishState == false && deadState == false){
                if(bossMove){
                    stop = 0;
                    go++;
                    if(go > 15){
                        if(bro == 0){
                            bro = 1;
                            go = 0;
                        } else if(bro == 1){
                            bro = 0;
                            go = 0;
                        }
                        if(bro == 0){
                            finalImage = imageB1;
                        } else if(bro == 1){
                            finalImage = imageB5;
                        }
                    }
                } else if(bossStop){
                    go = 0;
                    stop++;
                    if(stop > 15){
                        if(sister == 0){
                            sister = 1;
                            stop = 0;
                        } else if(sister == 1){
                            sister = 0;
                            stop = 0;
                        }
                        if(sister == 0){
                            finalImage = imageB1;
                        } else if(sister == 1){
                            finalImage = imageB2;
                        }
                    }
                }
            } else if(left && finishState == false && deadState == false){
                if(bossMove){
                    go++;
                    if(go > 20){
                        if(bro == 0){
                            bro = 1;
                            go = 0;
                        } else if(bro == 1){
                            bro = 0;
                            go = 0;
                        }
                        if(bro == 0){
                            finalImage = imageB3;
                        } else if(bro == 1){
                            finalImage = imageB6;
                        }
                    }
                } else if(bossStop){
                    go = 0;
                    stop++;
                    if(stop > 20){
                        if(sister == 0){
                            sister = 1;
                            stop = 0;
                        } else if(sister == 1){
                            sister = 0;
                            stop = 0;
                        }
                        if(sister == 0){
                            finalImage = imageB3;
                        } else if(sister == 1){
                            finalImage = imageB4;
                        }
                    }
                }
            }

            // useCajado = true;
            if(useFoice){
                armaBranca = true;
                armaDeFogo = false;
                finalGunDireita = imageFoiceDireita;
                finalGunEsquerda = imageFoiceEsquerda;
            } else if(useGlock){
                armaDeFogo = true;
                armaBranca = false;
                finalGunDireita = imageGlockDireita;
                finalGunEsquerda = imageGlockEsquerda;
            } else if(useCajado){
                armaBranca = false;
                armaDeFogo = true;
                finalGunDireita = imageCajadoDireita;
                finalGunEsquerda = imageCajadoEsquerda;
            } else if(useBook){
                armaBranca = true;
                armaDeFogo = false;
                finalGunDireita = imageBookDireita;
                finalGunEsquerda = imageBookEsquerda;
            }

        } else if(moment == 101){

            if(shotPredictShot && canShootPredictShot){
                bullets.add(new Bullet((int) eyeX + 50, (int) eyeY + 50));
                angles.add((float) Math.atan2(goY - eyeY, goX - eyeX));
                shotPredictShot = false;
            }

            if(shotPredictShot == false && canShootPredictShot){
                predictDelay++;
                theBulletFollower = bullets.size() - 1;
                if(theBulletFollower > 0){
                    bullets.get(theBulletFollower).speedEffect = true;
                    bullets.get(theBulletFollower).theSpeed = 5;
                }
                if(predictDelay >= 60){
                    shotPredictShot = true;
                    predictDelay = 0;
                }
            }

            if(hittedPlayer){
                zero = 1;
                timer = 0;
                hittedPlayer = false;
            }

            if(hittedBullet){
                one = 0;
                time = 0;
                hittedBullet = false;
            }

            if(zero == 1){
                timer++;
                vX *= -1;
                vY *= -1;
                if(timer > 30){
                    vX = 0;
                    vY = 0;
                    zero = 0;
                }
            }

            for(int i = 0; i < bullets.size(); i++){
                bullets.get(i).update(angles.get(i), 5);
            }

        }

        if(typeEnemy < 100){
            rectangle = new Rectangle((int) x + 25, (int) y + 10, 50, 90);
            enemyCollision = new Rectangle((int) x + 35, (int) y + 45, 25, 25);
        } else if (typeEnemy == 100 && finishState == false && deadState == false){
            rectangle = new Rectangle((int) x + 25, (int) y + 10, 150, 190);
        } else if (typeEnemy == 101){
            rectangle = new Rectangle((int) eyeX, (int) eyeY + 5, 100, 100);
        }

        x += vX;
        y += vY;

    }

    public void draw(Graphics2D g2){

        g2.setColor(Color.RED);
        if(typeEnemy < 100){
            g2.drawImage(sSombra, (int) x + 5, (int) y + 25, null);
            g2.drawImage(finalImage, (int) x, (int) y, null);
            // g2.draw(enemyCollision);
        }

        if(typeEnemy > 100){
            if(spawnEye){
                g2.drawImage(imageEye, eyeX, eyeY, null);
                float angle = (float) Math.atan2(goY - (eyeBallY), goX - (eyeBallX));
                eyeBallX = 400 + (int) (10 * Math.cos(angle));
                eyeBallY = -50 + (int) (10 * Math.sin(angle));
                g2.drawImage(imageEyeBall, eyeBallX, eyeBallY, null);
                g2.draw(rectangle);
                for(int i = 0; i < bullets.size(); i++){
                    bullets.get(i).draw(g2);
                }
            }
        }

        if(typeEnemy == 100){
            g2.drawImage(sSombra, (int) x + 25, (int) y + 100, null);
            g2.drawImage(finalImage, (int) x, (int) y, null);
            g2.setColor(Color.DARK_GRAY);
            g2.setFont(new Font("MV Boli", Font.PLAIN, 20));
            g2.drawString("Boss life: " + life + "/50", x + 20, y - 10);
            g2.setColor(Color.RED);
            if(armaDeFogo){
                g2.rotate(theta, x + 100, y + 100);
                if(useGlock){
                    if(right){
                        g2.drawImage(finalGun, (int) x + 150, (int) y + 35, null);
                        g2.drawImage(imageHand, (int) x + 117, (int) y + 35, null);
                    } else{
                        g2.drawImage(finalGun, (int) x + 150, (int) y + 25, null);
                        g2.drawImage(imageHand, (int) x + 117, (int) y - 0, null);
                    }
                } else if(useCajado){
                    if(right){
                        g2.drawImage(finalGun, (int) x + 150, (int) y + 35, null);
                        g2.drawImage(imageHand, (int) x + 117, (int) y + 35, null);
                    } else{
                        g2.drawImage(finalGun, (int) x + 150, (int) y + 25, null);
                        g2.drawImage(imageHand, (int) x + 117, (int) y + 25, null);
                    }
                }
                g2.rotate(-theta, x + 100, y + 100);
            } else if(armaBranca){
                if(useFoice){
                    if(right){
                        g2.drawImage(finalGun, (int) x + 150, (int) y + 25, null);
                        g2.drawImage(imageHand, (int) x + 109, (int) y + 35, null);
                    } else{
                        g2.drawImage(finalGun, (int) x - 100, (int) y + 25, null);
                        g2.drawImage(imageHand, (int) x - 59, (int) y + 35, null);
                    }
                } else if(useBook){
                    if(right){
                        g2.drawImage(finalGun, (int) x + 50, (int) y + 45, null);
                        g2.drawImage(imageHand, (int) x + 52, (int) y + 75, null);
                    } else{
                        g2.drawImage(finalGun, (int) x - 0, (int) y + 45, null);
                        g2.drawImage(imageHand, (int) x - 2, (int) y + 75, null);
                    }
                }
            }
            g2.draw(rectangle);
            for(int i = 0; i < bullets.size(); i++){
                bullets.get(i).draw(g2);
            }
        }

        // g2.draw(rectangle);
        if(spawn != 0){
            for(int i = 0; i < bullets.size(); i++){
                bullets.get(i).draw(g2);
            }
        }

    }

}
