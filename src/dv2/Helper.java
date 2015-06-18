package dv2;

import java.awt.Color;
import java.awt.Graphics;
import java.io.FileNotFoundException;

public class Helper extends GameObject
{
    private static boolean verandering;
    private static boolean looptDood;
    private static boolean splitsing;
    private static int splitsingX, splitsingY;
    private static String startRichting;
    public Helper(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.looptDood = false;
        this.splitsing = false;
        this.startRichting = "boven";
    }
    
    public void solve() throws FileNotFoundException
    {
        for (int i = 0; i < 15; i++)
        {
            for (int j = 0; j < 15; j++)
            {
                Spel.doolhof.grid[i][j].solverWaarde = 1000; 
                Spel.doolhof.grid[i][j].kortstePad = false;
            }           
        }
        Spel.doolhof.grid[y][x].solverWaarde = 0;
        Spel.doolhof.grid[y][x].kortstePad = true;
        
        //////////////////////////////////////////////alles is nu false & 1000, behalve locatie helper = 0 & true
        
        for (int i = 0; i < 1000; i++)
        {
            vindRoute();
        }
        maakRoute();
    } 
    
    public void vindRoute()
    {   
        for (int i = 1; i < 14; i++)
        {
            for (int j = 1; j < 14; j++)
            {
                if((Spel.doolhof.grid[(i - 1)][j].solverWaarde + 1) > Spel.doolhof.grid[i][j].solverWaarde)
                {
                    if(!(Spel.doolhof.grid[(i - 1)][j] instanceof Binnenmuur) && !(Spel.doolhof.grid[(i - 1)][j] instanceof Buitenmuur))
                    {
                        Spel.doolhof.grid[(i - 1)][j].solverWaarde = Spel.doolhof.grid[i][j].solverWaarde + 1;
                        verandering = true;
                    }
                }
                else
                {
                    verandering = false;
                }
                if((Spel.doolhof.grid[(i + 1)][j].solverWaarde + 1) > Spel.doolhof.grid[i][j].solverWaarde)
                {
                    if(!(Spel.doolhof.grid[(i + 1)][j] instanceof Binnenmuur) && !(Spel.doolhof.grid[(i + 1)][j] instanceof Buitenmuur))
                    {
                        Spel.doolhof.grid[(i + 1)][j].solverWaarde = Spel.doolhof.grid[i][j].solverWaarde + 1;
                        verandering = true;
                    }
                }
                else
                {
                    verandering = false;
                }
                if((Spel.doolhof.grid[i][(j - 1)].solverWaarde + 1) > Spel.doolhof.grid[i][j].solverWaarde)
                {
                    if(!(Spel.doolhof.grid[i][(j - 1)] instanceof Binnenmuur) && !(Spel.doolhof.grid[i][(j - 1)] instanceof Buitenmuur))
                    {
                        Spel.doolhof.grid[(i)][(j - 1)].solverWaarde = Spel.doolhof.grid[i][j].solverWaarde + 1;
                        verandering = true;
                    }
                }
                else
                {
                    verandering = false;
                }
                if((Spel.doolhof.grid[i][(j + 1)].solverWaarde + 1) > Spel.doolhof.grid[i][j].solverWaarde)
                {
                    if(!(Spel.doolhof.grid[i][(j + 1)] instanceof Binnenmuur) && !(Spel.doolhof.grid[i][(j + 1)] instanceof Buitenmuur))
                    {
                        Spel.doolhof.grid[i][(j + 1)].solverWaarde = Spel.doolhof.grid[i][j].solverWaarde + 1;
                        verandering = true;
                    }
                }
                else
                {
                    verandering = false;
                }
            }
        }
    }
    
    public void maakRoute()
    {
        int solverWaardeVriend = Spel.doolhof.grid[Spel.doolhof.getVriendY()][Spel.doolhof.getVriendX()].solverWaarde;
        Spel.doolhof.grid[Spel.doolhof.vriend.y][Spel.doolhof.vriend.x].kortstePad = true; 
        Spel.doolhof.grid[Spel.doolhof.helper.y][Spel.doolhof.helper.x].kortstePad = false;
        looptDood = false;
        int x;
        int y;
        y = Spel.doolhof.vriend.y;
        x = Spel.doolhof.vriend.x;
        
        checkOnderdeelRoute(x, y, solverWaardeVriend);
        System.out.println("einde recu");
        dubbeleShow();
        
    }
    
