/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Admin
 */
public class addAerobicEntryPane {
        
    private JPanel mainPanel;
    private JPanel fieldPanel;
    private JTextField minutesField;
        
    public addAerobicEntryPane(){
        mainPanel = new JPanel(new GridLayout(2, 1));
        mainPanel.setBorder(new EmptyBorder(10,10,10,10));
        fieldPanel = new JPanel(new GridLayout(1,2));
        mainPanel.add(fieldPanel);
        minutesField = new JTextField();
        
        fieldPanel.add(new JLabel("Minutes Spent Exercising:"));
        fieldPanel.add(minutesField);
        
        JFrame frame = new JFrame();
        JOptionPane.showConfirmDialog(frame, mainPanel, "Add Entry: " , JOptionPane.OK_CANCEL_OPTION);
    }
    
    public String getMinutes(){
        return minutesField.getText();
    }
}
