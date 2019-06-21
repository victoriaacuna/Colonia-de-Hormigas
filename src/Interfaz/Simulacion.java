
package Interfaz;

import Algoritmo.Camino;
import Algoritmo.Circulo;
import Algoritmo.Grafo;
import Algoritmo.Hormiga;
import Algoritmo.Iteracion;
import java.awt.Graphics;


public class Simulacion extends javax.swing.JFrame {

//    public static int[][] matrizDistancias;
//    public static String[] ciudades;
//    public static int[] datosSimulacion;
//    public static double[] valoresCalculo;
    public static Grafo grafo;
//    public static Iteracion[] iteracion;
    public static Hormiga[][] hormigas;
    public static int contHormigas, contIteracion;
//    public static Iteracion iteracionActual;
//    public static Hormiga hormigaActual;
   
    public Simulacion(int[][] matrizDistancias, String[] ciudades, int[] datosSimulacion, double[] valoresCalculo) {
        initComponents();
//        this.matrizDistancias=matrizDistancias;
//        this.ciudades=ciudades;
//        this.datosSimulacion=datosSimulacion;
//        this.valoresCalculo=valoresCalculo;
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
        
        
        
//        this.iteracionActual=iteracion[0];
//        this.hormigaActual=iteracion[0].hormigas[0];
        
        
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
        btnComenzarIteracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComenzarIteracionActionPerformed(evt);
            }
        });

        btnContinuar.setText("Continuar");
        btnContinuar.setEnabled(false);
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnComenzarIteracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnContinuar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
                    .addComponent(btnMostrarGrafo, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGap(51, 51, 51)
                        .addComponent(btnMostrarGrafo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
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
//        Circulo[] circulos = new Circulo[this.ciudades.length];
//        circulos = generarVectorCirculos();
 
        Graphics g = Panel.getGraphics();
        for (int i = 0; i < this.grafo.ciudades.length; i++) {
            this.grafo.circulos[i].dibujarCiudad(g);
        }
        
    }//GEN-LAST:event_btnMostrarGrafoActionPerformed

    private void btnComenzarIteracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComenzarIteracionActionPerformed
        this.btnContinuar.setEnabled(true);
        
        System.out.println("Matriz de feromonas inicial");
        for (int i = 0; i < grafo.matrizFeromonas.length; i++) {
                for (int j = 0; j < grafo.matrizFeromonas.length; j++) {
                    System.out.print(grafo.matrizFeromonas[i][j]+" ");
                }
                System.out.println("");
        }
        
        if(this.contIteracion==0){
            this.grafo.iteracionesSimulacion[this.contIteracion].hormigas[0].recorridoHPrev=1;
            // Inicializa la matriz camino de la primera hormiga correspondiente a la iteración que se está realizando;
            this.grafo.iteracionesSimulacion[this.contIteracion].hormigas[0].inicializarCaminos(this.grafo.matrizDistancias, 
                this.grafo.matrizFeromonas);
        } else {
            this.grafo.iteracionesSimulacion[this.contIteracion].hormigas[0].recorridoHPrev=
                    this.grafo.iteracionesSimulacion[this.contIteracion-1].hormigas[(this.grafo.iteracionesSimulacion[0].hormigas.length-1)].distRecorrida;
            // Inicializa la matriz camino de la primera hormiga correspondiente a la iteración que se está realizando;
            this.grafo.iteracionesSimulacion[this.contIteracion].hormigas[0].inicializarCaminos(this.grafo.matrizDistancias, 
                this.grafo.matrizFeromonas);
            
            
//            this.grafo.iteracionesSimulacion[this.contIteracion].hormigas[0].caminos=
//                    this.grafo.iteracionesSimulacion[this.contIteracion-1].hormigas[(this.grafo.iteracionesSimulacion[0].hormigas.length-1)].caminos;
        }
        
        
//        this.grafo.iteracionesSimulacion[this.contIteracion].hormigas[0].ciudadesRecorridas=0;
        this.grafo.iteracionesSimulacion[this.contIteracion].hormigas[0].moverse(this.grafo.iteracionesSimulacion[this.contIteracion].hormigas[0], 
                grafo.datosSimulacion[1], this.grafo);
        
        this.contHormigas++;
        this.btnComenzarIteracion.setEnabled(false);
    }//GEN-LAST:event_btnComenzarIteracionActionPerformed

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        
            System.out.println("Hormiga " + contHormigas);

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
                    grafo.datosSimulacion[1], this.grafo);
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
                } else {
                    // Si no es la última iteración, le permite al usuario comenzar la siguiente iteración.
                   this.btnContinuar.setEnabled(false);
                   this.btnComenzarIteracion.setEnabled(true); 
                   this.grafo=
                           this.grafo.iteracionesSimulacion[this.contIteracion-1].hormigas[this.grafo.iteracionesSimulacion[this.contIteracion-1].hormigas.length-1].EvaporacionFeromonas(this.grafo);
                }
            }
            
        
        
    }//GEN-LAST:event_btnContinuarActionPerformed

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
                new Simulacion(grafo.matrizDistancias,grafo.ciudades,grafo.datosSimulacion,grafo.valoresCalculo).setVisible(true);
            }
        });
    }
    
