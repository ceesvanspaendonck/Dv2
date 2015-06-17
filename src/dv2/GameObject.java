package dv2;

import java.awt.Graphics;

public abstract class GameObject
{
    public int x,y, solverWaarde;
    public Boolean kortstePad;
    
    public static boolean alGeweest;
    
    
    public abstract String toString();
    
    public abstract void teken(Graphics g);
}
