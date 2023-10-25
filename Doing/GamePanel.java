import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{

    TelaInicial telaInicial = new TelaInicial();
    TelaGame telaGame = new TelaGame();

    Thread thread;
    float sleepTime;
    float FPS = 60;
    int contar = 0;
    int segundo = 0;

    GamePanel(){
        this.setSize(1280, 720);
        // this.setBackground(Color.BLACK);
        // this.setVisible(true);
        this.add(telaInicial);
        this.add(telaGame);
        this.setLayout(null);
    }

    public void createGameThread(){
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        sleepTime = 1000/FPS;
        if(thread != null){
            while (true) {
                try {
                    Thread.sleep((long) sleepTime);
                } catch (InterruptedException e) {
                }
                update();
                repaint();
            }
        }
    }

    public void update(){
        // contar++;
        // if(contar == 60){
        //     segundo++;
        //     System.out.println(segundo);
        //     contar = 0;
        // }
        if(telaInicial.iniciarOJogoPeloAmorDeDeus){
            telaInicial.setVisible(false);
            telaGame.update();
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if(telaInicial.iniciarOJogoPeloAmorDeDeus){
            telaGame.draw(g2);
        }

    }
    
}
