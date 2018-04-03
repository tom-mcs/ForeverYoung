/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author Admin
 */
public class DisplayUsers {
    
    public DisplayUsers(){
        JFrame frame = new JFrame("ForeverYoung - Users");
        JPanel panel = new JPanel(new GridLayout(2,1));
        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 100));
        JPanel userPanel = new JPanel();
        
        //Dimensions
        int frameHeight = 500;
        int frameWidth = 400;
        Dimension FrameSize = new Dimension(frameWidth,frameHeight);
        
        Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = ScreenSize.width;
        int screenHeight = ScreenSize.height;
        
        frame.setSize(FrameSize);
        frame.setLocation((screenWidth-frameWidth)/2,(screenHeight-frameHeight)/2);
        
        //Import Logo and add to Logo Panel
        ImageIcon logo = new ImageIcon("./lph.png");
        JLabel label  = new JLabel(logo);
        logoPanel.add(label);
  
        
        //create text field of all users
        User[] users = Broker.getAllUsers();
        String[][] table = new String[users.length][2];
       
        for(int i = 0 ; i < users.length ; i++){
            table[i][0] = users[i].getUserName();
            table[i][1] = users[i].getPassword();
        }
        String[] titles = {"Username", "Password"};
        JTable jTable = new JTable(table, titles);
        
        userPanel.add(jTable);
        
        //Add panels to frame and make visible
        panel.add(logoPanel);
        panel.add(userPanel);
        frame.add(panel);
        frame.repaint();
        frame.revalidate();
        frame.setVisible(true);
       
        
    }
    
    
}
