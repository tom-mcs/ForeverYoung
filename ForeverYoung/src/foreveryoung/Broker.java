package foreveryoung;

import java.sql.Connection;
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
/**
 *
 * @author Matt
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
/**
 * Dropping the table will prevent data from being saved into the derby database
 * @author Ryan
 */       
/*
        try{
            statement.execute("DROP TABLE users");
            System.out.println("table dropped");
        }
        catch(SQLException sqlExcept){
            System.out.println("error dropping user table");
        } 
*/
        
        try{
            statement.execute("CREATE TABLE users (username VARCHAR(15) PRIMARY KEY NOT NULL, password VARCHAR(15) NOT NULL, firstName VARCHAR(15), lastName VARCHAR(15), parent VARCHAR(15))");
            System.out.println("user table created");
        }
        catch(SQLException sqlExcept2){
            System.out.println("error creating user table");
        }
     }

/**
 * The program again makes use of the SQL imports, in order to close the connection
 * to the database. The method makes use of the stated booleans above to detect when
 * to terminate the connection.
 * @author Ryan
 */  
     
    //closes all connections to the database
    public void shutdown()
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
 * @return 
 * 
 * The addUser method uses statements to add a newly created user to the database.
 * When using the derby DB database, statements are required to perform any SQL 
 * executions.
 * @author Ryan
 */
    
    //adds practitioner with username, password, first name, and last name as argument
     public boolean addUser(User user){
        if(user.getUserName().isEmpty() || user.getPassword().isEmpty() || user.getFirstName().isEmpty() || user.getLastName().isEmpty()){
            return false;
        }
        else{
            try{
                statement = connection.createStatement();
                if(user.isPractitioner()){
                    statement.execute("INSERT INTO users VALUES ('" + user.getUserName() + "', '" + user.getPassword() + "', '" + user.getFirstName() + "', '" + user.getLastName() + "', NULL)");
                }else{
                    statement.execute("INSERT INTO users VALUES ('" + user.getUserName() + "', '" + user.getPassword() + "', '" + user.getFirstName() + "', '" + user.getLastName() + "', '" + user.getParent() + "')");
                }
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
 * Similar to the addUser method, this method also uses a statement to retrieve
 * both the username and password from the database. The method also utilizes get
 * methods to retrieve the appropriate information.
 * @author Ryan
 */
     
     //looks up username in db and returns their info as a user object
     //returns null if the user isn't found
     public User getUser(String username){  
        try{
            ResultSet rs = statement.executeQuery("SELECT * FROM users WHERE username='" + username + "'");
            
            if(rs.next()){
                User user = new User(rs.getString("username"),rs.getString("password"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("parent"));
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
 * The getAllUsers method used an ArrayList to store all of the pulled from the datbase 
 * into a list, which then can be displayed to the user.
 * @author Ryan
 */         
     
    public ArrayList<User> getClients(User practitioner){
        try{
            ResultSet rs = statement.executeQuery("SELECT * FROM users WHERE parent='" + practitioner.getUserName() + "'");
            ArrayList<User> Users = new ArrayList<>();
            
            while(rs.next()){
                Users.add(new User(rs.getString("username"),rs.getString("password"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("parent")));
            }
            return Users;
        }
        catch(SQLException ex){
           return null; 
        }        
    }
}
