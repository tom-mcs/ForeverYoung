/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

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
    private String action;
    
    public PractitionerClientMenuController(Client client, Broker broker, MainFrame mainFrame){
        this.client = client;
        this.broker = broker;
        this.mainFrame = mainFrame;
        menu = new PractitionerClientMenu(this.client);
    }
    
    public void activate(){
        action = null;
        mainFrame.setPanel(menu);
        while(action == null){
            try{sleep(50);}catch(InterruptedException ie){}
            check();
        }
    }
    
    private void check(){
        if(menu.isBackClicked()){
            menu.setBackClicked(false);
            action = "back";
        }
        if(menu.isAddExerciseClicked()){
            menu.setAddExerciseClicked(false);
            action = "addExercise";
        }
        if(menu.isAddGoalClicked()){
            menu.setAddGoalClicked(false);
            action = "addGoal";
        }
    }
    
    public String getAction(){
        return action;
    }
}
