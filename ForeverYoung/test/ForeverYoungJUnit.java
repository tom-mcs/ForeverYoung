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
    
    
    
    
    
    public ForeverYoungJUnit() {
    }
    
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
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
        public void terminate() throws SQLException {
            
           try {
              connection.close(); 
           } catch(SQLException sqlE) {
               
               System.out.println("close failed");
               throw sqlE;
           } 
                   
            
        }
    
}
