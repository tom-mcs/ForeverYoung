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
import java.util.Observable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class WelcomeInterface extends Observable {
    
    private JButton loginButton = new JButton("Log In");
    private JButton createAccountButton = new JButton("Create Account");
    private boolean selectionMade = false;
    private String action;
    JFrame frame = new JFrame("Forever Young - Welcome");
    
    
    public WelcomeInterface(){
        init();
    }
    
    private void init(){
        //create relevant panels and frames

        JPanel panel = new JPanel(new GridLayout(2,1));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 100));
        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 100));
        
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
        
        //add Buttons
        buttonPanel.add(loginButton);
        buttonPanel.add(createAccountButton);
        
        //Add panels to frame and make visible
        panel.add(logoPanel);
        panel.add(buttonPanel);
        frame.add(panel);
        frame.repaint();
        frame.revalidate();
        frame.setVisible(true);
        
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
 
    public boolean selectionMade(){
        return selectionMade;
    }
    
    public String getAction(){
        selectionMade = false;
        return action;
    }
    
    public void dispose(){
        frame.dispose();
    }

}
