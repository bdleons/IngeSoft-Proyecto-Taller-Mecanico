/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author NICOLAS
 */
@Entity
@Table(name="factura")
public class Factura implements Serializable {

    private long cedulacliente;
    private int idempleado; //tomar el id del empleado por medio de la contraseña buscando en la tabla empleados
    private String autoCliente;
    private String servicioTomado;
    private String productoComprado;
    //private ArrayList<Producto> productos;
    //private ArrayList<Servicio> servicios;    
    private float precio;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Factura[ id=" + id + " ]";
    }*/

    public Factura() {
    }

    public long getCedulacliente() {
        return cedulacliente;
    }

    public void setCedulacliente(long cedulacliente) {
        this.cedulacliente = cedulacliente;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    /*public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }*/

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getAutoCliente() {
        return autoCliente;
    }

    public void setAutoCliente(String autoCliente) {
        this.autoCliente = autoCliente;
    }

    public String getServicioTomado() {
        return servicioTomado;
    }

    public void setServicioTomado(String servicioTomado) {
        this.servicioTomado = servicioTomado;
    }

    public String getProductoComprado() {
        return productoComprado;
    }

    public void setProductoComprado(String productoComprado) {
        this.productoComprado = productoComprado;
    }
    
    
    
}
