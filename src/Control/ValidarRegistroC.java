/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import DAO.ClienteDAO;
import Entidad.Cliente;
import Frontera.RegistroCliente;


/**
 *
 * @author Marcos
 */
public class ValidarRegistroC {
 
    private ClienteDAO dao = new ClienteDAO();

    public ValidarRegistroC() {
    }
    
    public boolean validarCedulaRepetido(/*long cedula*/Cliente client){
    /*for(Cliente u : RegistroCliente.clientes ){
            if(u.getCedula() == cedula){
                return false; // en caso de que el cedula este repetido                
            } 
        }*/
    if(dao.leer(client) != null)
        return false;
    return true;
    }
    public boolean validarCedulaExiste(long cedula){  
    if(dao.leer(cedula) == null)
        return false;
    return true;
    }
    
    public boolean verificarLongitudCedula (long cedula){
        return (cedula > 999 && cedula <= 999999999); // tamaño de 4 a 9 digitos
    }
    
    public boolean verificarLongitudNombres (String nombre){
        return (nombre.length() > 1 && nombre.length() <= 15);
    }
    
    public boolean verificarLongitudApellidos (String apellidos){
        return (apellidos.length() > 1 && apellidos.length() <= 15);
    }

    public boolean verificarLongitudDireccion (String direccion){
        return (direccion.length() > 1 && direccion.length() <= 22);
    }

    public boolean verificarLongitudTelefono (long telefono){
        return (telefono > 999999 && telefono <= 9999999); // 7 digitos
    }    
    
    public String VerificarRegistro(Cliente clicach){
        if(!validarCedulaRepetido(clicach)){
            return("La cedula ya esta registrada");            
        }
        if(!verificarLongitudCedula((long) clicach.getCedula())){
            return("La longitud de la cedula no es correcta");
        }
        if(!verificarLongitudNombres(clicach.getNombres())){
            return("No cumple con la Longitud del nombre el usuario"); 
        }
        if(!verificarLongitudApellidos(clicach. getApellidos())){
            return("No cumple con la longitud de los apellidos del usuario");
        }
        if(!verificarLongitudDireccion(clicach.getDireccion())){
            return("La longitud de la direccion no es correcta");
        }
        if(!verificarLongitudTelefono((long) clicach.getTelefono())){
            return("La longitud del telefono no es la correcta");
        }
        return("Usuario registrado con exito");
    }
    public String VerificarActualización(Cliente clicach, long cedula){
        if(!validarCedulaRepetido(clicach)){
            return("La cedula ya esta registrada");            
        }
        if (!validarCedulaExiste(cedula)){
            return("La cedula que quiere cambiar no existe");            
        }
        if(!verificarLongitudCedula((long) clicach.getCedula())){
            return("La longitud de la cedula no es correcta");
        }
        if(!verificarLongitudNombres(clicach.getNombres())){
            return("No cumple con la Longitud del nombre el usuario"); 
        }
        if(!verificarLongitudApellidos(clicach. getApellidos())){
            return("No cumple con la longitud de los apellidos del usuario");
        }
        if(!verificarLongitudDireccion(clicach.getDireccion())){
            return("La longitud de la direccion no es correcta");
        }
        if(!verificarLongitudTelefono((long) clicach.getTelefono())){
            return("La longitud del telefono no es la correcta");
        }
        return("Usuario registrado con exito");
    }
    public boolean ExitoRegistro(Cliente clicach){
        return(validarCedulaRepetido(clicach) && verificarLongitudApellidos(clicach.getApellidos()) && verificarLongitudCedula((long) clicach.getCedula()) && verificarLongitudNombres(clicach.getNombres()) && verificarLongitudDireccion(clicach.getDireccion()) && verificarLongitudTelefono((long) clicach.getTelefono()));
    }
}
