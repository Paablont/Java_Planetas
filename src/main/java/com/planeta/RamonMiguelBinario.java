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
            
    }

    public static void ingresarPlaneta(ArrayList<Planeta> planetas) throws FileNotFoundException, IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PlanetaApp.archivoBinario))) {
                for (Planeta planeta : planetas) {
                    // Crear un nuevo objeto Planeta solo con ID y otras propiedades (sin nombre)
                    Planeta planetaSinNombre = new Planeta(planeta.getIdPlaneta(), planeta.getNombre(), planeta.getDistanciaSolar(), planeta.getRadio(), planeta.isVida(), planeta.getTipoPlaneta(), planeta.getSatelite());

                    oos.writeObject(planetaSinNombre);
                }
                System.out.println("Archivo binario creado con éxito.");
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public static void leerPlanetaCarac() throws FileNotFoundException, IOException {
        Planeta plane;
        try ( ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(PlanetaApp.archivoBinario))) {
            int i = 1;
            boolean eof = false;
            while (!eof) {
                try {
                    plane = (Planeta) oIS.readObject();
                    System.out.println(i++ + "=>" + plane);
                } catch (IOException iOException) {
                    eof = true;
                } catch (ClassNotFoundException ex) {
                    eof = true;
                    System.out.println("El objeto leÃ­do no era del tipo esperado");
                }
            }
        }
    }
}
