import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PauseScreen extends JPanel{

    TheMouse mouse = new TheMouse();

    JPanel pPause = new JPanel();
    JLabel lPause = new JLabel();

    JPanel pResume = new JPanel();
    JLabel lResume = new JLabel();

    JPanel pOptions = new JPanel();
    JLabel lOptions = new JLabel();

    JPanel pQuit = new JPanel();
    JLabel lQuit = new JLabel();

    PauseScreen(){

        this.setBounds(325, 75, 250, 425);
        this.setBackground(Color.gray);
        this.setOpaque(true);
        this.addMouseListener(mouse);
        this.addMouseMotionListener(mouse);
        this.add(pPause);

        pPause.setBounds(50, 25, 150, 50);
        pPause.setBackground(Color.DARK_GRAY);
        pPause.setOpaque(true);
        pPause.add(lPause);
        lPause.setForeground(Color.WHITE);
        lPause.setFont(new Font("MV Boli", Font.PLAIN, 35));
        lPause.setText("Paused");
        lPause.setBorder(BorderFactory.createEmptyBorder(0, 20, 30, 20));

        this.setLayout(null);

    }

}
