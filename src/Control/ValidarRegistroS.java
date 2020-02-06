/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.ServicioDAO;
import Entidad.Servicio;

/**
 *
 * @author Marcos
 */
public class ValidarRegistroS {
    private ServicioDAO dao = new ServicioDAO();
    
    public ValidarRegistroS(){        
    }
    private boolean validarCodigoRepetido(int cod){
    if(dao.leer(cod) != null)
        return false;
    return true;
    }
    /*private boolean validarCodigoexistente(Servicio serv){
        if(dao.leer(serv) == null)
        return false;
    return true;
    }*/
    private boolean validarLongitudCodigo(int serv){
        if(serv >9999 && serv <= 9999999){
            return true;
        }
        return false;
    }
    private boolean validarLongitudNombre(String serv){
        if(serv.length() >=2 && serv.length() <= 15){
            return true;
        }
        return false;
    }
    public String VerificarServicio(Servicio serviciocache){
        if(!validarCodigoRepetido(serviciocache.getCodigo())){
            return("El código ya existe");
        }
        if(!validarLongitudCodigo(serviciocache.getCodigo())){
            return("Longitud del servicio incorrecta");
        }
        if(!validarLongitudNombre(serviciocache.getNombreservicio())){
            return("Longitud del nombre incorrecto");
        }
        return("Servicio correcto");
    }
}
