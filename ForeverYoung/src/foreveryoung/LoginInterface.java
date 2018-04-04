package foreveryoung;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This is the login interface. It is added to the main frame, when the user selects
 * "login" from the welcome interface. It has fields for username and password, a
 * "login" button and a "cancel" button. When a button is selected, the "action"
 * variable is altered. The main method checks this variable to determine what action
 * has been taken by the user.
 * @author Thomas McSkimming
 */
class LoginInterface extends JPanel {

    private JTextField userNameTextField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JLabel dialog = new JLabel();
    private JButton login = new JButton("login");
    private JButton cancel = new JButton("cancel");
    private String action;
    private boolean selectionMade;
    
    //constructor
    public LoginInterface(){
        this.init();
    }
    
    //initialises components
    private void init(){
        //create panels
        this.setLayout(new GridLayout(2,1));
        this.setBorder(new EmptyBorder(10,10,10,10));
        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setLayout(new BorderLayout(5,5)); 
        
        JPanel LabelPanel = new JPanel(new GridLayout(0,1,2,20));
        JPanel TextFieldPanel = new JPanel();
        TextFieldPanel.setLayout(new GridLayout(0,1,2,20));
        
        JPanel ButtonPanel = new JPanel(new FlowLayout());

        //create fonts
        Font dialogFont = new Font(Font.SANS_SERIF, Font.PLAIN, 11);
        dialog.setFont(dialogFont);
        
        //create Labels
        JLabel uLabel = new JLabel("Username:", SwingConstants.RIGHT);
        JLabel pLabel = new JLabel("Password:", SwingConstants.RIGHT);
        
 
        
        //Add components to panels
        ButtonPanel.add(login);
        ButtonPanel.add(cancel);
        LabelPanel.add(uLabel);
        TextFieldPanel.add(userNameTextField);
        LabelPanel.add(pLabel);
        TextFieldPanel.add(passwordField);
        
        //add panels to main panel
        bottomPanel.add(TextFieldPanel, BorderLayout.CENTER);
        bottomPanel.add(LabelPanel, BorderLayout.WEST);
        bottomPanel.add(dialog, BorderLayout.NORTH);
        bottomPanel.add(ButtonPanel, BorderLayout.SOUTH);
        
        //Import Logo and add to Logo Panel
        ImageIcon logo = new ImageIcon("./lph.png");
        JLabel label  = new JLabel(logo);
        topPanel.add(label);
        
        this.add(topPanel);
        this.add(bottomPanel);
        
        login.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                action = "login";
                selectionMade = true;
            }
        });
        
        cancel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                action = "cancel";
                selectionMade = true;
            }
        });

       
    }
    
    private User user;
    public User getUser(){
        return user;
    }
    
    public boolean login(){
        //gets user from the typed username, and checks the typed password with the one in the database
        //first checks to see if user exists, then if password matches, user is logged in, if not then prints that the password doesn't match
        String username = userNameTextField.getText();
        String password = passwordField.getText();  //java doesn't like that the password isn't encrypted, so might have to change this later
        user = Broker.getUser(username);  
        if(user == null){
            displayMessage("User not found");
        }
        else{
            if (password.equals(user.getPassword())){
                user.login();
                System.out.println("user is logged in as " + user.getUserName());
                return true;
            }
            else{
                displayMessage("Incorrect password");
            }  
        }
        return false;
    }
    
 public void setSelectionMade(boolean bool){
        selectionMade = bool;
    }
 
    public boolean selectionMade(){
        return selectionMade;
    }
    
    public String getAction(){
        setSelectionMade(false);
        return action;
    }
    
    public void displayMessage(String message){
        dialog.setText(message);
    }
    
    public void clearMessage(){
        dialog.setText("");
    }
    
    public void setDefaultButton()throws NullPointerException{
        this.getRootPane().setDefaultButton(login);
    }
}

