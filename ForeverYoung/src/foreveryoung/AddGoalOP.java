/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Admin
 */
public class AddGoalOP {
    
    private JPanel mainPanel;
    private JPanel fieldPanel;
    private JTextField nameField = new JTextField();
    private JTextArea description = new JTextArea();
    private int n;
    
    public AddGoalOP(){
        mainPanel = new JPanel(new GridLayout());
        mainPanel.setBorder(new EmptyBorder(10,10,10,10));
        fieldPanel = new JPanel(new GridLayout(2,2));
        mainPanel.add(fieldPanel);
        
        fieldPanel.add(new JLabel("Goal Name: "));
        fieldPanel.add(nameField);
        fieldPanel.add(new JLabel("Description: "));
        fieldPanel.add(description);
             
        
        JFrame frame = new JFrame();
        n = JOptionPane.showConfirmDialog(frame, mainPanel, "New Goal", JOptionPane.OK_CANCEL_OPTION);
    }
    
    public String getGoalName(){
        if(n == JOptionPane.CANCEL_OPTION){
            return "";
        }
        return nameField.getText();
    }
    
    public String getDescription(){
        if(n == JOptionPane.CANCEL_OPTION){
            return "";
        }
        return description.getText();
    }
    
}
