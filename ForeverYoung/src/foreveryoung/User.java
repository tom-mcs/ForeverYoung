/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

/**
 *
 * @author Admin
 */
public class User {
    private String userName;
    private String password;
    private boolean isLoggedIn = false;
    
    public User(String username, String password){
        this.userName = username;
        this.password = password;
    }
    
    public void login(){
        isLoggedIn = true;
    }
    public void logout(){
        isLoggedIn = false;
    }
    public boolean isLoggedIn(){
        return isLoggedIn();
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
