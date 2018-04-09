package foreveryoung;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Broker {
 
/**
 * The program uses specialized strings to set up the connection to the derby database
 * The driver string tells the program which driver to use to allow the database to work
 * The protocol string specifies how to connect to the database
 * @author Ryan
 */     
    
    final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    final String protocol = "jdbc:derby:";
    final String dbName = "derbyDB";
    static Connection connection = null;
    static Statement statement = null;

/**
 * @throws SQLException 
 * The program makes use of Java SQL imports to try to establish a connection to the database.
 * If the program detects it cannot make a connection, it will throw an exception. If a 
 * successful connection has been made, the program will then attempt to create a table
 * to store and retrieve information.
 * @author Ryan
 */
    
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
        
        try{
            statement.execute("SELECT * FROM users");
        }
        catch(SQLException sqlExcept){
            try{
                statement.execute("CREATE TABLE users (username VARCHAR(15) PRIMARY KEY NOT NULL, password VARCHAR(15) NOT NULL)");
            }
            catch(SQLException sqlExcept2){
                System.out.println("error creating user table");
            }
        } 
     }

/**
 * The program again makes use of the SQL imports, in order to close the connection
 * to the database. The method makes use of the stated booleans above to detect when
 * to terminate the connection.
 * @author Ryan
 */  
     
    //closes all connections to the database
    public static void shutdown()
    {
        try
        {
            if (statement != null)
            {
                statement.close();
                System.out.println("statement closed");
            }
            if (connection != null)
            {
                connection.close();
                System.out.println("connection closed");
            }           
        }
        catch (SQLException sqlExcept)
        {
            System.out.print(sqlExcept);
        }
    }

/**
 * 
 * @param username
 * @param password
 * @return 
 * 
 * The addUser method uses statements to add a newly created user to the database.
 * When using the derby DB database, statements are required to perform any SQL 
 * executions.
 * @author Ryan
 */
    
    //adds user with username and password as argument
     public static boolean addUser(String username, String password){
        if(username.isEmpty() || password.isEmpty()){
            return false;
        }
        else{
            try{
                statement = connection.createStatement();
                statement.execute("INSERT INTO users VALUES ('" + username + "', '" + password + "')");
                return true;
            }
            catch (SQLException ex) {
                return false;
            }
        }
     }

/**
 * 
 * @param username
 * @return
 * Similar to the addUSer method, this method also uses a statement to retrieve
 * both the username and password from the database. The method also utilizes get
 * methods to retrieve the appropriate information.
 * @author Ryan
 */
     
     //looks up username in db and returns their info as a user object
     //returns null if the user isn't found
     public static User getUser(String username){  
        try{
            ResultSet rs = statement.executeQuery("SELECT * FROM users WHERE username='" + username + "'");
            
            if(rs.next()){
                User user = new User(rs.getString("username"),rs.getString("password"));
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
 
/**
 * 
 * @return
 * The getAllUsers method used an ArrayList to store all of the pulled into a list,
 * which then can be displayed to the user.
 * @author Ryan
 */         
     
    public static ArrayList<User> getAllUsers(){
        try{
            ResultSet rs = statement.executeQuery("SELECT * FROM users");
            ArrayList<User> Users = new ArrayList<>();
            
            while(rs.next()){
                Users.add(new User(rs.getString("username"),rs.getString("password")));
            }
            return Users;
        }
        catch(SQLException ex){
           return null; 
        }        
    }
}
