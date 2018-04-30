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
import javax.swing.JComboBox;
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
public class PractitionerMenu extends JPanel {

    private final JButton logout = new JButton("logout");
    private boolean logoutClicked = false;
    private boolean viewClientClicked = false;
    private boolean deleteClientClicked = false;
    private final JButton createAccountButton = new JButton("Create Client Account");
    private boolean CNAButtonClicked = false;
    private Practitioner practitioner;
    private JTable jTable;
    private JPanel userPanel;
    private JButton deleteClientButton;
    private JButton viewClientButton;
    private JComboBox comboBox;
    
    //constructor
    public PractitionerMenu(Practitioner practitioner) {
        this.practitioner = practitioner;
        init();
    }
        
    private void init(){
        //formatting
        this.setLayout(new GridLayout(2, 1));
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        JPanel logoPanel = new JPanel(new BorderLayout());
        userPanel = new JPanel(new FlowLayout());
        JPanel buttonPanel = new JPanel(new FlowLayout());         
        //import logo
        ImageIcon logo = new ImageIcon("./lph.png");
        JLabel label = new JLabel(logo);
        
        JLabel loginInfo= new JLabel();
        Font loginInfoFont = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
        loginInfo.setFont(loginInfoFont);
        loginInfo.setText("logged in as Practitioner " + practitioner.getFirstName());
        logoPanel.add(loginInfo, BorderLayout.NORTH);
        
        //add action listener to logout button
        logout.addActionListener(logoutAL);
        createAccountButton.addActionListener(CNAButtonAL);
        
        userPanel.setBorder (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (), "Clients", TitledBorder.CENTER, TitledBorder.TOP));
        
        //add elements
        logoPanel.add(label, BorderLayout.CENTER);
        
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
    
    public void setTable(ArrayList<Client> users){
        //create table of all clients of this practitioner
        comboBox = new JComboBox(users.toArray());
        viewClientButton = new JButton("View Client");
        viewClientButton.addActionListener(viewClientAL);
        deleteClientButton = new JButton("Delete Client");
        deleteClientButton.addActionListener(deleteClientAL);
        userPanel.removeAll();
        userPanel.add(comboBox, BorderLayout.NORTH);
        userPanel.add(deleteClientButton);
        userPanel.add(viewClientButton);
        userPanel.repaint();
        userPanel.revalidate();
    }
       
    public void setLogoutClicked(boolean bool){
        logoutClicked = bool;
    }
    
    public boolean isLogoutClicked() {
        return logoutClicked;
    }

    public void setCNAButtonClicked(boolean bool){
        CNAButtonClicked = bool;
    }
    
    public boolean isCNAButtonClicked(){
        return CNAButtonClicked;
    }

    public boolean isViewClientClicked() {
        return viewClientClicked;
    }

    public void setViewClientClicked(boolean viewClientClicked) {
        this.viewClientClicked = viewClientClicked;
    }

    public boolean isDeleteClientClicked() {
        return deleteClientClicked;
    }

    public void setDeleteClientClicked(boolean deleteClientClicked) {
        this.deleteClientClicked = deleteClientClicked;
    }
    
    public Client getSelectedClient(){
        return (Client)comboBox.getSelectedItem();
    }
    
    //logout actionListener
    private ActionListener logoutAL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            logoutClicked = true;
        }
    };
    
    private ActionListener CNAButtonAL = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            CNAButtonClicked = true;
        }
    };
    
    private ActionListener viewClientAL = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            viewClientClicked = true;
        }
    };
    
    private ActionListener deleteClientAL = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("click");
            deleteClientClicked = true;
        }
    };

}

