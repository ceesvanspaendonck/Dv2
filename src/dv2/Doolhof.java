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
    public GameObject[][] grid = new GameObject[15][15];
    
    public Doolhof(int stappen)
    {
        this.stappen = stappen;
    }
    
    public void vormGrid() throws FileNotFoundException
    {
       
        //java.io.File file = new java.io.File("C:\\Users\\max\\Desktop\\woo\\D\\src\\Doolhoftxt4.txt");
        java.io.File file = new java.io.File("C:/Users/Sony/Documents/NetBeansProjects/Dv2/src/DoolhofTxt.txt");
        
        if (level == 1){
             file = new java.io.File("C:\\Users\\max\\Desktop\\woo\\D\\src\\Doolhoftxt5.txt");
        }
         if (level == 2){
             file = new java.io.File("C:\\Users\\max\\Desktop\\woo\\D\\src\\Doolhoftxt.txt");
        } 
         if (level == 3){
             file = new java.io.File("C:\\Users\\max\\Desktop\\woo\\D\\src\\Doolhoftxt4.txt");
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
                        Bazooka bazooka = new Bazooka(j, i);
                        grid[i][j] = bazooka;
                    }
                    if(getal == 5)
                    {
                        Buitenmuur buitenmuur = new Buitenmuur(j, i);
                        grid[i][j] = buitenmuur;
                    }
                    if (getal == 6)
                    {
                        Cheater cheater = new Cheater(j, i);
                        grid[i][j] = cheater;
                    }
                    if (getal == 7)
                    {
                        helper = new Helper(j, i);
                        grid[i][j] = helper;
                    }
                    if (getal == 8)
                    {
                        Vijand vijand = new Vijand(j, i);
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
