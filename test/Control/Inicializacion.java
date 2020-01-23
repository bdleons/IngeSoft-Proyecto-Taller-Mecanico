/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.ClienteDAO;
import Entidad.Cliente;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author NICOLAS
 */
public class Inicializacion {
    
    public Inicializacion() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void initData(){
    
    ArrayList<Cliente> clientes = new ArrayList<Cliente>();
   ClienteDAO dao = new ClienteDAO();
    // Creacion usuarios
    Cliente a = new Cliente();
    Cliente b = new Cliente();
    
    //Datos
    
    a.setNombres("Juan");
    a.setApellidos("Mendoza");
    a.setDireccion("calle y carrera");
    a.setTelefono(1234567);
    a.setCedula(1234567);
    
    a.setNombres("Diana");
    a.setApellidos("Hernandez");
    a.setDireccion("calle y carrera");
    a.setTelefono(7654321);
    a.setCedula(7654321);
    
    clientes.add(a);
    clientes.add(b);
  
       for(Cliente u: clientes){
            System.out.println(u.getNombres());
            System.out.println(u.getApellidos());
            System.out.println(u.getDireccion());
            System.out.println(u.getTelefono());
            System.out.println(u.getCedula());
            System.out.println("----------------");
            dao.crear(u);
        }
        
    }
}
