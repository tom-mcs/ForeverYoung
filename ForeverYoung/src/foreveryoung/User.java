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
    private String userName;
    private String password;
    private boolean isLoggedIn;
    
    //create a user with username and password
    public User(String username, String password){
        this.userName = username;
        this.password = password;
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
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
