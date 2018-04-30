/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

/**
 * This class is the User class. It is to be extended to practitioner and client classes.
 * @author Thomas McSkimming
 */
public class User {
    protected String username;
    protected String password;
    protected String firstName;
    protected String lastName;
    protected boolean isLoggedIn;
    
    //create a user with username and password
    public User(String username, String password, String firstName, String lastName){
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        isLoggedIn = false;
    }
    
    //create a user with no username and password
    public User(){
        isLoggedIn = false;
    }
    
    public void login(){
        isLoggedIn = true;
    }
    
    public void logout(){
        isLoggedIn = false;
    }
    
    public boolean isLoggedIn(){
        return isLoggedIn;
    }

    public boolean isPractitioner(){
        return false;
    }
    
    public boolean isClient(){
        return false;
    }
            
    public String getUsername() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString(){
        return username;
    }
    
    public String getName(){
        String string = getFirstName() + " " + getLastName();
        return string;
    }

}
