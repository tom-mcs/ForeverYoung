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
public class PractitionerMenuController {
    
    private Practitioner practitioner;
    private Broker broker;
    private PractitionerMenu menu;
    private MainFrame mainFrame;
    private String action;
    
    public PractitionerMenuController(Practitioner pract, Broker broker, MainFrame mainFrame){
        practitioner = pract;
        this.broker = broker;
        this.mainFrame = mainFrame;
        menu = new PractitionerMenu(practitioner);
    }
    
    public void activate(){
        menu.setTable(practitioner.getClients());
        action = null;
        mainFrame.setPanel(menu);
        while(action == null){
            try{sleep(50);}catch(InterruptedException ie){}
            check();
        }
    }
    
    private void check(){
        if(menu.isCNAButtonClicked()){
            menu.setCNAButtonClicked(false);
            action = "CNA";
        }
        if(menu.isLogoutClicked()){
            menu.setLogoutClicked(false);
            action = "logout";
        }
    }
    
    public String getAction(){
        return action;
    }
    
}
