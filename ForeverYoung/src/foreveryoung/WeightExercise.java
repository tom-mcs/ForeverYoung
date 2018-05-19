/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

import java.time.LocalDateTime;

/**
 *
 * @author Matt
 */
public class WeightExercise extends Exercise {

    public class Entry extends Exercise.Entry{        
        Set set1;
        Set set2;
        public Entry(LocalDateTime date, Set set1, Set set2){
            this.date = date;
            this.set1 = set1;
            this.set2 = set2;
        }

        @Override
        public String toString() {
            return "Entry{" + "set1=" + set1 + ", set2=" + set2 + '}';
        }      
    }
    
    public class Set {
        int weight;
        int reps;
        public Set(int weight, int reps) {
            this.weight = weight;
            this.reps = reps;
        }

        @Override
        public String toString() {
            return "Set{" + "weight=" + weight + ", reps=" + reps + '}';
        }
        
    }
    
    public WeightExercise(String name) {
        super(name);
        type="weight";
    }

    public Entry addEntry(int set1Weight, int set1Reps, int set2Weight, int set2Reps) {
        Set set1 = new Set(set1Weight, set1Reps);
        Set set2 = new Set(set2Weight, set2Reps);
        LocalDateTime date = LocalDateTime.now();
        Entry entry = new Entry(date, set1, set2);
        entries.add(entry);
        return entry;
    }
    
    public boolean addEntry(int set1Weight, int set1Reps, int set2Weight, int set2Reps, LocalDateTime date) {
        Set set1 = new Set(set1Weight, set1Reps);
        Set set2 = new Set(set2Weight, set2Reps);
        Entry entry = new Entry(date, set1, set2);
        return entries.add(entry);
    }
    
}
