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
    private Pedometer pedometer;
    private ArrayList<AerobicExercise> aerobicExercises;
    private ArrayList<WeightExercise> weightExercises;
    private ArrayList<Goal> goals;
    
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
        aerobicExercises = new ArrayList<>();
        goals = new ArrayList<>();
    }
    
    public boolean loadStats(Broker broker){
        ArrayList<AerobicExercise> aeList = broker.getAllAerobicExercisesOfClient(this);
        for(AerobicExercise a : aeList){
            if(!addAerobicExercise(a)){
                return false;
            }
        }
        ArrayList<WeightExercise> weList = broker.getAllWeightExercisesOfClient(this);
        for(WeightExercise w : weList){
            if(!addWeightExercise(w)){
                return false;
            }
        }
        ArrayList<Goal> gList = broker.getGoals(this);
        for(Goal g : gList){
            if (!addGoal(g)){
                return false;
            }
        }
        return true;
    }
    
    public String getPractitionerName(){
        return practitionerName;
    }
    
    public boolean addAerobicExercise(AerobicExercise ae){
        return aerobicExercises.add(ae);
    }
    
    public boolean addWeightExercise(WeightExercise we){
        return weightExercises.add(we);
    }
    
    public boolean addGoal(Goal goal){
        return goals.add(goal);
    }
    
    public ArrayList<Goal> getGoals(){
        return goals;
    }
    
    public ArrayList<AerobicExercise> getAerobicExercises(){
        return aerobicExercises;
    }
    
    public ArrayList<WeightExercise> getWeightExercises(){
        return weightExercises;
    }
    
    @Override 
       public String toString(){
        return firstName + " "  + lastName;
    }
}
