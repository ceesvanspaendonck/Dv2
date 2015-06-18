package dv2;

import java.awt.Color;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Vriend extends GameObject
{
    public Vriend(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.kortstePad = true;
    }
    
    public void volgendLevel() throws FileNotFoundException, SQLException
    {
        Connectie.HighScoreOpslaan(Spel.doolhof.speler.naam, Doolhof.stappen, Doolhof.level+1);
        Spel.doolhof.level++;
        Spel.restart();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    @Override
    public String toString()
    {
        return "3";
    }
    
    @Override
    public void teken(Graphics g)
    {
        g.setColor(Color.BLUE);
        g.fillRect(this.x*25, this.y*25, 22, 22);
    } 
}
