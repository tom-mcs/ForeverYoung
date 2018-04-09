package foreveryoung;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static java.lang.Thread.sleep;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This is the main controller for the ForeverYoung Fitness tracking app.
 * @author Thomas McSkimming
 */
public class ForeverYoung {
    
    public static void main(String[] args) throws Exception {
        Broker broker = new Broker();
        MainFrame mainFrame = new MainFrame();
        User user = new User();
        WelcomeInterface WInterface = new WelcomeInterface();
        mainFrame.setVisible(true);
        
        //program terminates and database is shut down when the main frame is closed
        mainFrame.addWindowListener(new WindowAdapter(){
        @Override
        public void windowClosing(WindowEvent we)
        {
            Broker.shutdown();
            System.exit(0);    
        }
        });
         
        //loop forever
        while(true){
            /**
             * login/create new account sequence
             * continues until a user is logged in.
             * checks if a button is clicked and creates the relevant interface
             **/
            while (!user.isLoggedIn()){
                mainFrame.setPanel(WInterface);
                sleep(50);  //delay to reduce frequency of checking
                
                //create login interface
                if (WInterface.getLoginButtonClicked()){
                    WInterface.setLoginButtonClicked(false);
                    LoginInterface loginInterface = new LoginInterface();
                    mainFrame.setPanel(loginInterface);
                    loginInterface.setDefaultButton();
                    boolean done = false;
                    
                    //continues until user is logged in or cancel is clicked
                    while (!done){
                        sleep(50);
                        if(loginInterface.getLoginButtonClicked()){
                            loginInterface.setLoginButtonClicked(false);
                            if(loginInterface.login()){
                                user = loginInterface.getUser();
                                done = true;
                            }
                        }
                        if(loginInterface.getCancelButtonClicked()){
                            loginInterface.setCancelButtonClicked(false);
                            done = true;
                        }
                    }
                }

                //create CNA interface
                if (WInterface.getCNAButtonClicked()){
                    WInterface.setCNAButtonClicked(false);
                    CreateNewAccountInterface CNAInterface = new CreateNewAccountInterface();
                    mainFrame.setPanel(CNAInterface);
                    CNAInterface.setDefaultButton();
                    boolean done = false;
                    
                    //continues until account is created or cancel is pressed
                    while(!done){
                        sleep(50);
                        if(CNAInterface.isCreateButtonClicked()){
                            CNAInterface.setCreateButtonClicked(false);
                            done = CNAInterface.create();
                        }
                        if(CNAInterface.isCancelButtonClicked()){
                            CNAInterface.setCancelButtonClicked(false);
                            done = true;
                        }
                    }
                }
            }
            
            /**
             * user is logged in create display users interface
             */
            DisplayUsers displayUsers = new DisplayUsers(user);
            mainFrame.setPanel(displayUsers);
            //continues until user is logs out
            while(user.isLoggedIn()){
                sleep(50);
                if(displayUsers.getLogoutClicked()){
                    displayUsers.setLogoutClicked(false);
                    System.out.println("logging out");
                    user.logout();
                }
            }
        }
    }
}
