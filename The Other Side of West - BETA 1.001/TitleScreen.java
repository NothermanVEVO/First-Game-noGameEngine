import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitleScreen extends JPanel{

    JPanel titlePanel = new JPanel();
    JLabel titleLabel = new JLabel();

    JPanel newPanel = new JPanel();
    JLabel newLabel = new JLabel();

    JPanel loadPanel = new JPanel();
    JLabel loadLabel = new JLabel();

    JPanel exitPanel = new JPanel();
    JLabel exitLabel = new JLabel();

    TheMouse newMouse = new TheMouse();
    TheMouse loadMouse = new TheMouse();
    TheMouse quitMouse = new TheMouse();

    BufferedImage playButton, playButtonSelected, playButtonPressed;
    BufferedImage optionButton, optionButtonSelected, optionButtonPressed;
    BufferedImage exitButton, exitButtonSelected, exitButtonPressed;

    ImageIcon image1Pone, image1Ptwo, image1Pthree;
    ImageIcon image1Oone, image1Otwo, image1Othree;
    ImageIcon image1Eone, image1Etwo, image1Ethree;

    TitleScreen(){

        try {
            playButton = ImageIO.read(getClass().getResourceAsStream("assets\\playButton.png"));
            playButtonSelected = ImageIO.read(getClass().getResourceAsStream("assets\\playButtonSelected.png"));
            playButtonPressed = ImageIO.read(getClass().getResourceAsStream("assets\\playButtonPressed.png"));

            optionButton = ImageIO.read(getClass().getResourceAsStream("assets\\optionButton.png"));
            optionButtonSelected = ImageIO.read(getClass().getResourceAsStream("assets\\optionButtonSelected.png"));
            optionButtonPressed = ImageIO.read(getClass().getResourceAsStream("assets\\optionButtonPressed.png"));

            exitButton = ImageIO.read(getClass().getResourceAsStream("assets\\exitButton.png"));
            exitButtonSelected = ImageIO.read(getClass().getResourceAsStream("assets\\exitButtonSelected.png"));
            exitButtonPressed = ImageIO.read(getClass().getResourceAsStream("assets\\exitButtonPressed.png"));
        } catch (IOException e) {
        }

        Image image1 = playButton;
        Image image2 = playButtonSelected;
        Image image3 = playButtonPressed;

        Image image4 = optionButton;
        Image image5 = optionButtonSelected;
        Image image6 = optionButtonPressed;

        Image image7 = exitButton;
        Image image8 = exitButtonSelected;
        Image image9 = exitButtonPressed;

        image1Pone = new ImageIcon(image1);
        image1Ptwo = new ImageIcon(image2);
        image1Pthree = new ImageIcon(image3);

        image1Oone = new ImageIcon(image4);
        image1Otwo = new ImageIcon(image5);
        image1Othree = new ImageIcon(image6);

        image1Eone = new ImageIcon(image7);
        image1Etwo = new ImageIcon(image8);
        image1Ethree = new ImageIcon(image9);

        this.setSize(900, 600);

        this.setBackground(Color.gray);
        this.setOpaque(true);

        titlePanel.setBounds(150, 50, 600, 100);
        titlePanel.setBackground(Color.BLACK);
        titlePanel.setOpaque(true);
        titlePanel.setLayout(null);
        titlePanel.add(titleLabel);
        titleLabel.setBounds(10, 0, 600, 100);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("MV Boli", Font.PLAIN, 50));
        titleLabel.setText("The Other Side of West");

        newPanel.setBounds(300, 200, 300, 100);
        newPanel.setBackground(Color.GRAY);
        newPanel.setOpaque(true);
        newPanel.setLayout(null);
        newPanel.add(newLabel);
        newPanel.addMouseListener(newMouse);
        newPanel.setCursor(newMouse.cursor);
        newLabel.setBounds(0, 0, 300, 100);
        newLabel.setIcon(image1Oone);
        // newLabel.setForeground(Color.white);
        // newLabel.setFont(new Font("MV Boli", Font.PLAIN, 65));
        // newLabel.setText("Play");

        loadPanel.setBounds(300, 320, 300, 100);
        loadPanel.setBackground(Color.GRAY);
        loadPanel.setOpaque(true);
        loadPanel.setLayout(null);
        loadPanel.add(loadLabel);
        loadPanel.addMouseListener(loadMouse);
        loadPanel.setCursor(loadMouse.cursor);
        loadLabel.setBounds(0, 0, 300, 100);
        loadLabel.setIcon(image1Oone);
        // loadLabel.setForeground(Color.white);
        // loadLabel.setFont(new Font("MV Boli", Font.PLAIN, 65));
        // loadLabel.setText("Options");

        exitPanel.setBounds(300, 440, 300, 100);
        exitPanel.setBackground(Color.GRAY);
        exitPanel.setOpaque(true);
        exitPanel.setLayout(null);
        exitPanel.add(exitLabel);
        exitPanel.addMouseListener(quitMouse);
        exitPanel.setCursor(quitMouse.cursor);
        exitLabel.setBounds(0, 0, 300, 100);
        exitLabel.setIcon(image1Eone);
        // exitLabel.setForeground(Color.white);
        // exitLabel.setFont(new Font("MV Boli", Font.PLAIN, 65));
        // exitLabel.setText("Exit");

        this.add(titlePanel);
        this.add(newPanel);
        this.add(loadPanel);
        this.add(exitPanel);

        this.setLayout(null);

    }

    public void update(){

        if(newMouse.inThere == false){
            newLabel.setIcon(image1Pone);
        } else if(newMouse.mouseClicked){
            newLabel.setIcon(image1Pthree);
        } else if(newMouse.inThere){
            newLabel.setIcon(image1Ptwo);
        }

        if(loadMouse.inThere == false){
            loadLabel.setIcon(image1Oone);
        } else if(loadMouse.mouseClicked){
            loadLabel.setIcon(image1Othree);
        } else if(loadMouse.inThere){
            loadLabel.setIcon(image1Otwo);
        }

        if(quitMouse.inThere == false){
            exitLabel.setIcon(image1Eone);
        } else if(quitMouse.mouseClicked){
            exitLabel.setIcon(image1Ethree);
        } else if(quitMouse.inThere){
            exitLabel.setIcon(image1Etwo);
        }

    }

}
