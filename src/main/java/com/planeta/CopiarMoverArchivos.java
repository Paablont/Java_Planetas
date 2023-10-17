package com.planeta;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

/**
 * Clase que contiene los metodos para copiar y mover archivos y directorios
 * @author Pablo, Ramon
 */
public class CopiarMoverArchivos {
    
    public static void copiarArchivo(){
        File archivoOrigen = new File(Planeta.archivoTXT);
        File archivoNuevo = new File("." + File.separatorChar +"copiaArchivoTXT.txt");
        
         try {
            // Copiar el archivo
            Path origen = archivoOrigen.toPath();
            Path destino = archivoNuevo.toPath();
            Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);

             JOptionPane.showMessageDialog(null, "Archivo copiado correctamente en el mismo directorio del proyecto", "Mensaje ID", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            PlanetaApp.logger.error("No se ha podido copiar el fichero txt");
        }
    }
    public static void copiaSeguridadADirectorio(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int resultado = fileChooser.showDialog(null, "Seleccionar Carpeta de Destino");

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File carpetaDestino = fileChooser.getSelectedFile();
            File carpetaOrigen = new File("archivos"); // Ruta de la carpeta "archivos" en la raíz del programa

            try {
                // Verificar si la carpeta de destino existe, si no, crearla
                if (!carpetaDestino.exists()) {
                    carpetaDestino.mkdirs();
                }
                // Obtener la lista de archivos y subcarpetas en la carpeta de origen
                File[] archivos = carpetaOrigen.listFiles();

                // Copiar cada archivo/subcarpeta al directorio de destino
                for (File archivo : archivos) {
                    Path origen = archivo.toPath();
                    Path destino = new File(carpetaDestino, archivo.getName()).toPath();

                    Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
                }
                JOptionPane.showMessageDialog(null, "Copia selectiva completa en la carpeta de destino.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al realizar la copia selectiva.");
                ex.printStackTrace();
            }
        }
    }
    public static void copiaSeguridadADocumentos(){
        // Ruta de la carpeta "archivos" en la raíz del programa
        File carpetaOrigen = new File("archivos");

        // Lamamos a FileSystemView.getFileSystemView().getDefaultDirectory() para buscar la carpeta Documentos
        File carpetaDestino = FileSystemView.getFileSystemView().getDefaultDirectory();

        // Hacemos la carpeta CopiaSeguridadPlanetas
        String subcarpetaNombre = "CopiaSeguridadPlanetas";

        if (subcarpetaNombre != null && !subcarpetaNombre.isEmpty()) {
            carpetaDestino = new File(carpetaDestino, subcarpetaNombre);
        }

        try {
            // Verificar si la carpeta de destino existe, si no, crearla
            if (!carpetaDestino.exists()) {
                carpetaDestino.mkdirs();
            }

            // Obtener la lista de archivos y subcarpetas en la carpeta de origen
            File[] archivos = carpetaOrigen.listFiles();

            // For que recorre la lista de archivos y los va copiando
            for (File archivo : archivos) {
                Path origen = archivo.toPath();
                Path destino = new File(carpetaDestino, archivo.getName()).toPath();

                Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
            }
            JOptionPane.showMessageDialog(null, "Copia de seguridad completada");
        } catch (IOException ex) {
             JOptionPane.showMessageDialog(null, "Error al realizar la copia");
            ex.printStackTrace();
        }
    }
}
