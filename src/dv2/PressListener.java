package dv2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PressListener implements KeyListener
{
    public PressListener()
    {
        
    }

    @Override
    public void keyTyped(KeyEvent ke)
    {
        
    }

    @Override
    public void keyPressed(KeyEvent ke)
    {
        int key = ke.getKeyCode();
        if (key == KeyEvent.VK_UP)
        {
            try {
                Doolhof.speler.move("up");
            } catch (    FileNotFoundException | SQLException ex) {
                Logger.getLogger(PressListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (key == KeyEvent.VK_DOWN)
        {
            try {
                Doolhof.speler.move("down");
            } catch (    FileNotFoundException | SQLException ex) {
                Logger.getLogger(PressListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (key == KeyEvent.VK_LEFT)
        {
            try {
                Doolhof.speler.move("left");
            } catch (    FileNotFoundException | SQLException ex) {
                Logger.getLogger(PressListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (key == KeyEvent.VK_RIGHT)
        {
            try {
                Doolhof.speler.move("right");
            } catch (    FileNotFoundException | SQLException ex) {
                Logger.getLogger(PressListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (key == KeyEvent.VK_SPACE)
        {
            Doolhof.speler.schiet();
        }
        if (key == KeyEvent.VK_E)
        {
            Spel.doolhof.speler.pakBazooka();
        }
        if (key == KeyEvent.VK_R)
        {
            try {
                Spel.restart();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PressListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
