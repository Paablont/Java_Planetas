package com.planeta;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

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
        String direccionRAF = Satelite.archivoRAF + "satelite" + p.getNombre() + ".dat";
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

}
