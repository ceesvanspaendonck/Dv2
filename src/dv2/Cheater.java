package dv2;

import java.awt.Color;
import java.awt.Graphics;

public class Cheater extends GameObject
{
    public Cheater(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString()
    {
        return "6";
    }
    
    @Override
    public void teken(Graphics g)
    {
        g.setColor(Color.cyan);
        g.fillRect(this.x*25, this.y*25, 22, 22);
    } 
}
