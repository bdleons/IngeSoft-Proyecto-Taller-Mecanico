/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author Marcos
 */
public class CalculoPrecioProducto {
    
   public CalculoPrecioProducto(){        
    }
    
    public float calcularPrecioProducto(float precioCompra){
        float precioVenta;
        precioVenta = (float) (precioCompra * 1.35);
        return precioVenta;
    }
    
}
