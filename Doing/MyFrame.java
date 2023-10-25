import javax.swing.JFrame;

public class MyFrame extends JFrame{

    GamePanel gamePanel = new GamePanel();

    MyFrame(){

        this.setSize(1280, 720);
        this.setTitle("Como fazer um jogo 2D no Java");
        this.add(gamePanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        gamePanel.createGameThread();

    }

}
