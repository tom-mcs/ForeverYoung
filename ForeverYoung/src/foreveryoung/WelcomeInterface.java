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
 * checked by the main method, in order to determine what action has occured.
 * @author Thomas McSkimming
 */
public class WelcomeInterface extends JPanel {
    
    private JButton loginButton = new JButton("Log In");
    private JButton createAccountButton = new JButton("Create Account");
    private boolean selectionMade = false;
    private String action;
    private JLabel dialog = new JLabel();
    
    public WelcomeInterface(){
        init();
    }
    
    private void init(){
        
        //create panels
        this.setLayout(new GridLayout(2,1));                       
        JPanel topPanel = new JPanel(new BorderLayout());                               
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 100));    
        JPanel dialogPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 11);
        dialog.setFont(font);
        
        //Import Logo and add to Logo Panel
        ImageIcon logo = new ImageIcon("./lph.png");
        JLabel label  = new JLabel(logo);
        topPanel.add(label);
        
        //add Buttons
        buttonPanel.add(loginButton);
        buttonPanel.add(createAccountButton);
        
        dialogPanel.add(dialog);
        
        bottomPanel.add(buttonPanel, BorderLayout.CENTER);
        bottomPanel.add(dialogPanel, BorderLayout.SOUTH);

        //Add panels to frame and make visible
        this.add(topPanel);
        this.add(bottomPanel);

        
        //add action listeners.
        loginButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                action = "login";
                selectionMade = true;
            }
            
        });
        createAccountButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                action = "createNewAccount";
                selectionMade = true;
            }
        });
        
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
}
