package foreveryoung;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
class LoginInterface {

    //constructor
    public LoginInterface(){
        this.init();
    }
    
    //initialises components
    private void init(){
        //create frames and panels
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new BorderLayout(5,5)); 
        JPanel LabelPanel = new JPanel(new GridLayout(0,1,2,2));
        JPanel TextFieldPanel = new JPanel(new GridLayout(0,1,2,2));
        
        //create text fields
        JTextField userNameTextField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        //create Labels
        JLabel uLabel = new JLabel("Username:", SwingConstants.RIGHT);
        JLabel pLabel = new JLabel("Password:", SwingConstants.RIGHT);
        
        //Add components to panels
        LabelPanel.add(uLabel);
        LabelPanel.add(pLabel);
        TextFieldPanel.add(userNameTextField);
        TextFieldPanel.add(passwordField);
        
        //add panels to main panel
        panel.add(TextFieldPanel, BorderLayout.CENTER);
        panel.add(LabelPanel, BorderLayout.WEST);
        
        //Show JOption Pane containing panel within frame
        JOptionPane.showConfirmDialog(frame, panel, "Forever Young - Login", JOptionPane.OK_CANCEL_OPTION);
        
        //gets user from the typed username, and checks the typed password with the one in the database
        //first checks to see if user exists, then if password matches, user is logged in, if not then prints that the password doesn't match
        String username = userNameTextField.getText();
        String password = passwordField.getText();  //java doesn't like that the password isn't encrypted, so might have to change this later
        User user = Broker.getUser(username);  
        if(user == null){
            System.out.println("user not found");
        }
        else{
            if (password.equals(user.getPassword())){
                System.out.println("user is logged in as " + user.getUserName());
            }
            else{
                System.out.println("password doesn't match");
            }  
        }
      
    }
}
