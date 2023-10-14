/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.planeta;

/**
 *
 * @author Alumno
 */
public enum TipoPlaneta {
    ROCOSO,GASEOSO,HELADO;
    public static TipoPlaneta parse(String str){
        if(ROCOSO.name().equalsIgnoreCase(str)){
            return ROCOSO;
        } else if(GASEOSO.name().equalsIgnoreCase(str)){
            return GASEOSO;
        }else{
            return HELADO;
        }
    }
}
