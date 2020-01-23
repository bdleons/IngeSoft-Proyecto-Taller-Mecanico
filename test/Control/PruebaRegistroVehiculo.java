/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Cliente;
import Entidad.Vehiculo;
import static Frontera.RegistroCliente.clientes;
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
public class PruebaRegistroVehiculo {
    
    private static ValidarRegistroV validar = new ValidarRegistroV(); 
    
    private String LONG_MATRICULA_INCORRECTO = "Longitud matricula incorrecta";
    private String CLIENTE_NO_EXISTE = "El cliente no existe";
    private String EXITO_VALIDAR = "Exito en validar Vehiculo";
    
    
    public PruebaRegistroVehiculo() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Cliente a = new Cliente();
    a.setNombres("Juan");
    a.setApellidos("Mendoza");
    a.setDireccion("calle y carrera");
    a.setTelefono(1234567);
    a.setCedula(1234567);
    clientes.add(a);
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
    @Test
    public void ValidarMatricula() {
    
        Vehiculo veh_cache = new Vehiculo();
        veh_cache.setCedDueño(1234567);
        veh_cache.setMatricula("JGS3453");
        assertEquals(validar.VerificarVehiculo(veh_cache),LONG_MATRICULA_INCORRECTO);
    }
       @Test
    public void ValidarCliente() {
    
        Vehiculo veh_cache = new Vehiculo();
        veh_cache.setCedDueño(1234569);
        veh_cache.setMatricula("JGS345");
        assertEquals(validar.VerificarVehiculo(veh_cache),CLIENTE_NO_EXISTE);
    }
       @Test
    public void ValidarExito() {
    
        Vehiculo veh_cache = new Vehiculo();
        veh_cache.setCedDueño(1234567);
        veh_cache.setMatricula("JGS345");
        assertEquals(validar.VerificarVehiculo(veh_cache),EXITO_VALIDAR);
    }
}