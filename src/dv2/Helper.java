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
        this.startRichting = "links";
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
        for (int i = 0; i < 3000; i++)
        {
            checkOnderdeelRoute(solverWaardeVriend);
        }
        dubbeleShow();
        
    }
    
    public static void checkOnderdeelRoute(int solverWaardeVriend)
    {
        for (int i = 1; i < 14; i++)
        {
            for (int j = 1; j < 14; j++)
            {
                if(looptDood == true)
                {
                    System.out.print("Vorige pad liep dood en er is een splitsing geweest, verander startrichting naar ");
                    if(startRichting.equals("boven"))
                    {
                        startRichting = "rechts";
                    }
                    else if(startRichting.equals("rechts"))
                    {
                        startRichting = "onder";
                    }
                    else if(startRichting.equals("onder"))
                    {
                        startRichting = "links";
                    }
                    else if(startRichting.equals("links"))
                    {
                        startRichting = "boven";
                    }
                    System.out.println(startRichting + " - alle tegels alGeweest op false (nieuwe route wordt gevormd vanaf laatste splitsing)");
                    i = splitsingX;
                    j = splitsingY;
                    looptDood = false;
                    for (int k = 0; k < 15; k++)
                    {
                        for (int l = 0; l < 15; l++)
                        {
                            Spel.doolhof.grid[k][l].alGeweest = false;
                        }
                    }                    
                } 
                
                if(i == Spel.doolhof.vriend.y && j == Spel.doolhof.vriend.x || Spel.doolhof.grid[i][j].kortstePad == true && looptDood == false) //begin bij solverwaarde vriend maar ook elk ander vakje dat 20 heeft 
                {
                    System.out.println("i(" + i + ") & j(" + j + ")  == coordinaten vriend of i,j.kortstePad is true (op pad)");
                    System.out.println("pad loopt tot nu toe niet dood - startRichting: " + startRichting);
                    if(startRichting.equals("boven"))
                    {
                        if(bovenMogelijk(i, j) == true) //als erboven gelijk is aan solverwaarde vriend - 1
                        {
                            System.out.print("pad hierboven is mogelijk - ");
                            if(onderMogelijk(i, j) == true || linksMogelijk(i, j) == true || rechtsMogelijk(i, j) == true)
                            {
                                System.out.print("maar andere richting is ook mogelijk, dus hier is splitsing - ");
                                splitsing = true;
                                splitsingX = i;
                                splitsingY = j;
                            }
                            looptDood = false;
                            System.out.println("pad hierboven wordt onderdeel van kortste route voor nu, looptdood = false");
                            Spel.doolhof.grid[(i - 1)][j].kortstePad = true; //dan wordt vakje erboven ook kortstePad
                            Spel.doolhof.grid[(i - 1)][j].alGeweest = true;
                        }

                        if(rechtsMogelijk(i, j) == true)
                        {
                            System.out.print("pad hierrechts is mogelijk - ");
                            if(onderMogelijk(i, j) == true || linksMogelijk(i, j) == true || bovenMogelijk(i, j) == true)
                            {
                                System.out.print("maar andere richting is ook mogelijk, dus hier is splitsing - ");
                                splitsing = true;
                                splitsingX = i;
                                splitsingY = j;
                            }
                            looptDood = false;
                            System.out.println("pad hierrechts wordt onderdeel van kortste route voor nu");
                            Spel.doolhof.grid[i][(j + 1)].kortstePad = true;
                            Spel.doolhof.grid[i][(j + 1)].alGeweest = true;
                        }

                        if(onderMogelijk(i, j) == true)
                        {
                            System.out.print("pad hieronder is mogelijk - ");
                            if(linksMogelijk(i, j) == true || bovenMogelijk(i, j) == true || rechtsMogelijk(i, j) == true)
                            {
                                System.out.print("maar andere richting is ook mogelijk, dus hier is splitsing - ");
                                splitsing = true;
                                splitsingX = i;
                                splitsingY = j;
                            }
                            looptDood = false;
                            System.out.println("pad hieronder wordt onderdeel van kortste route voor nu");
                            Spel.doolhof.grid[(i + 1)][j].kortstePad = true;
                            Spel.doolhof.grid[(i + 1)][j].alGeweest = true;
                        }

                        if(linksMogelijk(i, j) == true)
                        {
                            System.out.print("pad hierlinks is mogelijk - ");
                            if(bovenMogelijk(i, j) == true || rechtsMogelijk(i, j) == true || onderMogelijk(i, j) == true)
                            {
                                System.out.print("maar andere richting is ook mogelijk, dus hier is splitsing - ");
                                splitsing = true;
                                splitsingX = i;
                                splitsingY = j;
                            }
                            looptDood = false;
                            System.out.println("pad hierlinks wordt onderdeel van kortste route voor nu");
                            Spel.doolhof.grid[i][(j - 1)].kortstePad = true;
                            Spel.doolhof.grid[i][(j - 1)].alGeweest = true;
                        }                        
                        if(bovenMogelijk(i, j) == false && rechtsMogelijk(i, j) == false && onderMogelijk(i, j) == false && linksMogelijk(i, j) == false)
                        {
                            System.out.println("geen mogelijkheden. looptDood wordt true");
                            looptDood = true;
                        }
                    }
                    else if(startRichting.equals("rechts"))
                    {
                        if(rechtsMogelijk(i, j) == true)
                        {
                            System.out.print("pad hierrechts is mogelijk - ");
                            if(onderMogelijk(i, j) == true || linksMogelijk(i, j) == true || bovenMogelijk(i, j) == true)
                            {
                                System.out.print("maar andere richting is ook mogelijk, dus hier is splitsing - ");
                                splitsing = true;
                                splitsingX = i;
                                splitsingY = j;
                            }
                            looptDood = false;
                            System.out.println("pad hierrechts wordt onderdeel van kortste route voor nu");
                            Spel.doolhof.grid[i][(j + 1)].kortstePad = true;
                            Spel.doolhof.grid[i][(j + 1)].alGeweest = true;
                        }

                        if(onderMogelijk(i, j) == true)
                        {
                            System.out.print("pad hieronder is mogelijk - ");
                            if(linksMogelijk(i, j) == true || bovenMogelijk(i, j) == true || rechtsMogelijk(i, j) == true)
                            {
                                System.out.print("maar andere richting is ook mogelijk, dus hier is splitsing - ");
                                splitsing = true;
                                splitsingX = i;
                                splitsingY = j;
                            }
                            looptDood = false;
                            System.out.println("pad hieronder wordt onderdeel van kortste route voor nu");
                            Spel.doolhof.grid[(i + 1)][j].kortstePad = true;
                            Spel.doolhof.grid[(i + 1)][j].alGeweest = true;
                        }

                        if(linksMogelijk(i, j) == true)
                        {
                            System.out.print("pad hierlinks is mogelijk - ");
                            if(bovenMogelijk(i, j) == true || rechtsMogelijk(i, j) == true || onderMogelijk(i, j) == true)
                            {
                                System.out.print("maar andere richting is ook mogelijk, dus hier is splitsing - ");
                                splitsing = true;
                                splitsingX = i;
                                splitsingY = j;
                            }
                            looptDood = false;
                            System.out.println("pad hierlinks wordt onderdeel van kortste route voor nu");
                            Spel.doolhof.grid[i][(j - 1)].kortstePad = true;
                            Spel.doolhof.grid[i][(j - 1)].alGeweest = true;
                        } 
                        if(bovenMogelijk(i, j) == true) //als erboven gelijk is aan solverwaarde vriend - 1
                        {
                            System.out.print("pad hierboven is mogelijk - ");
                            if(onderMogelijk(i, j) == true || linksMogelijk(i, j) == true || rechtsMogelijk(i, j) == true)
                            {
                                System.out.print("maar andere richting is ook mogelijk, dus hier is splitsing - ");
                                splitsing = true;
                                splitsingX = i;
                                splitsingY = j;
                            }
                            looptDood = false;
                            System.out.println("pad hierboven wordt onderdeel van kortste route voor nu");
                            Spel.doolhof.grid[(i - 1)][j].kortstePad = true; //dan wordt vakje erboven ook kortstePad
                            Spel.doolhof.grid[(i - 1)][j].alGeweest = true;
                        }
                        if(bovenMogelijk(i, j) == false && rechtsMogelijk(i, j) == false && onderMogelijk(i, j) == false && linksMogelijk(i, j) == false)
                        {
                            System.out.println("geen mogelijkheden. looptDood wordt true");
                            looptDood = true;
                        }
                    }
                    else if(startRichting.equals("onder"))
                    {
                        if(onderMogelijk(i, j) == true)
                        {
                            System.out.print("pad hieronder is mogelijk - ");
                            if(linksMogelijk(i, j) == true || bovenMogelijk(i, j) == true || rechtsMogelijk(i, j) == true)
                            {
                                System.out.print("maar andere richting is ook mogelijk, dus hier is splitsing - ");
                                splitsing = true;
                                splitsingX = i;
                                splitsingY = j;
                            }
                            looptDood = false;
                            System.out.println("pad hieronder wordt onderdeel van kortste route voor nu");
                            Spel.doolhof.grid[(i + 1)][j].kortstePad = true;
                            Spel.doolhof.grid[(i + 1)][j].alGeweest = true;
                        }

                        if(linksMogelijk(i, j) == true)
                        {
                            System.out.print("pad hierlinks is mogelijk - ");
                            if(bovenMogelijk(i, j) == true || rechtsMogelijk(i, j) == true || onderMogelijk(i, j) == true)
                            {
                                System.out.print("maar andere richting is ook mogelijk, dus hier is splitsing - ");
                                splitsing = true;
                                splitsingX = i;
                                splitsingY = j;
                            }
                            looptDood = false;
                            System.out.println("pad hierlinks wordt onderdeel van kortste route voor nu");
                            Spel.doolhof.grid[i][(j - 1)].kortstePad = true;
                            Spel.doolhof.grid[i][(j - 1)].alGeweest = true;
                        } 

                        if(bovenMogelijk(i, j) == true) //als erboven gelijk is aan solverwaarde vriend - 1
                        {
                            System.out.print("pad hierboven is mogelijk - ");
                            if(onderMogelijk(i, j) == true || linksMogelijk(i, j) == true || rechtsMogelijk(i, j) == true)
                            {
                                System.out.print("maar andere richting is ook mogelijk, dus hier is splitsing - ");
                                splitsing = true;
                                splitsingX = i;
                                splitsingY = j;
                            }
                            looptDood = false;
                            System.out.println("pad hierboven wordt onderdeel van kortste route voor nu");
                            Spel.doolhof.grid[(i - 1)][j].kortstePad = true; //dan wordt vakje erboven ook kortstePad
                            Spel.doolhof.grid[(i - 1)][j].alGeweest = true;
                        }
                        if(rechtsMogelijk(i, j) == true)
                        {
                            System.out.print("pad hierrechts is mogelijk - ");
                            if(onderMogelijk(i, j) == true || linksMogelijk(i, j) == true || bovenMogelijk(i, j) == true)
                            {
                                System.out.print("maar andere richting is ook mogelijk, dus hier is splitsing - ");
                                splitsing = true;
                                splitsingX = i;
                                splitsingY = j;
                            }
                            looptDood = false;
                            System.out.println("pad hierrechts wordt onderdeel van kortste route voor nu");
                            Spel.doolhof.grid[i][(j + 1)].kortstePad = true;
                            Spel.doolhof.grid[i][(j + 1)].alGeweest = true;
                        }
                        if(bovenMogelijk(i, j) == false && rechtsMogelijk(i, j) == false && onderMogelijk(i, j) == false && linksMogelijk(i, j) == false)
                        {
                            System.out.println("geen mogelijkheden. looptDood wordt true");
                            looptDood = true;
                        }
                    }
                    else if(startRichting.equals("links"))
                    {
                        if(linksMogelijk(i, j) == true)
                        {
                            System.out.print("pad hierlinks is mogelijk - ");
                            if(bovenMogelijk(i, j) == true || rechtsMogelijk(i, j) == true || onderMogelijk(i, j) == true)
                            {
                                System.out.print("maar andere richting is ook mogelijk, dus hier is splitsing - ");
                                splitsing = true;
                                splitsingX = i;
                                splitsingY = j;
                            }
                            looptDood = false;
                            System.out.println("pad hierlinks wordt onderdeel van kortste route voor nu");
                            Spel.doolhof.grid[i][(j - 1)].kortstePad = true;
                            Spel.doolhof.grid[i][(j - 1)].alGeweest = true;
                        } 
                        if(bovenMogelijk(i, j) == true) //als erboven gelijk is aan solverwaarde vriend - 1
                        {
                            System.out.print("pad hierboven is mogelijk - ");
                            if(onderMogelijk(i, j) == true || linksMogelijk(i, j) == true || rechtsMogelijk(i, j) == true)
                            {
                                System.out.print("maar andere richting is ook mogelijk, dus hier is splitsing - ");
                                splitsing = true;
                                splitsingX = i;
                                splitsingY = j;
                            }
                            looptDood = false;
                            System.out.println("pad hierboven wordt onderdeel van kortste route voor nu");
                            Spel.doolhof.grid[(i - 1)][j].kortstePad = true; //dan wordt vakje erboven ook kortstePad
                            Spel.doolhof.grid[(i - 1)][j].alGeweest = true;
                        }
                        if(rechtsMogelijk(i, j) == true)
                        {
                            System.out.print("pad hierrechts is mogelijk - ");
                            if(onderMogelijk(i, j) == true || linksMogelijk(i, j) == true || bovenMogelijk(i, j) == true)
                            {
                                System.out.print("maar andere richting is ook mogelijk, dus hier is splitsing - ");
                                splitsing = true;
                                splitsingX = i;
                                splitsingY = j;
                            }
                            looptDood = false;
                            System.out.println("pad hierrechts wordt onderdeel van kortste route voor nu");
                            Spel.doolhof.grid[i][(j + 1)].kortstePad = true;
                            Spel.doolhof.grid[i][(j + 1)].alGeweest = true;
                        }
                        if(onderMogelijk(i, j) == true)
                        {
                            System.out.print("pad hieronder is mogelijk - ");
                            if(linksMogelijk(i, j) == true || bovenMogelijk(i, j) == true || rechtsMogelijk(i, j) == true)
                            {
                                System.out.print("maar andere richting is ook mogelijk, dus hier is splitsing - ");
                                splitsing = true;
                                splitsingX = i;
                                splitsingY = j;
                            }
                            looptDood = false;
                            System.out.println("pad hieronder wordt onderdeel van kortste route voor nu");
                            Spel.doolhof.grid[(i + 1)][j].kortstePad = true;
                            Spel.doolhof.grid[(i + 1)][j].alGeweest = true;
                        }
                        if(bovenMogelijk(i, j) == false && rechtsMogelijk(i, j) == false && onderMogelijk(i, j) == false && linksMogelijk(i, j) == false)
                        {
                            System.out.println("geen mogelijkheden. looptDood wordt true");
                            looptDood = true;
                        }
                    }
                }
            }
        }
    }
    
    public static boolean bovenMogelijk(int i, int j)
    {
        if(Spel.doolhof.grid[(i - 1)][j].solverWaarde == (Spel.doolhof.grid[i][j].solverWaarde - 1) && Spel.doolhof.grid[(i - 1)][j].alGeweest == false) //als erboven gelijk is aan solverwaarde vriend - 1
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static boolean rechtsMogelijk(int i, int j)
    {
        if(Spel.doolhof.grid[i][(j + 1)].solverWaarde == (Spel.doolhof.grid[i][j].solverWaarde - 1) && Spel.doolhof.grid[i][(j + 1)].alGeweest == false) //als erboven gelijk is aan solverwaarde vriend - 1
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static boolean onderMogelijk(int i, int j)
    {
        if(Spel.doolhof.grid[(i + 1)][j].solverWaarde == (Spel.doolhof.grid[i][j].solverWaarde - 1) && Spel.doolhof.grid[(i + 1)][j].alGeweest == false) //als erboven gelijk is aan solverwaarde vriend - 1
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static boolean linksMogelijk(int i, int j)
    {
        if(Spel.doolhof.grid[i][(j - 1)].solverWaarde == (Spel.doolhof.grid[i][j].solverWaarde - 1) && Spel.doolhof.grid[i][(j - 1)].alGeweest == false) //als erboven gelijk is aan solverwaarde vriend - 1
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
