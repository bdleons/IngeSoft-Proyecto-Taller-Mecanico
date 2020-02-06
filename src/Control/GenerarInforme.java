/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.ProductoDAO;
import Entidad.Producto;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import javax.swing.JTable;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.*;

/**
 *
 * @author braya
 */
public class GenerarInforme {

    Workbook wb;
    
    ProductoDAO invDao = new ProductoDAO();
    
    
    public String ExportarInventario(File archivo) {

        String respuesta = "No se realizo con exito la exportación.";
        List<Producto> inventario = invDao.leer();

        if (inventario == null) {
            respuesta = "No hay inventario.";
        } else {
            String nombres[] = {"Cantidad", "Codigo", "Nombre", "Precio de Compra", "Precio de Venta"};
            int numFila = inventario.size(), numColumna = nombres.length;
            System.out.println("tamaño inventario: " + numFila);
            if (archivo.getName().endsWith("xls")) {
                wb = new HSSFWorkbook();
            } else {
                wb = new XSSFWorkbook();
            }
            Sheet hoja = wb.createSheet("Inventario");

            try {
                for (int i = -1; i < numFila; i++) {
                    Row fila = hoja.createRow(i + 1);
                    for (int j = 0; j < numColumna; j++) {
                        Cell celda = fila.createCell(j);
                        if (i == -1) {
                            celda.setCellValue(String.valueOf(nombres[j]));
                        } else {
                            Producto pInventario = inventario.get(i);
                            String pInventarioValues[] = {String.valueOf(pInventario.getCantidad()), String.valueOf(pInventario.getCodigo()),
                                String.valueOf(pInventario.getNombre()), String.valueOf(pInventario.getPrecioCompra()), String.valueOf(pInventario.getPrecioVenta())};
                            celda.setCellValue(String.valueOf(pInventarioValues[j]));
                        }
                        wb.write(new FileOutputStream(archivo));
                    }
                }
                respuesta = "Exportación exitosa.";
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return respuesta;
    }

}
