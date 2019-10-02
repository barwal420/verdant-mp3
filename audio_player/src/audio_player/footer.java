package audio_player;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

class footer extends JInternalFrame implements ActionListener,MouseListener{
    
    Audio_player AP;
    Color c1,c2;
    JLabel copy;
    
    footer(Audio_player AP){
        this.AP = AP;
        c1 = new Color(0,219,247);
        c2 = new Color(0,0,0);
        
        setLayout(null);
        setBorder(null);
        setBackground(c1);
        
        copy = new JLabel("Created by Mohit Rana Copyrights 2017");
        copy.setBounds(75,-1,350,25);
        add(copy);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){}
    
    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
  
}
