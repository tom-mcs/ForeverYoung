package foreveryoung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
    
     public Broker(){
     /* ------- Start DB ----------- */
        final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
        try{
            Class.forName(driver).newInstance();
        }
        catch(Exception E){
            E.printStackTrace();
        }
        final String protocol = "jdbc:derby:";
        final String dbName = "derbyDB";
        try {
             Connection connection = DriverManager.getConnection(
                     protocol + dbName + ";create=true");
        } 
        catch (SQLException ex) {
             Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("=====    Started/Connected DB    =====");
     }
    
    
    
    
}
