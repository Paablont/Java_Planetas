package com.planeta;


import Jframes.MenuPrincipal;

import java.io.File;

import java.io.IOException;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author @Pablo Villaseñor Ruiz
 */
public class PlanetaApp {
    
    static Logger logger = LogManager.getRootLogger();
    
    static File archivo = new File(Planeta.archivoTXT);    
    static File carpeta = new File("." + File.separatorChar + "archivos");

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MenuPrincipal menu = new MenuPrincipal();
        
        menu.setVisible(true);
        ArrayList<Satelite> sat = new ArrayList<>();
        ArrayList<Planeta> planetas = new ArrayList<>();
        
        planetas = FactoriaLista.creacion();
        if (archivo.exists()) {
//           planetas.add(new Planeta(11, "Caracol", 0.39, 2439.7, false, TipoPlaneta.ROCOSO, sat));
//            logger.trace("Ya esta creado");
//            RamonMiguelBinario.ingresarPlaneta(planetas);
//            RamonMiguelBinario.leerPlanetaCarac();
            RamonMiguelBinario.leerPlanetaSolo(11);
        } else {
            if (!carpeta.exists()) {
                carpeta.mkdir();
            }
            PabloJoseTexto.escribirID(9);
            PabloJoseTexto.escribirInicialesTXT(Planeta.archivoTXT, planetas);            
            RamonMiguelBinario.ingresarPlaneta(planetas);
            RamonMiguelBinario.leerPlanetaCarac();            
            RamonMiguelBinario.leerPlanetaSolo(1);
            PabloJoseRAF.ingresarSatelite(planetas);
            PabloJoseRAF.leerFicheroSateliteArray(planetas);
            
        }
        
    }
}
