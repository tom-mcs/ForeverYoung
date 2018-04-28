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
public class WelcomeController {
    
    private WelcomeInterface welcomeInterface;
    private MainFrame frame;
    private String action;
    
    public WelcomeController(MainFrame frame){
        welcomeInterface = new WelcomeInterface();
        this.frame = frame;
    }
    
    public void activate(){
        frame.setPanel(welcomeInterface);
        welcomeInterface.setDefaultButton();
        welcomeInterface.setLoginButtonClicked(false);
        welcomeInterface.setCNAButtonClicked(false);
        action = null;
        while(action == null){
            try{sleep(50);}catch(InterruptedException ie){}
            check();
        }
    }
    
    public WelcomeInterface getInterface(){
        return welcomeInterface;
    }
    
    public String getAction(){
        return action;
    }
    
    public void check(){
        if (welcomeInterface.getLoginButtonClicked()){
            welcomeInterface.setLoginButtonClicked(false);
            action = "login";
        }
        if (welcomeInterface.getCNAButtonClicked()){
            welcomeInterface.setCNAButtonClicked(false);
            action = "CNP";
        }
    }
    
}
