package facialAnalysisCore;

import org.json.JSONObject;

public class Timestamp2 {

    private Double time;
    
    private Double anger ;
    private Double disgust;
    private Double fear;
    private Double joy;
    private Double sadness;
    private Double surprise;
    
    private String blinking;
    
    private Double attention;
    private Double dwell;
    private Double glances;
    
    private Double yaw;
    private Double pitch;
    private Double roll;
    
    private Double x;
    private Double y;
    private Double width;
    private Double height;
    private Double distance;
    
    public Timestamp2(){};

    public Timestamp2(Double time, Double anger, Double disgust, Double fear, Double joy, Double sadness, Double surprise) {
        this.time = time;
        this.anger = anger;
        this.disgust = disgust;
        this.fear = fear;
        this.joy = joy;
        this.sadness = sadness;
        this.surprise = surprise;
    }
    
    public Timestamp2(JSONObject builder)
    {
     //   this.time = builder.getInt("time");
        this.anger = builder.getDouble("anger");
        this.disgust = builder.getDouble("disgust");
        this.fear = builder.getDouble("fear");
        this.joy = builder.getDouble("joy");
        this.sadness = builder.getDouble("sadness");
        this.surprise = builder.getDouble("surprise");
    };
    
    public Timestamp2(Double time, JSONObject builder)
    {
        this.time = time;
        this.anger = builder.getDouble("anger");
        this.disgust = builder.getDouble("disgust");
        this.fear = builder.getDouble("fear");
        this.joy = builder.getDouble("joy");
        this.sadness = builder.getDouble("sadness");
        this.surprise = builder.getDouble("surprise");
    };

    @Override
    public String toString() {
        return "Timestamp{" + "time=" + time + ", anger=" + anger + ", disgust=" + disgust + ", fear=" + fear + ", joy=" + joy + ", sadness=" + sadness + ", surprise=" + surprise + '}';
    }

    public Double getTime() {
        return time;
    }

    public Double getAnger() {
        return anger;
    }

    public Double getDisgust() {
        return disgust;
    }

    public Double getFear() {
        return fear;
    }

    public Double getJoy() {
        return joy;
    }

    public Double getSadness() {
        return sadness;
    }

    public Double getSurprise() {
        return surprise;
    }

    public String getBlinking() {
        return blinking;
    }

    public Double getAttention() {
        return attention;
    }

    public Double getDwell() {
        return dwell;
    }

    public Double getGlances() {
        return glances;
    }

    public Double getYaw() {
        return yaw;
    }

    public Double getPitch() {
        return pitch;
    }

    public Double getRoll() {
        return roll;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public Double getWidth() {
        return width;
    }

    public Double getHeight() {
        return height;
    }

    public Double getDistance() {
        return distance;
    }
    
    
    
}
