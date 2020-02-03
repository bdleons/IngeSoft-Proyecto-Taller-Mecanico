
package Entidad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Marcos
 */
@Entity
@Table(name="empleados")
public class Empleado implements Serializable {
    private String empleado;
    private String password;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public Empleado(){}
    
    public String getUser() {
        return empleado;
    }

    public void setUser(String empleado) {
        this.empleado = empleado;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
