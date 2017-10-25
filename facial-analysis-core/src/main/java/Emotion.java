/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facialAnalysisCore;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mo.organization.FileDescription;

public class Emotion {

    private String name;
    private ArrayList<Instant> instants;
    private ArrayList<TimeStamp> timeStamps;


    public Emotion(String name) {
        this.name = name;
    }

    public Emotion(String name, ArrayList<Instant> instants) {
        this.name = name;
        this.instants = instants;
    }

    public Emotion() {
        this.name= null;
        this.instants = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInstants(ArrayList<Instant> instants) {
        this.instants = instants;
    }

    public ArrayList<Instant> getInstants() {
        return instants;
    }
    
    public void addInstant(Instant instant){
        if(this.instants==null){this.instants = new ArrayList<Instant>();}
        this.instants.add(instant);
    }
    
    public void addInstant(long time, Double value){
        if(this.instants==null){this.instants = new ArrayList<Instant>();}
        Instant i = new Instant(time,value);
        this.instants.add(i);
    }
    
    public ArrayList<TimeStamp> makeTimeStamps(Double detectionValue){
    
        timeStamps = new ArrayList<>();
        if(this.instants==null){
            return timeStamps;
        }else{
            if(this.instants.size()<=0){
                return timeStamps;
            }
        }
        
            for(int i=0 ; i<this.instants.size();i++ ){
                Instant instant = this.instants.get(i);
                if(instant.getValue()>= detectionValue){
                    long start = instant.getTime(), end= instant.getTime();;
                    Double startValue= instant.getValue()  , endValue = instant.getValue();
                    
                    while(i<this.instants.size()&&instant.getValue()>= detectionValue){
                            end= instant.getTime();
                            endValue = instant.getValue();
                            instant = this.instants.get(i);
                            i++;
                    }
                    
                    timeStamps.add(new TimeStamp(start,
                                                 end,
                                                 detectionValue,
                                                 this.name+": "+ Math.round(startValue*100)+"%-"+Math.round(endValue*100)+"%"));
                }
            }
        
        
        return this.timeStamps;
    }
    
    public void timeStampsToFile(File outputFile){
    
        ArrayList<TimeStamp> outputTimeStamps = this.timeStamps;

            if(outputTimeStamps ==null){
                return ;
            }else{
                if(outputTimeStamps.size()<=0){
                    return;
                }
            }

        //writing output file
        try (BufferedWriter outputWritter = new BufferedWriter(new FileWriter(outputFile))) {
            for(TimeStamp outT : outputTimeStamps ){
                outputWritter.write(outT.getStart()+","+outT.getEnd()+","+outT.getNote()+"\n");   
            }
        } catch (IOException ex) {
            Logger.getLogger(FileDescription.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    }
    
    public void timeStampsToFile(File outputFile, ArrayList<TimeStamp> timeStamps){
    
        ArrayList<TimeStamp> outputTimeStamps = timeStamps;
        
            if(outputTimeStamps ==null){
                return ;
            }else{
                if(outputTimeStamps.size()<=0){
                    return;
                }
            }

        //writing output file
        try (BufferedWriter outputWritter = new BufferedWriter(new FileWriter(outputFile))) {
            for(TimeStamp outT : outputTimeStamps ){
                outputWritter.write(outT.getStart()+","+outT.getEnd()+","+outT.getNote()+"\n");   
            }
        } catch (IOException ex) {
            Logger.getLogger(FileDescription.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        
        
    }
    
    
    public void timeStampsToFile(String path){
    
        ArrayList<TimeStamp> outputTimeStamps = this.timeStamps;
        
             if(outputTimeStamps ==null){
                return ;
            }else{
                if(outputTimeStamps.size()<=0){
                    return;
                }
            }       
        
        File outputFile = new File(path);

        //writing output file
        try (BufferedWriter outputWritter = new BufferedWriter(new FileWriter(outputFile))) {

            for(TimeStamp outT : outputTimeStamps ){
                outputWritter.write(outT.getStart()+","+outT.getEnd()+","+outT.getNote()+"\n");   
            }
        } catch (IOException ex) {
            Logger.getLogger(FileDescription.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
    
    public void timeStampsToFile(String path, ArrayList<TimeStamp> timeStamps){
    
        ArrayList<TimeStamp> outputTimeStamps = timeStamps;
        
            if(outputTimeStamps ==null){
                return ;
            }else{
                if(outputTimeStamps.size()<=0){
                    return;
                }
            }        
        
        File outputFile = new File(path);
        
        //writing output file
        try (BufferedWriter outputWritter = new BufferedWriter(new FileWriter(outputFile))) {
            for(TimeStamp outT : outputTimeStamps ){
                outputWritter.write(outT.getStart()+","+outT.getEnd()+","+outT.getNote()+"\n");   
            }
        } catch (IOException ex) {
            Logger.getLogger(FileDescription.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }    
    
    
    
 
}
