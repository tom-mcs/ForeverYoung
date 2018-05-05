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
public class AddExerciseMenuController {
    private Client client;
    private Broker broker;
    private MainFrame mainFrame;
    private AddExerciseMenu menu;
    private String action;
    
    public AddExerciseMenuController(Client client, Broker broker, MainFrame mainFrame){
        this.client = client;
        this.broker = broker;
        this.mainFrame = mainFrame;
        menu = new AddExerciseMenu(this.client);
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
        if(menu.isAddClicked()){
            menu.setAddClicked(false);
            client.addAerobicExercise(new AerobicExercise("exercise"));
            System.out.println(client.getAerobicExercises());
        }
    }
    
    public String getAction(){
        return action;
    }
}
