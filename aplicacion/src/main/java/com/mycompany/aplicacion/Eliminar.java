/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.aplicacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author quiji
 */
public class Eliminar extends javax.swing.JFrame {
        Connection connection = DBConnection.connection;
    /**
     * Creates new form Eliminar
     */
    public Eliminar() {
        initComponents();
        this.setLocationRelativeTo(null);
        actualizarTabla();
    }
    
    public void actualizarTabla() {
        String[] nombreColumnas = {"Codigo","Nombre","Precio","Tipo"};
        String[] registros = new String[4];
        
        int posicion = cmbTipo.getSelectedIndex();
        
        String platillos;
        
        switch(posicion) {
            case 0:
                platillos = "SELECT * FROM Platillo WHERE TipoPlatillo = 'Desayuno'";
                break;
            case 1:
                platillos = "SELECT * FROM Platillo WHERE TipoPlatillo = 'Fuertes'";
                break;
            case 2:
                platillos = "SELECT * FROM Platillo WHERE TipoPlatillo = 'Bebidas Frias'";
                break;
            case 3:
                platillos = "SELECT * FROM Platillo WHERE TipoPlatillo = 'Bebida Caliente'";
                break;
            case 4:
                platillos = "SELECT * FROM Platillo WHERE TipoPlatillo = 'Postre'";
                break;
            default:
                platillos = "SELECT * FROM Platillo";
                break;
        }
        
        DefaultTableModel model = new DefaultTableModel(null, nombreColumnas);
        
        
        try (PreparedStatement preSt = connection.prepareStatement(platillos)) {
            ResultSet result = preSt.executeQuery();
            
            while(result.next()) {
                registros[0] = result.getString("CodigoPlatillo");
                registros[1] = result.getString("NombrePlatillo");
                registros[2] = result.getString("Precio");
                registros[3] = result.getString("TipoPlatillo");
                model.addRow(registros);
            }
            TablaPlatillos.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al actualizar la tabla: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbCampo = new javax.swing.JComboBox<>();
        txtDato = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btEliminat = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPlatillos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(91, 33, 129));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(63, 25, 88));
        jLabel1.setText("E L I M I N A R");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(63, 25, 88));
        jLabel2.setText("P L A T I L L O S");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(33, 33, 33))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(70, 70, 70))
        );

        jLabel3.setBackground(new java.awt.Color(91, 33, 129));
        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Panel a Destacar");

        cmbCampo.setBackground(new java.awt.Color(91, 33, 129));
        cmbCampo.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        cmbCampo.setForeground(new java.awt.Color(204, 204, 204));
        cmbCampo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Nombre", "Precio", "Tipo" }));
        cmbCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCampoActionPerformed(evt);
            }
        });

        txtDato.setBackground(new java.awt.Color(91, 33, 129));
        txtDato.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtDato.setForeground(new java.awt.Color(204, 204, 204));
        txtDato.setBorder(null);
        txtDato.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDatoFocusGained(evt);
            }
        });

        btEliminat.setBackground(new java.awt.Color(91, 33, 129));
        btEliminat.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btEliminat.setForeground(new java.awt.Color(204, 204, 204));
        btEliminat.setText("Eliminar");
        btEliminat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminatActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(91, 33, 129));
        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Mostrar");

        cmbTipo.setBackground(new java.awt.Color(91, 33, 129));
        cmbTipo.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        cmbTipo.setForeground(new java.awt.Color(204, 204, 204));
        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Desayuno", "Fuertes", "Bebidas Frias", "Bebida Caliente", "Postre" }));
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });

        TablaPlatillos.setBackground(new java.awt.Color(91, 33, 129));
        TablaPlatillos.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TablaPlatillos.setForeground(new java.awt.Color(204, 204, 204));
        TablaPlatillos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TablaPlatillos);

        jButton1.setBackground(new java.awt.Color(91, 33, 129));
        jButton1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 204, 204));
        jButton1.setText("Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Dato a Destacar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbCampo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(54, 54, 54)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSeparator1)
                                        .addComponent(txtDato, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(57, 57, 57)
                                    .addComponent(btEliminat, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel5)))
                        .addComponent(jScrollPane1)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(38, 38, 38)
                            .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEliminat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDatoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDatoFocusGained
       
    }//GEN-LAST:event_txtDatoFocusGained

    private void btEliminatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminatActionPerformed
        String dato;
        dato = txtDato.getText();
        
        int posicion = cmbCampo.getSelectedIndex();
        
        String delete;
        
        switch(posicion) {
            case 0:
                delete = "DELETE FROM Platillo WHERE CodigoPlatillo = ?";
                break;
            case 1:
                delete = "DELETE FROM Platillo WHERE NombrePlatillo = ?";
                break;
            case 2:
                delete = "DELETE FROM Platillo WHERE Precio = ?";
                break;
            case 3:
                delete = "DELETE FROM Platillo WHERE TipoPlatillo = ?";
                break;
            default:
                delete = "DELETE FROM Platillo WHERE CodigoPlatillo = ?";
                break;
        }
        
        try(PreparedStatement preSt = connection.prepareStatement(delete)) {
            preSt.setString(1, dato);
            
            preSt.executeUpdate();
            
            actualizarTabla();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar el campo: " + e.getMessage(), "Error de Actualizacion", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btEliminatActionPerformed

    private void cmbCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCampoActionPerformed
        
    }//GEN-LAST:event_cmbCampoActionPerformed

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_cmbTipoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        MenuAdministrador m1 = new MenuAdministrador();
        m1.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Eliminar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaPlatillos;
    private javax.swing.JButton btEliminat;
    private javax.swing.JComboBox<String> cmbCampo;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtDato;
    // End of variables declaration//GEN-END:variables
}
