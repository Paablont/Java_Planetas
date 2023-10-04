package com.planeta;

import java.io.Serializable;

/**
 * Planeta planetium planetare
 *
 *
 */
public class Planeta implements Serializable{

    int idPlaneta;
    String nombre,distanciaSolar;
    double radio;
    boolean vida;

    public Planeta(int idPlaneta, String nombre, double radio, String distanciaSolar, boolean vida) {
        this.idPlaneta = idPlaneta;
        this.nombre = nombre;
        this.radio = radio;
        this.distanciaSolar = distanciaSolar;
        this.vida = vida;
    }

    public int getIdPlaneta() {
        return idPlaneta;
    }

    public String getNombre() {
        return nombre;
    }

    public double getRadio() {
        return radio;
    }

    public String getDistanciaSolar() {
        return distanciaSolar;
    }

    public boolean isVida() {
        return vida;
    }

    public void setIdPlaneta(int idPlaneta) {
        this.idPlaneta = idPlaneta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public void setDistanciaSolar(String distanciaSolar) {
        this.distanciaSolar = distanciaSolar;
    }

    public void setVida(boolean vida) {
        this.vida = vida;
    }

    @Override
    public String toString() {
        return "Planeta{" + "idPlaneta=" + idPlaneta 
                + ", nombre=" + nombre + 
                ", distanciaSolar=" + distanciaSolar + 
                ", radio=" + radio + 
                ", vida=" + vida;
    }
    
    

}
