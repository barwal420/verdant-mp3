package audio_player;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

class songs extends JInternalFrame{
    
    Audio_player AP;
    Color c1,c2;
    JLabel jlbsong;
    String filename;
    
    songs(Audio_player AP){
        this.AP = AP;
        c1 = new Color(0,219,247);
        c2 = new Color(0,0,0);
        
        setLayout(null);
        setBackground(c2);
        setForeground(c1);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        setVisible(true);
    }
    
    public void Display(String filename){
        this.filename= filename;
        
             
        jlbsong =new JLabel("filename");
        jlbsong.setBounds(0,1,296,500);
        add(jlbsong);
        
       
    }
}