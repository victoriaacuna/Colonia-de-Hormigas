
package Interfaz;

import Algoritmo.Camino;
import Algoritmo.Circulo;
import Algoritmo.Grafo;
import Algoritmo.Hormiga;
import Algoritmo.Iteracion;
import java.awt.Graphics;


public class Simulacion extends javax.swing.JFrame {


    public static Grafo grafo;
    public static Hormiga[][] hormigas;
    public static int contHormigas, contIteracion;
    public boolean porIteracion;

   
    public Simulacion(int[][] matrizDistancias, String[] ciudades, int[] datosSimulacion, double[] valoresCalculo) {
        initComponents();

        Grafo grafo = new Grafo(matrizDistancias, ciudades, datosSimulacion, valoresCalculo);
        this.grafo=grafo;
        this.grafo.iteracionesSimulacion = new Iteracion[grafo.datosSimulacion[0]];
        
        this.hormigas = new Hormiga[grafo.datosSimulacion[1]][grafo.datosSimulacion[1]];
        for (int i = 0; i < this.hormigas.length; i++) {
            this.hormigas[i] = new Hormiga [grafo.datosSimulacion[1]];
        }
        
        for (int i = 0; i < this.grafo.iteracionesSimulacion.length; i++) {
            this.grafo.iteracionesSimulacion[i]=new Iteracion(hormigas[i]);
            for (int j = 0; j < this.grafo.iteracionesSimulacion[i].hormigas.length; j++) {
                this.grafo.iteracionesSimulacion[i].hormigas[j]=new Hormiga(j+1);
                this.grafo.iteracionesSimulacion[i].hormigas[j].ciudadesDisponibles=
                        this.grafo.iteracionesSimulacion[i].hormigas[j].vectorCiudadesDisponibles(this.grafo.ciudades);
            }
        }
        this.contIteracion=0;
        this.contHormigas=0;
        this.porIteracion=false;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        btnComenzarIteracion = new javax.swing.JButton();
        btnContinuar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnMostrarGrafo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTexto = new javax.swing.JTextArea();
        btnHormiga = new javax.swing.JButton();
        btnIteracion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnConclusion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 662, Short.MAX_VALUE)
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 567, Short.MAX_VALUE)
        );

        btnComenzarIteracion.setFont(new java.awt.Font("Malayalam MN", 0, 14)); // NOI18N
        btnComenzarIteracion.setText("Comenzar iteración");
        btnComenzarIteracion.setEnabled(false);
        btnComenzarIteracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComenzarIteracionActionPerformed(evt);
            }
        });

        btnContinuar.setFont(new java.awt.Font("Malayalam MN", 0, 14)); // NOI18N
        btnContinuar.setText("Continuar");
        btnContinuar.setEnabled(false);
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Malayalam MN", 0, 14)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnMostrarGrafo.setFont(new java.awt.Font("Malayalam MN", 0, 14)); // NOI18N
        btnMostrarGrafo.setText("Mostrar Grafo");
        btnMostrarGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarGrafoActionPerformed(evt);
            }
        });

        txtTexto.setColumns(20);
        txtTexto.setRows(5);
        txtTexto.setEnabled(false);
        jScrollPane1.setViewportView(txtTexto);

        btnHormiga.setFont(new java.awt.Font("Malayalam MN", 0, 14)); // NOI18N
        btnHormiga.setText("Por hormiga");
        btnHormiga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHormigaActionPerformed(evt);
            }
        });

        btnIteracion.setFont(new java.awt.Font("Malayalam MN", 0, 14)); // NOI18N
        btnIteracion.setText("Por iteracion");
        btnIteracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIteracionActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Malayalam MN", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Seleccione cómo quiere que funcione el programa");

        btnConclusion.setText("Conclusión");
        btnConclusion.setEnabled(false);
        btnConclusion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConclusionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btnIteracion, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHormiga, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnComenzarIteracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnContinuar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnMostrarGrafo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnConclusion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnComenzarIteracion, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnMostrarGrafo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnConclusion, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIteracion, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnHormiga, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnMostrarGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarGrafoActionPerformed

        Graphics g = Panel.getGraphics();
        for (int i = 0; i < this.grafo.ciudades.length; i++) {
            this.grafo.circulos[i].dibujarCiudad(g);
        }
        
    }//GEN-LAST:event_btnMostrarGrafoActionPerformed

    private void btnComenzarIteracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComenzarIteracionActionPerformed
        
        if(this.porIteracion){
                
                Graphics g = Panel.getGraphics();
                for (int i = 0; i < this.grafo.ciudades.length; i++) {
                    this.grafo.circulos[i].dibujarCiudad(g);
                }
            
                if(this.contIteracion==0){
                    this.grafo.iteracionesSimulacion[this.contIteracion].hormigas[0].recorridoHPrev=1;
                    this.grafo.iteracionesSimulacion[this.contIteracion].hormigas[0].inicializarCaminos(this.grafo.matrizDistancias, 
                        this.grafo.matrizFeromonas);
                } else {
                    this.grafo.iteracionesSimulacion[this.contIteracion].hormigas[0].recorridoHPrev=
                        this.grafo.iteracionesSimulacion[this.contIteracion-1].hormigas[(this.grafo.iteracionesSimulacion[0].hormigas.length-1)].distRecorrida;
                   this.grafo.iteracionesSimulacion[this.contIteracion].hormigas[0].caminos=
                        this.grafo.iteracionesSimulacion[this.contIteracion-1].hormigas[(this.grafo.iteracionesSimulacion[0].hormigas.length-1)].caminos;
                }
                while(contHormigas<this.grafo.iteracionesSimulacion[0].hormigas.length){
                    if(this.contHormigas!=0){
                        this.grafo.iteracionesSimulacion[contIteracion].hormigas[contHormigas].recorridoHPrev=
                                this.grafo.iteracionesSimulacion[contIteracion].hormigas[contHormigas-1].distRecorrida;
                        this.grafo.iteracionesSimulacion[this.contIteracion].hormigas[contHormigas].caminos=
                                this.grafo.iteracionesSimulacion[this.contIteracion].hormigas[contHormigas-1].caminos;
                    }
                    //Se mueve la hormiga.
                    this.grafo.iteracionesSimulacion[this.contIteracion].hormigas[this.contHormigas].moverse(this.grafo.iteracionesSimulacion[this.contIteracion].hormigas[this.contHormigas], 
                            grafo.datosSimulacion[1], this.grafo,this.contIteracion);
                    //Se actualizan el contador.
                    this.contHormigas++;
                }
                
                this.grafo.generarTextoIteracion(this.contIteracion);
                this.grafo.dibujarLineasIteracion(contIteracion);
                
                this.contHormigas=0;
                this.contIteracion++;
                if(this.contIteracion==this.grafo.iteracionesSimulacion.length){
                    this.btnComenzarIteracion.setEnabled(false);
                    this.btnConclusion.setEnabled(true);
                }
        } else {
                
                Graphics g = Panel.getGraphics();
                for (int i = 0; i < this.grafo.ciudades.length; i++) {
                    this.grafo.circulos[i].dibujarCiudad(g);
                }
            
                this.btnContinuar.setEnabled(true);
                if(this.contIteracion==0){
                    //Establece la variable recorridoPrev para la primera hori=miga del programa.
                    this.grafo.iteracionesSimulacion[this.contIteracion].hormigas[0].recorridoHPrev=1;
                    // Inicializa la matriz camino de la primera hormiga correspondiente a la iteración que se está realizando.
                    this.grafo.iteracionesSimulacion[this.contIteracion].hormigas[0].inicializarCaminos(this.grafo.matrizDistancias, 
                        this.grafo.matrizFeromonas);
                } else {
                    //Establece la variable recorridaPrev como la distancia que recorrió la hormiga anterior a ella.
                    this.grafo.iteracionesSimulacion[this.contIteracion].hormigas[0].recorridoHPrev=
                            this.grafo.iteracionesSimulacion[this.contIteracion-1].hormigas[(this.grafo.iteracionesSimulacion[0].hormigas.length-1)].distRecorrida;
                    // Inicializa la matriz camino de la primera hormiga correspondiente a la iteración que se está realizando;
//                    this.grafo.iteracionesSimulacion[this.contIteracion].hormigas[0].inicializarCaminos(this.grafo.matrizDistancias, 
//                        this.grafo.matrizFeromonas);
                    this.grafo.iteracionesSimulacion[this.contIteracion].hormigas[0].caminos=
                            this.grafo.iteracionesSimulacion[this.contIteracion-1].hormigas[(this.grafo.iteracionesSimulacion[0].hormigas.length-1)].caminos;
                }
                //Se mueve la hormiga.
                this.grafo.iteracionesSimulacion[this.contIteracion].hormigas[0].moverse(this.grafo.iteracionesSimulacion[this.contIteracion].hormigas[0], 
                        grafo.datosSimulacion[1], this.grafo,this.contIteracion);
                this.grafo.dibujarLineasHormigas(contIteracion, contHormigas);
                //Se actualizan el contador.
                this.grafo.generarTextoHormiga(this.contIteracion, this.contHormigas);
                this.contHormigas++;
                this.btnComenzarIteracion.setEnabled(false);
        }
        

    }//GEN-LAST:event_btnComenzarIteracionActionPerformed

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
            

            Graphics g = Panel.getGraphics();
            for (int i = 0; i < this.grafo.ciudades.length; i++) {
                this.grafo.circulos[i].dibujarCiudad(g);
            }
            // Para los cálculos internos del algoritmo, se actualiza la distancia recorrida por la hormiga anterior.
            this.grafo.iteracionesSimulacion[contIteracion].hormigas[contHormigas].recorridoHPrev=
                    this.grafo.iteracionesSimulacion[contIteracion].hormigas[contHormigas-1].distRecorrida;
            // Se inicializan los caminos de la hormiga que se va a mover.
            this.grafo.iteracionesSimulacion[this.contIteracion].hormigas[contHormigas].caminos=
                    this.grafo.iteracionesSimulacion[this.contIteracion].hormigas[contHormigas-1].caminos;            
