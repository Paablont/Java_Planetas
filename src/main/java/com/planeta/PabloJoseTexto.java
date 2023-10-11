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
import javax.swing.JOptionPane;

/**
 *
 * @author jose1
 */
public class PabloJoseTexto {

    /**
     *
     * @author Jose
     */
    public static void escribirTexto(Planeta p) {
        String archivoTexto = ".\\archivos\\planetas.txt";
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(archivoTexto, StandardCharsets.UTF_8, true));) {
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
     * @author Pablo Villaseñor
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
}
  

