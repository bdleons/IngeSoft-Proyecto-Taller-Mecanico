/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.VehiculoDAO;
import Entidad.Cliente;
import Entidad.Vehiculo;
import static Frontera.RegistroCliente.clientes;

/**
 *
 * @author Marcos
 */
public class ValidarRegistroV {
    VehiculoDAO dao = new VehiculoDAO();
    public ValidarRegistroV() {
    }
    
    private boolean validarExitenciaCliente(long cedula){
    for(Cliente u : clientes ){
            if(u.getCedula() == cedula){
                return true; // en caso de que la cedula exista                
            }
        }
    return false;
    }
    private boolean validarMatricula(Vehiculo vehiculo){
        if(dao.leer(vehiculo) != null)
            return false;
        return true;   
    }
    
    private boolean validarLongitudMatricula(String matricula){
        if(matricula.length()==6){
            return true;
        }
        return false;
    }
    
    public String VerificarVehiculo(Vehiculo veh_cache){
        if(!validarExitenciaCliente(veh_cache.getCedDueño())){
            return("El cliente no existe");
        }
        if(!validarMatricula(veh_cache)){
            return("La matrícula ya está registrada");
        }
        if(!validarLongitudMatricula(veh_cache.getMatricula())){
            return("Longitud matricula incorrecta");
        }
        return("Exito en validar Vehiculo");
    }
}
