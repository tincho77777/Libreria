
package com.Martin.Libreria.Errores;


public class ErrorServicio extends Exception {
    
    public ErrorServicio(String mensaje){  //creamos esta clase para diferenciar nuestros errores de los errores del programa
        super(mensaje);
        
    }
    
}
