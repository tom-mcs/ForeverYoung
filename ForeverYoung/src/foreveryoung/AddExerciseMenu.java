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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class AddExerciseMenu extends JPanel{
    private final JButton backButton = new JButton("Back");
    private final JButton addButton = new JButton("Add");
    private boolean addClicked = false;
    private boolean backClicked = false;
    private Client client;
    
    
    //constructor
    public AddExerciseMenu(Client client) {
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
        backButton.addActionListener(backAL);
        addButton.addActionListener(addAL);
             
        //add elements
        logoPanel.add(label, BorderLayout.CENTER);
        
        //Add panels main panel
        this.add(logoPanel);
        this.add(userPanel);
        this.add(buttonPanel);
        buttonPanel.add(backButton);
        buttonPanel.add(addButton);
  
    }

    public boolean isAddClicked() {
        return addClicked;
    }

    public void setAddClicked(boolean addClicked) {
        this.addClicked = addClicked;
    }

    public boolean isBackClicked() {
        return backClicked;
    }

    public void setBackClicked(boolean backClicked) {
        this.backClicked = backClicked;
    }
    
    private ActionListener addAL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            addClicked = true;
        }
    };
    
    private ActionListener backAL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            backClicked = true;
        }
    };
    
}
