/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;

/**
 *
 * @author Admin
 */
public class PractitionerClientMenuController {
    private Client client;
    private Broker broker;
    private MainFrame mainFrame;
    private PractitionerClientMenu menu;
    private boolean done;
    
    public PractitionerClientMenuController(Client client, Broker broker, MainFrame mainFrame){
        this.client = client;
        this.broker = broker;
        this.mainFrame = mainFrame;
        menu = new PractitionerClientMenu(this.client);
    }
    
    public void activate(){
        done = false;
        menu.updateTables();
        mainFrame.setPanel(menu);
        while(done == false){
            try{sleep(50);}catch(InterruptedException ie){}
            check();
        }
    }
    
    private void check(){
        if(menu.isBackClicked()){
            menu.setBackClicked(false);
            done = true;
        }
        if(menu.isAddExerciseClicked()){
            menu.setAddExerciseClicked(false);
            String name = new addExerciseOP().getExerciseName();
            AerobicExercise exercise = new AerobicExercise(name);
            client.addAerobicExercise(exercise);
        //    broker.addAerobicExercise(exercise, client);
            menu.updateTables();
        }
        if(menu.isAddGoalClicked()){
            menu.setAddGoalClicked(false);
            AddGoalOP addGoalOP = new AddGoalOP();
            String name = addGoalOP.getGoalName();
            String description = addGoalOP.getDescription();
            Goal goal = new Goal(name, description, client.username);
            client.addGoal(goal);
            broker.addGoal(goal);
            menu.updateTables();
        }
    }

    public boolean isDone() {
        return done;
    }
    
    
    
}
