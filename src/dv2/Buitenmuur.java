package dv2;

import java.awt.Color;
import java.awt.Graphics;

public class Buitenmuur extends GameObject
{  
    public Buitenmuur(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString()
    {
        return "5";
    }
    
    @Override
    public void teken(Graphics g)
    {
        g.setColor(Color.RED);
        g.fillRect(this.x*25, this.y*25, 22, 22);
    } 
}
