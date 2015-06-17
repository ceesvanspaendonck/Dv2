package dv2;

import java.awt.Graphics;
import javax.swing.JPanel;

public class Drawing extends JPanel
{
    @Override
    public void paintComponent(Graphics g)
    {
        for (int i = 0; i < 15; i++)
        {
            for (int j = 0; j < 15; j++)
            {
                Spel.doolhof.grid[i][j].teken(g);
                Doolhof.speler.teken(g);
                repaint();
            }
        }
    }
}
