/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Control.ValidarRegistroS;
import Entidad.Servicio;
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
public class PruebaRegistroServicio {
    
    private ValidarRegistroS validar = new ValidarRegistroS();
            
    private String EL_CODIGO_YA_EXISTE = "El código ya existe";
    private String LONG_SERV_INCORRECTA = "Longitud del servicio incorrecta";
    private String LONG_NOMBRE_INCORRECTO = "Longitud del nombre incorrecto";
    private String EXITO = "Servicio correcto";
    
    public PruebaRegistroServicio() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Servicio service = new Servicio();
        service.setCodigo(44444);
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
    
        Servicio ser_cache = new Servicio();
        ser_cache.setCodigo(44444);
        assertEquals(validar.VerificarServicio(ser_cache),EL_CODIGO_YA_EXISTE);
    }
         @Test
    public void ValidarLongCodigo() {
    
        Servicio ser_cache = new Servicio();
        ser_cache.setCodigo(4444);
        assertEquals(validar.VerificarServicio(ser_cache),LONG_SERV_INCORRECTA);
        Servicio ser_cache2 = new Servicio();
        ser_cache2.setCodigo(99999999);
        assertEquals(validar.VerificarServicio(ser_cache2),LONG_SERV_INCORRECTA);
    }
    
          @Test
    public void ValidarLongNombre() {
    
        Servicio ser_cache = new Servicio();
        ser_cache.setNombreservicio("s");
        assertEquals(validar.VerificarServicio(ser_cache),LONG_NOMBRE_INCORRECTO);
        Servicio ser_cache2 = new Servicio();
        ser_cache2.setNombreservicio("servicio de lavado");
        assertEquals(validar.VerificarServicio(ser_cache2),LONG_NOMBRE_INCORRECTO);
    }
     @Test
    public void ValidarExito() {
    
        Servicio ser_cache = new Servicio();
        ser_cache.setCodigo(44445);
        ser_cache.setNombreservicio("polichado");
        ser_cache.setPrecioBaseHora(12000);
        assertEquals(validar.VerificarServicio(ser_cache),EXITO);
    }
}
