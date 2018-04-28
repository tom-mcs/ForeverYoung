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
public class Client extends User{
    
    private String practitionerName;
    
    public Client(User user, String practitionerName){
        this(user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(), practitionerName);
    }
    
    public Client(String username, String password, String firstName, String lastName, String practitionerName){
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isLoggedIn = false;
        this.practitionerName = practitionerName;
    }
    
    public String getPractitionerName(){
        return practitionerName;
    }
}
