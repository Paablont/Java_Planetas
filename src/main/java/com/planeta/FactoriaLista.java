package com.planeta;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase que crea una lista con los Planetas iniciales que cargara el programa
 * @author Miguel y Ramon
 */
public class FactoriaLista {

    public static ArrayList<Planeta> creacion() throws IOException {
         StringBuilder informacionSatelite=new StringBuilder("");
        ArrayList<Satelite> satelitesMercurio = new ArrayList<>();
        ArrayList<Satelite> satelitesVenus = new ArrayList<>();
        ArrayList<Satelite> satelitesTierra = new ArrayList<>();
        ArrayList<Satelite> satelitesMarte = new ArrayList<>();
        ArrayList<Satelite> satelitesJupiter = new ArrayList<>();
        ArrayList<Satelite> satelitesSaturno = new ArrayList<>();
        ArrayList<Satelite> satelitesUrano = new ArrayList<>();
        ArrayList<Satelite> satelitesNeptuno = new ArrayList<>();
        
        ArrayList<Planeta> planetas = new ArrayList<>();
        if (!PlanetaApp.archivo.exists()) {
            // Satélites reales de los planetas
            satelitesMercurio.add(new Satelite("NULO ".toCharArray(), 0.0, " N/A")); // Mercurio
            
            satelitesMercurio.add(new Satelite("WOWO ".toCharArray(), 5.2, " 20/01/2001")); // Mercurio
            satelitesVenus.add(new Satelite("NULO ".toCharArray(), 0.0, " N/A")); // Venus
            satelitesTierra.add(new Satelite("Luna ".toCharArray(), 3.34, " 20/07/1969")); // Tierra
            satelitesMarte.add(new Satelite("Fobos ".toCharArray(), 1.88, " 18/08/1877")); // Marte
            satelitesJupiter.add(new Satelite("Ganímedes ".toCharArray(), 1.94, " 11/01/1610")); // Júpiter
            satelitesSaturno.add(new Satelite("Titán ".toCharArray(), 1.88, " 25/03/1655")); // Saturno
            satelitesUrano.add(new Satelite("Miranda ".toCharArray(), 1.20, " 16/02/1948")); // Urano
            satelitesNeptuno.add(new Satelite("Tritón ".toCharArray(), 2.05, " 10/10/1846")); // Neptuno

            planetas.add(new Planeta(1, "Mercurio", 0.39, 2439.7, false, TipoPlaneta.ROCOSO, satelitesMercurio));
            planetas.add(new Planeta(planetas.size() + 1, "Venus", 0.72, 6051.8, false, TipoPlaneta.ROCOSO, satelitesVenus));
            planetas.add(new Planeta(planetas.size() + 1, "Tierra", 1.0, 6371.0, true, TipoPlaneta.ROCOSO, satelitesTierra));
            planetas.add(new Planeta(planetas.size() + 1, "Marte", 1.52, 3389.5, false, TipoPlaneta.ROCOSO, satelitesMarte));
            planetas.add(new Planeta(planetas.size() + 1, "Júpiter", 5.2, 69911.0, false, TipoPlaneta.GASEOSO, satelitesJupiter));
            planetas.add(new Planeta(planetas.size() + 1, "Saturno", 9.58, 58232.0, false, TipoPlaneta.GASEOSO, satelitesSaturno));
            planetas.add(new Planeta(planetas.size() + 1, "Urano", 19.22, 25362.0, false, TipoPlaneta.GASEOSO, satelitesUrano));
            planetas.add(new Planeta(planetas.size() + 1, "Neptuno", 30.05, 24622.0, false, TipoPlaneta.GASEOSO, satelitesNeptuno));
            
        
           // informacionSatelite=PabloJoseRAF.leerFicheroSatelite(planetas.get(0));
            
            
        }
        
        
        return planetas;
    }
}
