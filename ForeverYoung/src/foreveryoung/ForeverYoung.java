package foreveryoung;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import java.time.LocalDateTime;


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
    
    public static Font textFont = new Font(Font.SANS_SERIF, Font.PLAIN, 22);
    
    public static void main(String[] args) throws Exception {
        Broker broker = new Broker();
        MainFrame mainFrame = new MainFrame();
        User user = new User();
      
        //program terminates and database is shut down when the main frame is closed
        mainFrame.addWindowListener(new WindowAdapter(){
        @Override 
        public void windowClosing(WindowEvent we){
            broker.shutdown();
            System.exit(0);    
        }});
        
        WelcomeController welcomeController = new WelcomeController(mainFrame);
        LoginController loginController = new LoginController(broker, mainFrame);
        CreateNewPractitionerController CNPController = new CreateNewPractitionerController(broker, mainFrame);
         
        //loop forever
        while(true){
            /**
             * login/create new account sequence
             * continues until a user is logged in.
             * checks if a button is clicked and creates the relevant interface
             **/
            while (!user.isLoggedIn()){
                sleep(50);
                welcomeController.activate();
                //login clicked
                if (welcomeController.getAction().equals("login")){
                    loginController.activate();
                    user = loginController.getUser();   
                }
                //CNA clicked
                if (welcomeController.getAction().equals("CNP")){
                    CNPController.activate();
                }
            }
    
            System.out.println(user.getUsername() + " is logged in");
            /**
             * user is logged in. create display users interface
             */
            System.out.println(user.getFirstName() + user.getLastName());
            if(user instanceof Practitioner){
                PractitionerMenuController menuController = new PractitionerMenuController((Practitioner)user, broker, mainFrame);
                while(true){
                    menuController.activate();
                    if(menuController.getAction().equals("logout")){
                        user.logout();
                        break;
                    }
                    if(menuController.getAction().equals("CNA")){
                        NewClientController newClientController = new NewClientController(broker, mainFrame, (Practitioner)user);
                        newClientController.activate();
                    }
                    if(menuController.getAction().equals("view")){
                        Client client = menuController.getSelectedClient();
                        client.loadStats(broker);
                        PractitionerClientMenuController PCMenuController = new PractitionerClientMenuController(client, broker, mainFrame);
                        while(!PCMenuController.isDone()){
                            PCMenuController.activate();
                            }

                        
                    }
                }
            }
            
            if(user instanceof Client){
                Client client = (Client)user;
                client.loadStats(broker);
                ClientMenuController menuController = new ClientMenuController((Client)user, broker, mainFrame);
                menuController.activate();
                if(menuController.getAction().equals("logout")){
                    user.logout();
                }
            }
            
            
        }
    }
}
