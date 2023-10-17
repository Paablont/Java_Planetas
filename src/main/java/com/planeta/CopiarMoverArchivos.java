package com.planeta;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import javax.swing.JOptionPane;

/**
 *
 * @author pablo y Ramon
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
}
