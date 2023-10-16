package com.planeta;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Planeta planetium planetare
 *
 *
 */
public class Planeta implements Serializable{

    static String archivoBinario = "." + File.separatorChar + "archivos" + File.separatorChar + "planetasPropiedades" + File.separatorChar;
    static String archivoTXT = "." + File.separatorChar + "archivos" + File.separatorChar+ "planetas.txt";
    //este comentario no vale para nada
    int idPlaneta;
    String nombre;
    double distSolar;
    double radio;
    boolean vida;
    TipoPlaneta tipoPlaneta;
    ArrayList<Satelite> satelite;

    public Planeta(int idPlaneta, String nombre, double distSolar, double radio, boolean vida, TipoPlaneta tipoPlaneta, ArrayList<Satelite> satelite) {
        this.idPlaneta = idPlaneta;
        this.nombre = nombre;
        this.distSolar = distSolar;
        this.radio = radio;
        this.vida = vida;
        this.tipoPlaneta = tipoPlaneta;
        this.satelite = satelite;
    }

        

    public int getIdPlaneta() {
        return idPlaneta;
    }

    public void setIdPlaneta(int idPlaneta) {
        this.idPlaneta = idPlaneta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDistanciaSolar() {
        return distSolar;
    }

    public void setDistanciaSolar(double distanciaSolar) {
        this.distSolar = distanciaSolar;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public boolean isVida() {
        return vida;
    }

    public void setVida(boolean vida) {
        this.vida = vida;
    }

    public TipoPlaneta getTipoPlaneta() {
        return tipoPlaneta;
    }

    public void setTipoPlaneta(TipoPlaneta tipoPlaneta) {
        this.tipoPlaneta = tipoPlaneta;
    }

    public ArrayList<Satelite> getSatelite() {
        return satelite;
    }

    public void setSatelite(ArrayList<Satelite> satelite) {
        this.satelite = satelite;
    }
    @Override
    public String toString() {
        return "Planeta --> " + "idPlaneta=" + idPlaneta 
                + ", nombre=" + nombre + 
                ", distanciaSolar=" + distSolar + 
                ", radio=" + radio + 
                ", vida=" + vida;
    }
    
    

}
