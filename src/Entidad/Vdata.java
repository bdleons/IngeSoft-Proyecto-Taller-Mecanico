/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.util.ArrayList;

public class Vdata {
    
    // Arreglo que contiene todos los vehiculos registrados
        private ArrayList <Vehiculo> vehiculosAlmacen;

    public Vdata(ArrayList<Vehiculo> vehiculosAlmacen) {
        this.vehiculosAlmacen = vehiculosAlmacen;
    }

    public ArrayList<Vehiculo> getVehiculosAlmacen() {
        return vehiculosAlmacen;
    }

    public void setVehiculosAlmacen(ArrayList<Vehiculo> vehiculosAlmacen) {
        this.vehiculosAlmacen = vehiculosAlmacen;
    }

}
