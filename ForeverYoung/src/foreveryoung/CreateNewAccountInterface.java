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

import java.sql.*;

/**
 *
 * @author Admin
 */
public class CreateNewAccountInterface {
    
    private JTextField userNameTextField = new JTextField();
    private JPasswordField passwordField1 = new JPasswordField();
    private JPasswordField passwordField2 = new JPasswordField();
    
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
    
    public void create(){

        String username = userNameTextField.getText();
        String password1 = passwordField1.getText();
        String password2 = passwordField2.getText();
        
        
        //if passwords match, adds the user. if user already exists returns an error
        if (password1.equals(password2)){
            if(Broker.addUser(username, password1)){
                System.out.println("user added successfully");
            }
            else{
                System.out.println("error: username already exists or fields were left empty"); 
            }
        }
        else{
            System.out.println("passwords do not match");
        }
    }
}