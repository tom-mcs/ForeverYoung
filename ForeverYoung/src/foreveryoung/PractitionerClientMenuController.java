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
            String name = new addExerciseOP("aerobic").getExerciseName();
            AerobicExercise exercise = new AerobicExercise(name);
            client.addAerobicExercise(exercise);
            broker.addExercise(exercise, client);
            menu.updateTables();
        }
        if(menu.isWeightsClicked()){
            menu.setAddWeightsClicked(false);
            String name = new addExerciseOP("weight").getExerciseName();
            WeightExercise exercise = new WeightExercise(name);
            client.addWeightExercise(exercise);
            broker.addExercise(exercise, client);
            menu.updateTables();
            System.out.println(client.getWeightExercises());
            System.out.println(broker.getAllWeightExercisesOfClient(client));
        }
        if(menu.isAddGoalClicked()){
            menu.setAddGoalClicked(false);
            AddGoalOP addGoalOP = new AddGoalOP();
            String name = addGoalOP.getGoalName();
            String description = addGoalOP.getDescription();
            if(!name.isEmpty() && !description.isEmpty()){
                Goal goal = new Goal(name, description);
                client.addGoal(goal);
                broker.addGoal(goal, client);
            }
            menu.updateTables();
        }
    }

    public boolean isDone() {
        return done;
    }
    
    
    
}
