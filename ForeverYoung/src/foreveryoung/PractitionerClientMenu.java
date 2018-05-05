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
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Admin
 */
public class PractitionerClientMenu extends JPanel{
    private final JButton back = new JButton("Back");
    private final JButton recordsteps = new JButton("Record Pedometer");
    private final JButton addgoals = new JButton("Add Goals");
    private final JButton addexercise = new JButton("Add exercises");
    private boolean logoutClicked = false;
    private boolean stepsClicked = false;
    private boolean goalsClicked = false;
    private boolean exerciseClicked = false;
    private Client client;
    
    
    //constructor
    public PractitionerClientMenu(Client client) {
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
        loginInfo.setText("Viewing Client " + client.getFirstName() + " " + client.getLastName());
        logoPanel.add(loginInfo, BorderLayout.NORTH);
        
        //add action listener to logout button
        back.addActionListener(backAL);
        recordsteps.addActionListener(stepsAL);
        addgoals.addActionListener(goalsAL);
        addexercise.addActionListener(exerciseAL);
             
        //add elements
        logoPanel.add(label, BorderLayout.CENTER);
        
        //Add panels main panel
        this.add(logoPanel);
        this.add(userPanel);
        this.add(buttonPanel);
        buttonPanel.add(back);
        buttonPanel.add(recordsteps);
        buttonPanel.add(addgoals);
        buttonPanel.add(addexercise);
  
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
    
    public boolean isGoalsClicked() {
        return goalsClicked;
    }
    
    public void setGoalsClicked(boolean bool) {
        goalsClicked = bool;
    }
    
    public boolean isExerciseClicked() {
        return exerciseClicked;
    }
    
    public void setExerciseClicked(boolean bool) {
        exerciseClicked = bool;
    }
    
    //logout actionListener
    private ActionListener backAL = new ActionListener() {
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
    
    //goals actionListener
    private ActionListener goalsAL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            goalsClicked = true;
        }
    };
    
    //exercise actionListener
    private ActionListener exerciseAL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            exerciseClicked = true;
        }
    };
    
}
