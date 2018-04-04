/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 * This is the create new account interface. It is added to the main frame, when the user selects
 * "New Account" from the welcome interface. It has fields for username and two password fields, a
 * "create" button and a "cancel" button. When a button is selected, the "action"
 * variable is altered. The main method checks this variable to determine what action
 * has been taken by the user.
 * @author Thomas McSkimming
 */
public class CreateNewAccountInterface extends JPanel{
    
    private JTextField userNameTextField = new JTextField();
    private JPasswordField passwordField1 = new JPasswordField();
    private JPasswordField passwordField2 = new JPasswordField();
    private JLabel dialog = new JLabel();
    private JButton create = new JButton("create");
    private JButton cancel = new JButton("cancel");
    private String action;
    private boolean selectionMade;
    
    public CreateNewAccountInterface() {
        this.init();
    }
    
    //initialises components
    private void init(){
        //create frames and panels
 
        this.setLayout(new GridLayout(2,1));
        this.setBorder(new EmptyBorder(10,10,10,10));
        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setLayout(new BorderLayout(5,5)); 
        
        JPanel LabelPanel = new JPanel(new GridLayout(0,1,2,20));
        JPanel TextFieldPanel = new JPanel(new GridLayout(0,1,2,20));
        
        JPanel ButtonPanel = new JPanel(new FlowLayout());

        //create fonts
        Font dialogFont = new Font(Font.SANS_SERIF, Font.PLAIN, 11);
        dialog.setFont(dialogFont);
        
        //create Labels
        JLabel uLabel = new JLabel("Username:", SwingConstants.RIGHT);
        JLabel pLabel = new JLabel("Password:", SwingConstants.RIGHT);
        JLabel p2Label = new JLabel("Re-enter password", SwingConstants.RIGHT);
        

        
        //Add components to panels
        ButtonPanel.add(create);
        ButtonPanel.add(cancel);
        LabelPanel.add(uLabel);
        LabelPanel.add(pLabel);
        LabelPanel.add(p2Label);
        TextFieldPanel.add(userNameTextField);
        TextFieldPanel.add(passwordField1);
        TextFieldPanel.add(passwordField2);
        
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
        
        create.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                action = "create";
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
    
    public boolean create(){

        String username = userNameTextField.getText();
        String password1 = passwordField1.getText();
        String password2 = passwordField2.getText();
        
        
        //if passwords match, adds the user. if user already exists returns an error
        if (password1.equals(password2)){
            if(Broker.addUser(username, password1)){
                setMessage("user added successfully");
                selectionMade = false;
                return true;
            }
            else{
                setMessage("error: username already exists or fields were left empty"); 
                selectionMade = false;
            }
        }
        else{
            setMessage("passwords do not match");
            selectionMade = false;
        }
        return false;
        
    }
    
    public void setDefaultButton()throws NullPointerException{
        this.getRootPane().setDefaultButton(create);
    }
    
    public boolean selectionMade(){
        return selectionMade;
    }

    public String getAction() {
        return action;
    }
    
    private void setMessage(String message){
        dialog.setText(message);
    }
    private void clearMessage(){
        dialog.setText("");
    }
}