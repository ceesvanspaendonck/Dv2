package dv2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Binnenmuur extends GameObject
{
    public Binnenmuur(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString()
    {
        return "1";
    }
    
    public static void vernietigMuur(int y, int x)
    {
        Pad pad = new Pad(x, y);
        Spel.doolhof.grid[y][x] = pad;
        Spel.doolhof.speler.ammo--;
    }
    
    public void teken(Graphics g)
    {
            g.setColor(Color.RED);
        g.fillRect(this.x*25, this.y*25, 22, 22);

        
      
        
    } 
}
