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
    private boolean done;
   
    public PractitionerMenuController(Practitioner pract, Broker broker, MainFrame mainFrame){
        practitioner = pract;
        this.broker = broker;
        this.mainFrame = mainFrame;
        menu = new PractitionerMenu(practitioner);
    }
    
    public void activate(){
        done = false;
        menu.setTable(practitioner.getClients());
        action = null;
        mainFrame.setPanel(menu);
        while(!done){
            try{sleep(50);}catch(InterruptedException ie){}
            check();
        }
    }
    
    private void check(){
        if(menu.isCNAButtonClicked()){
            done = true;
            menu.setCNAButtonClicked(false);
            action = "CNA";
        }
        if(menu.isLogoutClicked()){
            done = true;
            menu.setLogoutClicked(false);
            action = "logout";
        }
        if(menu.isDeleteClientClicked()){   
            if(menu.getSelectedClient() != null) {    
            System.out.println("delete client: " + menu.getSelectedClient().getName());
            menu.setDeleteClientClicked(false);
        //    broker.removeUser(menu.getSelectedClient().getUsername());
            broker.removeUser(menu.getSelectedClient());      
            practitioner.removeClient(menu.getSelectedClient());
            }
            menu.setTable(practitioner.getClients());
        }
        
        if(menu.getSelectedClient() != null) {
        
            if(menu.isViewClientClicked()){
                done = true;
                menu.setViewClientClicked(false);
                System.out.println("view client: " + menu.getSelectedClient().getName());
                action = "view";          
            }   
        }     
        
    }
    
    public Client getSelectedClient(){
        return menu.getSelectedClient();
    }
    
    public String getAction(){
        return action;
    }
    
}
