package com.planeta;

/**
 *
 * @author @Pablo Villaseñor Ruiz
 */
public class Satelite {
    String nombre;
    double densidad;
    int anioDescubrimiento;

    public Satelite(String nombre, double densidad, int anioDescubrimiento) {
        this.nombre = nombre;
        this.densidad = densidad;
        this.anioDescubrimiento = anioDescubrimiento;
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

    public int getAnioDescubrimiento() {
        return anioDescubrimiento;
    }

    public void setAnioDescubrimiento(int anioDescubrimiento) {
        this.anioDescubrimiento = anioDescubrimiento;
    }
    
}
