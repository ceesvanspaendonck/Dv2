package dv2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Pad extends GameObject
{
    boolean hahaha;
    public ArrayList<Color> kleuren = new ArrayList<Color>();
    int i = 0;
    public Pad(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.kortstePad = false;
        this.hahaha = false;
        kleuren.add(Color.BLACK);      
        kleuren.add(Color.BLUE);
        kleuren.add(Color.CYAN);
        kleuren.add(Color.DARK_GRAY);
        kleuren.add(Color.GRAY);
        kleuren.add(Color.GREEN);
        kleuren.add(Color.LIGHT_GRAY);
        kleuren.add(Color.MAGENTA);
        kleuren.add(Color.ORANGE);
        kleuren.add(Color.PINK);
        kleuren.add(Color.RED);
        kleuren.add(Color.WHITE);
        kleuren.add(Color.YELLOW);
    }
    
    
    @Override
    public String toString()
    {
        return "0";
    }
    
    @Override
    public void teken(Graphics g)
    {
        System.out.println(i);
        if(this.kortstePad == true)
        {
            g.setColor(kleuren.get(i));
            g.fillRect(this.x*25, this.y*25, 22, 22);
            if(i == 12)
            {
                i = 0;
            }
            else
            {
                i++;
            }
        }
        else
        {
            g.setColor(Color.WHITE);
            g.fillRect(this.x*25, this.y*25, 22, 22);
        }
    } 
}
