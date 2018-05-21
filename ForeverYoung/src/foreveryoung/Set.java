/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

/**
 *
 * @author Admin
 */
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
