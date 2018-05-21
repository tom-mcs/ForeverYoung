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
  
    protected String name;
    protected String type;
    
    public Exercise(String name){
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
            

    public String getType() {
        return type;
    }
        
    @Override
    public String toString(){
        return name;
    }
}
