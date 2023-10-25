import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ModeScreen extends JPanel{

    JPanel storyPanel = new JPanel();
    JLabel storyLabel = new JLabel();

    JPanel storyButtonP = new JPanel();
    JLabel storyButtonL = new JLabel();

    JPanel infinitePanel = new JPanel();
    JLabel infititeLabel = new JLabel();

    TheMouse mouseButtonStory = new TheMouse();
    TheMouse mouseReturn = new TheMouse();

    JPanel returnPanel = new JPanel();
    JLabel returnLabel = new JLabel();

    ModeScreen(){

        this.setSize(900, 600);
        this.setBackground(Color.DARK_GRAY);
        this.setOpaque(true);

        storyPanel.setBounds(100, 100, 150, 150);
        storyPanel.setBackground(Color.WHITE);
        storyPanel.setOpaque(true);

        storyButtonP.setBounds(100, 270, 150, 50);
        storyButtonP.setBackground(Color.WHITE);
        storyButtonP.setOpaque(true);
        storyButtonP.addMouseListener(mouseButtonStory);
        storyButtonP.addMouseMotionListener(mouseButtonStory);
        storyButtonP.setCursor(mouseButtonStory.cursor);

        returnPanel.setBounds(25, 475, 200, 75);
        returnPanel.setBackground(Color.black);
        returnPanel.setOpaque(true);
        returnPanel.add(returnLabel);
        returnPanel.addMouseListener(mouseReturn);
        returnPanel.addMouseMotionListener(mouseReturn);
        returnPanel.setCursor(mouseReturn.cursor);
        returnLabel.setBounds(50, 0, 200, 75);
        returnLabel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
        returnLabel.setForeground(Color.WHITE);
        returnLabel.setText("Return");
        returnLabel.setFont(new Font("MV Boli", Font.PLAIN, 40));

        this.add(storyPanel);
        this.add(storyButtonP);
        this.add(infinitePanel);
        this.add(returnPanel);

        this.setLayout(null);

    }

}
