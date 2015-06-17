package dv2;

import java.awt.Color;
import java.awt.Graphics;

public class Vriend extends GameObject
{
    public Vriend(int x, int y)
    {
        this.x = x;
        this.y = y;
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
