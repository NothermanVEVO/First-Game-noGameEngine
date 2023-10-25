import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CharacterScreen extends JPanel{

    int stop = 0;
    int bro = 1;

    boolean firstTimeP1 = true, firstTimeP2 = true;

    boolean right, left;
    TheMouse mouseAbs = new TheMouse();

    int num = 0;

    String name;

    BufferedImage buttonLeft;
    BufferedImage buttonRight;
    BufferedImage buttonLeftPressed;
    BufferedImage buttonRightPressed;
    BufferedImage comboyOneDireita1, comboyOneDireita2, comboyOneEsquerda1, comboyOneEsquerda2;
    BufferedImage comboyTwoDireita1, comboyTwoDireita2, comboyTwoEsquerda1, comboyTwoEsquerda2;
    BufferedImage comboyTwo;
    BufferedImage backIn;
    ImageIcon image1;
    ImageIcon image2;
    ImageIcon image3Done, image3Dtwo, image3Eone, image3Etwo;
    ImageIcon image4Done, image4Dtwo, image4Eone, image4Etwo;
    ImageIcon image5, image6;
    ImageIcon image7;

    ImageIcon finalImageP1;

    TheMouse mouseLeft = new TheMouse();
    TheMouse mouseRight = new TheMouse();

    JPanel continuePanel = new JPanel();
    JLabel continueLabel = new JLabel();

    JPanel backPanel = new JPanel();
    JLabel backLabel = new JLabel();

    TheMouse continueMouse = new TheMouse();
    TheMouse backMouse = new TheMouse();

    JPanel rightPanel = new JPanel();
    JLabel rightLabel = new JLabel();

    JPanel leftPanel = new JPanel();
    JLabel leftLabel = new JLabel();

    JPanel characterPanel = new JPanel();
    JLabel characterLabel = new JLabel();

    JPanel descPanel = new JPanel();
    JLabel descLabel = new JLabel();

    JPanel rDescPanel = new JPanel();

    JPanel namePanel = new JPanel();
    JLabel nameLabel = new JLabel();

    JPanel basePanel = new JPanel();
    JLabel baseLabel = new JLabel();

    //---------------------------//

    JPanel passiveP = new JPanel();
    JLabel passiveL = new JLabel();
    TheMouse mousePassive = new TheMouse();

    JPanel hab1P = new JPanel();
    JLabel hab1L = new JLabel();
    TheMouse mouseHab1 = new TheMouse();

    JPanel hab2P = new JPanel();
    JLabel hab2L = new JLabel();
    TheMouse mouseHab2 = new TheMouse();

    JPanel ultP = new JPanel();
    JLabel ultL = new JLabel();
    TheMouse mouseUlt = new TheMouse();

    JPanel descriP = new JPanel();
    JLabel descriL = new JLabel();
    //---------------------------//

    JPanel dialogP = new JPanel();
    JLabel title = new JLabel();

    JLabel line1 = new JLabel();
    JLabel line2 = new JLabel();
    JLabel line3 = new JLabel();
    JLabel line4 = new JLabel();
    JLabel line5 = new JLabel();
    JLabel line6 = new JLabel();
    JLabel line7 = new JLabel();
    JLabel line8 = new JLabel();
    JLabel line9 = new JLabel();
    JLabel line10 = new JLabel();
    JLabel line11 = new JLabel();
    JLabel line12 = new JLabel();

    boolean history = true, passive, hab1, hab2, ult;

    BufferedImage hab1Arthur, hab2Arthur, hab1Jules, hab2Jules;
    ImageIcon hab1ArthurIcon, hab2ArthurIcon, hab1JulesIcon, hab2JulesIcon;

    CharacterScreen(){

        try {
            hab1Arthur = ImageIO.read(getClass().getResourceAsStream("assets\\tirosHabilidade.png"));
            Image image1 = hab1Arthur.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            hab1ArthurIcon = new ImageIcon(image1);

            hab2Arthur = ImageIO.read(getClass().getResourceAsStream("assets\\cambalhotaHabilidade.png"));
            Image image2 = hab2Arthur.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            hab2ArthurIcon = new ImageIcon(image2);

            hab1Jules = ImageIO.read(getClass().getResourceAsStream("assets\\tiraoHabilidade.png"));
            Image image3 = hab1Jules.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            hab1JulesIcon = new ImageIcon(image3);

            hab2Jules = ImageIO.read(getClass().getResourceAsStream("assets\\toroHabilidade.png"));
            Image image4 = hab2Jules.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            hab2JulesIcon = new ImageIcon(image4);
        } catch (IOException e) {
        }

        try {
            buttonLeft = ImageIO.read(getClass().getResourceAsStream("assets\\buttonLeft.png"));
            buttonRight = ImageIO.read(getClass().getResourceAsStream("assets\\buttonRight.png"));
            buttonLeftPressed = ImageIO.read(getClass().getResourceAsStream("assets\\buttonLeftPressed.png"));
            buttonRightPressed = ImageIO.read(getClass().getResourceAsStream("assets\\buttonRightPressed.png"));
            //Cowboy 1
            comboyOneDireita1 = ImageIO.read(getClass().getResourceAsStream("assets\\Comboy1TwoDireita1.png"));
            comboyOneDireita2 = ImageIO.read(getClass().getResourceAsStream("assets\\Comboy1TwoDireita2.png"));
            comboyOneEsquerda1 = ImageIO.read(getClass().getResourceAsStream("assets\\Comboy1TwoEsquerda1.png"));
            comboyOneEsquerda2 = ImageIO.read(getClass().getResourceAsStream("assets\\Comboy1TwoEsquerda2.png"));
            //Cowboy 2
            comboyTwoDireita1 = ImageIO.read(getClass().getResourceAsStream("assets\\Comboy2TwoDireita1.png"));
            comboyTwoDireita2 = ImageIO.read(getClass().getResourceAsStream("assets\\Comboy2TwoDireita2.png"));
            comboyTwoEsquerda1 = ImageIO.read(getClass().getResourceAsStream("assets\\Comboy2TwoEsquerda1.png"));
            comboyTwoEsquerda2 = ImageIO.read(getClass().getResourceAsStream("assets\\Comboy2TwoEsquerda2.png"));

            comboyTwo = ImageIO.read(getClass().getResourceAsStream("assets\\Comboy2Two.png"));
            backIn = ImageIO.read(getClass().getResourceAsStream("assets\\backback3.0.png"));
        } catch (IOException e) {
        }

        Image imageLeft = buttonLeft.getScaledInstance(75, 75, Image.SCALE_DEFAULT);
        Image imageRight = buttonRight.getScaledInstance(75, 75, Image.SCALE_DEFAULT);
        Image imageLeftPressed = buttonLeftPressed.getScaledInstance(75, 75, Image.SCALE_DEFAULT);
        Image imageRightPressed = buttonRightPressed.getScaledInstance(75, 75, Image.SCALE_DEFAULT);
        Image imageOneD1 = comboyOneDireita1.getScaledInstance(275, 300, Image.SCALE_DEFAULT);
        Image imageOneD2 = comboyOneDireita2.getScaledInstance(275, 300, Image.SCALE_DEFAULT);
        Image imageOneE1 = comboyOneEsquerda1.getScaledInstance(275, 300, Image.SCALE_DEFAULT);
        Image imageOneE2 = comboyOneEsquerda2.getScaledInstance(275, 300, Image.SCALE_DEFAULT);
        Image imageTwoD1 = comboyTwoDireita1.getScaledInstance(275, 300, Image.SCALE_DEFAULT);
        Image imageTwoD2 = comboyTwoDireita2.getScaledInstance(275, 300, Image.SCALE_DEFAULT);
        Image imageTwoE1 = comboyTwoEsquerda1.getScaledInstance(275, 300, Image.SCALE_DEFAULT);
        Image imageTwoE2 = comboyTwoEsquerda2.getScaledInstance(275, 300, Image.SCALE_DEFAULT);
        Image imageBack = backIn.getScaledInstance(275, 420, Image.SCALE_DEFAULT);

        image1 = new ImageIcon(imageLeft);
        image2 = new ImageIcon(imageRight);
        image3Done = new ImageIcon(imageOneD1);
        image3Dtwo = new ImageIcon(imageOneD2);
        image3Eone = new ImageIcon(imageOneE1);
        image3Etwo = new ImageIcon(imageOneE2);
        image4Done = new ImageIcon(imageTwoD1);
        image4Dtwo = new ImageIcon(imageTwoD2);
        image4Eone = new ImageIcon(imageTwoE1);
        image4Etwo = new ImageIcon(imageTwoE2);
        image5 = new ImageIcon(imageLeftPressed);
        image6 = new ImageIcon(imageRightPressed);
        image7 = new ImageIcon(imageBack);

        this.setSize(900, 600);
        this.setBackground(Color.darkGray);
        this.setOpaque(true);        

        this.add(dialogP);
        this.add(hab1P);
        this.add(hab2P);
        this.add(ultP);
        this.add(passiveP);
        this.add(characterPanel);
        this.add(basePanel);
        this.add(rDescPanel);
        this.add(namePanel);
        this.add(continuePanel);
        this.add(backPanel);
        this.add(rightPanel);
        this.add(leftPanel);
        this.add(descPanel);

        dialogP.setBounds(620, 140, 177, 300);
        dialogP.setBackground(Color.GRAY);
        dialogP.setOpaque(true);
        dialogP.add(title);
        dialogP.add(line1);
        dialogP.add(line2);
        dialogP.add(line3);
        dialogP.add(line4);
        dialogP.add(line5);
        dialogP.add(line6);
        dialogP.add(line7);
        dialogP.add(line8);
        dialogP.add(line9);
        dialogP.add(line10);
        title.setBounds(30, 10, 100, 25);
        title.setForeground(Color.WHITE);
        title.setBackground(Color.BLACK);
        title.setOpaque(true);
        title.setFont(new Font("MV Boli", Font.PLAIN, 30));
        title.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
        title.setText("TITULO");

        line1.setBounds(10, 45, 130, 245);
        line1.setForeground(Color.WHITE);
        line1.setBackground(Color.BLACK);
        line1.setOpaque(true);
        line1.setFont(new Font("MV Boli", Font.PLAIN, 12));
        // line1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 105));
        line1.setText("Linha 1");

        line2.setBounds(10, 55, 130, 245);
        line2.setForeground(Color.WHITE);
        line2.setBackground(Color.BLACK);
        line2.setOpaque(true);
        line2.setFont(new Font("MV Boli", Font.PLAIN, 12));
        // line2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 100));
        line2.setText("Linha 2");

        line3.setBounds(10, 65, 130, 245);
        line3.setForeground(Color.WHITE);
        line3.setBackground(Color.BLACK);
        line3.setOpaque(true);
        line3.setFont(new Font("MV Boli", Font.PLAIN, 12));
        // line3.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 100));
        line3.setText("Linha 3");

        line4.setBounds(10, 55, 130, 245);
        line4.setForeground(Color.WHITE);
        line4.setBackground(Color.BLACK);
        line4.setOpaque(true);
        line4.setFont(new Font("MV Boli", Font.PLAIN, 12));
        // line4.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 100));
        line4.setText("Linha 4");

        line5.setBounds(10, 55, 130, 245);
        line5.setForeground(Color.WHITE);
        line5.setBackground(Color.BLACK);
        line5.setOpaque(true);
        line5.setFont(new Font("MV Boli", Font.PLAIN, 12));
        // line5.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 100));
        line5.setText("Linha 5");

        line6.setBounds(10, 55, 130, 245);
        line6.setForeground(Color.WHITE);
        line6.setBackground(Color.BLACK);
        line6.setOpaque(true);
        line6.setFont(new Font("MV Boli", Font.PLAIN, 12));
        // line6.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 100));
        line6.setText("Linha 6");

        line7.setBounds(10, 55, 130, 245);
        line7.setForeground(Color.WHITE);
        line7.setBackground(Color.BLACK);
        line7.setOpaque(true);
        line7.setFont(new Font("MV Boli", Font.PLAIN, 12));
        line7.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 100));
        line7.setText("Linha 7");

        line8.setBounds(10, 55, 130, 245);
        line8.setForeground(Color.WHITE);
        line8.setBackground(Color.BLACK);
        line8.setOpaque(true);
        line8.setFont(new Font("MV Boli", Font.PLAIN, 12));
        // line8.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 100));
        line8.setText("Linha 8");

        line9.setBounds(10, 55, 130, 245);
        line9.setForeground(Color.WHITE);
        line9.setBackground(Color.BLACK);
        line9.setOpaque(true);
        line9.setFont(new Font("MV Boli", Font.PLAIN, 12));
        // line9.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 100));
        line9.setText("Linha 9");
        
        line10.setBounds(10, 55, 130, 245);
        line10.setForeground(Color.WHITE);
        line10.setBackground(Color.BLACK);
        line10.setOpaque(true);
        line10.setFont(new Font("MV Boli", Font.PLAIN, 12));
        // line10.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 100));
        line10.setText("Linha 10");

        passiveP.setBounds(560, 145, 50, 50);
        passiveP.setBackground(Color.GREEN);
        passiveP.setOpaque(true);
        passiveP.addMouseMotionListener(mousePassive);
        passiveP.addMouseListener(mousePassive);
        passiveP.setCursor(mousePassive.cursor);

        hab1P.setBounds(555, 220, 60, 60);
        // hab1P.setBackground(Color.GREEN);
        hab1P.setOpaque(false);
        hab1P.addMouseMotionListener(mouseHab1);
        hab1P.addMouseListener(mouseHab1);
        hab1P.setCursor(mouseHab1.cursor);
        hab1P.add(hab1L);
        hab1L.setIcon(hab1ArthurIcon);

        hab2P.setBounds(555, 295, 60, 60);
        // hab2P.setBackground(Color.GREEN);
        hab2P.setOpaque(false);
        hab2P.addMouseMotionListener(mouseHab2);
        hab2P.addMouseListener(mouseHab2);
        hab2P.setCursor(mouseHab2.cursor);
        hab2P.add(hab2L);
        hab2L.setIcon(hab2ArthurIcon);

        ultP.setBounds(560, 370, 50, 50);
        ultP.setBackground(Color.GREEN);
        ultP.setOpaque(true);
        ultP.addMouseMotionListener(mouseUlt);
        ultP.addMouseListener(mouseUlt);
        ultP.setCursor(mouseUlt.cursor);

        descPanel.setBounds(525, 25, 300, 440);
        descPanel.setBackground(Color.BLACK);
        descPanel.setOpaque(true);

        namePanel.setBounds(578, 50, 200, 60);
        namePanel.setBackground(Color.DARK_GRAY);
        namePanel.setOpaque(true);
        namePanel.add(nameLabel);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("MV Boli", Font.PLAIN, 40));
        nameLabel.setText("NOME");

        rDescPanel.setBounds(550, 125, 250, 325);
        rDescPanel.setBackground(Color.DARK_GRAY);
        rDescPanel.setOpaque(true);

        continuePanel.setBounds(725, 500, 150, 50);
        continuePanel.setBackground(Color.BLACK);
        continuePanel.setOpaque(true);
        continuePanel.add(continueLabel);
        continuePanel.addMouseListener(continueMouse);
        continuePanel.addMouseMotionListener(continueMouse);
        continuePanel.setCursor(continueMouse.cursor);
        continuePanel.setLayout(null);
        continueLabel.setBounds(15, 2, 150, 50);
        continueLabel.setForeground(Color.WHITE);
        continueLabel.setFont(new Font("MV Boli", Font.PLAIN, 30));
        continueLabel.setText("Continue");

        backPanel.setBounds(15, 500, 150, 50);
        backPanel.setBackground(Color.BLACK);
        backPanel.setOpaque(true);
        backPanel.add(backLabel);
        backPanel.addMouseListener(backMouse);
        backPanel.addMouseMotionListener(backMouse);
        backPanel.setCursor(backMouse.cursor);
        backLabel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
        backLabel.setBounds(15, 0, 150, 50);
        backLabel.setForeground(Color.WHITE);
        backLabel.setFont(new Font("MV Boli", Font.PLAIN, 30));
        backLabel.setText("Return");

        rightPanel.setBounds(25, 200, 85, 85);
        rightPanel.setBackground(Color.DARK_GRAY);
        rightPanel.setOpaque(true);
        rightPanel.add(rightLabel);
        rightPanel.addMouseListener(mouseLeft);
        rightPanel.addMouseMotionListener(mouseLeft);
        rightPanel.setCursor(mouseLeft.cursor);
        rightLabel.setBounds(0, 0, 75, 75);
        rightLabel.setIcon(image1);

        leftPanel.setBackground(Color.DARK_GRAY);
        leftPanel.setBounds(400, 200, 85, 85);
        leftPanel.setOpaque(true);
        leftPanel.add(leftLabel);
        leftPanel.addMouseListener(mouseRight);
        leftPanel.addMouseMotionListener(mouseRight);
        leftPanel.setCursor(mouseRight.cursor);
        leftLabel.setBounds(0, 0, 75, 75);
        leftLabel.setIcon(image2);

        characterPanel.setBounds(170, 115, 200, 300);
        characterPanel.setBackground(new Color(148, 146, 159, 255));
        characterPanel.add(characterLabel);

        basePanel.setBounds(125, 25, 275, 425);
        basePanel.setBackground(Color.DARK_GRAY);
        basePanel.add(baseLabel);

        baseLabel.setIcon(image7);

        this.setLayout(null);

    }

    public void update(TheMouse mouse){

        // System.out.println(num);

        this.mouseAbs = mouse;
        
        if(mouseAbs.movCodeX <= 260){
            left = true;
            right = false;
        } else{
            left = false;
            right = true;
        }

        if(mousePassive.inThere == false && mouseHab1.inThere == false 
            && mouseHab2.inThere == false && mouseUlt.inThere == false){
            history = true;
            passive = false;
            hab1 = false;
            hab2 = false;
            ult = false;
        } else if(mousePassive.inThere){
            history = false;
            passive = true;
            hab1 = false;
            hab2 = false;
            ult = false;
        } else if(mouseHab1.inThere){
            history = false;
            passive = false;
            hab1 = true;
            hab2 = false;
            ult = false;
        } else if(mouseHab2.inThere){
            history = false;
            passive = false;
            hab1 = false;
            hab2 = true;
            ult = false;
        } else if(mouseUlt.inThere){
            history = false;
            passive = false;
            hab1 = false;
            hab2 = false;
            ult = true;
        }

        if(mouseRight.rightButton){

            num++;
            if(num == 2){
                num = 0;
            }
            mouseRight.rightButton = false;

        }if(mouseLeft.leftButton){

            num--;
            if(num == -1){
                num = 1;
            }
            mouseLeft.leftButton = false;

        }

        //! PROBLEMA AQUI!

        //O problema deve ser que está na condição toda hora, tem que fazer entrar na condição 
        //  e já sair, criar uma booleana, talvez...

        if(num == 0){
            hab1L.setIcon(hab1ArthurIcon);
            hab2L.setIcon(hab2ArthurIcon);
            if(firstTimeP1){
                if(right){
                    characterLabel.setIcon(image3Done);
                    firstTimeP1 = false;
                } else{
                    characterLabel.setIcon(image3Eone);
                    firstTimeP1 = false;
                }
            }
            stop++;
            if(right){
                if(stop >= 30){
                    if(bro == 1){
                        bro = 2;
                        stop = 0;
                    } else if(bro == 2){
                        bro = 1;
                        stop = 0;
                    }
                }
                if(bro == 1){
                    characterLabel.setIcon(image3Done);
                } else if(bro == 2){
                    characterLabel.setIcon(image3Dtwo);
                }
            } else {
                if(stop >= 30){
                    if(bro == 1){
                        bro = 2;
                        stop = 0;
                    } else if(bro == 2){
                        bro = 1;
                        stop = 0;
                    }
                }
                if(bro == 1){
                    characterLabel.setIcon(image3Eone);
                } else if(bro == 2){
                    characterLabel.setIcon(image3Etwo);
                }
            }
            // characterLabel.setIcon(image3);
            nameLabel.setText("Arthur Baludo");
            nameLabel.setFont(new Font("MV Boli", Font.PLAIN, 28));
            if(history){
                title.setText("ABOUT");
                line1.setText("Arthur it's the best cowboy");
                line2.setText("of the town. ");
                line3.setText("He won the nick \"Baludo\" ");
                line4.setText("after killing three guys using ");
                line5.setText("a stick and a cup of watter. ");
                line6.setText("");
                line7.setText("");
                line8.setText("");
                line9.setText("");
                line10.setText("");
            } else if(passive){
                title.setText("PASSIVE");
                line1.setText("");
                line2.setText("");
                line3.setText("");
                line4.setText("");
                line5.setText("");
                line6.setText("");
                line7.setText("");
                line8.setText("");
                line9.setText("");
                line10.setText("");
            } else if(hab1){
                title.setText("FAST HAND");
                line1.setText("It remove the gun cooldown ");
                line2.setText("Then, it's time to click! ");
                line3.setText("");
                line4.setText("");
                line5.setText("Hability time: 4,0s ");
                line6.setText("Hability cooldown: 4,0s ");
                line7.setText("");
                line8.setText("");
                line9.setText("");
                line10.setText("");
            } else if(hab2){
                title.setText("FRONTFLIP");
                line1.setText("You can dodge attacks ");
                line2.setText("by doing a frontflip ");
                line3.setText("This increase your speed ");
                line4.setText("and makes you immortal ");
                line5.setText("for a short period of time ");
                line6.setText("");
                line7.setText("");
                line8.setText("Hability time: 0,7s ");
                line9.setText("Hability cooldown: 1,0s ");
                line10.setText("");
            } else if(ult){
                title.setText("ULTIMATE");
                line1.setText("");
                line2.setText("");
                line3.setText("");
                line4.setText("");
                line5.setText("");
                line6.setText("");
                line7.setText("");
                line8.setText("");
                line9.setText("");
                line10.setText("");
            }
        } else if(num == 1){
            hab1L.setIcon(hab1JulesIcon);
            hab2L.setIcon(hab2JulesIcon);
            if(firstTimeP2){
                if(right){
                    characterLabel.setIcon(image4Done);
                    firstTimeP1 = false;
                } else{
                    characterLabel.setIcon(image4Eone);
                    firstTimeP1 = false;
                }
            }
            stop++;
            if(right){
                if(stop >= 30){
                    if(bro == 1){
                        bro = 2;
                        stop = 0;
                    } else if(bro == 2){
                        bro = 1;
                        stop = 0;
                    }
                }
                if(bro == 1){
                    characterLabel.setIcon(image4Done);
                } else if(bro == 2){
                    characterLabel.setIcon(image4Dtwo);
                }
            } else {
                if(stop >= 30){
                    if(bro == 1){
                        bro = 2;
                        stop = 0;
                    } else if(bro == 2){
                        bro = 1;
                        stop = 0;
                    }
                }
                if(bro == 1){
                    characterLabel.setIcon(image4Eone);
                } else if(bro == 2){
                    characterLabel.setIcon(image4Etwo);
                }
            }
            nameLabel.setText("Jules Jackson");
            //Jules Jackson V
            //J.J. V
            nameLabel.setFont(new Font("MV Boli", Font.PLAIN, 28));
            if(history){
                title.setText("ABOUT");
                line1.setText("Jules Jackson, as known as ");
                line2.setText("JJ. Five, he's the ");
                line3.setText("toughest guy of the west. ");
                line4.setText("There's legend that says ");
                line5.setText("that he killed a person ");
                line6.setText("just with his presence. ");
                line7.setText("");
                line8.setText("");
                line9.setText("");
                line10.setText("");
            } else if(passive){
                title.setText("PASSIVE");
                line1.setText("");
                line2.setText("");
                line3.setText("");
                line4.setText("");
                line5.setText("");
                line6.setText("");
                line7.setText("");
                line8.setText("");
                line9.setText("");
                line10.setText("");
            } else if(hab1){
                title.setText("THE DRILL");
                line1.setText("Your next bullet can go ");
                line2.setText("through all your enemies! ");
                line3.setText("");
                line4.setText("");
                line5.setText("Hability time: Until you shoot ");
                line6.setText("Hability cooldown: 8,0s ");
                line7.setText("");
                line8.setText("");
                line9.setText("");
                line10.setText("");
            } else if(hab2){
                title.setText("THE RAGE");
                line1.setText("Jules get's filled with ");
                line2.setText("rage, making him go through ");
                line3.setText("enemies without taking any ");
                line4.setText("damage, also, it increase ");
                line5.setText("his speed! ");
                line6.setText("");
                line7.setText("");
                line8.setText("Hability time: 3,0s ");
                line9.setText("Hability cooldown: 10,0s ");
                line10.setText("");
            } else if(ult){
                title.setText("ULTIMATE");
                line1.setText("");
                line2.setText("");
                line3.setText("");
                line4.setText("");
                line5.setText("");
                line6.setText("");
                line7.setText("");
                line8.setText("");
                line9.setText("");
                line10.setText("");
            }
        }

        if(mouseLeft.mouseClicked){
            rightLabel.setIcon(image5);
        } else if(mouseLeft.mouseReleased){
            rightLabel.setIcon(image1);
        } else if(mouseLeft.inThere == false){
            rightLabel.setIcon(image1);
        }

        if(mouseRight.mouseClicked){
            leftLabel.setIcon(image6);
        } else if(mouseRight.mouseReleased){
            leftLabel.setIcon(image2);
        } else if(mouseRight.inThere == false){
            leftLabel.setIcon(image2);
        }

        //! PROBLEMA AQUI!

    }

}
