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
        type = "aerobic";
    }
        
    public class Entry extends Exercise.Entry{
        public int minutes;
        
        public Entry(LocalDateTime date, int minutes){
            this.date = date;
            this.minutes = minutes;
        }

        @Override
        public String toString() {
            return "Entry{" + "date=" + date + ", minutes=" + minutes + '}';
        }        
    }
   
    public Entry addEntry(int minutes){
        LocalDateTime date = LocalDateTime.now();
        Entry entry = new Entry(date, minutes);
        entries.add(entry);
        return entry;
    }
    
    //overloaded method for when the date needs to be specified rather than just being the current time
    public boolean addEntry(int minutes, LocalDateTime date){
        return entries.add(new Entry(date, minutes));
    }
      
    @Override
    public String toString(){
        return name;
    }
 
}
