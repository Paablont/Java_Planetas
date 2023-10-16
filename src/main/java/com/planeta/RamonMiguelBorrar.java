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
 *
 * @author ramon y migue
 */
public class RamonMiguelBorrar {

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
            e.printStackTrace();
        }

    }

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
                    System.out.println("No se pudo eliminar el archivo " + archivo.getName());
                }
            }
        }
    }

}
