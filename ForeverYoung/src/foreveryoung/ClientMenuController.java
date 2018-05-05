/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;


import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ClientMenuController {
    
    private Client client;
    private Broker broker;
    private MainFrame mainFrame;
    private ClientMenu menu;
    private String action;
    
    public ClientMenuController(Client client, Broker broker, MainFrame mainFrame){
        this.client = client;
        this.broker = broker;
        this.mainFrame = mainFrame;
        menu = new ClientMenu(this.client);
    }
    
    public void activate(){
        action = null;
        mainFrame.setPanel(menu);
        menu.updateTables();
        while(action == null){
            try{sleep(50);}catch(InterruptedException ie){}
            check();
        }
    }
    
    private void check(){
        if(menu.isLogoutClicked()){
            menu.setLogoutClicked(false);
            action = "logout";
        }
        if(menu.isAddEntryClicked()){
            AerobicExercise exercise = menu.getExercise();
            try{
                exercise.addEntry(Integer.parseInt(new addAerobicEntryPane().getMinutes()));
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Enter A number", "Whoops!", JOptionPane.ERROR_MESSAGE);
                check();
            }
            menu.setAddEntryClicked(false);
            menu.updateTables();
        }
        if(menu.isCompleteGoalClicked()){
            menu.setCompleteGoalClicked(false);
            Goal goal = menu.getGoal();
            goal.setCompleted(true);
            menu.updateTables();
        }
    }
    
    public String getAction(){
        return action;
    }

    private Object LocalDateTime() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
