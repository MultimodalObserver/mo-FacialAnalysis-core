
package facialAnalysisCore;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.Future;


public abstract class FacialAnalyser {
    
    protected String urlBase; //url base del servicio web a utilizar
    
    protected String userAlias; //nombre que utiliza el servicio para el user (ejemplo: user, appy_user, appyAplicattion , etc)
    protected String user; //usuario o appy_user/ appy_name u otro parametro similar
    
    protected String keyAlias; //nombre que utiliza el servicio para la key (ejemplo: appykey, appy_key, credential, etc)
    protected String key; //key de la api a utilizar
    

    public FacialAnalyser(){}
    
    public FacialAnalyser(String urlBase, String userAlias, String user, String keyAlias, String key, String idAlias, String sourceAlias) {
        this.urlBase = urlBase;
        this.userAlias = userAlias;
        this.user = user;
        this.keyAlias = keyAlias;
        this.key = key;
    }
    

    /*** nuevos/aun en uso***/
    
    public abstract FacialAnalysis uploadVideo(String urlOrPath); 
    public abstract FacialAnalysis uploadVideo(File file); 
    
    public abstract Future<FacialAnalysis> uploadVideoAsync(String urlOrPath); 
    public abstract Future<FacialAnalysis> uploadVideoAsync(File file); 
    
    public abstract FacialAnalysis update(FacialAnalysis analysis); 
    public abstract Future<FacialAnalysis> updateAsync(FacialAnalysis analysis); 

    public abstract FacialAnalysis analysisFromFile(String jsonPath);
    public abstract boolean analysisToFile(FacialAnalysis analysis, String path);

}
