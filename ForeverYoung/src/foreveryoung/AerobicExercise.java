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
public class AerobicExercise {
    
    private class Entry{
        public LocalDateTime date;
        public int minutes;
        
        public Entry(LocalDateTime date, int minutes){
            this.date = date;
            this.minutes = minutes;
        }
    }
    
    private ArrayList<Entry> entries;
    private String name;
    
    public AerobicExercise(String name){
        this.name = name;
        entries = new ArrayList<>();
    }

    public ArrayList<Entry> getEntries(){
        return entries;
    }
    
    public int getNumberOfEntries(){
        return entries.size();
    }
    
    public String getName() {
        return name;
    }
    
    public boolean addEntry(int minutes){
        LocalDateTime date = LocalDateTime.now();
        return entries.add(new Entry(date, minutes));
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
