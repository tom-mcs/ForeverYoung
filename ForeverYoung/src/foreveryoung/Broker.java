package foreveryoung;

import java.sql.Connection;
import java.sql.DriverManager;

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
    
     public static void main(String[] args) throws Exception {
     /* ------- Start DB ----------- */
        final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
        Class.forName(driver).newInstance();

        final String protocol = "jdbc:derby:";
        final String dbName = "derbyDB";
        Connection connection = DriverManager.getConnection(
                protocol + dbName + ";create=true");
        System.out.println("=====    Started/Connected DB    =====");
     }
    
    
    
    
}
