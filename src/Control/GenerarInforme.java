/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.FacturaDAO;
import DAO.ProductoDAO;
import Entidad.Factura;
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
    FacturaDAO facDao = new FacturaDAO();
    float valorTotalInventario = 0, valorTotalEsperadodeVenta = 0, totalProductos = 0, totalDeVentas = 0;

    public Object[][] inventarioValues(List<Producto> inventario) {
        Object sInventarioValues[][] = new Object[inventario.size()][5];
        for (int i = 0; i < inventario.size(); i++) {
            Producto pInventario = inventario.get(i);
            totalProductos += pInventario.getCantidad();
            valorTotalInventario += pInventario.getPrecioCompra();
            valorTotalEsperadodeVenta += pInventario.getPrecioVenta();
            sInventarioValues[i][0] = pInventario.getCantidad();
            sInventarioValues[i][1] = pInventario.getCodigo();
            sInventarioValues[i][2] = pInventario.getNombre();
            sInventarioValues[i][3] = pInventario.getPrecioCompra();
            sInventarioValues[i][4] = pInventario.getPrecioVenta();
        }
        return sInventarioValues;
    }

    public Object[][] facturaValues(List<Factura> facturas) {
        Object sFacturaValues[][] = new Object[facturas.size()][5];
        for (int i = 0; i < facturas.size(); i++) {
            Factura fFacturas = facturas.get(i);
            totalDeVentas+=fFacturas.getPrecio();
            sFacturaValues[i][0] = fFacturas.getIdempleado();
            sFacturaValues[i][1] = fFacturas.getCedulacliente();
            sFacturaValues[i][2] = fFacturas.getAutoCliente();
            sFacturaValues[i][3] = fFacturas.getProductoComprado();
            sFacturaValues[i][4] = fFacturas.getServicioTomado();
            sFacturaValues[i][5] = fFacturas.getPrecio();
        }
        return sFacturaValues;
    }

    public String ExportarInventario(File archivo) {

        String respuesta = "No se realizo con exito la exportación.";
        List<Producto> inventario = invDao.leer();

        if (inventario == null) {
            respuesta = "No hay inventario.";
        } else {
            String nombres[] = {"Cantidad", "Codigo", "Nombre", "Precio de Compra", "Precio de Venta"};
            String nombresInfo[] = {"Total de Productos", "Valor Total Inventario", "Valor Total Esperado de Venta"};
            int numFila = inventario.size(), numColumna = nombres.length;
            System.out.println("tamaño inventario: " + numFila);
            if (archivo.getName().endsWith("xls")) {
                wb = new HSSFWorkbook();
            } else {
                wb = new XSSFWorkbook();
            }
            Sheet hoja = wb.createSheet("Inventario");
            Object pInventarioValues[][] = inventarioValues(inventario);
            Float valoresInfo[] = {totalProductos, valorTotalInventario, valorTotalEsperadodeVenta};
            try {
                for (int i = -1; i < numFila; i++) {
                    Row fila = hoja.createRow(i + 1);
                    for (int j = 0; j < numColumna; j++) {
                        Cell celda = fila.createCell(j);
                        if (i == -1) {
                            Font bold = wb.createFont();
                            bold.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
                            XSSFCellStyle styleBold = (XSSFCellStyle) wb.createCellStyle();
                            styleBold.setFont(bold);
                            celda.setCellStyle(styleBold);
                            celda.setCellValue(String.valueOf(nombres[j]));
                        } else {
                            Object obj = pInventarioValues[i][j];
                            if (obj instanceof Float) {
                                celda.setCellValue((Float) obj);
                            } else if (obj instanceof Integer) {
                                celda.setCellValue((Integer) obj);
                            } else {
                                celda.setCellValue("" + obj);
                            }
                        }
                        wb.write(new FileOutputStream(archivo));
                    }
                }

                int numFinalFila = inventario.size() + 4, numFinalColumna = nombresInfo.length;

                for (int i = inventario.size() + 2; i < numFinalFila; i++) {
                    Row fila = hoja.createRow(i + 1);
                    for (int j = 0; j < numFinalColumna; j++) {
                        Cell celda = fila.createCell(j);
                        if (i == inventario.size() + 2) {
                            Font bold = wb.createFont();
                            bold.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
                            XSSFCellStyle styleBold = (XSSFCellStyle) wb.createCellStyle();
                            styleBold.setFont(bold);
                            celda.setCellStyle(styleBold);
                            celda.setCellValue(String.valueOf(nombresInfo[j]));
                        } else {
                            Object obj = valoresInfo[j];
                            if (obj instanceof Float) {
                                celda.setCellValue((Float) obj);
                            } else if (obj instanceof Integer) {
                                celda.setCellValue((Integer) obj);
                            } else {
                                celda.setCellValue("" + obj);
                            }
                        }
                        wb.write(new FileOutputStream(archivo));
                    }
                }

                respuesta = "Exportación exitosa.";
                wb.write(new FileOutputStream(archivo));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return respuesta;
    }

    public String ExportarFacturas(File archivo) {

        String respuesta = "No se realizo con exito la exportación.";
        List<Factura> facturas = facDao.leer();

        if (facturas == null) {
            respuesta = "No hay facturas. No se han hecho ventas";
        } else {
            String nombres[] = {"Id Empleado", "Cedula Cliente", "Auto del Cliente", "Producto Comprado", "Servicio Tomado", "Precio Total"};
            String nombresInfo[] = {"Total de Ventas"};
            int numFila = facturas.size(), numColumna = nombres.length;
            System.out.println("Numero de Facturas: " + numFila);
            if (archivo.getName().endsWith("xls")) {
                wb = new HSSFWorkbook();
            } else {
                wb = new XSSFWorkbook();
            }
            Sheet hoja = wb.createSheet("Facturas");
            Object pFacturaValues[][] = facturaValues(facturas);
            Float valoresInfo[] = {totalDeVentas};
            try {
                for (int i = -1; i < numFila; i++) {
                    Row fila = hoja.createRow(i + 1);
                    for (int j = 0; j < numColumna; j++) {
                        Cell celda = fila.createCell(j);
                        if (i == -1) {
                            Font bold = wb.createFont();
                            bold.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
                            XSSFCellStyle styleBold = (XSSFCellStyle) wb.createCellStyle();
                            styleBold.setFont(bold);
                            celda.setCellStyle(styleBold);
                            celda.setCellValue(String.valueOf(nombres[j]));
                        } else {
                            Object obj = pFacturaValues[i][j];
                            if (obj instanceof Float) {
                                celda.setCellValue((Float) obj);
                            } else if (obj instanceof Integer) {
                                celda.setCellValue((Integer) obj);
                            } else {
                                celda.setCellValue("" + obj);
                            }
                        }
                        wb.write(new FileOutputStream(archivo));
                    }
                }

                int numFinalFila = facturas.size() + 4, numFinalColumna = nombresInfo.length;

                for (int i = facturas.size() + 2; i < numFinalFila; i++) {
                    Row fila = hoja.createRow(i + 1);
                    for (int j = 0; j < numFinalColumna; j++) {
                        Cell celda = fila.createCell(j);
                        if (i == facturas.size() + 2) {
                            Font bold = wb.createFont();
                            bold.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
                            XSSFCellStyle styleBold = (XSSFCellStyle) wb.createCellStyle();
                            styleBold.setFont(bold);
                            celda.setCellStyle(styleBold);
                            celda.setCellValue(String.valueOf(nombresInfo[j]));
                        } else {
                            Object obj = valoresInfo[j];
                            if (obj instanceof Float) {
                                celda.setCellValue((Float) obj);
                            } else if (obj instanceof Integer) {
                                celda.setCellValue((Integer) obj);
                            } else {
                                celda.setCellValue("" + obj);
                            }
                        }
                        wb.write(new FileOutputStream(archivo));
                    }
                }

                respuesta = "Exportación exitosa.";
                wb.write(new FileOutputStream(archivo));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return respuesta;
    }

}
