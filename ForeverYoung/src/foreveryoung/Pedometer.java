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
    
    private class Entry{
        public LocalDateTime date;
        public int steps;
        
        public Entry(LocalDateTime date, int steps){
            this.date = date;
            this.steps = steps;
        }
    }
    
    private ArrayList<Entry> entries;
    private String name;
    
    public Pedometer(String name){
        this.name = name;
        entries = new ArrayList<>();
    }
    
    public boolean addEntry(int steps){
        LocalDateTime date = LocalDateTime.now();
        return entries.add(new Entry(date, steps));
    }
    
    public boolean RemoveEntry(int i){
        if (entries.size()<= i){
            return false;
        }
        entries.remove(i);
        return true;
    }
 
}
