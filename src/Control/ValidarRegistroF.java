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
   
    private boolean validarPrecio(float precio){
        return precio != 0;
    }
    
    public String validarRegistro(Factura facturacache){
        if(!validarPrecio(facturacache.getPrecio())){
            return "El precio de la factura no puede ser 0";
        }
        return "Exito en registro de factura";
    }
    
}
