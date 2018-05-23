/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

import static foreveryoung.ForeverYoung.textFont;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Admin
 */
public class PractitionerClientMenu extends JPanel{
    private final JButton backButton = new JButton("Back");
    private final JButton addGoalButton = new JButton("Add Goal");
    private final JButton addExerciseButton = new JButton("Add exercise");
    private final JButton addWeightsButton = new JButton("Add weight exercise");
    private JTable exerciseTable;
    private JTable weightsTable;
    private JTable goalTable;
    private JPanel userPanel;
    private boolean addGoalClicked = false;
    private boolean addExerciseClicked = false;
    private boolean backClicked = false;
    private boolean addWeightsClicked = false;
    private Client client;
   
    //constructor
    public PractitionerClientMenu(Client client) {
        this.client = client;
        init();
    }
        
    private void init(){
        //formatting
        addExerciseButton.setFont(textFont);
        addGoalButton.setFont(textFont);
        addWeightsButton.setFont(textFont);
        backButton.setFont(textFont);
        
        this.setLayout(new GridLayout(1, 2));
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        userPanel = new JPanel(new GridLayout(3,1,10,10));
        JPanel buttonPanel = new JPanel(new GridLayout(3,1,10,10));         
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
        addWeightsButton.addActionListener(AddWeightsAL);
        //add elements
        JPanel exerciseButtonPanel = new JPanel(new FlowLayout());
        exerciseButtonPanel.add(addExerciseButton);
        JPanel goalButtonPanel = new JPanel(new FlowLayout());
        goalButtonPanel.add(addGoalButton);
        JPanel WeightsButtonPanel = new JPanel(new FlowLayout());
        WeightsButtonPanel.add(addWeightsButton);
        
        buttonPanel.add(exerciseButtonPanel);
        buttonPanel.add(WeightsButtonPanel);
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
        int numEntries = 0;
        for(AerobicExercise a : exercises){
            if (a.getNumberOfEntries() > numEntries){
                numEntries = a.getNumberOfEntries();
            }
        }
        exerciseTable = new JTable(exercises.size()+1, numEntries + 1);
        exerciseTable.removeAll();
        for(int i = 0 ; i < exercises.size(); i++){
            exerciseTable.setValueAt("Exercise Name" , 0, 0);
            exerciseTable.setValueAt(exercises.get(i).getName(), i+1, 0);
            AerobicExercise ae = exercises.get(i);
            ArrayList<AerobicExerciseEntry> entries = ae.getEntries();
            for(int e = 0 ; e < entries.size(); e++){
                AerobicExerciseEntry aee = entries.get(e);
                exerciseTable.setValueAt(aee.minutes, i+1, e+1);
            }
            
        }
        ArrayList<Goal> goals = client.getGoals();
        goalTable = new JTable(goals.size(), 3);
        goalTable.removeAll();
        String columnNames[] = {"Goal","Description","Completed"};
       
        for(int i = 0 ; i < goals.size(); i++){
            goalTable.setValueAt(goals.get(i).getName(), i, 0);
            goalTable.setValueAt(goals.get(i).getDescription(), i, 1);
            goalTable.setValueAt(goals.get(i).isCompleted(), i, 2);
        }
        ArrayList<WeightExercise> weights = new ArrayList<>();
        weights.clear();
        System.out.println(weights);
        weights = client.getWeightExercises();
        numEntries = 0;
        System.out.println(weights);
        for(WeightExercise we : weights){
            if (we.getNumberOfEntries() > numEntries){
                numEntries = we.getNumberOfEntries();
            }
        }
        
        weightsTable = new JTable(2*weights.size()+2, 2*numEntries + 2);
        weightsTable.removeAll();
        for(int x = 0 ; x < numEntries; x++){
            weightsTable.setValueAt("Set 1", 0 , (x+1)*2);
            weightsTable.setValueAt("Set 2", 0 , ((x+1)*2)+1);
        }
        
        for(int i = 0 ; i < weights.size(); i++){
            WeightExercise exercise = weights.get(i);
            ArrayList<WeightExerciseEntry> entries = exercise.getEntries();
            weightsTable.setValueAt(exercise.getName(), (2*i)+1, 0);
            weightsTable.setValueAt("weight",(2*i)+1,1);
            weightsTable.setValueAt("reps",(2*i)+2,1); 
            System.out.println(entries.size());
            for(int e = 0 ; e < entries.size(); e++){
                System.out.println(e);
                weightsTable.setValueAt(entries.get(e).getSet1().weight,(2*i)+1,(2*e)+2);
                weightsTable.setValueAt(entries.get(e).getSet1().reps,(2*i)+2,(2*e)+2);
                weightsTable.setValueAt(entries.get(e).getSet2().weight,(2*i)+1,(2*e)+3);
                weightsTable.setValueAt(entries.get(e).getSet2().reps,(2*i)+2,(2*e)+3);
            }
        }
        
        goalTable.setFont(textFont);
        weightsTable.setFont(textFont);
        exerciseTable.setFont(textFont);
        weightsTable.setRowHeight(25);
        exerciseTable.setRowHeight(25);
        goalTable.setRowHeight(25);
        
        userPanel.add(exerciseTable);
        userPanel.add(weightsTable);
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
    
    
    
    public boolean isWeightsClicked() {
        return addWeightsClicked;
    }
    
    public void setAddWeightsClicked(boolean bool) {
        addWeightsClicked = bool;
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
 
    private ActionListener AddWeightsAL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            addWeightsClicked = true;
        }
    };

    
    
}
