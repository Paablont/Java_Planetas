package com.planeta;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Clase con los metodos para escribir objetos en ficheros RAF de satelites y
 * lectura del fichero RAF con los satelites de cada planeta
 *
 * @author @Pablo Villaseñor Ruiz y Jose
 */
public class PabloJoseRAF {

    /**
     * Metodo que escribe un objeto nuevo satelite
     *
     * @author Pablo
     */
    public static void escribirRAF(Satelite s) {

    }

    /**
     * Genera el .dat con los satelites iniciales de los planetas iniciales
     *
     * @author Pablo
     */
    public static void crearRAFiniciales(String archivoTXT, String archivoRAF, String archivoBinario) throws ClassNotFoundException {
        try (BufferedReader bfr = new BufferedReader(new FileReader(archivoTXT))) {
            String linea;
            while ((linea = bfr.readLine()) != null) {
                String[] separador = linea.split(",");
                if (separador.length == 2) {
                    int idPlaneta = Integer.parseInt(separador[0]);
                    String nombrePlaneta = separador[1].trim();
                    String rafNombre = archivoRAF + "satelites" + nombrePlaneta + ".dat";
                    
                    RandomAccessFile raf = new RandomAccessFile(rafNombre, "rw");
                    
                    
                }
            }
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
