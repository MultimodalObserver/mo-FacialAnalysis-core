/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facialAnalysisCore;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import facialAnalysisCore.Emotion;
import facialAnalysisCore.FacialAnalyser;
import facialAnalysisCore.FacialAnalysis;
import facialAnalysisCore.FileDescriptorMaker;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.json.JSONObject;
import static mo.core.DataFileFinder.findFilesCreatedBy;
import mo.core.ui.dockables.DockableElement;
import mo.core.ui.dockables.DockablesRegistry;
import mo.organization.Organization;
import mo.organization.Participant;
import mo.organization.ProjectOrganization;
import static mo.organization.ProjectOrganization.logger;

/**
 *
 * @author gustavo
 */
public class SendVideoWindow extends javax.swing.JFrame {

    private File dir;
    private List<File> videoFiles;
    private List<File> jsonFiles;
    private FacialAnalyser analyser;
    private DefaultTableModel rowsModel;
    private ArrayList<Request> requests;
    private Participant participant;
    private String creator;
    
    public SendVideoWindow() {
        initComponents();
    }

    public SendVideoWindow(File dir, Participant participant ,FacialAnalyser analyser) {

       /*** getting component's data*****/
       
        // set folder and analyser
        this.analyser = analyser;
        this.participant = participant;
        this.creator = analyser.getClass().getName();
        
        if (dir.isDirectory()) {
            this.dir = dir;
        } else {
            System.out.println("The file dont's a folder");
            this.dir = null;
            this.dispose();
        }
            
     
        
        //get video files from folder
        this.videoFiles= findFilesCreatedBy(new File(this.dir.getPath()),"webcamcaptureplugin.WebcamRecorder");

                
        //get json files from folder
        //si no funciona borrar esta linea 
        this.jsonFiles=findFilesCreatedBy(new File(this.dir.getPath()),creator+".incomplete");
;
     
        
        //get Requests from json files
        this.requests = requestsFromFiles(this.jsonFiles);   
        
        
        
        this.setLocationRelativeTo(null);
        initComponents();
        this.setLocationRelativeTo(null);
    
        /*** adding data to components*****/
        
        //add files to files combo box
        for (File f : this.videoFiles) {
            this.videoListComboBox.addItem(f.getName());
        }
        
        //make table
        initTable(this.requests, this.analysisTable);
        this.rowsModel = (DefaultTableModel) this.analysisTable.getModel();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        analysisTable = new javax.swing.JTable();
        videoListComboBox = new javax.swing.JComboBox<>();
        cancelPetitionButton = new javax.swing.JButton();
        sendVideoButton = new javax.swing.JButton();
        removeAnalisisButton = new javax.swing.JButton();
        showResultsButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        timeStampsCheckBox = new javax.swing.JCheckBox();
        timeStampsSpinner = new javax.swing.JSpinner();
        percentLabel = new javax.swing.JLabel();
        percentLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        analysisTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Video", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(analysisTable);

        cancelPetitionButton.setText("Cancelar Envio");
        cancelPetitionButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelPetitionButtonMouseClicked(evt);
            }
        });

        sendVideoButton.setText("Enviar video");
        sendVideoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sendVideoButtonMouseClicked(evt);
            }
        });
        sendVideoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendVideoButtonActionPerformed(evt);
            }
        });

        removeAnalisisButton.setText("EliminarAnalisis");
        removeAnalisisButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeAnalisisButtonMouseClicked(evt);
            }
        });

        showResultsButton.setText("Obtener Resultados");
        showResultsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showResultsButtonMouseClicked(evt);
            }
        });

        timeStampsCheckBox.setSelected(true);
        timeStampsCheckBox.setText("Generar TimeStamps automaticamente");
        timeStampsCheckBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                timeStampsCheckBoxMouseClicked(evt);
            }
        });

        timeStampsSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 5));
        timeStampsSpinner.setToolTipText("determinar el procentaje de sensibilidad para generar los timeStamps");

        percentLabel.setText("Detectar al");

        percentLabel2.setText("%");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(videoListComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sendVideoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cancelPetitionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(removeAnalisisButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(timeStampsCheckBox)
                                .addGap(43, 43, 43)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(showResultsButton, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(percentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(timeStampsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(percentLabel2)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(videoListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendVideoButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeAnalisisButton)
                    .addComponent(showResultsButton)
                    .addComponent(cancelPetitionButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeStampsCheckBox)
                    .addComponent(timeStampsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(percentLabel)
                    .addComponent(percentLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendVideoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendVideoButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sendVideoButtonActionPerformed

    private void sendVideoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendVideoButtonMouseClicked
        
        //obtain index of element
         int selection = this.videoListComboBox.getSelectedIndex();

       //make the request's analysis objet 
         FacialAnalysis temp = new FacialAnalysis();
         temp.setStatus("Enviando ...");
         temp.setVideoName(this.videoListComboBox.getItemAt(selection));
         Request newRequest = new Request(temp);  
         this.requests.add(newRequest);
         makeTable2(requests, analysisTable);

        //create register of analysis
                
        
        Thread playerThread = new Thread(() -> {
        
            int s = selection+0;

            
            //send video and get id code
            //String id = this.analyser.sendVideo(this.videoFiles[selection]);
            newRequest.setFuture(this.analyser.uploadVideoAsync(this.videoFiles.get(s)));
            String id = newRequest.getActual().getId();
            
            //update
             try {
                 
                 newRequest.setActual((FacialAnalysis) newRequest.getFuture().get());
                 
                 
                 if(!newRequest.getFuture().isCancelled()){
                //set new status of video uploaded request and export to json
                newRequest.getActual().setStatus("En linea");
                String videoName = newRequest.getActual().getVideoName() ;
                if(videoName.contains(".")){videoName=videoName.substring(0,videoName.indexOf("."));}
                this.analyser.analysisToFile(newRequest.getActual(),this.dir+"\\analysis\\"+videoName+"_"+newRequest.getActual().getId()+".request" );
                //refresh table
                makeTable2(this.requests, analysisTable);
                }
                 
             } catch (InterruptedException ex) {
                 System.out.println("upload cancelled");
             } catch (ExecutionException ex) {
                 System.out.println("upload cancelled");
//                 Logger.getLogger(SendVideoWindow.class.getName()).log(Level.SEVERE, null, ex);
             } catch (CancellationException ex){
                 System.out.println("upload cancelled");
                 return;
             }
        
             });
        
                           
        SwingUtilities.invokeLater(() -> {
                     playerThread.start();          
        } ); 
        
    }//GEN-LAST:event_sendVideoButtonMouseClicked

    private void showResultsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showResultsButtonMouseClicked
         
     
        //obtain index of element
         int selection = this.analysisTable.getSelectedRow();
        
         //obtain analysis from list of analysis
         Request request = this.requests.get(selection);
         FacialAnalysis analysis = request.getActual();
         
         //if analysis is null
         //un mensaje 
         
         //gettting id of anlysis
         String id = analysis.getId();
         Thread playerThread = new Thread(() -> {

             //prepare table
            analysis.setStatus("Consultando...");
            makeTable2(requests, analysisTable);

            //updating request data
             request.setFuture(this.analyser.updateAsync(analysis));
             try {

                 request.setActual((FacialAnalysis) request.getFuture().get());
              
             } catch (InterruptedException ex) {
                 Logger.getLogger(SendVideoWindow.class.getName()).log(Level.SEVERE, null, ex);
             } catch (ExecutionException ex) {
                 Logger.getLogger(SendVideoWindow.class.getName()).log(Level.SEVERE, null, ex);
             } catch (CancellationException ex){
                 System.out.println("upload cancelled");
                 return;
             }

             if(request.getFuture().isCancelled()){
                 return;
             }
            //if null reuqest    
             
            //analysis.setStatus("Completado");
            this.makeTable2(requests, analysisTable);
            
            if(this.timeStampsCheckBox.isSelected()){
              
               writeTimeStampsForAnalysis(analysis,
                                          new Double((int)this.timeStampsSpinner.getValue())/100,
                                          new File(this.dir.getPath()+"\\analysis"),
                                          analysis.getVideoName()+"timeStamp_");
            }
                
            File resultDir = new File(this.dir.getAbsolutePath()+"\\analysis");
            if(!resultDir.isDirectory()){resultDir.mkdir();}
            String videoName= analysis.getVideoName();
            if(videoName.contains(".")){videoName=videoName.substring(0,videoName.indexOf("."));}
            this.analyser.analysisToFile(analysis, resultDir.getPath()+"\\"+ videoName +"_" +analysis.getId()+"_"+analysis.getStatus()+".json");
            File del = new File(this.dir+"\\analysis\\"+videoName+"_"+analysis.getId()+".json");
            del.delete();
            
         });
         
        SwingUtilities.invokeLater(() -> {playerThread.start();});
                          
    }//GEN-LAST:event_showResultsButtonMouseClicked

    private void cancelPetitionButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelPetitionButtonMouseClicked

        int selected =  this.analysisTable.getSelectedRow();
        if(this.requests.get(selected).getFuture()!=null){
            this.requests.get(selected).cancelFuture();
            this.requests.get(selected).getActual().setStatus("cancelado");
            this.makeTable2(requests, analysisTable);
        }  
    }//GEN-LAST:event_cancelPetitionButtonMouseClicked

    private void timeStampsCheckBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timeStampsCheckBoxMouseClicked
      
      if(!this.timeStampsCheckBox.isSelected()){
                this.timeStampsSpinner.setEnabled(false);
                this.percentLabel.setEnabled(false);
                this.percentLabel2.setEnabled(false);
      }else{
          if(this.timeStampsCheckBox.isSelected()){
                this.timeStampsSpinner.setEnabled(true);
                this.percentLabel.setEnabled(true);
                this.percentLabel2.setEnabled(true);          
          }
      }        
    }//GEN-LAST:event_timeStampsCheckBoxMouseClicked

    private void removeAnalisisButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeAnalisisButtonMouseClicked
               
                int selected =  this.analysisTable.getSelectedRow();
                FacialAnalysis analysis = this.requests.get(selected).getActual();
                
                String videoName = analysis.getVideoName();
                if(videoName.contains(".")){videoName=videoName.substring(0,videoName.indexOf("."));}                
                File del1 = new File(this.dir+"\\analysis\\"+videoName+"_"+analysis.getId()+".request");
                File del2 = new File(this.dir+"\\analysis\\"+videoName+"_"+analysis.getId()+".desc");
                
                
                if(selected >= 0){
                    if(this.requests.get(selected).getFuture()!=null){
                       this.requests.get(selected).getFuture().cancel(true);
                    }
                    
                    this.requests.remove(selected);
                    
                    if(del1.exists()){
                        del1.delete();
                    }
                    
                    if(del2.exists()){
                        del2.delete();
                    }                    
                    
                }
                makeTable2(this.requests, analysisTable);  
    }//GEN-LAST:event_removeAnalisisButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SendVideoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SendVideoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SendVideoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SendVideoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SendVideoWindow().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable analysisTable;
    private javax.swing.JButton cancelPetitionButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel percentLabel;
    private javax.swing.JLabel percentLabel2;
    private javax.swing.JButton removeAnalisisButton;
    private javax.swing.JButton sendVideoButton;
    private javax.swing.JButton showResultsButton;
    private javax.swing.JCheckBox timeStampsCheckBox;
    private javax.swing.JSpinner timeStampsSpinner;
    private javax.swing.JComboBox<String> videoListComboBox;
    // End of variables declaration//GEN-END:variables

    //create a extension filter for files
    private FilenameFilter makeExtensionNameFilter(String... extensionFilters) {

        return new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                for (String ext : extensionFilters) {
                    if (name.toLowerCase().endsWith(ext)) {
                        return true;
                    };
                }
                return false;
            }
        };
    }

    //make table with the analysis list
    private void makeTable(ArrayList<FacialAnalysis> baseList, javax.swing.JTable table) {
          
        if(table==null){return;}
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        while(model.getRowCount()>0){
            model.removeRow(0);
        }

        for(FacialAnalysis a : baseList){
            Object nuevo[]= {a.getVideoName(),a.getStatus()}  ;
            model.addRow(nuevo);   
        }
    }
    
    //make table with the analysis list
    private void makeTable2(ArrayList<Request> baseList, javax.swing.JTable table) {
          
        if(table==null){return;}
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        while(model.getRowCount()>0){
            model.removeRow(0);
        }

        for(Request r : baseList){
            Object nuevo[]= {r.getActual().getVideoName(),r.getActual().getStatus()}  ;
            model.addRow(nuevo);   
        }
    }
    
    
    
    public void initTable(ArrayList<Request> baseList, javax.swing.JTable table){
        if(table==null){return;}
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        for(Request r : baseList){
            Object nuevo[]= {r.getActual().getVideoName(),r.getActual().getStatus()}  ;
            model.addRow(nuevo);   
        }
    }

    //get a facial analysis list with a array of files
    private ArrayList<FacialAnalysis> analysisFromFiles(File[] jsonFiles) {
        
        ArrayList<FacialAnalysis> analysisList = new ArrayList<FacialAnalysis>(); 
        
        for(File jf : jsonFiles){
            FacialAnalysis analysis = this.analyser.analysisFromFile(jf.getAbsolutePath());
            if(analysis!=null){
                analysisList.add(analysis);
            }
        }
        return analysisList;
    }
    
    
    private ArrayList<Request> requestsFromFiles(List<File> jsonFiles) {
        
        ArrayList<Request> requestsList = new ArrayList<Request>(); 
        
        for(File jf : jsonFiles){
            if(jf!=null){
                FacialAnalysis analysis = this.analyser.analysisFromFile(jf.getAbsolutePath());
                    if(analysis!=null){
                        requestsList.add(new Request(analysis));
                    }
            }
        }
        return requestsList;
    }
    
    private void writeTimeStampsForAnalysis(FacialAnalysis analysis, Double referenceValue, File outputDir, String name){
    
        ArrayList<Emotion> emotions = analysis.getPerson(0).getEmotions();
        
        for(Emotion e : emotions){
            
            e.makeTimeStamps(referenceValue);
            e.timeStampsToFile(outputDir.getPath()+"\\"+name+"_"+e.getName()+".txt");
            FileDescriptorMaker.makeFileDescriptor(new File(outputDir.getPath()+"\\"+name+"_"+e.getName()+".txt"),
                                                    "creator="+creator,
                                                    "compatible=mo.analysis.NotesRecorder",
                                                    "captureFile=..\\" + analysis.getVideoName());
        }
        
    }
    
    
    

}
