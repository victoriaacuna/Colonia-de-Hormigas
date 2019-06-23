/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Algoritmo.Archivo;
import static Algoritmo.Archivo.archivoValido;
import static Algoritmo.Archivo.ciudadesDelArchivo;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author victoriaacuna
 */
public class CargarUnaSimulacion extends javax.swing.JFrame {

    private static JFileChooser seleccionado = new JFileChooser();
    private static File archivo;
    private static Archivo gestion = new Archivo();
    private static Archivo a = new Archivo();
    private static String[] ciudades, ciudadesFinales;
    private static int[][] matrizDistancias, matrizDistanciaFinal;
    private static int[] datosSimulacion;
    private static double[] valoresCalculos;
    private boolean modificado;
    
    public CargarUnaSimulacion() {
        initComponents();
        this.modificado=false;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSubir = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArchivo = new javax.swing.JTextArea();
        btnModificar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        btnSubir.setText("Cargar un archivo");
        btnSubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirActionPerformed(evt);
            }
        });

        btnSeleccionar.setText("Seleccionar este archivo");
        btnSeleccionar.setEnabled(false);
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        txtArchivo.setColumns(20);
        txtArchivo.setRows(5);
        txtArchivo.setEnabled(false);
        jScrollPane1.setViewportView(txtArchivo);

        btnModificar.setText("Modificar el archivo");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel1.setText("Puedes agregar o eliminar ciudades");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

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
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnSubir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSeleccionar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRegresar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegresar)
                .addGap(37, 37, 37)
                .addComponent(btnSubir, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirActionPerformed
        this.modificado=false;
        if(seleccionado.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION){
            this.archivo = seleccionado.getSelectedFile();
            if(archivo.canRead()){
                if(archivo.getName().endsWith("txt")){
                    if(archivoValido(archivo)){
                        String contenido = gestion.AbrirTexto(archivo);
                        txtArchivo.setText(contenido);
                        btnModificar.setEnabled(true);
                        btnSeleccionar.setEnabled(true);
                        this.ciudades = new String[Archivo.numCiudades(this.archivo)];
                        this.ciudades= ciudadesDelArchivo(this.archivo, ciudades);
                        this.matrizDistancias=new int[ciudades.length][ciudades.length];
                        this.matrizDistancias=Archivo.distanciasCiudades(ciudades.length, this.archivo);
                        this.datosSimulacion = new int [2];
                        this.datosSimulacion=Archivo.datosSimulacion(this.archivo, datosSimulacion);
                        valoresCalculos = new double[3];
                        valoresCalculos=Archivo.valoresCalculos(archivo, valoresCalculos);
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "El archivo que seleccionó, no contiene la información adecuada "
                                + "para hacer la simulación.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    
                }else{
                    
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione un archivo de texto.\n(Tiene que terminar en "
                            + "\".txt\")");
                }
            }
        }
        
    }//GEN-LAST:event_btnSubirActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        
        this.modificado=true;
        ModificarArchivo modificar = new ModificarArchivo(ciudades.length,20,this.archivo);
        this.ciudades = new String[Archivo.numCiudades(this.archivo)];
        this.ciudades= ciudadesDelArchivo(this.archivo, ciudades);
        this.matrizDistancias=new int[ciudades.length][ciudades.length];
        this.matrizDistancias=Archivo.distanciasCiudades(ciudades.length, this.archivo);
        
        
        modificar.listaCiudades.addItem("item1");
        modificar.listaCiudades.removeAllItems();
        
        for (int i = 0; i < ciudades.length; i++) {
            ModificarArchivo.listaCiudades.addItem(ciudades[i]);
        }
        modificar.setLocationRelativeTo(null);
        modificar.setVisible(true);
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        
        if(modificado){
            Simulacion s = new Simulacion(this.matrizDistanciaFinal, this.ciudadesFinales, this.datosSimulacion,
                    this.valoresCalculos);
            s.setLocationRelativeTo(null);
            s.setVisible(true);
            this.setVisible(false);
        } else {
            Simulacion s = new Simulacion(this.matrizDistancias, this.ciudades, this.datosSimulacion,this.valoresCalculos);
            s.setLocationRelativeTo(null);
            s.setVisible(true);
            this.setVisible(false);
        }
        
        
        
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Menu m = new Menu();
        m.setVisible(true);
        m.setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(CargarUnaSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CargarUnaSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CargarUnaSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CargarUnaSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CargarUnaSimulacion().setVisible(true);
            }
        });
    }

    public static String[] getCiudades() {
        return ciudades;
    }

    public static void setCiudades(String[] ciudades) {
        CargarUnaSimulacion.ciudades = ciudades;
    }

    public static String[] getCiudadesFinales() {
        return ciudadesFinales;
    }

    public static void setCiudadesFinales(String[] ciudadesFinales) {
        CargarUnaSimulacion.ciudadesFinales = ciudadesFinales;
    }

    public static int[][] getMatrizDistancias() {
        return matrizDistancias;
    }

    public static void setMatrizDistancias(int[][] matrizDistancias) {
        CargarUnaSimulacion.matrizDistancias = matrizDistancias;
    }

    public static int[][] getMatrizDistanciaFinal() {
        return matrizDistanciaFinal;
    }

    public static void setMatrizDistanciaFinal(int[][] matrizDistanciaFinal) {
        CargarUnaSimulacion.matrizDistanciaFinal = matrizDistanciaFinal;
    }

    public static int[] getDatosSimulacion() {
        return datosSimulacion;
    }

    public static void setDatosSimulacion(int[] datosSimulacion) {
        CargarUnaSimulacion.datosSimulacion = datosSimulacion;
    }

    public static double[] getValoresCalculos() {
        return valoresCalculos;
    }

    public static void setValoresCalculos(double[] valoresCalculos) {
        CargarUnaSimulacion.valoresCalculos = valoresCalculos;
    }

    public static File getArchivo() {
        return archivo;
    }

    public static void setArchivo(File archivo) {
        CargarUnaSimulacion.archivo = archivo;
    }

    public static Archivo getGestion() {
        return gestion;
    }

    public static void setGestion(Archivo gestion) {
        CargarUnaSimulacion.gestion = gestion;
    }

    public static Archivo getA() {
        return a;
    }

    public static void setA(Archivo a) {
        CargarUnaSimulacion.a = a;
    }

    public boolean isModificado() {
        return modificado;
    }

    public void setModificado(boolean modificado) {
        this.modificado = modificado;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JButton btnSubir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea txtArchivo;
    // End of variables declaration//GEN-END:variables
}
