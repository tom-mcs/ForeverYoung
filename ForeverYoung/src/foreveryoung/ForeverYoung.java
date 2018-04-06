package foreveryoung;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static java.lang.Thread.sleep;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This is the main file for the ForeverYoung Fitness tracking app.
 * It is the main controller for the program.
 * @author Thomas McSkimming
 */
public class ForeverYoung {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Broker broker = new Broker();
        
        MainFrame mainFrame = new MainFrame();
        
        User user = new User();
        WelcomeInterface WInterface = new WelcomeInterface();
        
        mainFrame.setVisible(true); 
        
         mainFrame.addWindowListener(new WindowAdapter(){
        @Override
        public void windowClosing(WindowEvent we)
        {
            broker.shutdown();
            System.exit(0);
            
          
    }
        });
        
        
        //login/create account sequence
      
        while (!user.isLoggedIn()){
            mainFrame.setPanel(WInterface);
            while(!WInterface.selectionMade()){
                sleep(100);
            }
            String action = WInterface.getAction();
            
            
            //create login interface
            if (action.equals("login")){
                LoginInterface loginInterface = new LoginInterface();
                mainFrame.setPanel(loginInterface);
                loginInterface.setDefaultButton();
                boolean done = false;
                while (!done){
                    while(!loginInterface.selectionMade()){
                        sleep(100);
                    }
                    String loginAction = loginInterface.getAction();
                    if(loginAction.equals("login")){
                        if(loginInterface.login()){
                            user = loginInterface.getUser();
                            done = true;
                        }
                    }
                    if(loginAction.equals("cancel")){
                        done = true;
                    }
                }
            }
            
            //create CNA interface
            if (action.equals("createNewAccount")){
                CreateNewAccountInterface CNAInterface = new CreateNewAccountInterface();
                mainFrame.setPanel(CNAInterface);
                CNAInterface.setDefaultButton();
                
                boolean done = false;
                while(!done){
                    while(!CNAInterface.selectionMade()){
                        sleep(100);
                    }
                    String CNAAction = CNAInterface.getAction();
                    if(CNAAction.equals("create")){
                        done = CNAInterface.create();
                    }
                    if(CNAAction.equals("cancel")){
                        done = true;
                    }
                }
            }
        }
        mainFrame.setPanel(new DisplayUsers());
        
      
        
        
    }

}
