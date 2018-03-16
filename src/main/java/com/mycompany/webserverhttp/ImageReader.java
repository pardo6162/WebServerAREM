/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author andres
 */
public class ImageReader {
    private String pathFile;
    private  File image;
        public ImageReader(String pathFile){
            this.pathFile=pathFile;
            image=new File(pathFile);
        }
        
        public byte[] loadImage(){
            byte[] data =null;
            try { 
                FileInputStream inFile = new FileInputStream(image);
                data =new byte[(int) image.length()];
                inFile.read(data);
                inFile.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ImageReader.class.getName()).log(Level.SEVERE, null, ex);
            } catch(IOException ex){
                System.err.println("Error en la lectura de el archivo");
            }  
            
            
            return data;
            
        }
        
        public int getImgLength(){
            return  (int) image.length();
        }
}
