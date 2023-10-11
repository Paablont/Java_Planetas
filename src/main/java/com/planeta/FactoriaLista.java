package com.planeta;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author migue
 */
public class FactoriaLista {

    public static ArrayList<Planeta> creacion() {
        ArrayList<Satelite> sat = null;
        ArrayList<Planeta> planetas = new ArrayList<>();
        if (!PlanetaApp.archivo.exists()) {
            planetas.add(new Planeta(1, "Mercurio", 0.39, 2439.7, false, TipoPlaneta.ROCOSO, sat));
            planetas.add(new Planeta(planetas.size() + 1, "Venus", 0.72, 6051.8, false, TipoPlaneta.ROCOSO, sat));
            planetas.add(new Planeta(planetas.size() + 1, "Tierra", 1.0, 6371.0, true, TipoPlaneta.ROCOSO, sat));
            planetas.add(new Planeta(planetas.size() + 1, "Marte", 1.52, 3389.5, false, TipoPlaneta.ROCOSO, sat));
            planetas.add(new Planeta(planetas.size() + 1, "Júpiter", 5.2, 69911.0, false, TipoPlaneta.GASEOSO, sat));
            planetas.add(new Planeta(planetas.size() + 1, "Saturno", 9.58, 58232.0, false, TipoPlaneta.GASEOSO, sat));
            planetas.add(new Planeta(planetas.size() + 1, "Urano", 19.22, 25362.0, false, TipoPlaneta.GASEOSO, sat));
            planetas.add(new Planeta(planetas.size() + 1, "Neptuno", 30.05, 24622.0, false, TipoPlaneta.GASEOSO, sat));
        }
        return planetas;
    }
}
