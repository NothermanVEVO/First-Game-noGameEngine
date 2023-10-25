import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OptionScreen extends JPanel {

    JPanel pVideo = new JPanel();
    JLabel lVideo = new JLabel();

    JPanel pAudio = new JPanel();
    JLabel lAudio = new JLabel();

    JPanel pControl = new JPanel();
    JLabel lControl = new JLabel();

    JPanel pReturn = new JPanel();
    JLabel lReturn = new JLabel();

    TheMouse mouseVideo = new TheMouse();
    TheMouse mouseAudio = new TheMouse();
    TheMouse mouseControl = new TheMouse();
    TheMouse mouseReturn = new TheMouse();

    OptionScreen(){

        this.setSize(900, 600);
        this.setBackground(Color.DARK_GRAY);
        this.setOpaque(true);

        pVideo.setBounds(300, 50, 300, 100);
        pVideo.setBackground(Color.black);
        pVideo.setOpaque(true);
        pVideo.add(lVideo);
        pVideo.addMouseListener(mouseVideo);
        pVideo.addMouseMotionListener(mouseVideo);
        pVideo.setCursor(mouseVideo.cursor);
        lVideo.setBounds(0, 0, 300, 100);
        lVideo.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
        lVideo.setForeground(Color.WHITE);
        lVideo.setText("Video");
        lVideo.setFont(new Font("MV Boli", Font.PLAIN, 65));

        pAudio.setBounds(300, 170, 300, 100);
        pAudio.setBackground(Color.black);
        pAudio.setOpaque(true);
        pAudio.add(lAudio);
        pAudio.addMouseListener(mouseAudio);
        pAudio.addMouseMotionListener(mouseAudio);
        pAudio.setCursor(mouseAudio.cursor);
        lAudio.setBounds(0, 0, 300, 100);
        lAudio.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
        lAudio.setForeground(Color.WHITE);
        lAudio.setText("Audio");
        lAudio.setFont(new Font("MV Boli", Font.PLAIN, 65));

        pControl.setBounds(300, 290, 300, 100);
        pControl.setBackground(Color.black);
        pControl.setOpaque(true);
        pControl.add(lControl);
        pControl.addMouseListener(mouseControl);
        pControl.addMouseMotionListener(mouseControl);
        pControl.setCursor(mouseControl.cursor);
        lControl.setBounds(0, 0, 300, 100);
        lControl.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
        lControl.setForeground(Color.WHITE);
        lControl.setText("Controls");
        lControl.setFont(new Font("MV Boli", Font.PLAIN, 65));

        pReturn.setBounds(300, 410, 300, 100);
        pReturn.setBackground(Color.black);
        pReturn.setOpaque(true);
        pReturn.add(lReturn);
        pReturn.addMouseListener(mouseReturn);
        pReturn.addMouseMotionListener(mouseReturn);
        pReturn.setCursor(mouseReturn.cursor);
        lReturn.setBounds(0, 0, 300, 100);
        lReturn.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
        lReturn.setForeground(Color.WHITE);
        lReturn.setText("Return");
        lReturn.setFont(new Font("MV Boli", Font.PLAIN, 65));

        this.add(pVideo);
        this.add(pAudio);
        this.add(pControl);
        this.add(pReturn);

        this.setLayout(null);

    }

}
