/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.planeta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Clase con los metodos para lectura y escritura con TXT
 * @author Pablo,Jose
 */
public class PabloJoseTexto {

    /**
     * Escribe los planetas en el TXT
     * @author Jose
     */
    public static void escribirTexto(Planeta p) {
        
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(Planeta.archivoTXT, StandardCharsets.UTF_8, true));) {
            fw.append(p.getIdPlaneta() + "," + p.getNombre());
            fw.newLine();
            fw.flush();
            fw.close();
        } catch (FileNotFoundException fn) {
            System.out.println("No se encuentra el fichero en la ruta indicada");
        } catch (IOException io) {
            System.out.println("Error de E/S ");
        }
    }

    /**
     * Metodo para leer el archivo de TXT con los ids y nombres de los planetas
     * @author Pablo
     */
    public static String leerFicheroTXT(String rutaArchivo) {
       
        String texto = "", linea = "";
        try {
            //Como leeremos un archivo, objeto de tipo FileReader
             FileReader fr = new FileReader(rutaArchivo);
             BufferedReader br = new BufferedReader(fr);

            //Recorremos archivo y la añadimos a texto
            while (((linea = br.readLine()) != null)) {
                texto += linea + "\n";

            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Archivo no encontrado" + e);
        }
       return texto; 
    }
    
    /**
     * Metodos para cargar los planetas iniciales en el TXT
     *  @author Jose
     */
    public static void escribirInicialesTXT(String rutaArchivo,ArrayList<Planeta> planetas){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
                for (Planeta planeta : planetas) {
                    writer.write(planeta.getIdPlaneta() + "," + planeta.getNombre());
                    writer.newLine();
                }
                System.out.println("Archivo de texto creado con éxito.");
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    /**
     * Para tener el último Id
     * @param num 
     * @author miguel
     */
        public static void escribirID(int num) {
        
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(Planeta.numeroIDTXT, StandardCharsets.UTF_8,false));) {
            String numStr = Integer.toString(num);
            fw.write(numStr);
            fw.flush();
            fw.close();
        } catch (FileNotFoundException fn) {
            System.out.println("No se encuentra el fichero en la ruta indicada");
        } catch (IOException io) {
            System.out.println("Error de E/S ");
        }
    }
}
  

