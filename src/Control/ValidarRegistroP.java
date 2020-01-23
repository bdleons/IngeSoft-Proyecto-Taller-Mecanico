/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Producto;

/**
 *
 * @author Marcos
 */
public class ValidarRegistroP {
    
    public ValidarRegistroP() {
    }
    
    public boolean validarLongitudCodigo(int product){
        if(product >9999 && product <= 9999999){
            return true;
        }
        return false;
    }
    
    public boolean validarLongitudNombre(String product){
        if(product.length() >=2 && product.length() <= 15){
            return true;
        }
        return false;
    }
    
    public String VerificarProducto(Producto productocache){
        if(!validarLongitudCodigo(productocache.getCodigo())){
            return("Longitud del producto incorrecta");
        }
        if(!validarLongitudNombre(productocache.getNombre())){
            return("Longitud del nombre incorrecto");
        }
        return("Producto correcto");
    }
}
