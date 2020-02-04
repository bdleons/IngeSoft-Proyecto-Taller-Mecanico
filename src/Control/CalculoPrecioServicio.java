/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.ProductoDAO;
import DAO.ServicioDAO;
import DAO.VehiculoDAO;
import Entidad.Producto;
import Entidad.Servicio;
import Entidad.Vehiculo;

/**
 *
 * @author Marcos
 */
public class CalculoPrecioServicio {
    private final float parametroAuto;
    private final float parametroMoto;
    private final float parametroCamioneta;
    private final float parametroVPesado;
    
    CalculoPrecioServicio(){
        this.parametroAuto = (float) 1.94;
        this.parametroMoto = (float) 1.43;
        this.parametroCamioneta = (float) 2.3;
        this.parametroVPesado = (float) 2.67;
    }
    public float calcularPrecioServicio( Servicio servicio, Vehiculo vehiculo){
        float precioTotal = 0;
        
        VehiculoDAO daoV = new VehiculoDAO();
        ServicioDAO daoS = new ServicioDAO();
        Vehiculo vehic = daoV.leer(vehiculo);
        Servicio serv = daoS.leer(servicio);
        
        switch(vehic.getTipo_vehiculo()){
            case "Auto":{
                if(serv.getUsoProducto().equals("Ninguno")){
                    precioTotal = parametroAuto * serv.getPrecioBaseHora();
                }else{
                    ProductoDAO daoP = new ProductoDAO();                    
                    Producto prod = daoP.leer(serv.getUsoProducto());
                    precioTotal =  (parametroAuto * serv.getPrecioBaseHora() + prod.getPrecioVenta());
                }
                break;
            }
            case "Moto":{
                if(serv.getUsoProducto().equals("Ninguno")){
                    precioTotal = parametroMoto  * serv.getPrecioBaseHora();
                }else{
                    ProductoDAO daoP = new ProductoDAO();                    
                    Producto prod = daoP.leer(serv.getUsoProducto());
                    precioTotal =  (parametroMoto  * serv.getPrecioBaseHora() + prod.getPrecioVenta());
                }
                break;
            }
            case "Camioneta":{
                if(serv.getUsoProducto().equals("Ninguno")){
                    precioTotal = parametroCamioneta *  serv.getPrecioBaseHora();
                }else{
                    ProductoDAO daoP = new ProductoDAO();                    
                    Producto prod = daoP.leer(serv.getUsoProducto());
                    precioTotal =  (parametroCamioneta *  serv.getPrecioBaseHora() + prod.getPrecioVenta());
                }
                break;
            }
            case "Vehículo pesado":{
                if(serv.getUsoProducto().equals("Ninguno")){
                    precioTotal = parametroVPesado * serv.getPrecioBaseHora();
                }else{
                    ProductoDAO daoP = new ProductoDAO();                    
                    Producto prod = daoP.leer(serv.getUsoProducto());
                    precioTotal =  (parametroVPesado *  serv.getPrecioBaseHora() + prod.getPrecioVenta());
                }
                break;
            }
        }
        return precioTotal;
    }
}
