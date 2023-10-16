
package com.planeta;

/**
 * Enumerado 
 * @author migue
 */
public enum TipoPlaneta {
    ROCOSO,GASEOSO,HELADO;
    /**
     * Método para Pasar de String a Tipo planeta
     * @param str
     * @return 
     */
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
