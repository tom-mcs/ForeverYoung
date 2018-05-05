/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

import java.util.ArrayList;

/**
 *
 * @author Ivan Prga
 */
public class Goal {
    ArrayList<String> goal;
    
    private void Goal(String goal) {
        this.goal.add(goal);
    }

    public String getGoal(String goal) {
        return goal;
    }

    public String setGoal(String goal) {
        return goal;
    }
    
    
   public boolean isgoal(String goal){
       while (goal.isEmpty()){
           return false;    
   } return true;
   }
   @Override
   public String toString(){
       return goal.toString();
   }
}
