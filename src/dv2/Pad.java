package dv2;

import java.awt.Color;
import java.awt.Graphics;

public class Pad extends GameObject
{
    public Pad(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.kortstePad = false;
    }
    
    @Override
    public String toString()
    {
        return "0";
    }
    
    @Override
    public void teken(Graphics g)
    {
        
        g.setColor(Color.WHITE);
        g.fillRect(this.x*25, this.y*25, 22, 22);
    
        
    } 
}
