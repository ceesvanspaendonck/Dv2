package dv2;

import java.awt.Color;
import java.awt.Graphics;

public class Buitenmuur extends GameObject
{
    Color donkerRood = new Color(200, 0, 0);
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
        g.setColor(donkerRood);
        g.fillRect(this.x*25, this.y*25, 22, 22);
    } 
}
