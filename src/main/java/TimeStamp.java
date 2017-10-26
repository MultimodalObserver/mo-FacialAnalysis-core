/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facialAnalysisCore;

/**
 *
 * @author gustavo
 */
public class TimeStamp {
    
    long start;
    long end;
    Double value;
    String note;

    public TimeStamp(long start, long end, Double value, String note) {
        this.start = start;
        this.end = end;
        this.value = value;
        this.note = note;
    }
    

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }

    public String getNote() {
        return note;
    }

    public Double getValue() {
        return value;
    }
    
    
    
}
