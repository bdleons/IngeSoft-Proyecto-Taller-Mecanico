
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
@Table(name="clientes")
public class Cliente implements Serializable{
    private String nombres;
    private String apellidos;
    private double cedula;
    private double telefono;
    private String direccion;
    private int num_Vehiculos;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public Cliente(){}
    
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public double getCedula() {
        return cedula;
    }

    public void setCedula(double cedula) {
        this.cedula = cedula;
    }

    public double getTelefono() {
        return telefono;
    }

    public void setTelefono(double telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNum_Vehiculos() {
        return num_Vehiculos;
    }

    public void setNum_Vehiculos(int num_Vehiculos) {
        this.num_Vehiculos = num_Vehiculos;
    } 
    
}
