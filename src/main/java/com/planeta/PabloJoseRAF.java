package com.planeta;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase con los metodos para escribir objetos en ficheros RAF de satelites y
 * lectura del fichero RAF con los satelites de cada planeta
 *
 * @author @Pablo Villaseñor Ruiz y Jose
 */
public class PabloJoseRAF {

    static File f = new File(Satelite.archivoRAF);

    /**
     * Metodo para escribir un satelite en su archivo correspondiente
     *
     * @author Pablo
     */
    public static void escribirRAF(Satelite s, Planeta p) throws FileNotFoundException, IOException {

        if (!f.exists()) {
            f.mkdirs();
        }
        String direccionRAF = Satelite.archivoRAF + p.getIdPlaneta() + "satelite" + p.getNombre() + ".dat";
        try (RandomAccessFile raf = new RandomAccessFile(new File(direccionRAF), "rw")) {
            int nuevoID = (int) (raf.length() / Satelite.TAMAÑO_REGISTRO) + 1; // Calcula el nuevo ID
            // Calcula la posición para insertar el nuevo registro
            long posicion = (nuevoID - 1) * Satelite.TAMAÑO_REGISTRO;
            raf.seek(posicion);
            raf.write(s.getNombreByteArray());
            raf.writeChars(Double.toString(s.getDensidad()));
            raf.writeChars(s.getFechaDescubrimiento());
            // Cierra el archivo
        } catch (Exception e) {
            PlanetaApp.logger.error("No se ha encontrado el archivo");
        }
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

            for (Satelite s : satelitesIniciales) {
                escribirRAF(s, p);
            }
        }

    }

    /**
     *
     * @param s
     * @param p
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @autor Jose
     */
    public static StringBuilder leerFicheroSatelite(Planeta p) throws FileNotFoundException, IOException {
        String direccionRAF = Satelite.archivoRAF + p.getIdPlaneta() + "satelite" + p.getNombre() + ".dat";
        StringBuilder resultado = new StringBuilder();

        try (RandomAccessFile raf = new RandomAccessFile(new File(direccionRAF), "rw")) {
            raf.seek(0); // Me posiciono al inicio del archivo
            byte[] leido = new byte[Satelite.TAMAÑO_REGISTRO];
            int bytesRead;
            while ((bytesRead = raf.read(leido)) != -1) {
                String registro = new String(leido, 0, bytesRead, StandardCharsets.UTF_16);
                if (bytesRead > Satelite.TAMAÑO_REGISTRO) {
                    break; // Si no se leyó el tamaño completo, salimos del bucle
                }
                String[] partes = registro.split(" ");

                String nombre = partes[0];
                String densidad = partes[1];
                String añoDescubrimiento = partes[2];

                //Para mostrar bien el satelite lo formateo con stringBuilder
                resultado.append("Nombre: ").append(nombre).append(", Densidad:").append(densidad).append(", Año de Descubrimiento: ").append(añoDescubrimiento).append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            PlanetaApp.logger.error("Este planeta no tiene satelites");

        }

        return resultado;
    }

    public static StringBuilder leerFicheroSateliteArray(ArrayList<Planeta> planetas) throws IOException {
        StringBuilder resultado = new StringBuilder("");
        for (Planeta p : planetas) {
            String direccionRAF = Satelite.archivoRAF + p.getIdPlaneta() + "satelite" + p.getNombre() + ".dat";
            
            try (RandomAccessFile raf = new RandomAccessFile(new File(direccionRAF), "rw")) {
            raf.seek(0); // Me posiciono al inicio del archivo
            byte[] leido = new byte[Satelite.TAMAÑO_REGISTRO];
            int bytesRead;
            while ((bytesRead = raf.read(leido)) != -1) {
                String registro = new String(leido, 0, bytesRead, StandardCharsets.UTF_16);
                if (bytesRead > Satelite.TAMAÑO_REGISTRO) {
                    break; // Si no se leyó el tamaño completo, salimos del bucle
                }
                String[] partes = registro.split(" ");

                String nombre = partes[0];
                String densidad = partes[1];
                String añoDescubrimiento = partes[2];

                //Para mostrar bien el satelite lo formateo con stringBuilder
                resultado.append("Nombre: ").append(nombre).append(", Densidad:").append(densidad).append(", Año de Descubrimiento: ").append(añoDescubrimiento).append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            PlanetaApp.logger.error("Este planeta no tiene satelites");

        }


        }
        return resultado;
    }
    
    
//        public static void escribirNuevoSateliteRAF(Satelite s, Planeta p,int contsate) throws FileNotFoundException, IOException {
//        int x;
//        long posicion;
//        if (!f.exists()) {
//            f.mkdirs();
//        }
//        String direccionRAF = Satelite.archivoRAF + p.getIdPlaneta() + "satelite" + p.getNombre() + ".dat";
//        try (RandomAccessFile raf = new RandomAccessFile(new File(direccionRAF), "rw")) {
//           //multiplicamos el numero de satelites por el tamaño del registro
//           x=contsate*Satelite.TAMAÑO_REGISTRO;
//           //restamos ese numero por el read y lo dividimos entre satelite para que de entero
//            int nuevoID = (int) ((raf.length()+x) / Satelite.TAMAÑO_REGISTRO) + 1; // Calcula el nuevo ID
//            long rafi=raf.length();
//            System.out.println(rafi);
//            // Calcula la posición para insertar el nuevo registro
//            if (nuevoID==1) {
//                posicion = (nuevoID+1 - 1) * Satelite.TAMAÑO_REGISTRO;
//            }else{
//                posicion = (nuevoID - 1) * Satelite.TAMAÑO_REGISTRO;
//            }
//            
//            raf.seek(posicion);
//            raf.write(s.getNombreByteArray());
//            String densidadAsString = Double.toString(s.getDensidad()); // Convierte el double a una cadena
//            raf.writeChars(densidadAsString);
//            raf.writeChars(s.getFechaDescubrimiento());
//            // Cierra el archivo
//        } catch (Exception e) {
//            PlanetaApp.logger.error("No se ha encontrado el archivo");
//        }
//    }
//        public static int contarSatelites(  ArrayList<Planeta> planetas,Planeta p){
//            int cont=0;
//            for (Planeta pl : planetas) {
//                if (pl.getIdPlaneta()==p.getIdPlaneta()) {
//                    cont++;
//                }
//            }
//            
//        return cont;}
}
