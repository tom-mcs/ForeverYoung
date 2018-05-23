/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;


import static java.lang.Thread.sleep;
import javax.swing.JOptionPane;
import static java.lang.Thread.sleep;

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
            AerobicExercise exercise = menu.getAerobicExercise();
            try{
                AerobicExerciseEntry entry = exercise.addEntry(Integer.parseInt(new addAerobicEntryPane().getMinutes()));
                broker.addAerobicExerciseEntry(exercise, entry , client);
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Enter A number", "Whoops!", JOptionPane.ERROR_MESSAGE);
                check();
            }
            catch(NullPointerException e){
                System.out.println(e);
            }
            menu.setAddEntryClicked(false);
            menu.updateTables();
        }
        if(menu.isAddWeightClicked()){
            menu.setAddWeightClicked(false);
            WeightExercise exercise = menu.getWeightExercise();
            try{
                AddWeightEntryPane pane = new AddWeightEntryPane();
                WeightExerciseEntry entry = exercise.addEntry(pane.getSet1weight(),pane.getSet1reps(),pane.getSet2weight(),pane.getSet2reps());
                broker.addWeightExerciseEntry(exercise, entry , client);
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Enter A number", "Whoops!", JOptionPane.ERROR_MESSAGE);
                check();
            }
            catch(NullPointerException e){
                System.out.println(e);
            };
            menu.updateTables();
        }
        if(menu.isCompleteGoalClicked()){
            menu.setCompleteGoalClicked(false);
            Goal goal = menu.getGoal();
            goal.setCompleted(true);
            broker.setGoalAsCompleted(goal, client);
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
