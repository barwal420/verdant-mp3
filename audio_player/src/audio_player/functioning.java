
package audio_player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

class functioning {
    
    FileInputStream FIS;
    BufferedInputStream BIS;
    
    Audio_player AP;
    Player player;
    long pauselocation;
    long songlength;
    String filelocation;
    songs songname = new songs(AP);

//STOP THE SONG    
    void stop(){
    
        //CHECK IF ANY SONG IS PLAYING    
        if(player != null){
            
            player.close();
            
            pauselocation = 0;
            songlength = 0;
        
        }
    }
    
//PAUSE THE SONG    
    void pause(){
    
        //CHECK IF ANY SONG IS PLAYING    
        if(player != null){
            
            try {
                pauselocation = FIS.available();
                player.close();
            }
            catch (IOException ex) {}
        
        }
    }
    
//PLAY THE SONG    
    void Play(String path){
        
        try{
            FIS = new FileInputStream(path);
            BIS = new BufferedInputStream(FIS);
            
            player = new Player(BIS);
            
            songlength = FIS.available();
            
            filelocation = path + "";
        }
        
        catch (FileNotFoundException | JavaLayerException ex){
            
        }
        catch (IOException ex) {}
        
        new Thread(){
            
            @Override
            public void run(){
                try {
                    player.play();
                }
                catch (JavaLayerException ex) {   
                }
            }
            
        }.start();
    }
    
//RESUME THE SONG    
    void resume(){
        
        try{
            FIS = new FileInputStream(filelocation);
            BIS = new BufferedInputStream(FIS);
            
            player = new Player(BIS);
            
            FIS.skip(songlength-pauselocation);
        }
        catch (FileNotFoundException | JavaLayerException ex){
            
        } catch (IOException ex) {}

        
// LOOP CHECK        
        new Thread(){
            
            @Override
            public void run(){
                try {
                    player.play();
                    
                    if (player.isComplete() && buttons.count == 1){
                        Play(filelocation);
                    }
                    
                    if (player.isComplete()){
                        //songs.Display("");
                    }
                }
                catch (JavaLayerException ex) {
                
                }
            }
        }.start();
    }
}