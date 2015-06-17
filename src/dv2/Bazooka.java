package dv2;

import java.awt.Color;
import java.awt.Graphics;

public class Bazooka extends GameObject
{
    public Bazooka(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString()
    {
        return "4";
    }
    
    @Override
    public void teken(Graphics g)
    {
        g.setColor(Color.MAGENTA);
        g.fillRect(this.x*25, this.y*25, 22, 22);
    } 
}
