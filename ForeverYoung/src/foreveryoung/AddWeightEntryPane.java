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
public class AddWeightEntryPane {
        
    private JPanel mainPanel;
    private JPanel fieldPanel;
    private JTextField set1weight;
    private JTextField set2weight;
    private JTextField set1reps;
    private JTextField set2reps;
    private int n;
        
    public AddWeightEntryPane(){
        mainPanel = new JPanel(new GridLayout(1, 1));
        mainPanel.setBorder(new EmptyBorder(10,10,10,10));
        fieldPanel = new JPanel(new GridLayout(2,2));
        mainPanel.add(fieldPanel);
        set1weight = new JTextField();
        set2weight = new JTextField();
        set1reps = new JTextField();
        set2reps = new JTextField();
        
        fieldPanel.add(new JLabel("Set 1 Weight (kg):"));
        fieldPanel.add(set1weight);
        fieldPanel.add(new JLabel("Set 1 Reps:"));
        fieldPanel.add(set1reps);
        fieldPanel.add(new JLabel("Set 2 Weight (kg):"));
        fieldPanel.add(set2weight);
        fieldPanel.add(new JLabel("Set 2 Reps:"));
        fieldPanel.add(set2reps);
        
        JFrame frame = new JFrame();
        n = JOptionPane.showConfirmDialog(frame, mainPanel, "Add Entry: " , JOptionPane.OK_CANCEL_OPTION);
    }

    public int getSet1weight() {
        if(n == JOptionPane.CANCEL_OPTION){
            return -1;
        }
        return Integer.parseInt(set1weight.getText());
    }

    public int getSet2weight() {
        if(n == JOptionPane.CANCEL_OPTION){
            return -1;
        }
        return Integer.parseInt(set2weight.getText());
    }
    
    public int getSet1reps() {
        if(n == JOptionPane.CANCEL_OPTION){
            return -1;
        }
        return Integer.parseInt(set1reps.getText());
    }
    
    public int getSet2reps() {
        if(n == JOptionPane.CANCEL_OPTION){
            return -1;
        }
        return Integer.parseInt(set2reps.getText());
    }
    
  
}
