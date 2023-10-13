package com.planeta;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * Clase con los metodos para escribir objetos en ficheros RAF de satelites y
 * lectura del fichero RAF con los satelites de cada planeta
 *
 * @author @Pablo Villaseñor Ruiz y Jose
 */
public class PabloJoseRAF {

    /**
     * Metodo para escribir un satelite en su archivo correspondiente 
     *
     * @author Pablo
     */
    public static void escribirRAF(Satelite s, Planeta p) throws FileNotFoundException, IOException {
        String direccionRAF = Satelite.archivoRAF + "satelite" + p.getNombre() + ".dat";
        RandomAccessFile raf = new RandomAccessFile(new File(direccionRAF), "rw");

    int nuevoID = (int) (raf.length() / Satelite.TAMAÑO_REGISTRO) + 1; // Calcula el nuevo ID

    // Calcula la posición para insertar el nuevo registro
    long posicion = (nuevoID - 1) * Satelite.TAMAÑO_REGISTRO;
    raf.seek(posicion);
    raf.write(s.getNombreByteArray());
    raf.writeDouble(s.getDensidad());
    raf.writeChars(s.getFechaDescubrimiento());

    raf.close();  // Cierra el archivo
    }

    /**
     * Recoge la lista de planetas y escribe cada satelite en su archivo
     * correspondiente
     *
     * @author Pablo
     */
    public static void ingresarSatelite(ArrayList<Planeta> planetas) throws FileNotFoundException, IOException {
        for (Planeta p : planetas) {
            // Supongamos que tienes un ArrayList de satélites iniciales en cada objeto Planeta
            ArrayList<Satelite> satelitesIniciales = p.getSatelite();

            for (Satelite satelite : satelitesIniciales) {
                escribirRAF(satelite, p);
            }
        }

    }
    

}
