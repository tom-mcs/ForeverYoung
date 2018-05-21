/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class AerobicExercise extends Exercise {
    
    public AerobicExercise(String name) {
        super(name);
        entries = new ArrayList<>();
        type = "aerobic";
    }
   
    public AerobicExerciseEntry addEntry(int minutes){
        LocalDateTime date = LocalDateTime.now();
        AerobicExerciseEntry entry = new AerobicExerciseEntry(date, minutes);
        entries.add(entry);
        return entry;
    }
    
    //overloaded method for when the date needs to be specified rather than just being the current time
    public boolean addEntry(int minutes, LocalDateTime date){
        return entries.add(new AerobicExerciseEntry(date, minutes));
    }
    
    private ArrayList<AerobicExerciseEntry> entries;
    
    public ArrayList<AerobicExerciseEntry> getEntries(){
        return entries;
    }
    
    public int getNumberOfEntries(){
        return entries.size();
    }
    
    public boolean RemoveEntry(int i){
        if (entries.size()<= i){
            return false;
        }
        entries.remove(i);
        return true;
    }
      
    @Override
    public String toString(){
        return name;
    }
 
}
