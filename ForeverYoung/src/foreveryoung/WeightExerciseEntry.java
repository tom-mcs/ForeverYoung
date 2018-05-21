/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

import java.time.LocalDateTime;

/**
 *
 * @author Admin
 */
public class WeightExerciseEntry extends Entry{
    private Set set1;
    private Set set2;
    
    public WeightExerciseEntry(LocalDateTime date, Set set1, Set set2){
        this.date = date;
        this.set1 = set1;
        this.set2 = set2;
    }

    public Set getSet1() {
        return set1;
    }

    public Set getSet2() {
        return set2;
    }
    
    @Override
    public String toString() {
        return "Entry{" + "set1=" + set1 + ", set2=" + set2 + '}';
    }   
    
}
