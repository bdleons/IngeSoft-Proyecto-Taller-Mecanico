/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Control.ValidarRegistroC;
import DAO.ClienteDAO;

import Entidad.Cliente;
import static Frontera.RegistroCliente.clientes;
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
public class PruebaRegistroCliente {
    
    private static ValidarRegistroC validarRegistro = new ValidarRegistroC();
    
    private String LONG_NOMBRE_INCORRECTA = "No cumple con la Longitud del nombre el usuario";       
    private String LONG_APELLIDO_INCORRECTA = "No cumple con la longitud de los apellidos del usuario";       
    private String LONG_CEDULA_INCORRECTA = "La longitud de la cedula no es correcta";
    private String LONG_DIRECCION_INCORRECTA = "La longitud de la direccion no es correcta";        
    private String LONG_TELEFONO_INCORRECTA = "La longitud del telefono no es la correcta";   
    private String DISPONIBILIDAD_CEDULA = "La cedula ya esta registrada";
    private String CASO_EXITOSO = "Usuario registrado con exito"; 
    public PruebaRegistroCliente() {
    }
    
    @BeforeClass
    public static void setUpClass() {
   
  //  ArrayList<Cliente> clientes = new ArrayList<Cliente>();
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
    
    clientes.add(a);
    
    b.setNombres("Diana");
    b.setApellidos("Hernandez");
    b.setDireccion("calle y carrera");
    b.setTelefono(7654321);
    b.setCedula(7654321);
    
   // clientes.add(a);
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
    public void testLongitudNombre(){
        Cliente u = new Cliente();
        u.setNombres("R");
        u.setApellidos("Mendoza");
        u.setDireccion("calle 52 ");
        u.setTelefono(1234567);
        u.setCedula(123458);      
        assertEquals(validarRegistro.VerificarRegistro(u), LONG_NOMBRE_INCORRECTA);
        u.setNombres("Ryugunothwer Misinjawer");
        u.setApellidos("Mendoza");
        u.setDireccion("calle y carrera");
        u.setTelefono(1234567);
        u.setCedula(123458);      
        assertEquals(validarRegistro.VerificarRegistro(u), LONG_NOMBRE_INCORRECTA);
    }
      @Test
    public void testLongitudApellidos(){
        Cliente u = new Cliente();
        u.setNombres("Juan");
        u.setApellidos("M");
        u.setDireccion("calle 52 ");
        u.setTelefono(1234567);
        u.setCedula(123458);      
        assertEquals(validarRegistro.VerificarRegistro(u), LONG_APELLIDO_INCORRECTA);
        u.setNombres("Juan");
        u.setApellidos("Mendoza de la rosa de San Francisco");
        u.setDireccion("calle 52 ");
        u.setTelefono(1234567);
        u.setCedula(123458);      
        assertEquals(validarRegistro.VerificarRegistro(u), LONG_APELLIDO_INCORRECTA);
    }   
         @Test
    public void testLongitudDireccion(){
        Cliente u = new Cliente();
        u.setNombres("Juan");
        u.setApellidos("Mendoza");
        u.setDireccion("calle 52 a bis a carrera 99  b - 55");
        u.setTelefono(1234567);
        u.setCedula(123458);      
        assertEquals(validarRegistro.VerificarRegistro(u), LONG_DIRECCION_INCORRECTA);
        u.setNombres("Juan");
        u.setApellidos("Mendoza");
        u.setDireccion("c");
        u.setTelefono(1234567);
        u.setCedula(123458);      
        assertEquals(validarRegistro.VerificarRegistro(u), LONG_DIRECCION_INCORRECTA);
    }   
             @Test
    public void testLongitudTelefono(){
        Cliente u = new Cliente();
        u.setNombres("Juan");
        u.setApellidos("Mendoza");
        u.setDireccion("calle 52 ");
        u.setTelefono(123457);
        u.setCedula(123458);    
        assertEquals(validarRegistro.VerificarRegistro(u), LONG_TELEFONO_INCORRECTA);
        u.setNombres("Juan");
        u.setApellidos("Mendoza");
        u.setDireccion("calle 52");
        u.setTelefono(12345667);
        u.setCedula(123458);      
        assertEquals(validarRegistro.VerificarRegistro(u), LONG_TELEFONO_INCORRECTA);
    }   
    @Test
    public void testLongitudCedula(){
        Cliente u = new Cliente();
        u.setNombres("Juan");
        u.setApellidos("Mendoza");
        u.setDireccion("calle 52 ");
        u.setTelefono(1234567);
        u.setCedula(123);      
        assertEquals(validarRegistro.VerificarRegistro(u), LONG_CEDULA_INCORRECTA);
        u.setNombres("Juan");
        u.setApellidos("Mendoza");
        u.setDireccion("calle 52");
        u.setTelefono(1234567);
        u.setCedula(1234588165);     
        assertEquals(validarRegistro.VerificarRegistro(u),LONG_CEDULA_INCORRECTA );

    }  
    @Test
    public void testdisponibilidadcedula(){
        Cliente u = new Cliente();
        u.setNombres("Juan");
        u.setApellidos("Mendoza");
        u.setDireccion("calle 52 ");
        u.setTelefono(1234567);
        u.setCedula(1234567);       
        assertEquals(validarRegistro.VerificarRegistro(u), DISPONIBILIDAD_CEDULA);
    }
    @Test
    public void testExito(){
        Cliente u = new Cliente();
        u.setNombres("Juan");
        u.setApellidos("Mendoza");
        u.setDireccion("calle 52 ");
        u.setTelefono(1234567);
        u.setCedula(123458);      
        assertEquals(validarRegistro.VerificarRegistro(u), CASO_EXITOSO);
    }
}