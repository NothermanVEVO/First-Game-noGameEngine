import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Teste extends JButton{

    Teste(){

        this.setBounds(540, 390, 200, 100);
        this.setText("DIGA OLA");
        this.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("OLA");
                }
            }
        );

    }

}
