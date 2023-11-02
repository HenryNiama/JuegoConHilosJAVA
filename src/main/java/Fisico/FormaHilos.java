
package Fisico;

//Se importan las clases de los jugadores;
import Logica.clsJugador1;
import Logica.clsJugador2;
import Logica.clsJugador3;

import javax.swing.JOptionPane;
//se importa la clase para el manejo de modelo de tablas (JTable)
import javax.swing.table.DefaultTableModel;

public class FormaHilos extends javax.swing.JFrame {

    //se crea variable modeloTabla para apoyar el manejo de JTable tabla
    DefaultTableModel modeloTabla = new DefaultTableModel();
    //se crea variable modeloTabla para apoyar el manejo de JTable
    //tablaJugador1 y asi sucesivamente:
    DefaultTableModel modTablaJugador1 = new DefaultTableModel();
    DefaultTableModel modTablaJugador2 = new DefaultTableModel();
    DefaultTableModel modTablaJugador3 = new DefaultTableModel();
    
    //se crea un objeto “filas” de 24 elementos para
    //almacenar las columnas de la tabla "tabla"
    Object[] filas = new Object[24];
    //para datos del jugador 1 y así...
    Object[] datosJugador1 = new Object[3];
    Object[] datosJugador2 = new Object[3];
    Object[] datosJugador3 = new Object[3];
    
    public Boolean seguir = true;
    
    //para llevar el control de las
    //celdas para el jugador1 y así...
    int celdaJugador1 = 0;
    int celdaJugador2 = 0;
    int celdaJugador3 = 0;
    
    int p=0;
    int q=0;
    int m=0;
    
    //Se crea instancia de las clases de los jugadores
    clsJugador1 jug1 = new clsJugador1();
    clsJugador2 jug2 = new clsJugador2();
    clsJugador3 jug3 = new clsJugador3();
    
    
    public FormaHilos() {
        initComponents();
        cargarTabla(); //se carga la tabla con los titulos
        //se obtienen los nombres de los jugadores
        //y se cargan en las respectivas etiquetas.
        lblNomJug1.setText("Jugador : "+jug1.getNombre().toUpperCase());
        lblNomJug2.setText("Jugador : "+jug2.getNombre().toUpperCase());
        lblNomJug3.setText("Jugador : "+jug3.getNombre().toUpperCase());
    }

   //se carga el detalle de las tablas con los valores 0 y -1
    void cargarDetalles(){
        for(int i=0; i<24; i++){
            filas[i] =0;
        }
        for(int x=1; x<=3; x++){
            //para generar los numeros:
            int numero = (int)(Math.random()*22+1);          
            filas[numero] = -1;
        }
        //carga el modelo con los datos obtenidos
        modeloTabla.addRow(filas);
        tabla.setModel(modeloTabla);
    }
         
    void cargarTabla(){
        //cargar 24 valores en el encabezado;
        for(int i=1; i<=24; i++){
            modeloTabla.addColumn(String.valueOf(i));
        }
        //cargar el detalle de la table (0 y -1)
        cargarDetalles();
    }
    
    //Para limpiar la tabla:
    public void limpiarTabla(javax.swing.JTable miTabla){
        DefaultTableModel modelo = (DefaultTableModel)miTabla.getModel();
        
        //se elimina todas las filas del detalle:
        while(modelo.getRowCount() >0){
            modelo.removeRow(0);
        }
        
        celdaJugador1 =0;
        celdaJugador2 =0;
        celdaJugador3 =0;
        seguir = true;
    }
    
    //se configura la tabla según sus columnas.
    void confTablaJugadores(javax.swing.table.DefaultTableModel modelo){
        modelo.addColumn("Celda Avance");
        modelo.addColumn("Contenido de la Celda");
        modelo.addColumn("Celda Actual");
    }
    
    public void moverJugador1(int celda){
        try{
            celdaJugador1 +=celda;
            if(celdaJugador1 >=24 && seguir == true){
                celdaJugador1 = 24;
                seguir=false;
                JOptionPane.showMessageDialog(null, "Juego Terminado..\nGanó el jugador Nº"+
                String.valueOf(jug1.getNumero())+", "+jug1.getNombre().toUpperCase());               
            }
            if(celdaJugador1<=24){
                //se obtiene el contenido de la celda seleccionada
                //para jugador1
                Object valorCelda = tabla.getValueAt(0, celdaJugador1);
                //Si en esa celda existe un -1...
                if("-1".equals(valorCelda.toString())){
                    celdaJugador1=0;
                }
                //permite configurar solo una vez la tabla del jugador1
                if(p==0){
                    confTablaJugadores(this.modTablaJugador1);
                    p=1;
                }
                
                //se llenan las columnas del detalle de la table del jugador1
                datosJugador1[0] = String.valueOf(celda);
                datosJugador1[1] = valorCelda;
                datosJugador1[2] = celdaJugador1;
                modTablaJugador1.addRow(datosJugador1);
                tablaJugador1.setModel(modTablaJugador1);
                lblIntJugador1.setText("Interacciones: "+String.valueOf(modTablaJugador1.getRowCount()));
            }
        }catch(Exception e){
            seguir = false;
        }
    }
    
