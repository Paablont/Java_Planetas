package com.planeta;

import Jframes.JFrameCreadorPlaneta;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * Clase para Crear y leer Binario
 * @author migue
 */
public class RamonMiguelBinario {

    static File f = new File(Planeta.archivoBinario);

    /**
     * Método para ingresar  un planeta
     * @param p
     * @throws IOException 
     */
    public static void ingresarPlaneta1a1(Planeta p) throws IOException {

        if (!f.exists()) {
            f.mkdirs();
        }
        String nombreArchivo = Planeta.archivoBinario + p.getIdPlaneta() + "_" + p.getNombre() + ".bin";
        try ( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(p);
            PlanetaApp.logger.info("Objeto Planeta agregado con éxito en el archivo " + nombreArchivo);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para ingresar una lista de planetas
     * @param planetas
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static void ingresarPlaneta(ArrayList<Planeta> planetas) throws FileNotFoundException, IOException {
        for (Planeta p : planetas) {
            ingresarPlaneta1a1(p);
        }
    }

    /**
     * Método para leer planetas
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static void leerPlanetaCarac() throws FileNotFoundException, IOException {
        File directorioPlanetas = new File(Planeta.archivoBinario);

        if (directorioPlanetas.exists() && directorioPlanetas.isDirectory()) {
            File[] archivos = directorioPlanetas.listFiles();

            if (archivos != null) {
                for (File archivo : archivos) {
                    if (archivo.isFile()) {
                        try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                            Planeta planeta = (Planeta) ois.readObject();
                            PlanetaApp.logger.info("Leyendo " + archivo.getName() + ": " + planeta);
                        } catch (IOException | ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /**
     * Método para leer planetas según su ID
     * @param id
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static Planeta leerPlanetaSolo(int id) throws FileNotFoundException, IOException {
        File directorioPlanetas = new File(Planeta.archivoBinario);
        Planeta plan = null;

        if (directorioPlanetas.exists() && directorioPlanetas.isDirectory()) {
            File[] archivos = directorioPlanetas.listFiles();

            if (archivos != null) {
                for (File archivo : archivos) {
                    String num = archivo.toString().substring(31, archivo.toString().indexOf('_'));
                    if (num.equals(Integer.toString(id))) {
                        try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                            plan = (Planeta) ois.readObject();
                            PlanetaApp.logger.info("Leyendo " + archivo.getName() + ": " + plan);
                            ois.close();
                        } catch (IOException | ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return plan;
    }
}
