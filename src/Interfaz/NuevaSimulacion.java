
package Interfaz;

import javax.swing.JOptionPane;

// @author victoriaacuna

public class NuevaSimulacion extends javax.swing.JFrame {
    
    double rho, alfa, beta;
    int numCiudades=0;
    int maxCiudades=20, minCiudades=4;
    
    public NuevaSimulacion() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public static boolean isInt(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    
    public static boolean isDouble(String cadena){
	try {
                Double.parseDouble(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtIteraciones = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtHormigas = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rbtnValoresPorDefecto = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtAlfa = new javax.swing.JTextField();
        txtBeta = new javax.swing.JTextField();
        txtRho = new javax.swing.JTextField();
        btnCrearSimulacion = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtAgregarCiudad = new javax.swing.JTextField();
        btnAgregarCiudad = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        listCiudades = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtEliminarCiudad = new javax.swing.JTextField();
        btnEliminarCiudad = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1068, 597));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel1.setText("Número de iteraciones a realizar");

        txtIteraciones.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setFont(new java.awt.Font("Malayalam MN", 1, 36)); // NOI18N
        jLabel2.setText("Nueva simulación");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel3.setText("Número de hormigas por cada simulación");

        txtHormigas.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel4.setText("Ingrese los siguientes datos");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel5.setText("Valores α, β y ρ");

        rbtnValoresPorDefecto.setSelected(true);
        rbtnValoresPorDefecto.setText("Establecidos por defecto");
        rbtnValoresPorDefecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnValoresPorDefectoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel6.setText("Valor del grado de importancia de la ferormona (α)");

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel7.setText("Valor del grado de grado de visibilidad de la ciudad (β)");

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel8.setText("Valor del factor de evaporación (ρ)");

        txtAlfa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAlfa.setText("1");
        txtAlfa.setEnabled(false);

        txtBeta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBeta.setText("2");
        txtBeta.setEnabled(false);
        txtBeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBetaActionPerformed(evt);
            }
        });

        txtRho.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRho.setText("0.5");
        txtRho.setEnabled(false);

        btnCrearSimulacion.setText("Crear simulación");
        btnCrearSimulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearSimulacionActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir del programa");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel9.setText("Agrega las ciudades que desees en la simulación");

        jLabel10.setText("(Mínimo 4 y máximo 20)");

        txtAgregarCiudad.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnAgregarCiudad.setText("Agregar");
        btnAgregarCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCiudadActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel11.setText("Ciudades agregadas");

        jLabel12.setText("Si deseas eliminar una ciudad, introduce su nombre");

        txtEliminarCiudad.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnEliminarCiudad.setText("Eliminar");
        btnEliminarCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCiudadActionPerformed(evt);
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(190, 190, 190))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(371, 371, 371))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtHormigas, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIteraciones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarCiudad)
                        .addGap(187, 187, 187))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addComponent(rbtnValoresPorDefecto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(156, 156, 156))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAgregarCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(58, 58, 58))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(44, 44, 44)
                                .addComponent(txtAlfa, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRho, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBeta, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(176, 176, 176)
                                        .addComponent(btnCrearSimulacion)
                                        .addGap(51, 51, 51)
                                        .addComponent(btnSalir)
                                        .addGap(48, 48, 48))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(161, 161, 161)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(jLabel12)
                                                    .addGap(23, 23, 23))
                                                .addComponent(txtEliminarCiudad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(listCiudades, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminarCiudad)
                                .addGap(182, 182, 182))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnRegresar)))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtIteraciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAgregarCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtHormigas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarCiudad))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnValoresPorDefecto)
                    .addComponent(jLabel11))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(listCiudades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAlfa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 161, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalir)
                            .addComponent(btnCrearSimulacion))
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel12)
                                .addGap(28, 28, 28)
                                .addComponent(txtEliminarCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtRho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminarCiudad)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void rbtnValoresPorDefectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnValoresPorDefectoActionPerformed
        if(rbtnValoresPorDefecto.isSelected()){
            // Si quiere utilizar los valores por defecto, se inhabilitan los campos de texto de dichas variables para evitar
            // que los modifique y se le indica cuáles serían dichos valores.
            txtAlfa.setEnabled(false);
            txtBeta.setEnabled(false);
            txtRho.setEnabled(false);
            txtAlfa.setText("1");
            txtBeta.setText("1");
            txtRho.setText("0.5");
        } else {
            // En caso contrario, se habilitan los campos y se le solicita que los llene.
            txtAlfa.setEnabled(true);
            txtBeta.setEnabled(true);
            txtRho.setEnabled(true);
            txtAlfa.setText("");
            txtBeta.setText("");
            txtRho.setText("");
            
        }
    }//GEN-LAST:event_rbtnValoresPorDefectoActionPerformed

    private void btnAgregarCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCiudadActionPerformed
        // Antes de agregar la ciudad, se valida que no haya excedido el límite de ciudades que exige el programa y que
        // no haya dejado vacío el campo donde indica qué ciudad desea agregar.
        if(numCiudades<=maxCiudades && !txtAgregarCiudad.getText().isEmpty()){
            
            boolean sePuedeAgregar=true;
            int i=0;
            
            // Se valida que la ciudad que quiere agregar no haya sido agregada antes.
            while(sePuedeAgregar && i<numCiudades){
                if(txtAgregarCiudad.getText().toUpperCase().equals(listCiudades.getItemAt(i).toUpperCase())){
                    sePuedeAgregar=false;
                }
                i++;
            }
            
            if(!sePuedeAgregar){
                JOptionPane.showMessageDialog(this, "Ya agregó esta ciudad.", "Error", 
                    JOptionPane.ERROR_MESSAGE);
            } else {
                // Se agrega la ciudad.
                listCiudades.addItem(txtAgregarCiudad.getText());
                numCiudades++;
            }
            
            txtAgregarCiudad.setText("");
            
        } else if(numCiudades>maxCiudades){
            JOptionPane.showMessageDialog(this, "No puede agregar más de 20 ciudades.\nElimine una si desea agregar otra.", "Error", 
                    JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No ha escrito el nombre de la ciudad que desea agregar", "Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarCiudadActionPerformed

    private void btnEliminarCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCiudadActionPerformed
        
        //Se verifica que el campo de la ciudad que desea eliminar no esté vacío.
        if(!txtEliminarCiudad.getText().isEmpty()){
            boolean encontrado=false;
            int i=0;
            String ciudadAEliminar = txtEliminarCiudad.getText().toUpperCase(), item="";
            
            //Se verifica que en efecto la ciudad que quiere eliminar ha sido agregada previamente.
            while(!encontrado && i<numCiudades){
                item=listCiudades.getItemAt(i).toUpperCase();
                if(item.equals(ciudadAEliminar)){
                    // Se elimina la ciudad si es el caso.
                    encontrado=true;
                    listCiudades.removeItemAt(i);
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
        
        txtEliminarCiudad.setText("");
    }//GEN-LAST:event_btnEliminarCiudadActionPerformed

    private void btnCrearSimulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearSimulacionActionPerformed
        //Antes de crear la simulación se verifican todas las condiciones necesarias...
        // Que el campo de las hormigas de la simulación esté llenado con un entero.
        if(!txtHormigas.getText().isEmpty() && isInt(txtHormigas.getText())){
            // Que el campo de las iteraciones de la simulación esté llenado con un entero.
            if(!txtIteraciones.getText().isEmpty() && isInt(txtIteraciones.getText())){
                // Que las ciudades agregadas estén en el rango mínimo y máximo permitido por el programa.
                if(numCiudades>=minCiudades && numCiudades<=maxCiudades){
                    // Que los valores de alfa, beta y rho sean números entero, entero y decimal respectivamente.
                    if(isInt(txtAlfa.getText()) && isInt(txtBeta.getText()) && isDouble(txtRho.getText())){
                        
                        if(Double.parseDouble(txtRho.getText())>0 && Double.parseDouble(txtRho.getText())<=1){
                            
                            // Se crea un vector con los nombres de las ciudades elegidas.
                            String ciudades [] = new String[numCiudades];
                            for (int i = 0; i < ciudades.length; i++) {
                                ciudades[i]=listCiudades.getItemAt(i);
                            }

                            // Se crea un vector con los valores de α, β y ρ.
                            double valoresCalculo [] = new double[3];
                            valoresCalculo[0]=Double.parseDouble(txtAlfa.getText());
                            valoresCalculo[1]=Double.parseDouble(txtBeta.getText());
                            valoresCalculo[2]=Double.parseDouble(txtRho.getText());

                            // Se crea un vector con los datos de la cantidad de iteraciones y hormigas.
                            int datosSimulacion [] = new int[2];
                            datosSimulacion[0]=Integer.parseInt(txtIteraciones.getText());
                            datosSimulacion[1]=Integer.parseInt(txtHormigas.getText());


                            // Una vez validados todos los datos, se le pregunta al usuario si desea continuar.
                            CreacionCiudades verificar = new CreacionCiudades(ciudades, valoresCalculo, datosSimulacion,this);
                            verificar.setLocationRelativeTo(null);
                            verificar.setVisible(true);
                        
                            
                        } else {
                            JOptionPane.showMessageDialog(this, "El valor de ρ debe ser mayor que 0 y menor o igual a 1.", 
                                "Error", JOptionPane.ERROR_MESSAGE);
                            txtRho.setText("");
                        }
                        
                        
                    } else {
                        JOptionPane.showMessageDialog(this, "Los valores de α, β y ρ que escogió son incorrectos.\n"
                                + "Deben ser llenados por un números entero, entero y decimal/entero respectivamente.", "Error", 
                    JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Valide la cantidad de ciudades que agregó a la"
                    + " simulación.\nDeben ser mínimo 4 y máximo 20.\nUsted agregó " + numCiudades, "Error", 
                    JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Valide el campo de texto donde ingresó la cantidad de iteraciones de la "
                    + "simulación.\nDebe de estar lleno con un número entero. Por ejemplo, \"5\".", "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }  
        } else {
            JOptionPane.showMessageDialog(this, "Valide el campo de texto donde ingresó la cantidad de hormigas de la "
                    + "simulación.\nDebe de estar lleno con un número entero. Por ejemplo, \"5\".", "Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCrearSimulacionActionPerformed

    private void txtBetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBetaActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Menu m = new Menu();
        m.setVisible(true);
        m.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    
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
            java.util.logging.Logger.getLogger(NuevaSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevaSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevaSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevaSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevaSimulacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCiudad;
    private javax.swing.JButton btnCrearSimulacion;
    private javax.swing.JButton btnEliminarCiudad;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> listCiudades;
    private javax.swing.JRadioButton rbtnValoresPorDefecto;
    private javax.swing.JTextField txtAgregarCiudad;
    private javax.swing.JTextField txtAlfa;
    private javax.swing.JTextField txtBeta;
    private javax.swing.JTextField txtEliminarCiudad;
    private javax.swing.JTextField txtHormigas;
    private javax.swing.JTextField txtIteraciones;
    private javax.swing.JTextField txtRho;
    // End of variables declaration//GEN-END:variables
}
