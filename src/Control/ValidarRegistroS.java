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
    public boolean validarCodigoRepetido(Servicio serv){
    if(dao.leer(serv) != null)
        return false;
    return true;
    }
    /*public boolean validarCodigoexistente(Servicio serv){
        if(dao.leer(serv) == null)
        return false;
    return true;
    }*/
    public boolean validarLongitudCodigo(int serv){
        if(serv >9999 && serv <= 9999999){
            return true;
        }
        return false;
    }
    public boolean validarLongitudNombre(String serv){
        if(serv.length() >=2 && serv.length() <= 15){
            return true;
        }
        return false;
    }
    public String VerificarServicio(Servicio serviciocache){
        if(!validarCodigoRepetido(serviciocache)){
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
