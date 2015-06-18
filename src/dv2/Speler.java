package dv2;

import java.awt.Color;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Speler
{
    public int x, y;
    private String lastDirection;
    public String naam;
    public int ammo;
    private GameObject objectNorth, objectEast, objectSouth, objectWest, objectCurrent;
    
    public Speler(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.lastDirection = null;
        this.ammo = 0;
    }
    
    public void teken(Graphics g)
    {
        g.setColor(Color.YELLOW);
        g.fillRect(this.x*25, this.y*25, 22, 22);
    } 
    
    public void move(String richting) throws FileNotFoundException, SQLException
    {
        if(richting.equals("up"))
        {
            this.lastDirection = "north";
            
            objectNorth = Spel.getDoolhof().grid[(this.y - 1)][this.x];
            
            if(!(objectNorth instanceof Binnenmuur) && !(objectNorth instanceof Buitenmuur))
            {
                this.y--;
                objectCurrent = Spel.getDoolhof().grid[this.y][this.x];
                checkCurrent(objectCurrent);
                updateStappen();
            }
        }
        else if(richting.equals("right"))
        {
            this.lastDirection = "east";
            
            objectEast = Spel.getDoolhof().grid[this.y][(this.x + 1)];
            
            if(!(objectEast instanceof Binnenmuur) && !(objectEast instanceof Buitenmuur))
            {
               this.x++;
               objectCurrent = Spel.getDoolhof().grid[this.y][this.x];
               checkCurrent(objectCurrent);
               updateStappen();
            }
        }
        else if(richting.equals("down"))
        {
            this.lastDirection = "south";
            
            objectSouth = Spel.getDoolhof().grid[(this.y + 1)][this.x];
            
            if(!(objectSouth instanceof Binnenmuur) && !(objectSouth instanceof Buitenmuur))
            {
                this.y++;
                objectCurrent = Spel.getDoolhof().grid[this.y][this.x];
                checkCurrent(objectCurrent);
                updateStappen();
            }
        }
        else if(richting.equals("left"))
        {
            this.lastDirection = "west";
            objectWest = Spel.getDoolhof().grid[this.y][(this.x - 1)];
            
            if(!(objectWest instanceof Binnenmuur) && !(objectWest instanceof Buitenmuur))
            {     
                this.x--;
                objectCurrent = Spel.getDoolhof().grid[this.y][this.x];
                checkCurrent(objectCurrent);  
                updateStappen();
            }
        }
    }
    
    public void updateStappen()
    {
        Doolhof.setStappen(Doolhof.getStappen() + 1);
        Spel.stappen.setText("Aantal stappen: " + Spel.doolhof.stappen);
    }
    
    public void checkCurrent(GameObject objectCurrent) throws FileNotFoundException, SQLException
    {
       if(objectCurrent instanceof Vijand)
        {
            Spel.doolhof.vijand.verwijderObject();
            Doolhof.setStappen(Doolhof.getStappen() + 10);
        }
        if(objectCurrent instanceof Helper) //helper
        {
            Spel.doolhof.helper.solve();
        }
        if(objectCurrent instanceof Vriend)
        {
            Spel.doolhof.vriend.volgendLevel();
        }
        if(objectCurrent instanceof Cheater)
        {
            Spel.doolhof.cheater.verwijderObject();
            Spel.doolhof.cheater.verlaagStappen();
        }
    }
    
    public void pakBazooka()
    {
        if(Spel.doolhof.grid[Spel.doolhof.speler.y][Spel.doolhof.speler.x] instanceof Bazooka)
        {
            Spel.doolhof.bazooka.verwijderObject();
            Spel.doolhof.speler.ammo++;
        }
    }
    
    public void schiet()
    {
        if(ammo > 0)
        {
            if(lastDirection.equals("north"))
            {
                for (int i = y; i >= 0; i--)
                {
                    if(Spel.doolhof.grid[i][x] instanceof Binnenmuur)
                    {
                        Binnenmuur.vernietigMuur(i, x);
                        break;                     
                    }
                }
            }
            if(lastDirection.equals("east"))
            {
                for (int i = x; i < 15; i++)
                {
                    if(Spel.doolhof.grid[y][i] instanceof Binnenmuur)
                    {
                        Binnenmuur.vernietigMuur(y, i);
                        break;                     
                    }
                }
            }
            if(lastDirection.equals("south"))
            {
                for (int i = y; i < 15; i++)
                {
                    if(Spel.doolhof.grid[i][x] instanceof Binnenmuur)
                    {
                        Binnenmuur.vernietigMuur(i, x); 
                        break;
                    }
                }
            }
            if(lastDirection.equals("west"))
            {
                for (int i = x; i >= 0; i--)
                {
                    if(Spel.doolhof.grid[y][i] instanceof Binnenmuur)
                    {
                        Binnenmuur.vernietigMuur(y, i);
                        break;                     
                    }
                }
            }
        }
    }
    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public  int getY()
    {
        return y;
    }

    public  void setY(int y)
    {
        this.y = y;
    }
}