package Entidad;

import java.util.ArrayList;

/**
 *
 * @author Marcos
 */
public class Cdata {
    private ArrayList <Cliente> clientes;

    public Cdata() {
    }

    public Cdata(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    

}
