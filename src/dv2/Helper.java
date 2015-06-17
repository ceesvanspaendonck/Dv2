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
        System.out.println(solverWaardeVriend + "<- solverwaardevriend");
        for (int i = 0; i < solverWaardeVriend; i++)
        {
            checkOnderdeelRoute(solverWaardeVriend);
            solverWaardeVriend--;
        }
        System.out.println(solverWaardeVriend + "<- na checkonderdeelroute");
        dubbeleShow();
        
    }
    
    public static void checkOnderdeelRoute(int solverWaardeVriend)
    {
        for (int i = 1; i < 14; i++)
        {
            for (int j = 1; j < 14; j++)
            {
                if(Spel.doolhof.grid[i][j].kortstePad == true)
                {
                    if(Spel.doolhof.grid[(i - 1)][j].solverWaarde == (Spel.doolhof.grid[i][j].solverWaarde - 1))
                    {
                        Spel.doolhof.grid[(i - 1)][j].kortstePad = true;
                        Spel.doolhof.grid[(i - 1)][j].solverWaarde = Spel.doolhof.grid[i][j].solverWaarde + 1;
                        
                    }
                    else
                    {
                        verandering = false;
                    }
                    if(Spel.doolhof.grid[(i + 1)][j].solverWaarde == (Spel.doolhof.grid[i][j].solverWaarde - 1))
                    {
                        Spel.doolhof.grid[(i + 1)][j].kortstePad = true;
                        Spel.doolhof.grid[(i + 1)][j].solverWaarde = Spel.doolhof.grid[i][j].solverWaarde + 1;
                        
                    }
                    else
                    {
                        verandering = false;
                    }
                    if(Spel.doolhof.grid[i][(j - 1)].solverWaarde == (Spel.doolhof.grid[i][j].solverWaarde - 1))
                    {
                        Spel.doolhof.grid[i][(j - 1)].kortstePad = true;
                        Spel.doolhof.grid[i][(j - 1)].solverWaarde = Spel.doolhof.grid[i][j].solverWaarde + 1;
                    }
                    else
                    {
                        verandering = false;
                    }
                    if(Spel.doolhof.grid[i][(j + 1)].solverWaarde == (Spel.doolhof.grid[i][j].solverWaarde - 1))
                    {
                        Spel.doolhof.grid[i][(j + 1)].kortstePad = true;
                        Spel.doolhof.grid[i][(j + 1)].solverWaarde = Spel.doolhof.grid[i][j].solverWaarde + 1;
                    }
                    else
                    {
                        verandering = false;
                    }
                }
                //dubbeleShow();
            }
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
