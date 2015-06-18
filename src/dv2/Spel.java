package dv2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Spel extends JPanel
{
    public static JFrame frame;
    public static JPanel panel;
    public static JLabel stappen;
    public static JButton restartButton;
    public static Doolhof doolhof;
    public static PressListener listener;
    public static String naam;
    
    public static void main(String[] args) throws FileNotFoundException
    { 
        startScherm();
    }
    
    public static void startScherm()
    {
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("BDE - Max & Cees");
        //frame.setSize(450,500);

        final JPanel imagePanel = new JPanel();
        final JPanel panel = new JPanel();
        
        JLabel image = new JLabel(new ImageIcon("C:/Users/Sony/Desktop/uitleg v2.png"));
        imagePanel.add(image, BorderLayout.NORTH);
        
        final JLabel text = new JLabel("Voer je naam in: ");
        panel.add(text, BorderLayout.SOUTH);

        final JTextField textField = new JTextField("", 15);
        panel.add(textField);

        JButton button = new JButton("Start!");
        panel.add(button, BorderLayout.SOUTH);

        frame.getContentPane().add(imagePanel, BorderLayout.NORTH);
        frame.getContentPane().add(panel, BorderLayout.SOUTH);
        frame.setVisible(true);

        frame.setSize(450,500);
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                naam = textField.getText();
                if(naam.matches("[a-zA-Z]+"))
                {
                    frame.dispose();
                    try
                    {
                        start();                  
                    }
                    catch (FileNotFoundException ex)
                    {
                        Logger.getLogger(Spel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else
                {
                    textField.setText("Voer een geldige naam in!");
                    
                    frame.repaint();
                }
            }
        });     
    }
    
    
    
    public static void start() throws FileNotFoundException
    {
        doolhof = new Doolhof(0);       
        doolhof.vormGrid();
        doolhof.speler.naam = naam;
        doolhof.stappen = 0;
        
        frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        stappen = new JLabel("Aantal stappen: " + Doolhof.getStappen(), SwingConstants.CENTER);
        stappen.setPreferredSize(new Dimension(300, 100));
        stappen.setVisible(true);    
        
        listener = new PressListener();
        frame.addKeyListener(listener);
        
        frame.getContentPane().add(stappen, BorderLayout.SOUTH);
        
        Drawing drawing = new Drawing();
        frame.add(drawing);
        frame.setSize(390,550);     
        frame.repaint();   
    }
    
    public static void restart() throws FileNotFoundException
    {
        frame.dispose();      
        start();
    }
    
    public static void highScores()
    {
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("BDE - Max & Cees");
        frame.setSize(450,500);
        
        final JPanel panel = new JPanel();
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
