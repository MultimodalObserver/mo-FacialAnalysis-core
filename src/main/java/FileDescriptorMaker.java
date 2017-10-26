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
import java.util.logging.Level;
import java.util.logging.Logger;
import mo.organization.FileDescription;

/**
 *
 * @author gustavo
 */
public class FileDescriptorMaker {
    
    public static void makeFileDescriptor(File outputFile, File descFile, String ... arguments ){
    
            //writting description file
        try (BufferedWriter descWritter = new BufferedWriter(new FileWriter(descFile))) {
            descWritter.write("file=" + relativePath(descFile, outputFile) + "\n");
            for(String a : arguments){
                descWritter.write(a+"\n");            
            }

        } catch (IOException ex) {
            Logger.getLogger(FileDescription.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void makeFileDescriptor(File outputFile, String ... arguments ){
    
        File descFile = new File(outputFile.getParent(),getNameWithoutExtension(outputFile)+".desc");
        
        //writting description file
        try (BufferedWriter descWritter = new BufferedWriter(new FileWriter(descFile))) {
            descWritter.write("file=" + relativePath(descFile, outputFile) + "\n");
            for(String a : arguments){
                descWritter.write(a+"\n");            
            }

        } catch (IOException ex) {
            Logger.getLogger(FileDescription.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private static String getNameWithoutExtension(File file) {
        String s = file.getName();
        if (s.contains(".")) {
            s = s.substring(0, s.lastIndexOf("."));
        }
        return s;
    }
    
    private static String relativePath(File file1, File file2) {
        Path f1 = file1.toPath();
        Path f2 = file2.toPath();
        Path relative = f1.relativize(f2);
        return relative.toString();
    }
    
}
