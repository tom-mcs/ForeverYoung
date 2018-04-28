/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Practitioner extends User{
    
    private ArrayList<Client> clients;
    
    public Practitioner(User user){
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.username = user.username;
        this.isLoggedIn = user.isLoggedIn;
        this.password = user.password;
        clients = new ArrayList();
    }
    
    public Practitioner(String username, String password, String firstName, String lastName){
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isLoggedIn = false;
        clients = new ArrayList();
    }
    
    public Client newClient(String username, String password, String firstName, String lastName){
        Client client = new Client(username, password, firstName, lastName, this.username);
        clients.add(client);
        return client;
    }
    
    public boolean addClient(Client client){
        return clients.add(client);
    }
    
    public boolean removeClient(Client client){
        return clients.remove(client);
    }
    
    public ArrayList<Client> getClients(){
        return clients;
    }
    
    public String ClientsToString(){
        return clients.toString();
        
    }

}
