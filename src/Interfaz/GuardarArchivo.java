/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Algoritmo.Archivo;
import javax.swing.JOptionPane;
import java.io.*;
import javax.swing.JFileChooser;

/**
 *
 * @author victoriaacuna
 */
public class GuardarArchivo extends javax.swing.JFrame {

    static private String ciudades[];
    static private double valoresCalculo[];
    static private int datosSimulacion[];
    static private int matrizDistancias [][];
    static private String contenido;
    
    JFileChooser seleccionado = new JFileChooser();
    File archivo;
    Archivo gestion = new Archivo();
    
    public GuardarArchivo(String[] ciudades, double[] valoresCalculo, int[] datosSimulacion,  int[][] matrizDistancias) {
        initComponents();
        this.datosSimulacion=datosSimulacion;
        this.ciudades=ciudades;
        this.valoresCalculo=valoresCalculo;
        this.matrizDistancias = matrizDistancias;
        String contenido=Archivo.generarContenidoArchivo(matrizDistancias, ciudades, valoresCalculo, datosSimulacion);
        txtArchivo.setText(contenido);
        this.contenido=contenido;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtArchivo = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Guardar = new javax.swing.JButton();
        btnNoGuardar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtArchivo.setColumns(20);
        txtArchivo.setRows(5);
        txtArchivo.setEnabled(false);
        jScrollPane1.setViewportView(txtArchivo);

        jLabel1.setFont(new java.awt.Font("Malayalam MN", 1, 24)); // NOI18N
        jLabel1.setText("¿Desea guardar el archivo");

        jLabel2.setFont(new java.awt.Font("Malayalam MN", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("que creó para una próxima");

        jLabel3.setFont(new java.awt.Font("Malayalam MN", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("simulación?");

        Guardar.setFont(new java.awt.Font("Malayalam MN", 1, 14)); // NOI18N
        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        btnNoGuardar.setFont(new java.awt.Font("Malayalam MN", 1, 14)); // NOI18N
        btnNoGuardar.setText("No guardar");
        btnNoGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoGuardarActionPerformed(evt);
            }
        });

        btnRegresar.setFont(new java.awt.Font("Malayalam MN", 0, 14)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(btnNoGuardar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNoGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        
        if(seleccionado.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION){
            archivo = seleccionado.getSelectedFile();
            if(archivo.getName().endsWith("txt")){
                gestion.GuardarTexto(archivo, contenido);
                Simulacion s = new Simulacion(this.matrizDistancias, this.ciudades, this.datosSimulacion, this.valoresCalculo);
                s.setLocationRelativeTo(null);
                s.setVisible(true);
                this.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "El texto se debe guardar en un formato de texto.\n(Agréguele \".txt\" al nombre "
                        + "de su archivo cuando lo vaya a guardar).");
            }
        }
        
    }//GEN-LAST:event_GuardarActionPerformed

    private void btnNoGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoGuardarActionPerformed
        Simulacion s = new Simulacion(this.matrizDistancias, this.ciudades, this.datosSimulacion, this.valoresCalculo);
        s.setLocationRelativeTo(null);
        s.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnNoGuardarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        NuevaSimulacion n = new NuevaSimulacion();
        n.setVisible(true);
        n.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(GuardarArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuardarArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuardarArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuardarArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuardarArchivo(ciudades,valoresCalculo,datosSimulacion,matrizDistancias).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Guardar;
    private javax.swing.JButton btnNoGuardar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtArchivo;
    // End of variables declaration//GEN-END:variables
}
