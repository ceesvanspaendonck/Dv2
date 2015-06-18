package dv2;

import java.sql.*;

public class Connectie
{
    private static boolean geslaagd = false;
    private static Connection databaseConnectie;
    public static Connection getConnection()
    {
        if(databaseConnectie == null)
        {
            try
            {          
                String connectString = "jdbc:mysql://meru.hhs.nl:3306/14111071";
                databaseConnectie = DriverManager.getConnection(connectString, "14111071", "Thahkiethi");
            }
            catch (SQLException ex)
            {
                System.out.println("SQL error. Check je internetverbinding.");
            }
        }
        return databaseConnectie;
    }   
    
    public static ResultSet fetchQuery(String query) throws SQLException
    {
        Connection connectie = getConnection();
        Statement statement = connectie.createStatement();
        statement.execute(query);
        ResultSet resultSet = statement.getResultSet();
        return resultSet;
    }
    
    public static void getHighScores()
    {
        Connectie connection = new Connectie();
        int id;
        int score;
        String naam;
        
        try
        {        
            String query = "SELECT * FROM Highscore ORDER BY score DESC;";
            ResultSet statement = connection.fetchQuery(query);
            
            while(statement.next())
            {
                id = statement.getInt("id");
                score = statement.getInt("score");
                naam = statement.getString("naam");
                //in een scherm?
            }
        }
        catch (SQLException ex)
        {
            System.out.println("SQL error. Check je internetverbinding.");
        }
    }
    
    public static void HighScoreOpslaan(String naam , int score, int level) throws SQLException
    {
        Connection connectie = null;
        connectie = Connectie.getConnection();
        Connectie connection = new Connectie();
        
        String organiseerquery = "INSERT INTO Highscore (naam, score,level) VALUES (?, ?, ?)";
        System.out.println("1");
        PreparedStatement statement = connectie.prepareStatement(organiseerquery);
        System.out.println("2");
        statement.setString(1,naam);
        statement.setInt(2, score);
        System.out.println("3");
        statement.setInt(3, level);
        int rows = statement.executeUpdate();
        if(rows != 1)
        {
            System.out.println("Kan score niet toevoegen. Check je internet verbinding.");
            geslaagd = false;
        }
        else
        {
            System.out.println("Score toegevoegd");
            geslaagd = true;
        }
    }
}
