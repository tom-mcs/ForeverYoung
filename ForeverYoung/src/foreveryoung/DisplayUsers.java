/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

/**
 * This Interface displays the logo and a list of all users and passwords 
 * that are stored in the database. It is being used as a temporary tool for
 * demonstration and debugging.
 * @author Thomas McSkimming
 */
public class DisplayUsers extends JPanel {
    
    private final JButton logout = new JButton("logout");
    private boolean logoutClicked = false;
    
    public boolean getLogoutClicked(){
        return logoutClicked;
    }
    
    public DisplayUsers(){

        this.setLayout(new GridLayout(2,1));
        this.setBorder(new EmptyBorder(10,10,10,10));
        JPanel logoPanel = new JPanel(new BorderLayout());
        JPanel userPanel = new JPanel(new BorderLayout());
        
        //Dimensions
        int frameHeight = 500;
        int frameWidth = 400;
        Dimension FrameSize = new Dimension(frameWidth,frameHeight);
        
        Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = ScreenSize.width;
        int screenHeight = ScreenSize.height;
       
        
        //Import Logo and add to Logo Panel
        ImageIcon logo = new ImageIcon("./lph.png");
        JLabel label  = new JLabel(logo);
        logoPanel.add(label, BorderLayout.CENTER);
  
        logout.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                logoutClicked = true;
            }
        }); 
        
        //create text field of all users
        ArrayList<User> users = Broker.getAllUsers();
        String[][] table = new String[users.size()][2];
       
        for(int i = 0 ; i < users.size() ; i++){
            table[i][0] = users.get(i).getUserName();
            table[i][1] = users.get(i).getPassword();
        }
        String[] titles = {"Username", "Password"};
        JTable jTable = new JTable(table, titles);
        
        userPanel.add(jTable, BorderLayout.CENTER);
        userPanel.add(logout,BorderLayout.SOUTH);
        
        
        
        //Add panels to frame and make visible
        this.add(logoPanel);
        this.add(userPanel);
  
       
        
    }
    
    
}
