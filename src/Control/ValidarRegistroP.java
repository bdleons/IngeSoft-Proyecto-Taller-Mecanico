/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.ProductoDAO;
import Entidad.Producto;

/**
 *
 * @author Marcos
 */
public class ValidarRegistroP {
    private ProductoDAO dao = new ProductoDAO();
    
    public ValidarRegistroP() {
    }
    public boolean validarCodigoRepetido(Producto prod){
    if(dao.leer(prod) != null)
        return false;
    return true;
    }
    public boolean validarCodigoexistente(Producto prod){
        if(dao.leer(prod) == null)
        return false;
    return true;
    }
    public boolean validarCodigoAct(Producto prod){
        if(dao.leerAct(prod) == null)
        return false;
    return true;
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
        if(!validarCodigoRepetido(productocache)){
            return("El código ya existe");
        }
        if(!validarLongitudCodigo(productocache.getCodigo())){
            return("Longitud del producto incorrecta");
        }
        if(!validarLongitudNombre(productocache.getNombre())){
            return("Longitud del nombre incorrecto");
        }
        return("Producto correcto");
    }
    public String VerificarActualizacionProducto(Producto productocache){         
        if(!validarCodigoexistente(productocache)){
            return("El código que quiere actualizar no existe");
        }
        if(!validarCodigoAct(productocache)){
            return("El código no coincide con el nombre registrado, por favor revise los datos ingresados");
        }
        if(!validarLongitudCodigo(productocache.getCodigo())){
            return("Longitud del producto incorrecta");
        }
        if(!validarLongitudNombre(productocache.getNombre())){
            return("Longitud del nombre incorrecto");
        }
        return("Producto correcto");
    }
}
