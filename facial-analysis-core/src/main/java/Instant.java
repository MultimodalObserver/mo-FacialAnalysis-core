/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facialAnalysisCore;


public class Instant {

    private Double value;
    private long time;
    private long Distance;


    public void setDistance(long Distance) {
        this.Distance = Distance;
    }

    public long getDistance() {
        return Distance;
    }


    public Instant(long time, Double value) {
        this.value = value;
        this.time = time;
    }
    

    public void setValue(Double value) {
        this.value = value;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Double getValue() {
        return value;
    }

    public long getTime() {
        return time;
    }
    
    
    
}
