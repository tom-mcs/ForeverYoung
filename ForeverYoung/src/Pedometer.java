import java.time.Instant;
import java.util.ArrayList;
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
    
    private ArrayList<Pedometer> table = new ArrayList();
    ArrayList<String> dates;
    ArrayList<Integer> steps;
    
    
    public Pedometer() {
       
    }       
    
    public void addDay(int steps){
        Integer i = steps;
        Date date = Date.from(Instant.now());
        System.out.println(date.toString()); //
        this.dates.add(date.toString());
        this.steps.add(steps);
        if (dates.size() == steps);
    }
    
    public Integer getSteps(String date) {
        int index = dates.indexOf(date);
        return steps.get(index);
        
    }
      
    
    @Override
    public String toString() {
        return table.toString();
    }
    
}
