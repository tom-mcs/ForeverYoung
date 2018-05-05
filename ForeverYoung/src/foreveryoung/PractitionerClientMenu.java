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
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Admin
 */
public class PractitionerClientMenu extends JPanel{
    private final JButton backButton = new JButton("Back");
    private final JButton addGoalButton = new JButton("Add Goal");
    private final JButton addExerciseButton = new JButton("Add exercise");
    private JTable exerciseTable;
    private JTable goalTable;
    private JPanel userPanel;
    private boolean addGoalClicked = false;
    private boolean addExerciseClicked = false;
    private boolean backClicked = false;
    private Client client;
   
    
    
    //constructor
    public PractitionerClientMenu(Client client) {
        this.client = client;
        init();
    }
        
    private void init(){
        //formatting
        this.setLayout(new GridLayout(1, 2));
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        userPanel = new JPanel(new GridLayout(2,1,10,10));
        JPanel buttonPanel = new JPanel(new GridLayout(2,1,10,10));         
        //import logo
        ImageIcon logo = new ImageIcon("./lph.png");
        JLabel label = new JLabel(logo);
        
        JLabel message= new JLabel();
        Font messageFont = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
        message.setFont(messageFont);
        message.setText("Viewing Client: " + client.getFirstName() + " " + client.getLastName());
        
        //add action listener to logout button
        backButton.addActionListener(backAL);
        addGoalButton.addActionListener(AddGoalAL);
        addExerciseButton.addActionListener(AddExerciseAL);

        //add elements
        JPanel exerciseButtonPanel = new JPanel(new FlowLayout());
        exerciseButtonPanel.add(addExerciseButton);
        JPanel goalButtonPanel = new JPanel(new FlowLayout());
        goalButtonPanel.add(addGoalButton);
        buttonPanel.add(exerciseButtonPanel);
        buttonPanel.add(goalButtonPanel);
        
        JPanel homePanel = new JPanel(new GridLayout(2,1));
        homePanel.add(new JLabel("Client: " + client.getFirstName() + " " + client.getLastName()), new Font(Font.SANS_SERIF, Font.PLAIN, 17));
        JPanel backPanel = new JPanel(new FlowLayout());
        backPanel.add(backButton);
        homePanel.add(backPanel);
        
        
        this.add(homePanel);
        this.add(userPanel);
        this.add(buttonPanel);


  
  
    }
    
    public void updateTables(){
        userPanel.removeAll();
        ArrayList<AerobicExercise> exercises = client.getAerobicExercises();
        exerciseTable = new JTable(exercises.size(), 2);
        for(int i = 0 ; i < exercises.size(); i++){
            exerciseTable.setValueAt(exercises.get(i).getName(), i, 0);
            exerciseTable.setValueAt(exercises.get(i).getNumberOfEntries(), i, 1);
            
        }
        ArrayList<Goal> goals = client.getGoals();
        goalTable = new JTable(goals.size(), 3);
        String columnNames[] = {"Goal","Description","Completed"};
       
        for(int i = 0 ; i < goals.size(); i++){
            goalTable.setValueAt(goals.get(i).getName(), i, 0);
            goalTable.setValueAt(goals.get(i).getDescription(), i, 1);
            goalTable.setValueAt(goals.get(i).isCompleted(), i, 2);
        }
        
        
        userPanel.add(exerciseTable);
        userPanel.add(goalTable);
        userPanel.repaint();
        userPanel.revalidate();
    }
   
    public boolean isAddGoalClicked() {
        return addGoalClicked;
    }
    
    public void setAddGoalClicked(boolean bool) {
        addGoalClicked = bool;
    }
    
    public boolean isAddExerciseClicked() {
        return addExerciseClicked;
    }
    
    public void setAddExerciseClicked(boolean bool) {
        addExerciseClicked = bool;
    }

    public boolean isBackClicked() {
        return backClicked;
    }

    public void setBackClicked(boolean backClicked) {
        this.backClicked = backClicked;
    }
    
    //logout actionListener
    private ActionListener backAL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            backClicked = true;
        }
    };
  
    //add goal actionListener
    private ActionListener AddGoalAL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            addGoalClicked = true;
        }
    };
    
    //add exercise actionListener
    private ActionListener AddExerciseAL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            addExerciseClicked = true;
        }
    };

        }
