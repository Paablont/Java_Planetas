package com.planeta;

import java.awt.Dimension;
import java.awt.Toolkit;
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
     
   
    static Logger logger = LogManager.getRootLogger();
    
    static File archivo = new File(Planeta.archivoTXT);  
    public static void main(String[] args) throws IOException, ClassNotFoundException {
 MenuPrincipal menu = new MenuPrincipal();
       
      menu.setVisible(true);
        ArrayList<Satelite> sat = new ArrayList<>();
        ArrayList<Planeta> planetas = new ArrayList<>();
        
            planetas = FactoriaLista.creacion();
            if (archivo.exists()) {
//            planetas.add(new Planeta(11, "Caracol", 0.39, 2439.7, false, TipoPlaneta.ROCOSO, sat));
//            logger.trace("Ya esta creado");
//            RamonMiguelBinario.ingresarPlaneta(planetas);
//            RamonMiguelBinario.leerPlanetaCarac();
            RamonMiguelBinario.leerPlanetaSolo(11);
        } else {
            PabloJoseTexto.escribirInicialesTXT(Planeta.archivoTXT, planetas);      
            RamonMiguelBinario.ingresarPlaneta(planetas);
            RamonMiguelBinario.leerPlanetaCarac(); 
            RamonMiguelBinario.leerPlanetaSolo(1);
            PabloJoseRAF.ingresarSatelite(planetas);
            
        }
            
            
    }
}

