/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import foreveryoung.Broker;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ryan_Lancer
 */
public class ForeverYoungJUnit {
     
    final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    final String protocol = "jdbc:derby:";
    final String dbName = "derbyDB";
    static Connection connection = null;
    static Statement statement = null;
    
/**
* Declaring the code above is necessary for the tests to function correctly,
* as the connection needs to be made to the database
* @author Ryan 
*/    
    
    public ForeverYoungJUnit() {
    }
    
/**
 * The setUp method holds necessary code in order for the tests to function, as
 * the tests only try the method and expect an expected output, which does not 
 * automatically perform prerequisite code. 
 * @throws SQLException 
 */    
    
    @Before
    public void setUp() throws SQLException { 
        
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
        
        statement = connection.createStatement();
        
        
          
    }

/**
 * The connection is identical to the setUp method code but is actually testing
 * if a connection can be made to the database
 */
    
        // connection test sees if the program can actually connect to the derby db 
        @Test
        public void connection() {
              
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
                     
        }
        
        // tests if the program can drop an uneeded/unecessary table
        @Test 
        public void drop() throws SQLException {
            
            try {
                statement.execute("DROP TABLE SAMPLE");
                System.out.println("table dropped");
            }
            catch(SQLException sqlExcept){
                System.out.println("error dropping user table");
            } 
               
        }
        
        // tests if a table with columns can be created and then insert data into the table 
        @Test
        public void tablecreate() throws SQLException {  
           
            try {
                statement.execute("CREATE TABLE SAMPLE (SAMP INT PRIMARY KEY NOT NULL, MIX VARCHAR(5) )");
            //    System.out.println("statement success");
                
            } catch(SQLException sqlE) {
                
                System.out.println("statement failed");
                throw sqlE;        
            }
            
            try {
                statement.execute("INSERT INTO SAMPLE VALUES (1, 'MIX1'), (2, 'MIX2')");
            }catch(SQLException sqlE) {
                
                System.out.println("statement failed");
                throw sqlE;        
            }
               
        }
        
        @Test
        public void pulldata() throws SQLException{
            
            try {
                statement.executeQuery("SELECT * FROM users");
            } catch(SQLException sqlE) {
                
                System.out.println("statement failed");
                throw sqlE;
            }
        }
        
        @Test
        public void terminate() throws SQLException {
            
           try {
              connection.close(); 
           } catch(SQLException sqlE) {
               
               System.out.println("close failed");
               throw sqlE;
           }                         
        }
    
}
