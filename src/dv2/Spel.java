package dv2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Spel extends JPanel
{
    public static JFrame frame;
    public static JPanel panel;
    public static JLabel stappen;
    public static Doolhof doolhof;
    public static PressListener listener;
    
    public static void main(String[] args) throws FileNotFoundException
    { 
        start();
    }
    
    public static void start() throws FileNotFoundException
    {
        System.out.println("Start spel");
        doolhof = new Doolhof(0);       
        doolhof.vormGrid(); 
        
        frame = new JFrame();
        frame.setVisible(true);
        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
        stappen = new JLabel("Aantal stappen: " + Doolhof.getStappen(),SwingConstants.CENTER);
        stappen.setPreferredSize(new Dimension(300, 100));
        stappen.setVisible(true);
        
        listener = new PressListener();
        frame.addKeyListener(listener);
        frame.getContentPane().add(stappen, BorderLayout.SOUTH);
        Drawing drawing = new Drawing();
        frame.add(drawing);
        frame.setSize(400,600);
        
        frame.repaint();
    }
    
    public static void restart()
    {
        System.out.println("restart");
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        
    }

    public static Doolhof getDoolhof()
    {
        return doolhof;
    }
    
    
    
}
