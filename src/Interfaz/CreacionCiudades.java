
package Interfaz;

// @author victoriaacuna

import javax.swing.JOptionPane;


public class CreacionCiudades extends javax.swing.JFrame {
    static private String ciudades[];
    static private double valoresCalculo[];
    static private int datosSimulacion[];
    static private NuevaSimulacion simulacion;
    int matrizDistancias [][];

    public CreacionCiudades(String[] ciudades, double[] valoresCalculo, int[] datosSimulacion, NuevaSimulacion simulacion) {
        initComponents();
        this.datosSimulacion=datosSimulacion;
        this.ciudades=ciudades;
        this.valoresCalculo=valoresCalculo;
        this.simulacion=simulacion;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnContinuar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Malayalam MN", 1, 24)); // NOI18N
        jLabel1.setText("¿Está seguro que desean continuar?");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel2.setText("No podrá agregar ni eliminar más ciudades si continúa. ");

        btnContinuar.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        btnRegresar.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(131, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(118, 118, 118))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnContinuar))
                .addContainerGap(131, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        
        matrizDistancias = new int[ciudades.length][ciudades.length];
        matrizDistancias = inicializarMatriz(matrizDistancias);
        String aux;
        this.setVisible(false);
        for (int i = 0; i < matrizDistancias.length; i++) {
            for (int j = 0; j < matrizDistancias[0].length; j++) {
                // Como el grafo es no dirigido, se hace esta validación, ya que la distancia de A a B, es la misma que 
                // la de B a A.
                if(matrizDistancias[i][j]==0){
                    // Se realiza esta validación para no crear una distancia de una ciudad a ella misma.
                    if(i!=j){ 
                        aux=JOptionPane.showInputDialog(null, "Ingresa la distancia de " + ciudades[i] + " a " + ciudades[j]);
                        //Verificando que la distancia que introdujo es un entero positivo.
                        if(!NuevaSimulacion.isInt(aux) || (NuevaSimulacion.isInt(aux)&&Integer.parseInt(aux)<1)){
                            
                                while(!NuevaSimulacion.isInt(aux) || (NuevaSimulacion.isInt(aux)&&Integer.parseInt(aux)<1)){
                                
                                    if(!NuevaSimulacion.isInt(aux)){
                                        JOptionPane.showMessageDialog(this, "El número que introdujo NO es un entero y DEBE ser un entero.", 
                                        "Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                    if(NuevaSimulacion.isInt(aux) && Integer.parseInt(aux)<1){
                                        JOptionPane.showMessageDialog(this, "No puede introducir números negativos o ceros como distancia entre ciudades.", 
                                                "Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                    aux=JOptionPane.showInputDialog(null, "Ingresa la distancia de " + ciudades[i] + " a " + ciudades[j]);
                                }
                        }
                        //Se llena la matriz con la misma distancia desde A a B, que desde B a A.
                        matrizDistancias[i][j]=Integer.parseInt(aux);
                        matrizDistancias[j][i]=Integer.parseInt(aux);
                    }
                }
            }
        }
        
        
        
        GuardarArchivo guardarA = new GuardarArchivo(ciudades, valoresCalculo, datosSimulacion,matrizDistancias);
        guardarA.setLocationRelativeTo(null);
        guardarA.setVisible(true);
        simulacion.setVisible(false);
        this.setVisible(false);
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        
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
            java.util.logging.Logger.getLogger(CreacionCiudades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreacionCiudades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreacionCiudades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreacionCiudades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreacionCiudades(ciudades, valoresCalculo, datosSimulacion,simulacion).setVisible(true);
            }
        });
    }
    
    public int[][] inicializarMatriz (int[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j]=0;
            }
        }
        return matriz;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnContinuar;
    public static javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
