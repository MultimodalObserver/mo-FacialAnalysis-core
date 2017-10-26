
package facialAnalysisCore;

import java.util.ArrayList;


public class Person {

    private ArrayList<Emotion> emotions;
    private ArrayList<TimeStamp> timeStamps;

    
    public Person(){
        this.emotions = new ArrayList<Emotion>();
    }
    
    public Person(String... emotions)
    {
        this.emotions = new ArrayList<Emotion>();
        for(String e : emotions){
            this.emotions.add(new Emotion(e));
        }
    }

    
    public ArrayList<Emotion> getEmotions() {
        return emotions;
    }
    
    public Emotion getEmotion(int index){
        return this.emotions.get(index);
    }
    
    public ArrayList<TimeStamp> makeTimeStamps(Double detectionValue){
    
        timeStamps = new ArrayList<>();
        
        for( Emotion e :emotions){
            for(int i=0 ; i<e.getInstants().size();i++ ){
                Instant instant = e.getInstants().get(i);
                if(instant.getValue()>= detectionValue){
                    long start = instant.getTime(), end;
                    
                    while(i<e.getInstants().size()&&instant.getValue()>= detectionValue){
                            instant = e.getInstants().get(i);
                            i++;

                    }
                    
                    end= instant.getTime();
                    timeStamps.add(new TimeStamp(start,
                                                 end,
                                                 detectionValue,
                                                 e.getName()+">"+(detectionValue*100)+"%"));
                }
            }
            
        }
        
        return timeStamps;
    }
    
    
}
