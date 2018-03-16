/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author 2115237
 */
public class PageReader {
    private File page=null;
    private String filePath;
    
    public  PageReader(String filePath){
        page=new File(filePath);
        this.filePath=filePath;
    }
    
    public String loadPage(){
        String result="";
        try{
            FileReader fReader= new FileReader(page);
            BufferedReader bReader = new BufferedReader(fReader);
            String line;
            while((line = bReader.readLine())!= null)
                result+=line+"\n";
            bReader.close();
        }catch(FileNotFoundException ex){
            System.err.println("El recurso solicitado "+filePath +" no existe");
            ex.printStackTrace();
            
        }catch(IOException ex){
            System.err.println("Error en la lectura del Buffer");
            ex.printStackTrace();
        }
        
        return result;
    }
    
   
}
