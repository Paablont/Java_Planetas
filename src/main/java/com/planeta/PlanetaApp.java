package com.planeta;

import java.awt.Dimension;
import java.awt.Toolkit;
import Jframes.LeerTXT;
import Jframes.MenuPrincipal;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author @Pablo Villaseñor Ruiz
 */
public class PlanetaApp {
    static String archivoBinario = ".\\archivos\\planetasPropiedades\\";
    static Logger logger = LogManager.getRootLogger();
    static String archivoTexto = ".\\archivos\\planetas.txt"; 
    static File archivo = new File(archivoTexto);  
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        MenuPrincipal menu = new MenuPrincipal();
        //Declaramos un objeto de la clase Jfram LeerTXT
//        menu.setVisible(true);
        ArrayList<Satelite> sat = null;
        ArrayList<Planeta> planetas = new ArrayList<>();
        if (archivo.exists()) {
            planetas.add(new Planeta(11, "Caracol", 0.39, 2439.7, false, TipoPlaneta.ROCOSO, sat));
            logger.trace("Ya esta creado");
            RamonMiguelBinario.ingresarPlaneta(planetas);
            RamonMiguelBinario.leerPlanetaCarac();
        } else {
            planetas = FactoriaLista.creacion();
            RamonMiguelBinario.ingresarPlaneta(planetas);
            RamonMiguelBinario.leerPlanetaCarac(); 
        }
    }
}
