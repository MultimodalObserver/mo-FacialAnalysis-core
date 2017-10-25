
package facialAnalysisCore;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
import mo.organization.FileDescription;

public class FacialAnalysis {
    
    private ArrayList<Person> persons;
    private HttpResponse<JsonNode> originalBody;

    
    private FacialAnalyser analyser;
    private String id;

    private int duration;
    private String videoName;
    private String videoUrl;
    private String videoPath;
    private String jsonFilePath;
    
    private String status;
    private String name;
    
    private long start;
    private long end;

     
    public FacialAnalysis(){
    
    }
    
    public FacialAnalysis(FacialAnalyser analyser) {
        this.analyser = analyser;
        this.jsonFilePath = null;
    }

    public FacialAnalysis(FacialAnalyser analyser, String id, String videoName, String status) {
        this.analyser = analyser;
        this.id = id;
        this.videoName = videoName;
        this.status = status;
    }

    public FacialAnalysis(FacialAnalyser analyser, String id, String videoName) {
        this.analyser = analyser;
        this.id = id;
        this.videoName = videoName;
    }

    
    public FacialAnalysis(ArrayList<Person> persons, FacialAnalyser analyser, String id) {
        this.persons = persons;
        this.analyser = analyser;
        this.id = id;
    }
    
    

    public FacialAnalysis(ArrayList<Person> persons, HttpResponse<JsonNode> originalBody, FacialAnalyser analyser, String id) {
        this.persons = persons;
        this.originalBody = originalBody;
        this.analyser = analyser;
        this.id = id;
        this.jsonFilePath = null;
    }

    
    
    public FacialAnalysis(HttpResponse<JsonNode> originalBody, FacialAnalyser analyser) {
        this.originalBody = originalBody;
        this.analyser = analyser;
        this.jsonFilePath = null;
    }

    public FacialAnalysis(FacialAnalyser analyser, String jsonFilePath) {
        this.analyser = analyser;
        this.jsonFilePath = jsonFilePath;
    }


    public FacialAnalysis(ArrayList<Person> people, String id, String videoName, String videoUrl, String vidoPath) {
        this.persons = people;
        this.id = id;
        this.videoName = videoName;
        this.videoUrl = videoUrl;
        this.videoPath = vidoPath;
        this.jsonFilePath=null;
    }

    public FacialAnalysis(ArrayList<Person> people, HttpResponse<JsonNode> originalBody, FacialAnalyser analyser, String id, int duration, String videoName, String videoUrl, String vidoPath) {
        this.persons = people;
        this.originalBody = originalBody;
        this.analyser = analyser;
        this.id = id;
        this.duration = duration;
        this.videoName = videoName;
        this.videoUrl = videoUrl;
        this.videoPath = vidoPath;
    }

    public FacialAnalysis(HttpResponse<JsonNode> originalBody, FacialAnalyser analyser, String id, int duration, String videoName, String videoUrl, String vidoPath) {
        this.originalBody = originalBody;
        this.analyser = analyser;
        this.id = id;
        this.duration = duration;
        this.videoName = videoName;
        this.videoUrl = videoUrl;
        this.videoPath = vidoPath;
    }

    public FacialAnalysis(String jsonFilePath) {
        this.jsonFilePath = jsonFilePath;
    }
    
    public FacialAnalysis(File jsonFile) {
        this.jsonFilePath = jsonFile.getPath();
    }
    
    public void addPerson(Person person){
        if(this.persons == null){this.persons = new ArrayList<Person>();}
        this.persons.add(person);
    
    }
       
    public ArrayList<Person> getPersons() {
        return persons;
    }
    
    public Person getPerson(int index){
        if(this.persons==null){return new Person();}
        return this.persons.get(index);
    }
    
    public HttpResponse<JsonNode> getOriginalBody() {
        return originalBody;
    }

    public int getDuration() {
        return duration;
    }

    public String getVideoName() {
        return videoName;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public String getJsonFilePath() {
        return jsonFilePath;
    }

    public FacialAnalyser getAnalyser() {
        return analyser;
    }

    public String getId() {
        return id;
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }

    public void setOriginalBody(HttpResponse<JsonNode> originalBody) {
        this.originalBody = originalBody;
    }

    public void setAnalyser(FacialAnalyser analyser) {
        this.analyser = analyser;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public void setJsonFilePath(String jsonFilePath) {
        this.jsonFilePath = jsonFilePath;
    }
    
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public void setEnd(long end) {
        this.end = end;
    }
    

    
    

}
