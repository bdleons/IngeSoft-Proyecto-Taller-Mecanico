
package Entidad;

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
@Table(name="productos")
public class Producto {
    private String nombre;
    private int cantidad;
    private int codigo; //deuda técnica - manejo de excepciones, no necesidad de implementación DB en GUI
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public Producto(){}
    
    public String getNombre() {
        return nombre;
    }

   
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
    public int getCantidad() {
        return cantidad;
    }

  
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

   
    public int getCodigo() {
        return codigo;
    }

  
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
       
}
