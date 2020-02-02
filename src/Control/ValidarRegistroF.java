/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.FacturaDAO;
import Entidad.Cliente;
import Entidad.Factura;
import static Frontera.RegistroCliente.clientes;

/**
 *
 * @author NICOLAS
 */
public class ValidarRegistroF {
    
    private FacturaDAO dao = new FacturaDAO();

    public ValidarRegistroF() {
    }
    
    public boolean validarExitenciaCliente(long cedula){
    for(Cliente u : clientes ){
            if(u.getCedula() == cedula){
                return true; // en caso de que la cedula exista                
            }
        }
    return false;
    }
   
    public boolean validarPrecio(double precio){
        return precio != 0;
    }
    
    public String validarRegistro(Factura facturacache){
        if(!validarExitenciaCliente(facturacache.getCedulacliente())){
            return "Cedula del cliente no esta registrada";
        }
        if(!validarPrecio(facturacache.getPrecio())){
            return "El precio de la factura es incorrecto";
        }
        return "Exito en registro de factura";
    }
    
}
