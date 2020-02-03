
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
@Table(name="vehiculos")
public class Vehiculo implements Serializable {
    private String modelo;
    private String matricula;
    private String tipo_vehiculo;
    private String observaciones;
    private long cedDueño;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    public Vehiculo(){        
    }
    
    public String getModelo() {
        return modelo;
    }

  
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

   
    public String getMatricula() {
        return matricula;
    }

 
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTipo_vehiculo() {
        return tipo_vehiculo;
    }

    public void setTipo_vehiculo(String tipo_vehiculo) {
        this.tipo_vehiculo = tipo_vehiculo;
    }

   
    public String getObservaciones() {
        return observaciones;
    }

  
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * @return the cedDueño
     */
    public long getCedDueño() {
        return cedDueño;
    }

    public void setCedDueño(long cedDueño) {
        this.cedDueño = cedDueño;
    }
 
}