    public void moverJugador2(int celda){
          try{
            celdaJugador2 +=celda;
            if(celdaJugador2 >=24 && seguir == true){
                celdaJugador2 = 24;
                seguir=false;
                JOptionPane.showMessageDialog(null, "Juego Terminado..\nGanó el jugador Nº"+
                String.valueOf(jug2.getNumero())+", "+jug2.getNombre().toUpperCase());               
            }
            if(celdaJugador2<=24){
                //se obtiene el contenido de la celda seleccionada
                //para jugador1
                Object valorCelda = tabla.getValueAt(0, celdaJugador2);
                //Si en esa celda existe un -1...
                if("-1".equals(valorCelda.toString())){
                    celdaJugador2=0;
                }
                //permite configurar solo una vez la tabla del jugador1
                if(q==0){
                    confTablaJugadores(this.modTablaJugador2);
                    q=1;
                }
                
                //se llenan las columnas del detalle de la table del jugador1
                datosJugador2[0] = String.valueOf(celda);
                datosJugador2[1] = valorCelda;
                datosJugador2[2] = celdaJugador2;
                modTablaJugador2.addRow(datosJugador2);
                tablaJugador2.setModel(modTablaJugador2);
                lblIntJugador2.setText("Interacciones: "+String.valueOf(modTablaJugador2.getRowCount()));
            }
        }catch(Exception e){
            seguir = false;
        }
    }
    
