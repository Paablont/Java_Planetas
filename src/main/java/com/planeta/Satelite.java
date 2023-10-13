package com.planeta;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author @Pablo Villaseñor Ruiz
 */
public class Satelite implements Serializable {
   
    public static final String archivoRAF = "." + File.separatorChar + "archivos" + File.separatorChar + "satelites" + File.separatorChar;
    public static final int TAMAÑO_REGISTRO = 88; //30bytes al String *2bytes + 8 bytes de double + 10bytes a fechaDescubrimiento * 2 bytes) = 
    
    String nombre;
    double densidad;
    String fechaDescubrimiento;
    

    
    public Satelite(String nombre, double densidad, String fechaDescubrimiento) {
        this.nombre = nombre;
        this.densidad = densidad;
        this.fechaDescubrimiento = fechaDescubrimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDensidad() {
        return densidad;
    }

    public void setDensidad(double densidad) {
        this.densidad = densidad;
    }

    public String getFechaDescubrimiento() {
        return fechaDescubrimiento;
    }

    public void setFechaDescubrimiento(String fechaDescubrimiento) {
        this.fechaDescubrimiento = fechaDescubrimiento;
    }

   
    
}
