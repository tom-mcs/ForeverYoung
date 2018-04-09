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
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * This Interface displays the logo and a list of all users and passwords that
 * are stored in the database.
 *
 * @author Thomas McSkimming
 */
public class DisplayUsers extends JPanel {

    private final JButton logout = new JButton("logout");
    private boolean logoutClicked = false;
    private final JButton createAccountButton = new JButton("Create Account");
    private boolean CNAButtonClicked = false;
    private final boolean selectionMade = false;
    private String action;
    private JLabel dialog = new JLabel();
    private User user;
    
    //constructor
    public DisplayUsers(User user) {
        this.user = user;
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
        
        //add action listener to logout button
        logout.addActionListener(logoutAL);
        createAccountButton.addActionListener(CNAButtonAL);
        
        userPanel.setBorder (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),
                                                            "Clients",
                                                            TitledBorder.CENTER,
                                                            TitledBorder.TOP));
        
        //create table of all users
        ArrayList<User> users = Broker.getClients(this.user);
        String[][] table = new String[users.size()][3];
        for (int i = 0; i < users.size(); i++) {
            table[i][0] = users.get(i).getUserName();
            table[i][1] = users.get(i).getFirstName();
            table[i][2] = users.get(i).getLastName();
        }
        String[] titles = {"Username", "FirstName", "LastName"};
        JTable jTable = new JTable(table, titles);
      
        //add elements
        logoPanel.add(label, BorderLayout.CENTER);
        userPanel.add(jTable, BorderLayout.CENTER);
        userPanel.add(jTable.getTableHeader(), BorderLayout.NORTH);
        //Add panels main panel
        this.add(logoPanel);
        this.add(userPanel);
        this.add(buttonPanel);
        buttonPanel.add(logout);
        buttonPanel.add(createAccountButton);
         //add action listener to logout button
        logout.addActionListener(logoutAL);
        createAccountButton.addActionListener(CNAButtonAL);
  
    }
   
    public boolean getLogoutClicked() {
        return logoutClicked;
    }

    public void setLogoutClicked(boolean bool){
        logoutClicked = bool;
    }
    
     public void setCNAButtonClicked(boolean bool){
        CNAButtonClicked = bool;
    }
    
    public boolean getCNAButtonClicked(){
        return CNAButtonClicked;
    }
    
    
    //logout actionListener
    private ActionListener logoutAL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            logoutClicked = true;
        }
    };
    
    ActionListener CNAButtonAL = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            CNAButtonClicked = true;
        }
    };

}

