package dv2;

import java.awt.Graphics;

public abstract class GameObject
{
    public int x,y, solverWaarde;
    public Boolean kortstePad;    
    public static boolean alGeweest;
    
    public void verwijderObject()
    {
            Pad pad = new Pad(Spel.doolhof.speler.x,Spel.doolhof.speler.y);
            Spel.doolhof.grid[Spel.doolhof.speler.y][Spel.doolhof.speler.x] = pad;
    }
    
    public abstract String toString();
    
    public abstract void teken(Graphics g);
}