    public static void checkOnderdeelRoute(int x, int y, int solverWaardeVriend)
    {
        if(Spel.doolhof.grid[y][x].kortstePad == true)
        {
            System.out.println("x(" + x + ") - y(" + y + ") is momenteel of gelijk aan een tegel waar kortstePad true is");
            
            if(bovenMogelijk(x, y) == true)
            {
                if(rechtsMogelijk(x, y) == true || onderMogelijk(x, y) == true || linksMogelijk(x, y) == true)
                {
                    System.out.print(" maar andere richting is ook mogelijk, dus hier is splitsing");
                    splitsing = true;
                    splitsingX = x;
                    splitsingY = y;
                } 
                else
                {
                    splitsing = false;
                }
                System.out.println("vakje hierboven is mogelijke move");
                bovenKortsteRoute(x, y);
                y--;
            }
            else if(rechtsMogelijk(x, y) == true)
            {
                if(onderMogelijk(x, y) == true || linksMogelijk(x, y) == true || bovenMogelijk(x, y) == true)
                {
                    System.out.print(" maar andere richting is ook mogelijk, dus hier is splitsing");
                    splitsing = true;
                    splitsingX = x;
                    splitsingY = y;
                }
                else
                {
                    splitsing = false;
                }
                System.out.println("vakje hierrechts is mogelijke move");
                rechtsKortsteRoute(x, y);
                x++;
            }
            else if(onderMogelijk(x, y) == true)
            {
                if(linksMogelijk(x, y) == true || bovenMogelijk(x, y) == true || rechtsMogelijk(x, y) == true)
                {
                    System.out.print(" maar andere richting is ook mogelijk, dus hier is splitsing");
                    splitsing = true;
                    splitsingX = x;
                    splitsingY = y;
                }
                else
                {
                    splitsing = false;
                }
                System.out.println("vakje hieronder is mogelijke move");
                onderKortsteRoute(x, y);
                y++;
            }
            else if(linksMogelijk(x, y) == true)
            {
                if(bovenMogelijk(x, y) == true || rechtsMogelijk(x, y) == true || onderMogelijk(x, y) == true)
                {
                    System.out.print(" maar andere richting is ook mogelijk, dus hier is splitsing");
                    splitsing = true;
                    splitsingX = x;
                    splitsingY = y;
                }
                else
                {
                    splitsing = false;
                }
                System.out.println("vakje hierlinks is mogelijke move");           
                linksKortsteRoute(x, y);
                x--;
            }
            else if(bovenMogelijk(x, y) == false && rechtsMogelijk(x, y) == false && onderMogelijk(x, y) == false && linksMogelijk(x, y) == false)
            {
                System.out.println("geen mogelijke moves");
            }
        }
        System.out.println("\n x = " + x + ", y = " + y + " --- helperX = " + Spel.doolhof.helper.x + ", helperY = " + Spel.doolhof.helper.y + "\n");
        
        if(x == Spel.doolhof.helper.x && y == Spel.doolhof.helper.y)
        {
            System.out.println("klaar");         
        }
        else
        {
            checkOnderdeelRoute(x, y, solverWaardeVriend);
        }
    }
    
    public static void bovenKortsteRoute(int x, int y)
    {
        Spel.doolhof.grid[(y - 1)][x].kortstePad = true;
    }
    
    public static void rechtsKortsteRoute(int x, int y)
    {
        Spel.doolhof.grid[y][(x + 1)].kortstePad = true;
    }
    public static void onderKortsteRoute(int x, int y)
    {
        Spel.doolhof.grid[(y + 1)][x].kortstePad = true;
    }
    public static void linksKortsteRoute(int x, int y)
    {
        Spel.doolhof.grid[y][(x - 1)].kortstePad = true;
    }
    
    public static boolean bovenMogelijk(int x, int y)
    {
        if(Spel.doolhof.grid[(y - 1)][x].solverWaarde == (Spel.doolhof.grid[y][x].solverWaarde - 1) && Spel.doolhof.grid[(y - 1)][x].alGeweest == false)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static boolean rechtsMogelijk(int x, int y)
    {
        if(Spel.doolhof.grid[y][(x + 1)].solverWaarde == (Spel.doolhof.grid[y][x].solverWaarde - 1) && Spel.doolhof.grid[y][(x + 1)].alGeweest == false)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static boolean onderMogelijk(int x, int y)
    {
        if(Spel.doolhof.grid[(y + 1)][x].solverWaarde == (Spel.doolhof.grid[y][x].solverWaarde - 1) && Spel.doolhof.grid[(y + 1)][x].alGeweest == false)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static boolean linksMogelijk(int x, int y)
    {
        if(Spel.doolhof.grid[y][(x - 1)].solverWaarde == (Spel.doolhof.grid[y][x].solverWaarde - 1) && Spel.doolhof.grid[y][(x - 1)].alGeweest == false)
        {
            return true;
        }
        else
        {
            return false;
        }
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
        return "7";
    }
    
    @Override
    public void teken(Graphics g)
    {
        g.setColor(Color.GREEN);
        g.fillRect(this.x*25, this.y*25, 22, 22);
    } 
    
   public static void showSolverWaarde()
   {
       for (int i = 0; i < 15; i++)
        {
            for (int j = 0; j < 15; j++)
            {
                System.out.print(Spel.doolhof.grid[i][j].solverWaarde + "\t");
            }
            System.out.println("");
        }
   }
   
   public static void showKortstePad()
   {
       for (int i = 0; i < 15; i++)
        {
            for (int j = 0; j < 15; j++)
            {
                System.out.print(Spel.doolhof.grid[i][j].kortstePad + "\t");
            }
            System.out.println("");
        }
   }
   
   public static void dubbeleShow()
   {
       showSolverWaarde();
       showKortstePad();
   }
}
