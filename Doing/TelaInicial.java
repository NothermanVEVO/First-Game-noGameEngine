import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TelaInicial extends JPanel{

    JButton iniciarJogo = new JButton();
    JButton sairJogo = new JButton();
    boolean iniciarOJogoPeloAmorDeDeus;

    TelaInicial(){
        this.setSize(1280, 720);
        this.setBackground(Color.LIGHT_GRAY);
        this.setVisible(true);
        
        this.add(iniciarJogo);
        iniciarJogo.setText("Iniciar");
        iniciarJogo.setBounds(540, 100, 200, 100);
        iniciarJogo.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == iniciarJogo){
                        iniciarOJogoPeloAmorDeDeus = true;
                    }
                }
            }
        );

        this.add(sairJogo);
        sairJogo.setText("Sair");
        sairJogo.setBounds(540, 300, 200, 100);
        sairJogo.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            }
        );

        this.setLayout(null);
    }
    
}