    public void moverJugador3(int celda){
          try{
            celdaJugador3 +=celda;
            if(celdaJugador3 >=24 && seguir == true){
                celdaJugador3 = 24;
                seguir=false;
                JOptionPane.showMessageDialog(null, "Juego Terminado..\nGanó el jugador Nº"+
                String.valueOf(jug3.getNumero())+", "+jug3.getNombre().toUpperCase());               
            }
            if(celdaJugador3<=24){
                //se obtiene el contenido de la celda seleccionada
                //para jugador1
                Object valorCelda = tabla.getValueAt(0, celdaJugador3);
                //Si en esa celda existe un -1...
                if("-1".equals(valorCelda.toString())){
                    celdaJugador3=0;
                }
                //permite configurar solo una vez la tabla del jugador1
                if(m==0){
                    confTablaJugadores(this.modTablaJugador3);
                    m=1;
                }
                
                //se llenan las columnas del detalle de la table del jugador1
                datosJugador3[0] = String.valueOf(celda);
                datosJugador3[1] = valorCelda;
                datosJugador3[2] = celdaJugador3;
                modTablaJugador3.addRow(datosJugador3);
                tablaJugador3.setModel(modTablaJugador3);
                lblIntJugador3.setText("Interacciones: "+String.valueOf(modTablaJugador3.getRowCount()));
            }
        }catch(Exception e){
            seguir = false;
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblNomJug1 = new javax.swing.JLabel();
        lblNomJug3 = new javax.swing.JLabel();
        lblNomJug2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaJugador1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaJugador2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaJugador3 = new javax.swing.JTable();
        lblIntJugador1 = new javax.swing.JLabel();
        lblIntJugador2 = new javax.swing.JLabel();
        lblIntJugador3 = new javax.swing.JLabel();
        btnJugar = new javax.swing.JButton();
        btnReiniciarJuego = new javax.swing.JButton();
        btnGenerarTabla = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("Tabla de Juego");

        lblNomJug1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblNomJug1.setText("Jugador 1");

        lblNomJug3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblNomJug3.setText("Jugador 3");

        lblNomJug2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblNomJug2.setText("Jugador 2");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "null5", "6", "null", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14", "Title 15", "Title 16", "Title 17", "Title 18", "Title 19", "Title 20", "Title 21", "Title 22", "Title 23", "Title 24"
            }
        ));
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(2).setResizable(false);
            tabla.getColumnModel().getColumn(3).setResizable(false);
            tabla.getColumnModel().getColumn(4).setResizable(false);
            tabla.getColumnModel().getColumn(5).setResizable(false);
            tabla.getColumnModel().getColumn(6).setResizable(false);
            tabla.getColumnModel().getColumn(7).setResizable(false);
            tabla.getColumnModel().getColumn(8).setResizable(false);
            tabla.getColumnModel().getColumn(9).setResizable(false);
            tabla.getColumnModel().getColumn(10).setResizable(false);
            tabla.getColumnModel().getColumn(11).setResizable(false);
            tabla.getColumnModel().getColumn(12).setResizable(false);
            tabla.getColumnModel().getColumn(13).setResizable(false);
            tabla.getColumnModel().getColumn(14).setResizable(false);
            tabla.getColumnModel().getColumn(15).setResizable(false);
            tabla.getColumnModel().getColumn(16).setResizable(false);
            tabla.getColumnModel().getColumn(17).setResizable(false);
            tabla.getColumnModel().getColumn(18).setResizable(false);
            tabla.getColumnModel().getColumn(19).setResizable(false);
            tabla.getColumnModel().getColumn(20).setResizable(false);
            tabla.getColumnModel().getColumn(21).setResizable(false);
            tabla.getColumnModel().getColumn(22).setResizable(false);
            tabla.getColumnModel().getColumn(23).setResizable(false);
        }

        tablaJugador1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Celda Avance", "Contenido de la Celda", "Celda Actual"
            }
        ));
        jScrollPane2.setViewportView(tablaJugador1);
        if (tablaJugador1.getColumnModel().getColumnCount() > 0) {
            tablaJugador1.getColumnModel().getColumn(0).setResizable(false);
            tablaJugador1.getColumnModel().getColumn(1).setResizable(false);
            tablaJugador1.getColumnModel().getColumn(2).setResizable(false);
        }

        tablaJugador2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Celda Avance", "Contenido de la Celda", "Celda Actual"
            }
        ));
        jScrollPane3.setViewportView(tablaJugador2);
        if (tablaJugador2.getColumnModel().getColumnCount() > 0) {
            tablaJugador2.getColumnModel().getColumn(0).setResizable(false);
            tablaJugador2.getColumnModel().getColumn(1).setResizable(false);
            tablaJugador2.getColumnModel().getColumn(2).setResizable(false);
        }

        tablaJugador3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Celda Avance", "Contenido de la Celda", "Celda Actual"
            }
        ));
        jScrollPane4.setViewportView(tablaJugador3);
        if (tablaJugador3.getColumnModel().getColumnCount() > 0) {
            tablaJugador3.getColumnModel().getColumn(0).setResizable(false);
            tablaJugador3.getColumnModel().getColumn(1).setResizable(false);
            tablaJugador3.getColumnModel().getColumn(2).setResizable(false);
        }

        lblIntJugador1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblIntJugador1.setText("Interacciones: 0");

        lblIntJugador2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblIntJugador2.setText("Interacciones: 0");

        lblIntJugador3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblIntJugador3.setText("Interacciones: 0");

        btnJugar.setText("Jugar !");
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });

        btnReiniciarJuego.setText("Reiniciar Juego");
        btnReiniciarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarJuegoActionPerformed(evt);
            }
        });

        btnGenerarTabla.setText("Generar Tabla");
        btnGenerarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarTablaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(lblNomJug1)
                .addGap(329, 329, 329)
                .addComponent(lblNomJug2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNomJug3)
                .addGap(179, 179, 179))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(535, 535, 535)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblIntJugador1))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblIntJugador2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblIntJugador3)
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(421, 421, 421)
                        .addComponent(btnJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReiniciarJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGenerarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomJug1)
                    .addComponent(lblNomJug2)
                    .addComponent(lblNomJug3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIntJugador2)
                            .addComponent(lblIntJugador3))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReiniciarJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGenerarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblIntJugador1)
                        .addContainerGap(113, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarTablaActionPerformed
        //se cargan los nuevos detalles (nuevos 0 y -1 generados):
       //Elmina toda la fila 0 donde está el encabezado
        modeloTabla.removeRow(0);
        tabla.setModel(modeloTabla);//se acxtualiza la tabla
        cargarDetalles();
    }//GEN-LAST:event_btnGenerarTablaActionPerformed

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        clsJugador1 j1; //se crea una instancia de jugador 1
        j1 = new clsJugador1(this);
        clsJugador2 j2;
        j2 = new clsJugador2(this);
        clsJugador3 j3;
        j3 = new clsJugador3(this);
        
        j1.start();
        j2.start();
        j3.start();
        
        if(seguir ==false){
            j1 = null;
            j2 = null;
            j3 = null;
        }
        btnJugar.setEnabled(false);
        btnReiniciarJuego.setEnabled(true);
    }//GEN-LAST:event_btnJugarActionPerformed

    private void btnReiniciarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarJuegoActionPerformed
        limpiarTabla(this.tablaJugador1);
        limpiarTabla(this.tablaJugador2);
        limpiarTabla(this.tablaJugador3);
        btnJugar.setEnabled(true);
        btnReiniciarJuego.setEnabled(false);
        lblIntJugador1.setText("Interacciones: 0");
        lblIntJugador1.setText("Interacciones: 0");
        lblIntJugador2.setText("Interacciones: 0");
        lblIntJugador3.setText("Interacciones: 0");
    }//GEN-LAST:event_btnReiniciarJuegoActionPerformed

    
    
    

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
            java.util.logging.Logger.getLogger(FormaHilos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormaHilos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormaHilos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormaHilos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormaHilos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarTabla;
    private javax.swing.JButton btnJugar;
    private javax.swing.JButton btnReiniciarJuego;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblIntJugador1;
    private javax.swing.JLabel lblIntJugador2;
    private javax.swing.JLabel lblIntJugador3;
    private javax.swing.JLabel lblNomJug1;
    private javax.swing.JLabel lblNomJug2;
    private javax.swing.JLabel lblNomJug3;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tablaJugador1;
    private javax.swing.JTable tablaJugador2;
    private javax.swing.JTable tablaJugador3;
    // End of variables declaration//GEN-END:variables
}
