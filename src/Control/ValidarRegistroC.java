/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import Entidad.Cdata;
import Entidad.Cliente;


/**
 *
 * @author Marcos
 */
public class ValidarRegistroC {
 
    private Cdata clientdata = new Cdata();

    public ValidarRegistroC() {
    }
    
    public boolean validarCedulaRepetido(double cedula){
    for(Cliente u : clientdata.getClientes()){
            if(u.getCedula() == cedula){
                return false; // en caso de que el cedula este repetido    
            }
        }
    return true;
    }
    
    public boolean verificarLongitudCedula (double cedula){
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

    public boolean verificarLongitudTelefono (double telefono){
        return (telefono > 9999999 && telefono <= 9999999); // 7 digitos
    }    
    
    public String VerificarRegistro(Cliente clicach){
        if(!validarCedulaRepetido(clicach.getCedula())){
            return("La cedula ya está registrada");
        }
        if(!verificarLongitudCedula(clicach.getCedula())){
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
        if(!verificarLongitudTelefono(clicach.getTelefono())){
            return("La longitud del telefono no es la correcta");
        }
        return("Usuario registrado con exito");
    }
    public boolean ExitoRegistro(Cliente clicach){
        return(validarCedulaRepetido(clicach.getCedula()) && verificarLongitudApellidos(clicach.getApellidos()) && verificarLongitudCedula(clicach.getCedula()) && verificarLongitudNombres(clicach.getNombres()) && verificarLongitudDireccion(clicach.getDireccion()) && verificarLongitudTelefono(clicach.getTelefono()));
    }
}
