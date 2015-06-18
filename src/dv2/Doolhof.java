package dv2;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Doolhof
{
    static int level;
    static int stappen;
    static Speler speler;
    Helper helper;
    Vriend vriend;
    Cheater cheater;
    Bazooka bazooka;
    Vijand vijand;
    public GameObject[][] grid = new GameObject[15][15];
    
    public Doolhof(int stappen)
    {
        this.stappen = stappen;
    }
    
    public void vormGrid() throws FileNotFoundException
    {
        java.io.File file = null;
        
        if (level == 0)
        {
             file = new java.io.File("Levels/Doolhoftxt.txt");
        }
        if (level == 1)
        {
             file = new java.io.File("Levels/Doolhoftxt2.txt");
        } 
        if (level == 2)
        {
             file = new java.io.File("Levels/Doolhoftxt3.txt");
        }

        try
        {
            Scanner input = new Scanner(file);
            
            for (int i = 0; i < 15; i++)
            {
                for (int j = 0; j < 15; j++)
                {
                    
                    int getal = Integer.parseInt(input.next());
                    if(getal == 0)
                    {
                        Pad pad = new Pad(j, i);
                        grid[i][j] = pad;
                    }
                    if(getal == 1) 
                    {
                        Binnenmuur binnenmuur = new Binnenmuur(j, i);
                        grid[i][j] = binnenmuur;
                    }
                    if(getal == 2)
                    {
                        speler = new Speler(j, i);
                        Pad pad = new Pad(j, i);
                        grid[i][j] = pad;
                    }
                    if(getal == 3)
                    {
                        vriend = new Vriend(j, i);
                        grid[i][j] = vriend;
                    }
                    if(getal == 4)
                    {
                        bazooka = new Bazooka(j, i);
                        grid[i][j] = bazooka;
                    }
                    if(getal == 5)
                    {
                        Buitenmuur buitenmuur = new Buitenmuur(j, i);
                        grid[i][j] = buitenmuur;
                    }
                    if (getal == 6)
                    {
                        cheater = new Cheater(j, i);
                        grid[i][j] = cheater;
                    }
                    if (getal == 7)
                    {
                        helper = new Helper(j, i);
                        grid[i][j] = helper;
                    }
                    if (getal == 8)
                    {
                        vijand = new Vijand(j, i);
                        grid[i][j] = vijand;
                    }
                }
            }
        }
        
        catch(FileNotFoundException e)
        {
            System.err.format("Error, geen file\n");
        }
    }

    public static int getStappen() {
        return stappen;
    }

    public static void setStappen(int stappen) {
        Doolhof.stappen = stappen;
    }

    public static int getLevel() {
        return level;
    }

    public static void setLevel(int level) {
        Doolhof.level = level;
    }

    public int getVriendY()
    {
        return vriend.getY();
    }
    public int getVriendX()
    {
        return vriend.getX();
    }
}
