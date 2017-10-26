/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facialAnalysisCore;

import facialAnalysisCore.FacialAnalysis;
import java.util.concurrent.Future;

/**
 *
 * @author gustavo
 */
public class Request {
    
    private FacialAnalysis actual;
    private Future future;

    public Request(FacialAnalysis actual) {
        this.actual = actual;
        this.future = null;
    }

    public Request(Future future) {
        this.future = future;
        this.actual = null;
    }

    public FacialAnalysis getActual() {
        return actual;
    }

    public Future getFuture() {
        return future;
    }

    public void setActual(FacialAnalysis actual) {
        this.actual = actual;
    }

    public void setFuture(Future future) {
        this.future = future;
    }

    public boolean cancelFuture(){
        return this.getFuture().cancel(true);
    }

    
    
}
