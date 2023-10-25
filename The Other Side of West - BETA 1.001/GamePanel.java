import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class GamePanel extends JPanel implements Runnable{

    Gun gun = new Gun();
    TheClock clock = new TheClock();

    float theAngle;

    float degree;
    float anglePause;

    Rectangle rectangle;

    boolean hurt = false;
    boolean firstHurt = false;

    int lua = -1;

    int escolha;

    int quantBullet = 0;

    boolean cover = true;

    float angle;

    boolean changeToCharacter;
    boolean changeToGameMode;
    boolean changeToGame;
    boolean game;

    boolean firstShoot;

    float x = 0;
    float y = 0;

    float velX = 0;
    float velY = 0;

    TheKey key = new TheKey();
    TheMouse mouse = new TheMouse();

    TitleScreen titleScreen = new TitleScreen();
    CharacterScreen characterScreen = new CharacterScreen();
    GameScreen gameScreen = new GameScreen();

    Player player = new Player(key, characterScreen.num, 1);

    Bullet bullet = new Bullet(1000000000, 1000000000);

    ModeScreen modeScreen = new ModeScreen();

    OptionScreen optionScreen = new OptionScreen();
    PauseScreen pauseScreen = new PauseScreen();

    boolean show = false;

    EndScreen endScreen = new EndScreen();

    GamePanel(){

        this.setSize(900, 600);
        this.setBackground(new Color(236, 198, 160));
        this.setOpaque(true);

        this.add(player);
        this.addKeyListener(key);
        this.add(endScreen);
        endScreen.setVisible(false);
        this.add(pauseScreen);
        pauseScreen.setVisible(false);
        this.add(titleScreen);
        this.add(characterScreen);
        characterScreen.setVisible(false);
        this.add(gameScreen);
        gameScreen.setVisible(false);
        this.add(modeScreen);
        modeScreen.setVisible(false);
        this.add(optionScreen);
        optionScreen.setVisible(false);
        this.addMouseListener(mouse);
        this.addMouseMotionListener(mouse);

        this.setLayout(null);
        this.setFocusable(true);
        this.setDoubleBuffered(true);

    }

    @Override
    public void run() {

        double drawInterval = 1000000000/60;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        // System.out.println("Number of threads " + 
        //     ManagementFactory.getThreadMXBean().getThreadCount());

        // System.out.println("Number of threads " + Thread.activeCount());

        while(cover){

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;

            if(delta >= 1){

                update();
                repaint();
                delta--;

            }

        }

    }

    public void update(){

        if(titleScreen.quitMouse.mouseReleased && titleScreen.quitMouse.inThere){
            System.exit(0);
        }

        if(game && !(player.endGame)){
            if(key.pause == false){
                player.update(characterScreen.num, mouse);
                gun.update(characterScreen.num, escolha);
                // clock.createClock();
                if(mouse.movCodeX < player.playerX + 50){
                    escolha = -1;
                } else {
                    escolha = 1;
                }
                gameScreen.update(player.playerX, player.playerY, key, player.rectangle, player, this,
                    mouse);
            }
        }

        if(key.pause){
            show = true;
        } else{
            show = false;
        }

        pauseScreen.setVisible(show);

        titleScreen.update();

        if(titleScreen.newMouse.mouseReleased){
            // changeToCharacter = true;
            changeToCharacter = true;
            titleScreen.newMouse.mouseReleased = false;
        }

        if(titleScreen.loadMouse.mouseReleased){
            titleScreen.setVisible(false);
            optionScreen.setVisible(true);
            titleScreen.loadMouse.mouseReleased = false;
        }

        if(changeToGameMode){
            titleScreen.setVisible(false);
            modeScreen.setVisible(true);
            changeToGameMode = false;
        }

        if(changeToCharacter){
            titleScreen.setVisible(false);
            characterScreen.setVisible(true);
            characterScreen.update(mouse);
            player = new Player(key, characterScreen.num, 1);
        }

        if(modeScreen.mouseReturn.mouseReleased){
            modeScreen.setVisible(false);
            titleScreen.setVisible(true);
            modeScreen.mouseReturn.mouseReleased = false;
        }

        if(optionScreen.mouseReturn.mouseReleased){
            optionScreen.setVisible(false);
            titleScreen.setVisible(true);
            optionScreen.mouseReturn.mouseReleased = false;
        }

        if(characterScreen.backMouse.mouseReleased){

            changeToCharacter = false;
            characterScreen.backMouse.mouseReleased = false;
            characterScreen.setVisible(false);
            titleScreen.setVisible(true);

        }

        if(characterScreen.continueMouse.mouseReleased){
            game = true;
            changeToGame = true;
            characterScreen.continueMouse.mouseReleased = false;
            changeToCharacter = false;
        }
        if(changeToGame){
            characterScreen.setVisible(false);
            //gameScreen.setVisible(true);
            changeToGame = false;
        }

        degree = (float) Math.atan2(mouse.movCodeY - (player.playerY + 50), 
            mouse.movCodeX - (player.playerX + 50));

        if(player.ocorreu && !(player.endGame)){
            this.setBackground(new Color(185, 201, 210));
        }else if(player.endGame){
            this.setBackground(Color.BLACK);
            endScreen.setVisible(true);
        } else {
            this.setBackground(new Color(236, 198, 160));
        }
        if(endScreen.leave){
            gameScreen = new GameScreen();
            player = new Player(key, characterScreen.num, 1);
            player.resetar = true;
            gameScreen.moment = 1;
            gameScreen.clock = new TheClock();
            endScreen.setVisible(false);
            endScreen.frase = endScreen.random.nextInt(4) + 1;
            changeToCharacter = true;
            game = false;
            endScreen.leave = false;
        } else if(endScreen.tryy){
            gameScreen = new GameScreen();
            player = new Player(key, characterScreen.num, 1);
            player.resetar = true;
            gameScreen.moment = 1;
            gameScreen.clock = new TheClock();
            endScreen.setVisible(false);
            endScreen.frase = endScreen.random.nextInt(4) + 1;
            endScreen.tryy = false;
        }

    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        if(game && !(player.endGame)){
            gameScreen.draw(g2);
            g2.translate(player.playerX + 50, player.playerY + 50);
            if(key.pause == false){
                g2.rotate(degree);
                anglePause = degree;
            } else if(key.pause){
                g2.rotate(anglePause);
            }

            gun.x = -25;
            gun.y = -25;
            gun.draw(g2);
            g2.rotate(-(anglePause));
            g2.translate(-(player.playerX + 50), -(player.playerY + 50));
            g2.rotate(0);

            if(key.pause == false){
                g2.dispose();
            }
        } else if(player.endGame){
            endScreen.draw(g2, player);
        }

    }

}
