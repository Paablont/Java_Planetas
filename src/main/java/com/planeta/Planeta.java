package com.planeta;

/**
 * Planeta planetium planetare
 * 
 */
public class Planeta {
    
    int idPlaneta;
    String nombre;
    double radio,distanciaSolar;
    boolean vida;

    public Planeta(int idPlaneta, String nombre, double radio, double distanciaSolar, boolean vida) {
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
    
    public double getDistanciaSolar() {
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
    
    public void setDistanciaSolar(double distanciaSolar) {
        this.distanciaSolar = distanciaSolar;
    }
    
    public void setVida(boolean vida) {
        this.vida = vida;
    }
    
    //Crear planeta (agregarlo a los ficheros necesarios)
    
    
    
    
    
    
}
