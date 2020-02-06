/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontera;

import Control.GenerarInforme;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author braya
 */
public class Informes extends javax.swing.JFrame {

    /**
     * Creates new form Informes
     */
    public Informes() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        informeInventarioB = new javax.swing.JButton();
        inventarioOkB = new javax.swing.JButton();
        informeFacturaB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Informes");

        jLabel1.setText("Informes");

        informeInventarioB.setText("Informe de Inventario");
        informeInventarioB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                informeInventarioBActionPerformed(evt);
            }
        });

        inventarioOkB.setText("Ok");
        inventarioOkB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventarioOkBActionPerformed(evt);
            }
        });

        informeFacturaB.setText("Informe de Facturas");
        informeFacturaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                informeFacturaBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(informeFacturaB)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(138, 138, 138))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(informeInventarioB)
                            .addGap(87, 87, 87))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(inventarioOkB)
                            .addGap(25, 25, 25)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(59, 59, 59)
                .addComponent(informeInventarioB)
                .addGap(43, 43, 43)
                .addComponent(informeFacturaB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(inventarioOkB)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void informeInventarioBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informeInventarioBActionPerformed

        contAccion++;
        if (contAccion == 1) {
            AgregarFiltro();
        }

        if (selecArchivo.showDialog(null, "Exportar") == JFileChooser.APPROVE_OPTION) {
            archivo = selecArchivo.getSelectedFile();
            if (archivo.getName().endsWith("xls") || archivo.getName().endsWith("xlsx")) {
                JOptionPane.showMessageDialog(null, gInfo.ExportarInventario(archivo));
            } else {
                JOptionPane.showMessageDialog(null, "Elija un formato valido.");
            }
        }


    }//GEN-LAST:event_informeInventarioBActionPerformed

    private void inventarioOkBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventarioOkBActionPerformed
        Menu obj = new Menu();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_inventarioOkBActionPerformed

    private void informeFacturaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informeFacturaBActionPerformed
        
        contAccion++;
        if (contAccion == 1) {
            AgregarFiltro();
        }

        if (selecArchivo.showDialog(null, "Exportar") == JFileChooser.APPROVE_OPTION) {
            archivo = selecArchivo.getSelectedFile();
            if (archivo.getName().endsWith("xls") || archivo.getName().endsWith("xlsx")) {
                JOptionPane.showMessageDialog(null, gInfo.ExportarFacturas(archivo));
            } else {
                JOptionPane.showMessageDialog(null, "Elija un formato valido.");
            }
        }        
    }//GEN-LAST:event_informeFacturaBActionPerformed

    JFileChooser selecArchivo = new JFileChooser();
    File archivo;
    int contAccion = 0;
    GenerarInforme gInfo = new GenerarInforme();

    public void AgregarFiltro() {
        selecArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xls)", "xls"));
        selecArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xlsx)", "xlsx"));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Informes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Informes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Informes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Informes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Informes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton informeFacturaB;
    private javax.swing.JButton informeInventarioB;
    private javax.swing.JButton inventarioOkB;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}