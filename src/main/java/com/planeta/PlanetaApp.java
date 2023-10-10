package com.planeta;

import java.awt.Dimension;
import java.awt.Toolkit;
import Jframes.LeerTXT;
import Jframes.MenuPrincipal;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * 
 * @author @Pablo Villaseñor Ruiz
 */
public class PlanetaApp {

    public static void main(String[] args) {
//        MenuPrincipal menu = new MenuPrincipal();
         //Declaramos un objeto de la clase Jfram LeerTXT
//        menu.setVisible(true);
        ArrayList<Satelite> sat = null;
        ArrayList<Planeta> planetas = new ArrayList<>();
        planetas.add(new Planeta(1,"Mercurio", 0.39, 2439.7, false, TipoPlaneta.ROCOSO, sat));
        planetas.add(new Planeta(planetas.size() + 1,"Venus", 0.72, 6051.8, false, TipoPlaneta.ROCOSO, sat));
        planetas.add(new Planeta(planetas.size() + 1,"Tierra", 1.0, 6371.0, true, TipoPlaneta.ROCOSO, sat));
        planetas.add(new Planeta(planetas.size() + 1,"Marte", 1.52, 3389.5, false, TipoPlaneta.ROCOSO, sat));
        planetas.add(new Planeta(planetas.size() + 1,"Júpiter", 5.2, 69911.0, false, TipoPlaneta.GASEOSO,sat));
        planetas.add(new Planeta(planetas.size() + 1,"Saturno", 9.58, 58232.0, false, TipoPlaneta.GASEOSO,sat));
        planetas.add(new Planeta(planetas.size() + 1,"Urano", 19.22, 25362.0, false, TipoPlaneta.GASEOSO, sat));
        planetas.add(new Planeta(planetas.size() + 1,"Neptuno", 30.05, 24622.0, false, TipoPlaneta.GASEOSO, sat));      
        //Forma texto
        String archivoTexto = ".\\archivos\\planetas.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoTexto))) {
            for (Planeta planeta : planetas) {
                writer.write("ID: " + planeta.getIdPlaneta() + ", Nombre: " + planeta.getNombre());
                writer.newLine();
            }
            System.out.println("Archivo de texto creado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Forma binaria
         // Nombre del archivo binario
        String archivoBinario = ".\\archivos\\planetaPropiedades.dat";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoBinario))) {
            for (Planeta planeta : planetas) {
                // Crear un nuevo objeto Planeta solo con ID y otras propiedades (sin nombre)
                Planeta planetaSinNombre = new Planeta(planeta.getIdPlaneta(),planeta.getNombre(),planeta.getDistanciaSolar(),planeta.getRadio(),planeta.isVida(),planeta.getTipoPlaneta(),planeta.getSatelite());

                oos.writeObject(planetaSinNombre);
            }
            System.out.println("Archivo binario creado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
