package dv2;

import java.awt.Color;
import java.awt.Graphics;

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
    
    @Override
    public void teken(Graphics g)
    {
        g.setColor(Color.RED);
        g.fillRect(this.x*25, this.y*25, 22, 22);
        
    } 
}
