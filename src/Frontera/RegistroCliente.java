
package Frontera;

import Control.ValidarRegistroC;
import DAO.ClienteDAO;
import Entidad.Cliente;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos
 */
public class RegistroCliente extends javax.swing.JFrame {
    public static ArrayList <Cliente> clientes = new ArrayList<Cliente>(); 
    /**
     * Creates new form RegistroClientes
     */
    public RegistroCliente() {
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

        jPanel1 = new javax.swing.JPanel();
        direccion_L = new javax.swing.JLabel();
        direccionTF = new javax.swing.JTextField();
        telefonoTF = new javax.swing.JTextField();
        telefono_L = new javax.swing.JLabel();
        identificacion_L = new javax.swing.JLabel();
        identificacionTF = new javax.swing.JTextField();
        apellidosTF = new javax.swing.JTextField();
        apellidos_L = new javax.swing.JLabel();
        nombres_L = new javax.swing.JLabel();
        nombresTF = new javax.swing.JTextField();
        registrarB = new javax.swing.JButton();
        cancelarB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        direccion_L.setText("Dirección:");

        telefono_L.setText("Teléfono:");

        identificacion_L.setText("Identificación:");

        apellidos_L.setText("Apellidos:");

        nombres_L.setText("Nombres:");

        registrarB.setText("Registrar");
        registrarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarBActionPerformed(evt);
            }
        });

        cancelarB.setText("Cancelar");
        cancelarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cancelarB)
                        .addGap(18, 18, 18)
                        .addComponent(registrarB))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nombres_L)
                                .addComponent(apellidos_L))
                            .addGap(41, 41, 41)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nombresTF)
                                .addComponent(apellidosTF, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(identificacion_L)
                                .addComponent(telefono_L)
                                .addComponent(direccion_L))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(identificacionTF)
                                .addComponent(telefonoTF)
                                .addComponent(direccionTF, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombres_L)
                    .addComponent(nombresTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellidos_L)
                    .addComponent(apellidosTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(identificacion_L)
                    .addComponent(identificacionTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefono_L)
                    .addComponent(telefonoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(direccion_L)
                    .addComponent(direccionTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registrarB)
                    .addComponent(cancelarB))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registrarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarBActionPerformed
        Cliente cliente = new Cliente();
        cliente.setNombres(nombresTF.getText());
        cliente.setApellidos(apellidosTF.getText());
        cliente.setCedula(Long.parseLong(identificacionTF.getText()));
        cliente.setTelefono(Long.parseLong(telefonoTF.getText()));
        cliente.setDireccion(direccionTF.getText());
        ValidarRegistroC verC = new ValidarRegistroC();
        //System.out.println(verC.VerificarRegistro(cliente)); <<Banderilla
        if(verC.VerificarRegistro(cliente).equals("Usuario registrado con exito")){
            ClienteDAO dao = new ClienteDAO();
            dao.crear(cliente); 
            clientes.add(cliente);                     
             JOptionPane.showMessageDialog(null, "Usuario registrado con exito"); 
            RegistroVehiculo obj = new RegistroVehiculo();
            obj.setVisible(true);
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, verC.VerificarRegistro(cliente));              
        }
        
    }//GEN-LAST:event_registrarBActionPerformed

    private void cancelarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBActionPerformed
        Menu obj = new Menu();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelarBActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidosTF;
    private javax.swing.JLabel apellidos_L;
    private javax.swing.JButton cancelarB;
    private javax.swing.JTextField direccionTF;
    private javax.swing.JLabel direccion_L;
    private javax.swing.JTextField identificacionTF;
    private javax.swing.JLabel identificacion_L;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombresTF;
    private javax.swing.JLabel nombres_L;
    private javax.swing.JButton registrarB;
    private javax.swing.JTextField telefonoTF;
    private javax.swing.JLabel telefono_L;
    // End of variables declaration//GEN-END:variables
}
