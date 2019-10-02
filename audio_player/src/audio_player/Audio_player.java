
package audio_player;

import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.*;

class Audio_player extends JFrame 
{
    songs song;
    header head;
    footer foot;
    buttons btns;
    gif giff;
    Color c1,c2;
    JLabel logo,txt;

    Audio_player()
    {
        c1 = new Color(0,219,247);
        c2 = new Color(0,0,0);
        
//SET MAIN FRAME        
        setSize(500,253);
        setLayout(null);
        setResizable(false);
        setUndecorated(true);
        getContentPane().setBackground(c2);
        getRootPane().setBorder(BorderFactory.createLineBorder(c2,1,true));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Opens App in Centre of Screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
//set application icon
        setIconImage(new ImageIcon(getClass().getResource("icon.png")).getImage());

//DEFINE INTERNAL FRAME FOR SONGS        
        song = new songs(this);
        song.setBounds(2,115,300,30);
        add(song);
        song.setBackground(c2);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)song.getUI()).setNorthPane(null);

//DEFINE INTERNAL FRAME FOR HEADER
        head = new header(this);
        head.setBounds(0,0,500,22);
        add(head);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)head.getUI()).setNorthPane(null);

//DEFINE INTERNAL FRAME FOR FOOTER
        foot = new footer(this);
        foot.setBounds(0,231,500,22);
        add(foot);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)foot.getUI()).setNorthPane(null);
    
//DEFINE INTERNAL FRAME FOR BUTTONS
        btns = new buttons(this);
        btns.setBounds(2,165,300,50);
        add(btns);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)btns.getUI()).setNorthPane(null);

//DEFINE INTERNAL FRAME FOR GIF
        giff = new gif(this);
        giff.setBounds(304,22,196,209);
        add(giff);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)giff.getUI()).setNorthPane(null);

//LOGO IMAGE        
        logo = new JLabel(new ImageIcon(getClass().getResource("logo.png")));
        logo.setBounds(43,26,75,65);
        logo.setBorder(null);
        add(logo);
        
        txt = new JLabel(new ImageIcon(getClass().getResource("txt.png")));
        txt.setBounds(82,13,200,80);
        txt.setBorder(null);
        add(txt);
 
        setVisible(true);
    }
    
    public static void main(String[] args) 
    {

        new Audio_player();
        
    }
}