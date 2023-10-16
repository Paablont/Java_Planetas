package com.planeta;

import java.io.File;
import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author @Pablo Villaseñor Ruiz
 */
public class Satelite implements Serializable {
   
    public static final String archivoRAF = "." + File.separatorChar + "archivos" + File.separatorChar + "satelites" + File.separatorChar;
    public static final int TAMAÑO_REGISTRO = 88; //30 caracteres al String *2bytes + 8 bytes de double + 10bytes a fechaDescubrimiento * 2 bytes) = 
    public static final int TAMAÑO_NOMBRE = 30;
    
    private char[] nombre = new char[Satelite.TAMAÑO_NOMBRE];
    double densidad;
    String fechaDescubrimiento;
    

    
    public Satelite(char[] nombre, double densidad, String fechaDescubrimiento) {
        this.nombre = nombre;
        this.densidad = densidad;
        this.fechaDescubrimiento = fechaDescubrimiento;
    }

    public char[] getNombreCharArray() {
        return this.nombre;
    }

    public byte[] getNombreByteArray() {
        byte[] nombre_bytes = new byte[this.nombre.length * 2];

        for (int i = 0; i < this.nombre.length; i++) {
            nombre_bytes[i * 2] = (byte) (this.nombre[i] >> 8);
            nombre_bytes[i * 2 + 1] = (byte) this.nombre[i];
        }
        return nombre_bytes;
    }

    public void setNombre(String nombre) {
        this.setNombre(nombre.toCharArray());
    }

    public void setNombre(char[] nombre) {
        //sobrescribo el array completo, no lo creo de nuevo. ahorro memoria
        Arrays.fill(this.nombre, (char) 0);
        for (int i = 0; i < nombre.length && i < this.nombre.length; i++) {
            this.nombre[i] = nombre[i];
        }
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

    @Override
    public String toString() {
        return "Satelite --> " + "nombre: " + String.copyValueOf(nombre) + ", densidad: " + densidad + ", fechaDescubrimiento: " + fechaDescubrimiento + "\n";
    }
    
}
