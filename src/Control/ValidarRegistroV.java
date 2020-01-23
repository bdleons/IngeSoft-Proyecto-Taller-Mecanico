/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Cliente;
import Entidad.Vehiculo;
import static Frontera.RegistroCliente.clientes;

/**
 *
 * @author Marcos
 */
public class ValidarRegistroV {

    public ValidarRegistroV() {
    }
    
    public boolean validarExitenciaCliente(long cedula){
    for(Cliente u : clientes ){
            if(u.getCedula() == cedula){
                return true; // en caso de que la cedula exista                
            }
        }
    return false;
    }
    
    public boolean validarLongitudMatricula(String matricula){
        if(matricula.length()==6){
            return true;
        }
        return false;
    }
    
    public String VerificarVehiculo(Vehiculo veh_cache){
        if(!validarExitenciaCliente(veh_cache.getCedDueño())){
            return("El cliente no existe");
        }
        if(!validarLongitudMatricula(veh_cache.getMatricula())){
            return("Longitud matricula incorrecta");
        }
        return("Exito en validar Vehiculo");
    }
}
