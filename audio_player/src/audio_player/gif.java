
package audio_player;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

class gif extends JInternalFrame{
    
    Audio_player AP;
    Color c1,c2;
    JLabel jlbgif;
    
    gif(Audio_player AP){
        this.AP = AP;
        c1 = new Color(0,219,247);
        c2 = new Color(0,0,0);

        setLayout(null);
        setBorder(null);
        setBackground(c2);
        
        jlbgif = new JLabel(new ImageIcon(getClass().getResource("ap_1.gif")));
        jlbgif.setBounds(5,5,196,209);
        add(jlbgif);
        
        setVisible(true);
    }
    
}
