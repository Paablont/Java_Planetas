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
 *
 * @author Alumno
 */
public class RamonMiguelBinario {

    public static void ingresarPlaneta1a1(Planeta p) throws IOException {
        File f = new File(PlanetaApp.archivoBinario);
        if (!f.exists()) {
            f.mkdirs();
        }
        String nombreArchivo = PlanetaApp.archivoBinario + p.getIdPlaneta() + "_" + p.getNombre() + ".bin";
        try ( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(p);
            System.out.println("Objeto Planeta agregado con éxito en el archivo " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ingresarPlaneta(ArrayList<Planeta> planetas) throws FileNotFoundException, IOException {
        for (Planeta p : planetas) {
            ingresarPlaneta1a1(p);
        }
    }

    public static void leerPlanetaCarac() throws FileNotFoundException, IOException {
        File directorioPlanetas = new File(PlanetaApp.archivoBinario);

        if (directorioPlanetas.exists() && directorioPlanetas.isDirectory()) {
            File[] archivos = directorioPlanetas.listFiles();

            if (archivos != null) {
                for (File archivo : archivos) {
                    if (archivo.isFile()) {
                        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                            Planeta planeta = (Planeta) ois.readObject();
                            System.out.println("Leyendo " + archivo.getName() + ": " + planeta);
                        } catch (IOException | ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    public static void leerPlanetaSolo(int id) throws FileNotFoundException, IOException {
        File directorioPlanetas = new File(PlanetaApp.archivoBinario);

        if (directorioPlanetas.exists() && directorioPlanetas.isDirectory()) {
            File[] archivos = directorioPlanetas.listFiles();

            if (archivos != null) {
                for (File archivo : archivos) {
                    String num = archivo.toString().substring(31,archivo.toString().indexOf('_'));
                    if (num.equals(Integer.toString(id))) {
                        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                            Planeta planeta = (Planeta) ois.readObject();
                            System.out.println("Leyendo " + archivo.getName() + ": " + planeta);
                        } catch (IOException | ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
