package com.planeta;

/**
 *
 * @author @Pablo Villaseñor Ruiz
 */
public class Satelite {
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
