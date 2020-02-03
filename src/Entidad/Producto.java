
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
@Table(name="productos")
public class Producto implements Serializable {
    private String nombre;
    private int cantidad;
    private int codigo; 
    private float precioCompra; 
    public float precioVenta;
    

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

    public float getPrecioCompra() {
        return precioCompra;
    }
    
    public void setPrecioCompra(float precio) {
        this.precioCompra = precio;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }
       
}
