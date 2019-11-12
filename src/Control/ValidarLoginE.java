
package Control;

import Entidad.Edata;
import Entidad.Empleado;
import Frontera.VentanaPrincipal;

/**
 *
 * @author Marcos
 */
public class ValidarLoginE {
    
    private Edata sistema = VentanaPrincipal.sistema;
    
    public ValidarLoginE(){}
    
    public String verificarLogin(Empleado emp){
        if(!verificarLongitudUser(emp.getUser())){
            return ("Longitud nombre incorrecta");
        }
        if(!verificarLongitudPassword(emp.getPassword())){
            return ("Longitud contraseña incorrecta");
        } else {
        }
        for(Empleado u: sistema.getEmpleados()){
            if(u.getUser().equals(emp.getUser()) && u.getPassword().equals(emp.getPassword())){
                return ("Bienvenido");
            }
        }
        return ("Datos incorrectos");
    }
    
    
    public boolean verificarLongitudUser(String user){
        return (user.length() >3 && user.length()<=5);
    }
    
    public boolean verificarLongitudPassword(String password){
        return (password.length() >=4 && password.length()<9);
    }
}