//            this.grafo.iteracionesSimulacion[contIteracion].hormigas[contHormigas].inicializarCaminos(this.grafo.matrizDistancias, 
//                    this.grafo.matrizFeromonas);

//             this.grafo.iteracionesSimulacion[this.contIteracion].hormigas[contHormigas].ciudadesRecorridas=0;
            // Se mueve la hormiga.
            this.grafo.iteracionesSimulacion[contIteracion].hormigas[contHormigas].moverse(this.grafo.iteracionesSimulacion[contIteracion].hormigas[this.contHormigas], 
                    grafo.datosSimulacion[1], this.grafo,this.contIteracion);
            this.grafo.generarTextoHormiga(this.contIteracion, this.contHormigas);
            
            this.grafo.dibujarLineasHormigas(contIteracion, contHormigas);
            
            //Actualiza el contador de la cantidad de hormigas que se han movido.
            this.contHormigas++;
            
            // Se verifica si ya se ha movido la última hormiga de la iteración, en caso de que así sea:
            
            if(contHormigas==grafo.iteracionesSimulacion[0].hormigas.length){
                // El contador de hormigas vuelve a estar en 0.
                this.contHormigas=0;
                // Se aumenta el contador de iteraciones.
                this.contIteracion++;
                
                
                //Se verifica si esa iteración es la última.
                if(this.contIteracion==(grafo.iteracionesSimulacion.length)){
                    // Si era la última iteración, desabilita los botones de continuar y comenzar iteración.
                    this.btnComenzarIteracion.setEnabled(false);
                    this.btnContinuar.setEnabled(false);
                    this.btnConclusion.setEnabled(true);
                } else {
                    // Si no es la última iteración, le permite al usuario comenzar la siguiente iteración.
                   this.btnContinuar.setEnabled(false);
                   this.btnComenzarIteracion.setEnabled(true); 
                   this.grafo=
                           this.grafo.iteracionesSimulacion[this.contIteracion-1].hormigas[this.grafo.iteracionesSimulacion[this.contIteracion-1].hormigas.length-1].EvaporacionFeromonas(this.grafo);
                }
            }
            
        
        
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void btnIteracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIteracionActionPerformed
        this.porIteracion=true;
        this.btnIteracion.setEnabled(false);
        this.btnHormiga.setEnabled(false);
        this.btnComenzarIteracion.setEnabled(true);
    }//GEN-LAST:event_btnIteracionActionPerformed

    private void btnHormigaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHormigaActionPerformed
        this.porIteracion=false;
        this.btnComenzarIteracion.setEnabled(true);
        this.btnIteracion.setEnabled(false);
        this.btnHormiga.setEnabled(false);
    }//GEN-LAST:event_btnHormigaActionPerformed

    private void btnConclusionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConclusionActionPerformed
        Conclusion c = new Conclusion(this.grafo);
        this.setVisible(false);
    }//GEN-LAST:event_btnConclusionActionPerformed

    
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
            java.util.logging.Logger.getLogger(Simulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Simulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Simulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Simulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Simulacion(grafo.matrizDistancias,grafo.ciudades,grafo.datosSimulacion,grafo.valoresCalculo).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel Panel;
    private javax.swing.JButton btnComenzarIteracion;
    private javax.swing.JButton btnConclusion;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnHormiga;
    private javax.swing.JButton btnIteracion;
    private javax.swing.JButton btnMostrarGrafo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea txtTexto;
    // End of variables declaration//GEN-END:variables
}
