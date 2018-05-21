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
public class AerobicExerciseEntry extends Entry{
        public int minutes;
        
        public AerobicExerciseEntry(LocalDateTime date, int minutes){
            this.date = date;
            this.minutes = minutes;
        }

        @Override
        public String toString() {
            return "Entry{" + "date=" + date + ", minutes=" + minutes + '}';
        }        
}
