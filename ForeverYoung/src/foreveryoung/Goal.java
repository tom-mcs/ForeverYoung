/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

/**
 *
 * @author Ivan Prga
 */
public class Goal {
    private String name;
    private String description;
    private boolean completed;
    private String user;
    
    public Goal(String goal, String description, String user){
        this.name = goal;
        this.description = description;
        this.user = user;
        completed = false;
    }

    public String getName() {
        return name;
    }

    public void setGoal(String goal) {
        this.name = goal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    
    @Override
    public String toString(){
        return name;
    }
}
