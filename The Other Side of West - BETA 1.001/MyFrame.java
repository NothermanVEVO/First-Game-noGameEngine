import javax.swing.JFrame;

public class MyFrame extends JFrame {

    GamePanel gamePanel = new GamePanel();

    MyFrame(){

        this.setSize(900, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("The Other Side of West");

        this.add(gamePanel);

        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        gamePanel.run();

    }

}
