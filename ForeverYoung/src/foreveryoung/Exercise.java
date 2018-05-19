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
abstract class Exercise {
        
    abstract class Entry{
        public LocalDateTime date;
              
    }    
    protected ArrayList<Entry> entries;
    protected String name;
    protected String type;
    
    public Exercise(String name){
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
            
    public boolean RemoveEntry(int i){
        if (entries.size()<= i){
            return false;
        }
        entries.remove(i);
        return true;
    }

    public String getType() {
        return type;
    }
        
    @Override
    public String toString(){
        return name;
    }
}
