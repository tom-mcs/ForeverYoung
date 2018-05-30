/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

import static foreveryoung.ForeverYoung.textFont;
//import static foreveryoung.MainFrame.screenHeight;
//import static foreveryoung.MainFrame.screenWidth;
import java.awt.Dimension;
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
    private JTextField nameField = new JTextField(20);
    private JTextArea description = new JTextArea(5, 20);
    private int n;
    
    public AddGoalOP(){
        mainPanel = new JPanel(new GridLayout());
        mainPanel.setBorder(new EmptyBorder(10,10,10,10));
        fieldPanel = new JPanel(new GridLayout(2,2));
        mainPanel.add(fieldPanel);
        
        JLabel goalLabel = new JLabel("Goal Name: ");
        JLabel descriptionLabel = new JLabel("Description: ");
        goalLabel.setFont(textFont);
        descriptionLabel.setFont(textFont);
        
        
        fieldPanel.add(new JLabel("Goal Name: "));
        nameField.setFont(textFont);
        JPanel namePanel = new JPanel();
        namePanel.add(nameField);
        fieldPanel.add(namePanel);
        fieldPanel.add(new JLabel("Description: "));
        description.setFont(textFont);
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
