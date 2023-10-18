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
 * @author Pablo y Jose
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
            int nuevoID;
            if (raf.length() == 0) {
                //en el primero se suma uno porque raf.legth es cero ya que no hay nada
                nuevoID = (int) (raf.length() / Satelite.TAMAÑO_REGISTRO) + 1;
            } else {
                //Se suma dos porque solo se coge la parte entera
                nuevoID = (int) (raf.length() / Satelite.TAMAÑO_REGISTRO) + 2; // Calcula el nuevo ID
            }

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
     * Metodo que lee un array de objetos ya predefinidos y crea sus
     * nrespectivos satelites por defectos
     *
     * @autor Jose
     */
    public static StringBuilder leerFicheroSatelite(Planeta p) throws FileNotFoundException, IOException {
        String direccionRAF = Satelite.archivoRAF + p.getIdPlaneta() + "satelite" + p.getNombre() + ".dat";
        StringBuilder resultado = new StringBuilder();

        try (RandomAccessFile raf = new RandomAccessFile(new File(direccionRAF), "rw")) {
            //Nos posicionamos en la posicion cero pues que hay un nombre distinto para cada satelite y siempre va haber que leerlo todo
            raf.seek(0); // Me posiciono al inicio del archivo
            byte[] leido = new byte[Satelite.TAMAÑO_REGISTRO];
            int bytesRead;
            long rafi=raf.length();
            while ((bytesRead = raf.read(leido)) != -1) {
                String registro = new String(leido, 0, bytesRead, StandardCharsets.UTF_16);
                //Si es un nombre muy largo no escribira nada
                if (bytesRead > Satelite.TAMAÑO_REGISTRO) {
                    break;
                }
                System.out.print(registro);
                System.out.println(registro.equals(""));
                if(registro.isEmpty()){
                    continue;
                }
                //Dividos en 3 para dar formato a las 3 caracteristicas de los satelites
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

    /**
     * Metodo que lee un array de objetos ya predefinidos y crea sus
     * nrespectivos satelites por defectos
     *
     * @author Jose
     */

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

//    public static ArrayList<Satelite> filtrarSatelitesPorArchivoRAF(ArrayList<Satelite> satelites, Satelite sateliteFiltro) {
//        ArrayList<Satelite> satelitesFiltrados = new ArrayList<>();
//
//        for (Satelite s : satelites) {
//            if (s.archivoRAF.equals(sateliteFiltro.archivoRAF)) {
//                satelitesFiltrados.add(s);
//            }
//        }
//
//        return satelitesFiltrados;
//
//    }

    public static int saberPosSatelite(ArrayList<Satelite> satelitesnuevos, String nombreIntroducido) {
        int cont = 0;
        for (Satelite s : satelitesnuevos) {
            char[] nombreCharArray = s.getNombreCharArray();
            String nombre = new String(nombreCharArray);
            if (nombre.equalsIgnoreCase(nombreIntroducido)) {
                return cont;
            } else {
                cont++;
            }
        }
        cont = 0;
        return cont;

    }
    

    public static void borrarSatelite(Planeta p,int pos) throws FileNotFoundException, IOException {
        String direccionRAF = Satelite.archivoRAF + p.getIdPlaneta() + "satelite" + p.getNombre() + ".dat";
        

        try (RandomAccessFile raf = new RandomAccessFile(new File(direccionRAF), "rw")) {
            //Nos posicionamos en la posicion cero pues que hay un nombre distinto para cada satelite y siempre va haber que leerlo todo
            long posicionABorrar = pos * Satelite.TAMAÑO_REGISTRO;
            raf.seek(posicionABorrar); // Me posiciono al inicio del archivo
            
                //Dividos en 3 para dar formato a las 3 caracteristicas de los satelites
                 for (int i = 0; i < Satelite.TAMAÑO_REGISTRO; i++) {
                raf.write((byte) 0); // Escribe bytes en blanco
            }
            
        } catch (FileNotFoundException e) {
            PlanetaApp.logger.error("Este planeta no tiene satelites");
        }
       
    }
    

}
