package com.planeta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * Clase para borrar los ficheros segun se elija el id del planeta 
 * @author Ramon y Miguel
 */
public class BorrarArchivos {

    /**
     * Metodo que borra el planeta en el fichero TXT
     * @Ramon
     */
    public static void BorrarArchivoSecuencialPorId(int idBorrar) throws FileNotFoundException {
        String rutaArchivo = Planeta.archivoTXT;

        try {
            FileReader fr = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(fr);

            StringBuilder texto = new StringBuilder();
            String linea;

            while ((linea = br.readLine()) != null) {
                if (!linea.startsWith(Integer.toString(idBorrar)+",")) {
                    texto.append(linea).append("\n");
                }
            }

            br.close();

            FileWriter fw = new FileWriter(rutaArchivo);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(texto.toString());
            bw.close();

        } catch (IOException e) {
            PlanetaApp.logger.error("No se ha podido borrar el archivo");
        }

    }

    /**
     * Metodo que borra el fochero BINARIO de propiedades del planeta segun su ID
     * @author Ramon
     */
    public static void BorrarArchivoBinarioPorId(int idBorrar) {
        File carpeta = new File(Planeta.archivoBinario);

        if (carpeta.exists() && carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.matches(idBorrar + "_.*\\.bin");
                }
            });

            for (File archivo : archivos) {
                if (archivo.delete()) {
                    JOptionPane.showMessageDialog(null, "Archivo " + archivo.getName() + "Se  ha borrado correctamente", "Satelite", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    PlanetaApp.logger.error("No se ha encontrado el archivo");
                }
            }
        }
    }
    
    /**
     * Metodo que borra el fichero RAF satelites del planeta segun el id
     * @author Ramon 
     */
    public static void BorrarArchivoDatSatelites(int id){
        File carpeta = new File(Satelite.archivoRAF);

        if (carpeta.exists() && carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.matches(id +"satelite.*\\.dat");
                }
            });

            for (File archivo : archivos) {
                if (archivo.delete()) {
                } else {
                    PlanetaApp.logger.error("No se ha encontrado el archivo");
                }
            }
        }
    }

}
