
package com.planeta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ramon y migue
 */
public class RamonMiguelBorrar {
    
    public static void BorrarArchivoSecuencialPorId(int idBorrar) throws FileNotFoundException{
        String rutaArchivo = Planeta.archivoTXT;
        
        try{
            FileReader fr = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(fr);
            
            StringBuilder texto = new StringBuilder();
            String linea;
            
            while ((linea = br.readLine()) != null){
                if(!linea.startsWith("ID: "+Integer.toString(idBorrar))){
                    texto.append(linea).append("\n");
                }
            }
            
            br.close();
            
            FileWriter fw = new FileWriter(rutaArchivo);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(texto.toString());
            bw.close();
            
            
        }catch (IOException e){
            e.printStackTrace();
        }
        
    }
    
}
