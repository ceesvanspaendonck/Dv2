package dv2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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
        
        final JPanel imagePanel = new JPanel();
        final JPanel panel = new JPanel();
        
        JLabel image = new JLabel(new ImageIcon("/Images/uitleg v2.png"));
        imagePanel.add(image, BorderLayout.NORTH);
        
        final JButton buttonHighScore = new JButton("Highscores");
        panel.add(buttonHighScore, BorderLayout.SOUTH);
        
        final JLabel text = new JLabel("Voer je naam in: ");
        panel.add(text, BorderLayout.SOUTH);

        final JTextField textField = new JTextField("", 12);
        panel.add(textField);

        JButton button = new JButton("Start!");
        panel.add(button, BorderLayout.SOUTH);

        frame.getContentPane().add(imagePanel, BorderLayout.NORTH);
        frame.getContentPane().add(panel, BorderLayout.SOUTH);
        frame.setVisible(true);

        frame.setSize(450,500);
        
        buttonHighScore.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                
                highScores();                
                         
            }
        }); 
        
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                naam = textField.getText();
                if(naam.matches("[a-zA-Z]+"))
                {
                    frame.dispose();
                    keuzeMenu();                                    
                }
                else
                {
                    textField.setText("Geen geldige naam!");
                    
                    frame.repaint();
                }
            }
        });     
    }
    
    
    
    public static void start(int level) throws FileNotFoundException
    {
        doolhof = new Doolhof(0, level);
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
        start(doolhof.level);
    }
    
    public static void keuzeMenu()
    {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(450, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        panel = new JPanel();
        
        final JButton button1 = new JButton("Level 1");
        panel.add(button1, BorderLayout.NORTH);
        
        final JButton button2 = new JButton("Level 2");
        panel.add(button2, BorderLayout.CENTER);
        
        final JButton button3 = new JButton("Level 3");
        panel.add(button3, BorderLayout.SOUTH);
        
        frame.add(panel);
        
        button1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                try {
                    start(1);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Spel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        button2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                try {
                    start(2);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Spel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        button3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                try {
                    start(3);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Spel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public static void highScores()
    {
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("BDE - Max & Cees");
        frame.setSize(450,500);
        
        final JPanel panel = new JPanel();
        
        
        Object columnNames[] = {"Naam", "Level", "Score"};
        Highscore highscore = Connectie.getHighScore();
        Highscore highscore2 = Connectie.getHighScore();
        Highscore highscore3 = Connectie.getHighScore();
        Highscore highscore4 = Connectie.getHighScore();
        Highscore highscore5 = Connectie.getHighScore();
        
        Object rowData[][] = {{ highscore.naam, highscore.level, highscore.score },
                              { highscore2.naam, highscore2.level, highscore2.score},
                              { highscore3.naam, highscore3.level, highscore3.score},
                              { highscore4.naam, highscore4.level, highscore4.score},
                              { highscore5.naam, highscore5.level, highscore5.score},
                              };
        
        JTable table = new JTable(rowData, columnNames);

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
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
