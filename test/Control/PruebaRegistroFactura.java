/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Control.ValidarRegistroF;
import Entidad.Factura;
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
public class PruebaRegistroFactura {
    
    private ValidarRegistroF validar = new ValidarRegistroF();
            
    private String PRECIO_FACTURA = "El precio de la factura no puede ser 0";
    private String EXIO_VALIDAR = "Exito en registro de factura";
    
    public PruebaRegistroFactura() {
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
    public void ValidarUnicidadCodigo() {
    
        Factura fac_cache = new Factura();
       fac_cache.setPrecio(0);
        assertEquals(validar.validarRegistro(fac_cache),PRECIO_FACTURA);
    }
         @Test
    public void ValidarLongCodigo() {
    
        Factura fac_cache = new Factura();
       fac_cache.setPrecio(2000);
        assertEquals(validar.validarRegistro(fac_cache),EXIO_VALIDAR);;
    }
}
