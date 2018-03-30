package foreveryoung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryan_Lancer
 */
public class Broker {
    
    final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    final String protocol = "jdbc:derby:";
    final String dbName = "derbyDB";
    static Connection connection = null;
    static Statement statement = null;
    
    //constructer connects to db and creates username table
    //if a username table already exists it will drop the table and create a new one
     public Broker() throws SQLException{
   
        try{
            Class.forName(driver).newInstance();
        }
        catch(Exception E){
            E.printStackTrace();
        }
        try {
             connection = DriverManager.getConnection(
                     protocol + dbName + ";create=true");
        } 
        catch (SQLException ex) {
             Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("=====    Started/Connected DB    =====");
        
        statement = connection.createStatement();
        
        statement.execute("DROP table users");
        statement.execute("CREATE TABLE users (username VARCHAR(15) PRIMARY KEY, password VARCHAR(15))");
        
        //adds users to db as example data
        addUser("Matt", "password");
        addUser("Ryan", "123");
        addUser("Tom", "bum");
     }
     
    //closes all connections to the database
    private static void shutdown()
    {
        try
        {
            if (statement != null)
            {
                statement.close();
            }
            if (connection != null)
            {
                connection.close();
            }           
        }
        catch (SQLException sqlExcept)
        {
            
        }
    }
    
    //adds user with username and password as argument
     public static boolean addUser(String username, String password){  
        try{
            statement = connection.createStatement();
            statement.execute("INSERT INTO users VALUES ('" + username + "', '" + password + "')");
            return true;
        }
        catch (SQLException ex) {
            return false;
        }
     }
     
     //looks up username in db and returns their info as a user object
     //returns null if the user isn't found
     public static User getUser(String username){  
        try{
            ResultSet rs = statement.executeQuery("SELECT * FROM users WHERE username='" + username + "'");
            User user = new User();

            if(rs.next()){
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));

                return user;
            }
            else{
                return null;
            }
        }
        catch(SQLException ex){
            return null;
        }
    }    
}
