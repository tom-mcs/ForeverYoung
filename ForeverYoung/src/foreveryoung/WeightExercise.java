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
 * @author Matt
 */
public class WeightExercise extends Exercise {
    
    public WeightExercise(String name) {
        super(name);
        type = "weight";
        entries = new ArrayList<>();
    }

    public WeightExerciseEntry addEntry(int set1Weight, int set1Reps, int set2Weight, int set2Reps) {
        Set set1 = new Set(set1Weight, set1Reps);
        Set set2 = new Set(set2Weight, set2Reps);
        LocalDateTime date = LocalDateTime.now();
        WeightExerciseEntry entry = new WeightExerciseEntry(date, set1, set2);
        entries.add(entry);
        return entry;
    }
    
    public boolean addEntry(int set1Weight, int set1Reps, int set2Weight, int set2Reps, LocalDateTime date) {
        if(set1Weight < 0 || set2Weight < 0 ||set1Reps < 0 ||set2Reps < 0){
            return false;
        }
        Set set1 = new Set(set1Weight, set1Reps);
        Set set2 = new Set(set2Weight, set2Reps);
        WeightExerciseEntry entry = new WeightExerciseEntry(date, set1, set2);
        return entries.add(entry);
    }
    
    private ArrayList<WeightExerciseEntry> entries;
    
    public ArrayList<WeightExerciseEntry> getEntries(){
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
    
    
    
}
