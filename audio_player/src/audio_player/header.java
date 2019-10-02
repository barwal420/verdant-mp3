
package audio_player;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

class header extends JInternalFrame implements ActionListener,MouseListener{
    
    Audio_player AP;
    Color c1,c2;
    JButton jbtlike, jbtclose,jbtmin;
    Font f1;
    JLabel jlbname;
    
    header(Audio_player AP){
        this.AP = AP;
        c1 = new Color(0,219,247);
        c2 = new Color(0,0,0);
        f1 = new Font("Ariel",Font.BOLD, 21);
        
        setLayout(null);
        setBorder(null);
        setBackground(c1);
        
        jbtlike = new JButton("Like Us!");
        jbtlike.setBounds(0, 0, 50, 22);
        jbtlike.setFocusPainted(false);
        add(jbtlike);
        jbtlike.addActionListener(this);
        jbtlike.addMouseListener(this);
        jbtlike.setBackground(c1);
        jbtlike.setBorder(null);
        jbtlike.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        jbtclose = new JButton("x");
        jbtclose.setBounds(475, -5, 25, 30);
        jbtclose.setFont(f1);
        add(jbtclose);
        jbtclose.addActionListener(this);
        jbtclose.addMouseListener(this);
        jbtclose.setFocusPainted(false);
        jbtclose.setBackground(c1);
        jbtclose.setForeground(c2);
        jbtclose.setBorder(null);
        jbtclose.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        jbtmin = new JButton("_");
        jbtmin.setBounds(450, -8, 25, 27);
        jbtmin.setFont(f1);
        add(jbtmin);
        jbtmin.addActionListener(this);
        jbtmin.addMouseListener(this);
        jbtmin.setFocusPainted(false);
        jbtmin.setBackground(c1);
        jbtmin.setForeground(c2);
        jbtmin.setBorder(null);
        jbtmin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        jlbname = new JLabel("Verdant Music Player");
        jlbname.setBounds(189,0,121,22);
        add(jlbname);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == jbtclose){
            AP.dispose();
        }
        
        if(ae.getSource()== jbtmin){
            AP.setExtendedState(AP.ICONIFIED);
        }
        
        if(ae.getSource()==jbtlike)
        {
            try 
            {
                open(new URI("http://www.facebook.com/barwal420"));
            } 
            catch (URISyntaxException ex) 
            {
                Logger.getLogger(footer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
     private static void open(URI uri) 
    {
        if (Desktop.isDesktopSupported()) 
        {
            try 
            {
                Desktop.getDesktop().browse(uri);
            } 
            catch (IOException e) { }
        } 
        else 
        { 
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent ae) {
        
        if(ae.getSource() == jbtclose){
            jbtclose.setBounds(475, -7, 25, 30);
        }
        
        if(ae.getSource() == jbtmin){
            jbtmin.setBounds(450, -10, 25, 27);
        }
        
        if(ae.getSource() == jbtlike){
            jbtlike.setBounds(0, -2, 50, 22);
        }
    }

    @Override
    public void mouseExited(MouseEvent ae) {
        
        if(ae.getSource() == jbtclose){
            jbtclose.setBounds(475, -5, 25, 30);
        }
        
        if(ae.getSource() == jbtmin){
            jbtmin.setBounds(450, -8, 25, 27);
        }
        
        if(ae.getSource() == jbtlike){
            jbtlike.setBounds(0, 0, 50, 22);
        }
    }
}