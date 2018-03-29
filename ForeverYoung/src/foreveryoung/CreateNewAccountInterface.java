/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Admin
 */
public class CreateNewAccountInterface {
    
    public CreateNewAccountInterface(){
        this.init();
    }
    
    //initialises components
    private void init(){
        //create frames and panels
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new BorderLayout(5,5)); 
        JPanel LabelPanel = new JPanel(new GridLayout(0,1,2,2));
        JPanel TextFieldPanel = new JPanel(new GridLayout(0,1,2,2));
        
        //create components
        JTextField userNameTextField = new JTextField();
        JPasswordField passwordField1 = new JPasswordField();
        JPasswordField passwordField2 = new JPasswordField();
        JLabel uLabel = new JLabel("Username:", SwingConstants.RIGHT);
        JLabel p1Label = new JLabel("Password:", SwingConstants.RIGHT);
        JLabel p2Label = new JLabel("Re-Enter Password:", SwingConstants.RIGHT);
        
        //add components to panels
        LabelPanel.add(uLabel);
        LabelPanel.add(p1Label);
        LabelPanel.add(p2Label);
        TextFieldPanel.add(userNameTextField);
        TextFieldPanel.add(passwordField1);
        TextFieldPanel.add(passwordField2);
        
        //add panels to main panel
        panel.add(TextFieldPanel, BorderLayout.CENTER);
        panel.add(LabelPanel, BorderLayout.WEST);
        
        //display JOptionPane
        JOptionPane.showConfirmDialog(frame, panel, "Forever Young - Create New Account", JOptionPane.OK_CANCEL_OPTION);
       
    }
}

class DbCreate {
    
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