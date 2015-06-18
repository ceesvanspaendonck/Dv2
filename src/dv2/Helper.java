package dv2;

import java.awt.Color;
import java.awt.Graphics;
import java.io.FileNotFoundException;

public class Helper extends GameObject
{
    private static boolean verandering;
    public Helper(int x, int y)
    {
        this.x = x;
        this.y = y;
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
            if(bovenMogelijk(x, y) == true)
            {
                bovenKortsteRoute(x, y);
                y--;
            }
            else if(rechtsMogelijk(x, y) == true)
            {
                rechtsKortsteRoute(x, y);
                x++;
            }
            else if(onderMogelijk(x, y) == true)
            {
                onderKortsteRoute(x, y);
                y++;
            }
            else if(linksMogelijk(x, y) == true)
            {          
                linksKortsteRoute(x, y);
                x--;
            }
        }
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
