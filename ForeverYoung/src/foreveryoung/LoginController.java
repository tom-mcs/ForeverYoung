/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;

/**
 *
 * @author Admin
 */
public class LoginController {
    
    private Broker broker;
    private LoginInterface loginInterface;
    private User user;
    private boolean done;
    private MainFrame frame;
    private String action;
    
    public LoginController(Broker broker, MainFrame frame){
        this.broker = broker;
        loginInterface = new LoginInterface();
        this.frame = frame;
        done = false;
        user = new User();
    }
    
    public void activate(){
        loginInterface.clearAll();
        action = null;
        frame.setPanel(loginInterface);
        loginInterface.setDefaultButton();
        while(action == null){
            try{sleep(50);} catch(InterruptedException ie){}
            check();
        }
    }
    
    public LoginInterface getInterface(){
        return loginInterface;
    }
    
    /**
     * periodically checks for action in the interface and 
     * if login clicked tries to log in, if successful sets done = true
     * if cancel clicked sets done = true.
     */
    public void check(){
            if(loginInterface.getLoginButtonClicked()){
                loginInterface.setLoginButtonClicked(false);
                if(login()){
                    action = "login";
                }
            }
            if(loginInterface.getCancelButtonClicked()){
                loginInterface.setCancelButtonClicked(false);
                action = "cancel";
            }
    }
    
    /**
     * gets username from the username text field, and checks password with the one in the database
     * first checks to see if user exists, then if password matches, user is logged in, else displays message
     * @return true if user is logged in successfully, else false
     */
    private boolean login(){
 
        String username = loginInterface.getUsernameText();
        String password = loginInterface.getPasswordText();  //java doesn't like that the password isn't encrypted, so might have to change this later
        user = broker.getUser(username);  
        if(user.getUsername() == null){
            loginInterface.displayMessage("User not found");
        }
        else{
            if (password.equals(user.getPassword())){
                user.login();
                System.out.println("user is logged in as " + user.getUsername());
                return true;
            }
            else{
                loginInterface.displayMessage("Incorrect password");
            }  
        }
        return false;
    }
    
    public User getUser(){
        return user;
    }
}
