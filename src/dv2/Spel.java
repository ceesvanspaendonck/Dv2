package dv2;

import java.awt.*;
import java.io.FileNotFoundException;
import javax.swing.*;

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
    
    public static void startScherm()
    {
        frame = new JFrame();
        frame.setVisible(true);
        
        JPanel panel = new JPanel();
        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel welkom = new JLabel("Welkom bij BDE!", SwingConstants.CENTER);
        welkom.setPreferredSize(new Dimension(300, 100));
        welkom.setVisible(true);
        frame.getContentPane().add(welkom, BorderLayout.NORTH);
        frame.add(new JLabel(new ImageIcon("C:/Users/Sony/Pictures/sesamstraat/sesam.png")), BorderLayout.NORTH);
        frame.setSize(400,600);
        
        frame.repaint();
    }
    
    public static void start() throws FileNotFoundException
    {
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
