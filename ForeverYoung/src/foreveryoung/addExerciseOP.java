/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JComboBox;
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
public class addExerciseOP {
    
    private JPanel mainPanel;
    private JPanel fieldPanel;
    private String[] AerobicExercises = {"walking", "swimming", "dancing", "stair climbing", "tennis"};
    private String[] WeightsExercises = {"Seated Lateral Raise", "Bicep Curl", "Shoulder Shrug", "One Arm Triceps", "One Arm Row", "Chest Press", "Abdominal Crunch", "Leg Extention", "Heel Raises", "Hamstring Curl", "Gluteals Extension", "Body Weight Squat"};
    private JComboBox comboBox;
    private String type;
    int n;
    
    public addExerciseOP(String type){
        if(type == "aerobic"){
            comboBox = new JComboBox(AerobicExercises);
        }
        else{
            comboBox = new JComboBox(WeightsExercises);
        }
        mainPanel = new JPanel(new GridLayout(2, 1));
        mainPanel.setBorder(new EmptyBorder(10,10,10,10));
        fieldPanel = new JPanel(new GridLayout(1,2));
        mainPanel.add(fieldPanel);
        
        fieldPanel.add(new JLabel("Exercise Name:    "));
        fieldPanel.add(comboBox);
        
        JFrame frame = new JFrame();
        n = JOptionPane.showConfirmDialog(frame, mainPanel, "Exercise Name", JOptionPane.OK_CANCEL_OPTION);
    }
    
    public String getExerciseName(){
        if (n == JOptionPane.OK_OPTION){
            return (String)comboBox.getSelectedItem();
        }
        return "";
    }
    
}
