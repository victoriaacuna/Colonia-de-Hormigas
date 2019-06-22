
package Interfaz;

import Algoritmo.Archivo;
import javax.swing.JOptionPane;
import java.io.*;
import javax.swing.JFileChooser;

public class ModificarArchivo extends javax.swing.JFrame {

    static public int numCiudades, maxCiudades;
    static public File archivo;
    static public String [] ciudadesFinales;
    static public int[][] matrizDistanciaFinal;
    JFileChooser seleccionado = new JFileChooser();
    Archivo gestion = new Archivo();
    
    public ModificarArchivo(int numCiudades, int maxCiudades, File archivo) {
        this.numCiudades=numCiudades;
        this.maxCiudades=maxCiudades;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtAgregar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEliminar = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        listaCiudades = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Malayalam MN", 0, 14)); // NOI18N
        jLabel1.setText("Escribe el nombre de la ciudad que quieres agregar");

        txtAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgregarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Malayalam MN", 0, 14)); // NOI18N
        jLabel2.setText("Escribe el nombre de la ciudad que quieres eliminar");

        btnAgregar.setFont(new java.awt.Font("Malayalam MN", 1, 15)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Malayalam MN", 1, 15)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Malayalam MN", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ciudades de la simulación");

        btnSalir.setText("Salir del programa");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar y continuar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(103, 103, 103)
                                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(123, 123, 123)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(listaCiudades, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnRegresar)
                .addGap(105, 105, 105)
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listaCiudades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgregarActionPerformed
        
    }//GEN-LAST:event_txtAgregarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        if(numCiudades<=maxCiudades && !txtAgregar.getText().isEmpty()){
            
            boolean sePuedeAgregar=true;
            int i=0;
            
            // Se valida que la ciudad que quiere agregar no haya sido agregada antes.
            while(sePuedeAgregar && i<numCiudades){
                if(txtAgregar.getText().toUpperCase().equals(listaCiudades.getItemAt(i).toUpperCase())){
                    sePuedeAgregar=false;
                }
                i++;
            }
            
            if(!sePuedeAgregar){
                JOptionPane.showMessageDialog(this, "Ya agregó esta ciudad.", "Error", 
                    JOptionPane.ERROR_MESSAGE);
            } else {
                // Se agrega la ciudad.
                listaCiudades.addItem(txtAgregar.getText());
                numCiudades++;
            }
            
            txtAgregar.setText("");
            
        } else if(numCiudades>maxCiudades){
            JOptionPane.showMessageDialog(this, "No puede agregar más de 20 ciudades.\nElimine una si desea agregar otra.", "Error", 
                    JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No ha escrito el nombre de la ciudad que desea agregar", "Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //Se verifica que el campo de la ciudad que desea eliminar no esté vacío.
        if(!txtEliminar.getText().isEmpty()){
            boolean encontrado=false;
            int i=0;
            String ciudadAEliminar = txtEliminar.getText().toUpperCase(), item="";
            
            //Se verifica que en efecto la ciudad que quiere eliminar ha sido agregada previamente.
            while(!encontrado && i<numCiudades){
                item=listaCiudades.getItemAt(i).toUpperCase();
                if(item.equals(ciudadAEliminar)){
                    // Se elimina la ciudad si es el caso.
                    encontrado=true;
                    listaCiudades.removeItemAt(i);
                    numCiudades+= -1;
                }
                i++;
            }
            
            if(!encontrado){
                JOptionPane.showMessageDialog(this, "La ciudad que quiere eliminar no está en la lista de ciudades que agregó.", "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No ha escrito el nombre de la ciudad que desea eliminar", "Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
        
        txtEliminar.setText("");
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(numCiudades<4){
            JOptionPane.showMessageDialog(null, "Mínimo tiene que añadir 4 ciudades a la simulación.\nUsted añadió solo " + numCiudades,
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            ciudadesFinales = new String[listaCiudades.getItemCount()];
            for (int i = 0; i < ciudadesFinales.length; i++) {
                ciudadesFinales[i]=listaCiudades.getItemAt(i);
            }
            
            matrizDistanciaFinal=new int[listaCiudades.getItemCount()][listaCiudades.getItemCount()];
            for (int i = 0; i < matrizDistanciaFinal.length; i++) {
                for (int j = 0; j < matrizDistanciaFinal[0].length; j++) {
                    matrizDistanciaFinal[i][j]=0;
                }
            }
            
            //Para llenar la nueva matriz de distancias de acuerdo a las modificaciones del usuario, se debe evaluar si esta
            // nueva matriz creada tiene algo de compatibilidad con la matriz original del archivo. En caso de que así sea, 
            // se transfiere los datos.
            for (int i = 0; i < ciudadesFinales.length; i++) {
                for (int j = 0; j < CargarUnaSimulacion.ciudades.length; j++) {
                    if(CargarUnaSimulacion.ciudades[j]==ciudadesFinales[i]){
                        
                        for (int k = 0; k < ciudadesFinales.length; k++) {
                            for (int l = 0; l < CargarUnaSimulacion.ciudades.length; l++) {
                                if(matrizDistanciaFinal[i][k]==0){
                                    
                                    if((i!=k)&&(j!=l)&&(CargarUnaSimulacion.ciudades[l]==ciudadesFinales[k])){
                                        matrizDistanciaFinal[i][k]=CargarUnaSimulacion.matrizDistancias[j][l];
                                        matrizDistanciaFinal[k][i]=CargarUnaSimulacion.matrizDistancias[j][l];
                                }
                                }
                            }  
                        }
                    }
                }
            }
            CargarUnaSimulacion.ciudadesFinales=this.ciudadesFinales;
            CargarUnaSimulacion.matrizDistanciaFinal=matrizDistanciasFinal(this.matrizDistanciaFinal,this.ciudadesFinales);
            String contenido=Archivo.generarContenidoArchivo(CargarUnaSimulacion.matrizDistanciaFinal, 
                    CargarUnaSimulacion.ciudadesFinales, CargarUnaSimulacion.valoresCalculos, CargarUnaSimulacion.datosSimulacion);
            if(this.seleccionado.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION){
                this.archivo = seleccionado.getSelectedFile();
                if(this.archivo.getName().endsWith("txt")){
                    gestion.GuardarTexto(archivo, contenido);
                    CargarUnaSimulacion.archivo=this.archivo;
                    CargarUnaSimulacion.txtArchivo.setText(contenido);
                    this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "El texto se debe guardar en un formato de texto.\n(Agréguele \".txt\" al nombre "
                            + "de su archivo cuando lo vaya a guardar).");
                }
            }
            
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        CargarUnaSimulacion c = new CargarUnaSimulacion();
        c.setVisible(true);
        c.setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(ModificarArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarArchivo(numCiudades, maxCiudades, archivo).setVisible(true);
            }
        });
    }
    
    public static int[][] matrizDistanciasFinal(int[][] matrizDistancias, String[] ciudades){
        String aux;
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
                                        JOptionPane.showMessageDialog(null, "El número que introdujo NO es un entero y DEBE ser un entero.", 
                                        "Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                    if(NuevaSimulacion.isInt(aux) && Integer.parseInt(aux)<1){
                                        JOptionPane.showMessageDialog(null, "No puede introducir números negativos o ceros como distancia entre ciudades.", 
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
        return matrizDistancias;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JComboBox<String> listaCiudades;
    private javax.swing.JTextField txtAgregar;
    private javax.swing.JTextField txtEliminar;
    // End of variables declaration//GEN-END:variables
}
