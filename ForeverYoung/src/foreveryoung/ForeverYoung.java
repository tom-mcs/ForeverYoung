package foreveryoung;

import static java.lang.Thread.sleep;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class ForeverYoung {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Broker broker = new Broker();
        WelcomeInterface WInterface = new WelcomeInterface();
        User user = null;
        
        while (user == null){
            while(!WInterface.selectionMade()){
                sleep(100);
            }

            String action = WInterface.getAction();
            //create login interface
            if (action.equals("login")){
                LoginInterface loginInterface = new LoginInterface();
                user = loginInterface.login();
            }
            //create CNA interface
            if (action.equals("createNewAccount")){
                CreateNewAccountInterface CNAInterface = new CreateNewAccountInterface();
                CNAInterface.create();
            }
        }
        WInterface.dispose();
        
        new DisplayUsers();
        
    }

}
