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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class is the welcome interface and is added to the main frame when the program is open
 * it displays a logo and has two buttons, one of which will launch a log in interface,
 * the other will launch a create new user interface. 
 * When a button is selected, the "action" variable is altered. this variable is
 * checked by the main method, in order to determine what action has occurred.
 * @author Thomas McSkimming
 */
public class WelcomeInterface extends JPanel {
    
    private final JButton loginButton = new JButton("Log In");
    private final JButton createAccountButton = new JButton("Create Practitioner Account");
    private JLabel dialog = new JLabel();
    private boolean loginButtonClicked = false;
    private boolean CNAButtonClicked = false;
    
    public WelcomeInterface(){
        init();
    }
    
    private void init(){
        
        //formatting
        this.setLayout(new GridLayout(2,1));                       
        JPanel topPanel = new JPanel(new BorderLayout());                               
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 100));    
        JPanel dialogPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        dialog.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 11));
        
        //Import Logo and add to Logo Panel
        ImageIcon logo = new ImageIcon("./lph.png");
        JLabel label  = new JLabel(logo);
        topPanel.add(label);
        
        
        
        //add components to panels
        buttonPanel.add(loginButton);
        buttonPanel.add(createAccountButton);
        dialogPanel.add(dialog);
        bottomPanel.add(buttonPanel, BorderLayout.CENTER);
        bottomPanel.add(dialogPanel, BorderLayout.SOUTH);

        //Add panels to main panel
        this.add(topPanel);
        this.add(bottomPanel);
        
        //add action listeners.
        loginButton.addActionListener(loginButtonAL);
        createAccountButton.addActionListener(CNAButtonAL);
        
    }
 
    public void displayMessage(String message){
        dialog.setText(message);
    }
    
    public void clearMessage(){
        dialog.setText("");
    }
    
    public void setLoginButtonClicked(boolean bool){
        loginButtonClicked = bool;
    }
    
    public boolean getLoginButtonClicked(){
        return loginButtonClicked;
    }    
    
    public void setCNAButtonClicked(boolean bool){
        CNAButtonClicked = bool;
    }
    
    public boolean getCNAButtonClicked(){
        return CNAButtonClicked;
    }
  
    ActionListener loginButtonAL = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            loginButtonClicked = true;
        }
    };
    
    ActionListener CNAButtonAL = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            CNAButtonClicked = true;
        }
    };
    
    public void setDefaultButton()throws NullPointerException{
        this.getRootPane().setDefaultButton(loginButton);
    }
    
}
