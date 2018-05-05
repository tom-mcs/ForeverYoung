package foreveryoung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
            statement.execute("CREATE TABLE users (username VARCHAR(15) PRIMARY KEY NOT NULL, "
                    + "password VARCHAR(15) NOT NULL, firstName VARCHAR(15), lastName VARCHAR(15), practitioner VARCHAR(15))");
            System.out.println("user table created");
        }
        catch(SQLException sqlExcept2){
            System.out.println("error creating user table");
        }
        
        
        try{
            statement.execute("CREATE TABLE goals (goal VARCHAR(15) PRIMARY KEY NOT NULL)");
            System.out.println("goals table created");
        }
        catch(SQLException sqlExcept2){
            System.out.println("error creating goals table");
        }
          
        try{
            statement.execute("CREATE TABLE pedometer (dates VARCHAR(15) PRIMARY KEY NOT NULL, steps INT NOT NULL)");
            System.out.println("pedometer table created");
        }
        catch(SQLException sqlExcept2){
            System.out.println("error creating pedometer table");
        }
        
        try{
            statement.execute("DROP TABLE goals");
            System.out.println("goals table dropped");
        }
        catch(SQLException sqlExcept){
            System.out.println("error dropping goals table");
        } 
        
        try{
            statement.execute("DROP TABLE pedometer");
            System.out.println("pedometer table dropped");
        }
        catch(SQLException sqlExcept){
            System.out.println("error dropping pedometer table");
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
    public boolean addPractitioner(Practitioner user){
       if(user.getUsername().isEmpty() || user.getPassword().isEmpty() || user.getFirstName().isEmpty()|| user.getLastName().isEmpty()){
           return false;
       }
       else{
           try{
               statement.execute("INSERT INTO users VALUES ('" + user.getUsername() + "', '" + user.getPassword() + "', '" + user.getFirstName() + "', '" + user.getLastName() + "', NULL)");
               return true;
           }
           catch (SQLException ex) {
               return false;
           }
       }
    }
     
    //adds client with username, password, first name, last name and practitioner name as argument
    public boolean addClient(Client user){
       if(user.getUsername().isEmpty() || user.getPassword().isEmpty() || user.getFirstName().isEmpty()|| user.getLastName().isEmpty()){
           return false;
       }
       else{
           try{
               statement = connection.createStatement();
               statement.execute("INSERT INTO users VALUES ('" + user.getUsername() + "', '" + user.getPassword() + "', '" + user.getFirstName() + "', '" + user.getLastName() + "', '" + user.getPractitionerName() + "')");
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
            User user = new User();
            ResultSet rs = statement.executeQuery("SELECT * FROM users WHERE username='" + username + "'");          
            if(rs.next()){
                if (rs.getString("practitioner") == null){
                    user = new Practitioner(rs.getString("username"),rs.getString("password"), rs.getString("firstName"), rs.getString("lastName"));
                    ArrayList<Client> clients = getClients((Practitioner)user);
                    for(Client client : clients){
                        ((Practitioner)user).addClient(client);
                    }
                }
                else{
                    System.out.println("ELSEEEE");
                    user = new Client(rs.getString("username"),rs.getString("password"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("practitioner"));
                }
                
            }
            return user;
        }
        catch(SQLException ex){
            return new User();
        }
    }    
 
/**
 * 
 * @return
 * The getAllUsers method used an ArrayList to store all of the pulled from the database 
 * into a list, which then can be displayed to the user.
 * @author Ryan
 */         
     
    public ArrayList<Client> getClients(Practitioner practitioner){
        try{
            ResultSet rs = statement.executeQuery("SELECT * FROM users WHERE practitioner='" + practitioner.getUsername() + "'");
            ArrayList<Client> clients = new ArrayList<>();
            
            while(rs.next()){
                clients.add(new Client(rs.getString("username"),rs.getString("password"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("practitioner")));
            }
            return clients;
        }
        catch(SQLException ex){
           return null; 
        }        
    }
    
    //this isn't working
    public void removeUser(Client user) {
        try {   
                ResultSet rs;  
                System.out.println(user.getUsername());
                String username = user.getUsername();
                rs = statement.executeQuery("SELECT * FROM users WHERE username='" + username + "'"); 
              
                    String sql = "DELETE FROM users WHERE username'=" + username + "'";
                    statement.executeUpdate(sql);
                    //rs.deleteRow();
                
                
                
                   //rs.next();
                   
                   //rs.deleteRow();
                   //rs.close();
                   
//                 Connection conn = DriverManager.getConnection(protocol + dbName + ";create=true");
//                 String sql = "DELETE * FROM rs WHERE username='" + user.getUsername() + "'";
//                 PreparedStatement state = conn.prepareStatement(sql);
//                 state.executeUpdate();
                    
                 System.out.println("User successfully removed from database");
            
        }
        catch(SQLException ex) {
            System.out.println(user+ " does not exist");
        }
    }
    
    
}
