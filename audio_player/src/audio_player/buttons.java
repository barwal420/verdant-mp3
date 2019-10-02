
package audio_player;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

class buttons extends JInternalFrame implements ActionListener,MouseListener{
    
    Audio_player AP;
    Color c1,c2;
    JButton jbtpause, jbtstop,jbtloop;
    JButton jbtplay,jbtoptions;
    songs songname;
    static int count;
    
    functioning f = new functioning();
    
    buttons(Audio_player AP){
        this.AP = AP;
        songname = new songs(AP);
        c1 = new Color(0,219,200);
        c2 = new Color(0,0,0);
        
        setLayout(null);
        setBorder(null);
        setBackground(c2);
        
    //LOOP        
        jbtloop = new JButton(new ImageIcon(getClass().getResource("loop.png")));
        jbtloop.setBounds(0,0,50,50);
        add(jbtloop);
        jbtloop.addActionListener(this);
        jbtloop.addMouseListener(this);
        jbtloop.setBackground(c2);
        jbtloop.setBorder(null);
        jbtloop.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbtloop.setFocusPainted(false);
    
    //STOP        
        jbtstop = new JButton(new ImageIcon(getClass().getResource("stop.png")));
        jbtstop.setBounds(60,0,50,50);
        add(jbtstop);
        jbtstop.addActionListener(this);
        jbtstop.addMouseListener(this);
        jbtstop.setBackground(c2);
        jbtstop.setBorder(null);
        jbtstop.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbtstop.setFocusPainted(false);
        
    //PLAY        
        jbtplay = new JButton(new ImageIcon(getClass().getResource("play.png")));
        jbtplay.setBounds(125,0,50,50);
        add(jbtplay);
        jbtplay.addActionListener(this);
        jbtplay.addMouseListener(this);
        jbtplay.setBackground(c2);
        jbtplay.setBorder(null);
        jbtplay.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbtplay.setFocusPainted(false);
    
    //PAUSE        
        jbtpause = new JButton(new ImageIcon(getClass().getResource("pause.png")));
        jbtpause.setBounds(190,0,50,50);
        add(jbtpause);
        jbtpause.addActionListener(this);
        jbtpause.addMouseListener(this);
        jbtpause.setBackground(c2);
        jbtpause.setBorder(null);
        jbtpause.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbtpause.setFocusPainted(false);

    //OPTIONS        
         jbtoptions = new JButton(new ImageIcon(getClass().getResource("options.png")));
        jbtoptions.setBounds(250,0,50,50);
        add(jbtoptions);
        jbtoptions.addActionListener(this);
        jbtoptions.addMouseListener(this);
        jbtoptions.setBackground(c2);
        jbtoptions.setBorder(null);
        jbtoptions.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbtoptions.setFocusPainted(false);

        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent ae) {
        if(ae.getSource() == jbtstop){
            f.stop();
        }
        
        if(ae.getSource() == jbtplay){
            f.resume();
        }
        
        if(ae.getSource() == jbtpause){
            f.pause();
        }
        
        if(ae.getSource() == jbtoptions){
            FileFilter filter = new FileNameExtensionFilter("MP3 Files", "mp3", "mpeg3");
            
            JFileChooser chooser = new JFileChooser("G:\\Songs");
            
            chooser.addChoosableFileFilter(filter);
            
            int returnVal = chooser.showOpenDialog(null);
            
            if (returnVal == JFileChooser.APPROVE_OPTION){
                
                f.stop();
                
                File myFile = chooser.getSelectedFile();
                String song = myFile + "";
                
                String name = chooser.getSelectedFile().getName();
                               
                songname.Display(name);
                
                f.Play(song);
            }
        }
        
        if(ae.getSource() == jbtloop){
            switch(count){
                case 0:
                    count = 1;
                    System.out.println(count);
                    break;
                
                case 1:
                    count = 0;
                    System.out.println(count);
                    break;
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}