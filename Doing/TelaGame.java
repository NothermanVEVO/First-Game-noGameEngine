import java.awt.Graphics2D;

import javax.swing.JPanel;

public class TelaGame extends JPanel{

    Mouse mouse = new Mouse();
    Key key = new Key();
    Player player = new Player();
    Enemy enemy = new Enemy();

    TelaGame(){

        this.setSize(1280, 720);
        this.setOpaque(false);
        this.addKeyListener(key);
        this.addMouseListener(mouse);
        this.addMouseMotionListener(mouse);

        this.setFocusable(true);
        this.setDoubleBuffered(true);

    }

    public void update(){

        player.update(this);
        enemy.update(player);

        if(player.rectangle.intersects(enemy.rectangle)){
            System.out.println("AIAI");
        }

    }

    public void draw(Graphics2D g2){
        player.draw(g2);
        enemy.draw(g2);
    }

}
