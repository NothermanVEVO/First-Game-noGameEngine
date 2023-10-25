import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class EndScreen extends JPanel{

    boolean win;
    boolean lose;

    Random random = new Random();

    int frase;

    int highestCombo;

    BufferedImage duck;
    Image theDuck;

    JButton tryButton = new JButton();
    JButton leaveButton = new JButton();

    boolean tryy;
    boolean leave;

    EndScreen(){
        frase = random.nextInt(4) + 1;
        try {
            duck = ImageIO.read(getClass().getResourceAsStream("assets\\Duck.jpg"));
            theDuck = duck.getScaledInstance(256, 256, Image.SCALE_DEFAULT);
        } catch (IOException e) {
        }
        this.setSize(900, 600);
        this.setOpaque(false);
        this.add(tryButton);
        tryButton.setText("Try Again");
        tryButton.setBounds(220, 480, 100, 50);
        tryButton.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    tryy = true;
                }
            }
        );
        this.add(leaveButton);
        leaveButton.setText("Leave");
        leaveButton.setBounds(100, 480, 100, 50);
        leaveButton.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    leave = true;
                }
            }
        );
        this.setLayout(null);
    }

    public void update(){

    }

    public void draw(Graphics2D g2, Player player){
        this.win = player.won;
        this.lose = player.lose;
        this.highestCombo = player.highestCombo;

        g2.setColor(Color.WHITE);
        g2.setFont(new Font("MV Boli", Font.PLAIN, 30));

        if(win){
            g2.drawString("CONGRATULATIONS, YOU WON!!!", 180, 200);
            g2.drawImage(theDuck, 600, 225, null);
            g2.setFont(new Font("MV Boli", Font.PLAIN, 20));
            g2.drawString("TAKE A PICTURE OF THE DUCK AND YOUR", 150, 400);
            g2.drawString("HIGHEST SCORE AND SHOW TO ME!", 150, 430);
        } else if(lose){
            if(frase == 1){
                g2.drawString("WELL, YOU SHOULD TRY AGAIN, MAYBE", 130, 200);
            } else if(frase == 2){
                g2.drawString("GOOD LUCK NEXT TIME!", 230, 200);
            } else if(frase == 3){
                g2.drawString("OK, TRY AGAIN, BUT WITH MORE DEDICATION", 85, 200);
            } else if(frase == 4){
                g2.drawString("EEH, I HAVE TO WRITE SOMETHING HERE??", 100, 200);
            }
        }
        g2.setFont(new Font("MV Boli", Font.PLAIN, 30));
        g2.drawString("YOUR HIGHEST COMBO: " + highestCombo, 140, 300);

    }

}
