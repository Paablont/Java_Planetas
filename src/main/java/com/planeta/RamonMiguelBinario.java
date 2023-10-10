package com.planeta;

import Jframes.JFrameCreadorPlaneta;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Alumno
 */
public class RamonMiguelBinario {
    
    public static void ingresarPlaneta(ArrayList<Planeta> p) {
        for (int i = 0; i < p.size(); i++) {
            ingresarPlaneta(p.get(i));
        }
    }

    public static void ingresarPlaneta(Planeta p) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PlanetaApp.archivoBinario, true))) {
            oos.writeObject(p);
            System.out.println("Archivo binario creado con éxito.");
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leerPlanetaCarac() throws FileNotFoundException, IOException {
        Planeta plane;
        ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(PlanetaApp.archivoBinario));

        int i = 1;
        boolean eof = false;
        while (!eof) {
            try {
                plane = (Planeta) oIS.readObject(); // leer UNA Persona
                System.out.println(i++ + "=>" + plane);
            } catch (IOException iOException) {
                eof = true;
            } catch (ClassNotFoundException ex) {
                eof = true;
                System.out.println("El objeto leÃ­do no era del tipo esperado");
            }
        }
        oIS.close();
    }
}
