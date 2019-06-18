
package Interfaz;

import Algoritmo.Circulo;
import java.awt.Graphics;


public class Simulacion extends javax.swing.JFrame {

    public static int[][] matrizDistancias;
    public static String[] ciudades;
    public static int[] datosSimulacion;
    public static double[] valoresCalculo;
   
    public Simulacion(int[][] matrizDistancias, String[] ciudades, int[] datosSimulacion, double[] valoresCalculo) {
        initComponents();
        this.matrizDistancias=matrizDistancias;
        this.ciudades=ciudades;
        this.datosSimulacion=datosSimulacion;
        this.valoresCalculo=valoresCalculo;
        
//        for (int i = 0; i < ciudades.length; i++) {
//            System.out.println(ciudades[i]);
//        }
//        for (int i = 0; i < matrizDistancias.length; i++) {
//            for (int j = 0; j < matrizDistancias[0].length; j++) {
//                System.out.print(matrizDistancias[i][j]+" ");
//            }
//            System.out.println("");
//        }
//        System.out.println("Iteraciones: " +datosSimulacion[0]+"\nHormigas: "+datosSimulacion[1]);
//        System.out.println("Alfa: "+valoresCalculo[0]+"\nBeta: "+valoresCalculo[1]+"\nRo: "+valoresCalculo[2]);
        
        
        
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

        btnComenzarIteracion.setText("Comenzar iteración");

        btnContinuar.setText("Continuar");
        btnContinuar.setEnabled(false);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnMostrarGrafo.setText("Mostrar Grafo");
        btnMostrarGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarGrafoActionPerformed(evt);
            }
        });

        txtTexto.setColumns(20);
        txtTexto.setRows(5);
        jScrollPane1.setViewportView(txtTexto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnComenzarIteracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnContinuar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMostrarGrafo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnComenzarIteracion, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btnMostrarGrafo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnMostrarGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarGrafoActionPerformed
        Circulo[] circulos = new Circulo[this.ciudades.length];
        circulos = generarVectorCirculos();
 
        Graphics g = Panel.getGraphics();
        for (int i = 0; i < ciudades.length; i++) {
            circulos[i].dibujarCiudad(g);
        }
        
        
    }//GEN-LAST:event_btnMostrarGrafoActionPerformed

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
                new Simulacion(matrizDistancias,ciudades,datosSimulacion,valoresCalculo).setVisible(true);
            }
        });
    }
    
    public Circulo[] generarVectorCirculos(){
        Circulo[] circulos = new Circulo[this.ciudades.length];
        //Mínimo va a tener cuatro ciudades, por lo tanto:
        circulos[0]= new Circulo(50,50,this.ciudades[0]); 
        circulos[1] = new Circulo(100,150,this.ciudades[1]); 
        circulos[2] = new Circulo(350,80,this.ciudades[2]); 
        circulos[3] = new Circulo(400,150,this.ciudades[3]); 
        
        if(ciudades.length>4){
            switch(ciudades.length){
                case 5:
                    circulos[4]= new Circulo(600,500,this.ciudades[4]); 
                    break;
                case 6: 
                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
                    break;
                case 7:
                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
                    break;
                case 8:
                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
                    circulos[7] = new Circulo(230,400,this.ciudades[7]);
                    break;
                case 9:
                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
                    break;
                case 10:
                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
                    circulos[9] = new Circulo(120,500,this.ciudades[9]);
                    break;
                case 11:
                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
                    circulos[9] = new Circulo(120,500,this.ciudades[9]); 
                    circulos[10] = new Circulo(390,400,this.ciudades[10]); 
                    break;
                case 12: 
                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
                    circulos[9] = new Circulo(120,500,this.ciudades[9]); 
                    circulos[10] = new Circulo(390,400,this.ciudades[10]); 
                    circulos[11] = new Circulo(250,50,this.ciudades[11]);
                    break;
                case 13:
                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
                    circulos[9] = new Circulo(120,500,this.ciudades[9]); 
                    circulos[10] = new Circulo(390,400,this.ciudades[10]); 
                    circulos[11] = new Circulo(250,50,this.ciudades[11]); 
                    circulos[12]= new Circulo(310,500,this.ciudades[12]); 
                    break;
                case 14:
                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
                    circulos[9] = new Circulo(120,500,this.ciudades[9]); 
                    circulos[10] = new Circulo(390,400,this.ciudades[10]); 
                    circulos[11] = new Circulo(250,50,this.ciudades[11]); 
                    circulos[12]= new Circulo(310,500,this.ciudades[12]); 
                    circulos[13] = new Circulo(20,310,this.ciudades[13]);
                    break;
                case 15:
                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
                    circulos[9] = new Circulo(120,500,this.ciudades[9]); 
                    circulos[10] = new Circulo(390,400,this.ciudades[10]); 
                    circulos[11] = new Circulo(250,50,this.ciudades[11]); 
                    circulos[12]= new Circulo(310,500,this.ciudades[12]); 
                    circulos[13] = new Circulo(20,310,this.ciudades[13]); 
                    circulos[14] = new Circulo(469,310,this.ciudades[14]); 
                    break;
                case 16:
                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
                    circulos[9] = new Circulo(120,500,this.ciudades[9]); 
                    circulos[10] = new Circulo(390,400,this.ciudades[10]); 
                    circulos[11] = new Circulo(250,50,this.ciudades[11]); 
                    circulos[12]= new Circulo(310,500,this.ciudades[12]); 
                    circulos[13] = new Circulo(20,310,this.ciudades[13]); 
                    circulos[14] = new Circulo(469,310,this.ciudades[14]); 
                    circulos[15] = new Circulo(360,250,this.ciudades[15]); 
                    break;
                case 17:
                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
                    circulos[9] = new Circulo(120,500,this.ciudades[9]); 
                    circulos[10] = new Circulo(390,400,this.ciudades[10]); 
                    circulos[11] = new Circulo(250,50,this.ciudades[11]); 
                    circulos[12]= new Circulo(310,500,this.ciudades[12]); 
                    circulos[13] = new Circulo(20,310,this.ciudades[13]); 
                    circulos[14] = new Circulo(469,310,this.ciudades[14]); 
                    circulos[15] = new Circulo(360,250,this.ciudades[15]); 
                    circulos[16]= new Circulo(500,500,this.ciudades[16]); 
                    break;
                case 18:
                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
                    circulos[9] = new Circulo(120,500,this.ciudades[9]); 
                    circulos[10] = new Circulo(390,400,this.ciudades[10]); 
                    circulos[11] = new Circulo(250,50,this.ciudades[11]); 
                    circulos[12]= new Circulo(310,500,this.ciudades[12]); 
                    circulos[13] = new Circulo(20,310,this.ciudades[13]); 
                    circulos[14] = new Circulo(469,310,this.ciudades[14]); 
                    circulos[15] = new Circulo(360,250,this.ciudades[15]); 
                    circulos[16]= new Circulo(500,500,this.ciudades[16]); 
                    circulos[17] = new Circulo(190,230,this.ciudades[17]);  
                    break;
                case 19:
                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
                    circulos[9] = new Circulo(120,500,this.ciudades[9]); 
                    circulos[10] = new Circulo(390,400,this.ciudades[10]); 
                    circulos[11] = new Circulo(250,50,this.ciudades[11]); 
                    circulos[12]= new Circulo(310,500,this.ciudades[12]); 
                    circulos[13] = new Circulo(20,310,this.ciudades[13]); 
                    circulos[14] = new Circulo(469,310,this.ciudades[14]); 
                    circulos[15] = new Circulo(360,250,this.ciudades[15]); 
                    circulos[16]= new Circulo(500,500,this.ciudades[16]); 
                    circulos[17] = new Circulo(190,230,this.ciudades[17]); 
                    circulos[18] = new Circulo(480,200,this.ciudades[18]); 
                    break;
                default:
                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
                    circulos[9] = new Circulo(120,500,this.ciudades[9]); 
                    circulos[10] = new Circulo(390,400,this.ciudades[10]); 
                    circulos[11] = new Circulo(250,50,this.ciudades[11]); 
                    circulos[12]= new Circulo(310,500,this.ciudades[12]); 
                    circulos[13] = new Circulo(20,310,this.ciudades[13]); 
                    circulos[14] = new Circulo(469,310,this.ciudades[14]); 
                    circulos[15] = new Circulo(360,250,this.ciudades[15]); 
                    circulos[16]= new Circulo(500,500,this.ciudades[16]); 
                    circulos[17] = new Circulo(190,230,this.ciudades[17]); 
                    circulos[18] = new Circulo(480,200,this.ciudades[18]); 
                    circulos[19] = new Circulo(550,50,this.ciudades[19]); 
                    break;
            }
        }
        return circulos;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JButton btnComenzarIteracion;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnMostrarGrafo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtTexto;
    // End of variables declaration//GEN-END:variables
}
