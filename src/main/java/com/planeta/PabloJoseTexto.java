/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.planeta;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

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
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(archivoTexto, StandardCharsets.UTF_8,true));) {
            fw.append("ID: " + p.getIdPlaneta() + ", Nombre: " + p.getNombre());
            fw.newLine();
            fw.flush();
            fw.close();
        } catch (FileNotFoundException fn) {
            System.out.println("No se encuentra el fichero en la ruta indicada");
        } catch (IOException io) {
            System.out.println("Error de E/S ");
        }
    }
}
