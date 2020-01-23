/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Producto;
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
public class PruebaRegistroProducto {
    
    private static ValidarRegistroP validar = new ValidarRegistroP(); 
    
    private String LONG_CODIGO_INCORRECTO = "Longitud del producto incorrecta";
    private String LONG_NOMBRE_INCORRECTO = "Longitud del nombre incorrecto";
    private String EXITO_VALIDAR = "Producto correcto";

    public PruebaRegistroProducto() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        //new Inicializacion();
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
    public void LongitudCodigo(){
        
        Producto productcache = new Producto();
        productcache.setCantidad(5);
        productcache.setCodigo(999999);
        productcache.setNombre("chocorramo");
        assertEquals(validar.VerificarProducto(productcache), LONG_CODIGO_INCORRECTO);
    }
    @Test
    public void Longitudnombre(){
        Producto productcache = new Producto();
        productcache.setCantidad(5);
        productcache.setCodigo(9999999);
        productcache.setNombre("chocorramo y jugo de papaya con bocadillo");
        assertEquals(validar.VerificarProducto(productcache), LONG_NOMBRE_INCORRECTO);
    }
    @Test
    public void Exito(){
        Producto productcache = new Producto();
        productcache.setCantidad(5);
        productcache.setCodigo(9999999);
        productcache.setNombre("chocorramo");
        assertEquals(validar.VerificarProducto(productcache), EXITO_VALIDAR);
    }
}
