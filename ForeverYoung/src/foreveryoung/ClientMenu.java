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
import javax.swing.*;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author Matt
 */
public class ClientMenu extends JPanel{
    private final JButton logout = new JButton("logout");
    private final JButton recordsteps = new JButton("Record steps");
    private boolean logoutClicked = false;
    private boolean stepsClicked = false;
    private Client client;
    
    
    //constructor
    public ClientMenu(Client client) {
        this.client = client;
        init();
    }
        
    private void init(){
        //formatting
        this.setLayout(new GridLayout(2, 1));
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        JPanel logoPanel = new JPanel(new BorderLayout());
        JPanel userPanel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new FlowLayout());         
        //import logo
        ImageIcon logo = new ImageIcon("./lph.png");
        JLabel label = new JLabel(logo);
        
        JLabel loginInfo= new JLabel();
        Font loginInfoFont = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
        loginInfo.setFont(loginInfoFont);
        loginInfo.setText("logged in as Client " + client.getFirstName());
        logoPanel.add(loginInfo, BorderLayout.NORTH);
        
        //add action listener to logout button
        logout.addActionListener(logoutAL);
        recordsteps.addActionListener(stepsAL);    
        //add elements
        logoPanel.add(label, BorderLayout.CENTER);
        
        //Add panels main panel
        this.add(logoPanel);
        this.add(userPanel);
        this.add(buttonPanel);
        buttonPanel.add(logout);
        buttonPanel.add(recordsteps);
         //add action listener to logout button
        logout.addActionListener(logoutAL);
    }
       
    public boolean isLogoutClicked() {
        return logoutClicked;
    }

    public void setLogoutClicked(boolean bool){
        logoutClicked = bool;
    }
    
    public boolean isStepsClicked() {
        return stepsClicked;
    }
    
    public void setStepsClicked(boolean bool) {
        stepsClicked = bool;
    }
      
    //logout actionListener
    private ActionListener logoutAL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            logoutClicked = true;
        }
    };
      
    //steps actionListener
    private ActionListener stepsAL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            stepsClicked = true;
        }
    };
}