//    public Circulo[] generarVectorCirculos(){
//        Circulo[] circulos = new Circulo[this.ciudades.length];
//        //Mínimo va a tener cuatro ciudades, por lo tanto:
//        circulos[0]= new Circulo(50,50,this.ciudades[0]); 
//        circulos[1] = new Circulo(100,150,this.ciudades[1]); 
//        circulos[2] = new Circulo(350,80,this.ciudades[2]); 
//        circulos[3] = new Circulo(400,150,this.ciudades[3]); 
//        
//        if(ciudades.length>4){
//            switch(ciudades.length){
//                case 5:
//                    circulos[4]= new Circulo(600,500,this.ciudades[4]); 
//                    break;
//                case 6: 
//                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
//                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
//                    break;
//                case 7:
//                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
//                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
//                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
//                    break;
//                case 8:
//                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
//                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
//                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
//                    circulos[7] = new Circulo(230,400,this.ciudades[7]);
//                    break;
//                case 9:
//                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
//                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
//                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
//                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
//                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
//                    break;
//                case 10:
//                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
//                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
//                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
//                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
//                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
//                    circulos[9] = new Circulo(120,500,this.ciudades[9]);
//                    break;
//                case 11:
//                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
//                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
//                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
//                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
//                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
//                    circulos[9] = new Circulo(120,500,this.ciudades[9]); 
//                    circulos[10] = new Circulo(390,400,this.ciudades[10]); 
//                    break;
//                case 12: 
//                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
//                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
//                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
//                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
//                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
//                    circulos[9] = new Circulo(120,500,this.ciudades[9]); 
//                    circulos[10] = new Circulo(390,400,this.ciudades[10]); 
//                    circulos[11] = new Circulo(250,50,this.ciudades[11]);
//                    break;
//                case 13:
//                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
//                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
//                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
//                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
//                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
//                    circulos[9] = new Circulo(120,500,this.ciudades[9]); 
//                    circulos[10] = new Circulo(390,400,this.ciudades[10]); 
//                    circulos[11] = new Circulo(250,50,this.ciudades[11]); 
//                    circulos[12]= new Circulo(310,500,this.ciudades[12]); 
//                    break;
//                case 14:
//                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
//                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
//                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
//                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
//                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
//                    circulos[9] = new Circulo(120,500,this.ciudades[9]); 
//                    circulos[10] = new Circulo(390,400,this.ciudades[10]); 
//                    circulos[11] = new Circulo(250,50,this.ciudades[11]); 
//                    circulos[12]= new Circulo(310,500,this.ciudades[12]); 
//                    circulos[13] = new Circulo(20,310,this.ciudades[13]);
//                    break;
//                case 15:
//                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
//                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
//                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
//                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
//                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
//                    circulos[9] = new Circulo(120,500,this.ciudades[9]); 
//                    circulos[10] = new Circulo(390,400,this.ciudades[10]); 
//                    circulos[11] = new Circulo(250,50,this.ciudades[11]); 
//                    circulos[12]= new Circulo(310,500,this.ciudades[12]); 
//                    circulos[13] = new Circulo(20,310,this.ciudades[13]); 
//                    circulos[14] = new Circulo(469,310,this.ciudades[14]); 
//                    break;
//                case 16:
//                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
//                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
//                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
//                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
//                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
//                    circulos[9] = new Circulo(120,500,this.ciudades[9]); 
//                    circulos[10] = new Circulo(390,400,this.ciudades[10]); 
//                    circulos[11] = new Circulo(250,50,this.ciudades[11]); 
//                    circulos[12]= new Circulo(310,500,this.ciudades[12]); 
//                    circulos[13] = new Circulo(20,310,this.ciudades[13]); 
//                    circulos[14] = new Circulo(469,310,this.ciudades[14]); 
//                    circulos[15] = new Circulo(360,250,this.ciudades[15]); 
//                    break;
//                case 17:
//                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
//                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
//                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
//                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
//                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
//                    circulos[9] = new Circulo(120,500,this.ciudades[9]); 
//                    circulos[10] = new Circulo(390,400,this.ciudades[10]); 
//                    circulos[11] = new Circulo(250,50,this.ciudades[11]); 
//                    circulos[12]= new Circulo(310,500,this.ciudades[12]); 
//                    circulos[13] = new Circulo(20,310,this.ciudades[13]); 
//                    circulos[14] = new Circulo(469,310,this.ciudades[14]); 
//                    circulos[15] = new Circulo(360,250,this.ciudades[15]); 
//                    circulos[16]= new Circulo(500,500,this.ciudades[16]); 
//                    break;
//                case 18:
//                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
//                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
//                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
//                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
//                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
//                    circulos[9] = new Circulo(120,500,this.ciudades[9]); 
//                    circulos[10] = new Circulo(390,400,this.ciudades[10]); 
//                    circulos[11] = new Circulo(250,50,this.ciudades[11]); 
//                    circulos[12]= new Circulo(310,500,this.ciudades[12]); 
//                    circulos[13] = new Circulo(20,310,this.ciudades[13]); 
//                    circulos[14] = new Circulo(469,310,this.ciudades[14]); 
//                    circulos[15] = new Circulo(360,250,this.ciudades[15]); 
//                    circulos[16]= new Circulo(500,500,this.ciudades[16]); 
//                    circulos[17] = new Circulo(190,230,this.ciudades[17]);  
//                    break;
//                case 19:
//                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
//                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
//                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
//                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
//                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
//                    circulos[9] = new Circulo(120,500,this.ciudades[9]); 
//                    circulos[10] = new Circulo(390,400,this.ciudades[10]); 
//                    circulos[11] = new Circulo(250,50,this.ciudades[11]); 
//                    circulos[12]= new Circulo(310,500,this.ciudades[12]); 
//                    circulos[13] = new Circulo(20,310,this.ciudades[13]); 
//                    circulos[14] = new Circulo(469,310,this.ciudades[14]); 
//                    circulos[15] = new Circulo(360,250,this.ciudades[15]); 
//                    circulos[16]= new Circulo(500,500,this.ciudades[16]); 
//                    circulos[17] = new Circulo(190,230,this.ciudades[17]); 
//                    circulos[18] = new Circulo(480,200,this.ciudades[18]); 
//                    break;
//                default:
//                    circulos[4]= new Circulo(600,500,this.ciudades[4]);  
//                    circulos[5] = new Circulo(330,180,this.ciudades[5]); 
//                    circulos[6] = new Circulo(380,470,this.ciudades[6]); 
//                    circulos[7] = new Circulo(230,400,this.ciudades[7]); 
//                    circulos[8]= new Circulo(80,370,this.ciudades[8]); 
//                    circulos[9] = new Circulo(120,500,this.ciudades[9]); 
//                    circulos[10] = new Circulo(390,400,this.ciudades[10]); 
//                    circulos[11] = new Circulo(250,50,this.ciudades[11]); 
//                    circulos[12]= new Circulo(310,500,this.ciudades[12]); 
//                    circulos[13] = new Circulo(20,310,this.ciudades[13]); 
//                    circulos[14] = new Circulo(469,310,this.ciudades[14]); 
//                    circulos[15] = new Circulo(360,250,this.ciudades[15]); 
//                    circulos[16]= new Circulo(500,500,this.ciudades[16]); 
//                    circulos[17] = new Circulo(190,230,this.ciudades[17]); 
//                    circulos[18] = new Circulo(480,200,this.ciudades[18]); 
//                    circulos[19] = new Circulo(550,50,this.ciudades[19]); 
//                    break;
//            }
//        }
//        return circulos;
//    }
//
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
