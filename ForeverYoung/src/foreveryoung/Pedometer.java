package foreveryoung;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryan_Lancer
 */
public class Pedometer {
    
    public class Entry{
        public LocalDateTime date;
        public int steps;
        
        public Entry(LocalDateTime date, int steps){
            this.date = date;
            this.steps = steps;
        }
        
        @Override
        public String toString() {
            return "Entry{" + "date=" + date + ", steps=" + steps + '}';
        }
    }
    
    private ArrayList<Entry> entries;

    public ArrayList<Entry> getEntries() {
        return entries;
    }
    
    public Pedometer(){
        entries = new ArrayList<>();
    }
    
    public boolean addEntry(int steps){
        LocalDateTime date = LocalDateTime.now();
        return entries.add(new Entry(date, steps));
    }
    
    public boolean addEntry(int steps, LocalDateTime date){
        return entries.add(new Entry(date, steps));
    }
    
    public boolean RemoveEntry(int i){
        if (entries.size()<= i){
            return false;
        }
        entries.remove(i);
        return true;
    }

    @Override
    public String toString() {
        return "Pedometer{" + "entries=" + entries + '}';
    }
    
}
