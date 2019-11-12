
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
    private String Nombres;
    private String Apellidos;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int cedula;
    private int telefono;
    private String direccion;
    private int num_Vehiculos;

    Cliente(){}
    
    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int identificacion) {
        this.cedula = cedula;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
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
