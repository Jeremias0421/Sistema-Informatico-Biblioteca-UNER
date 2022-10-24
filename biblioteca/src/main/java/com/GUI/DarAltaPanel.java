/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.GUI;

import com.biblioteca.Edicion;
import com.biblioteca.Ejemplar;
import com.biblioteca.Funcionario;
import com.biblioteca.Identificacion;
import com.biblioteca.Obra;
import com.biblioteca.TipoObra;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dalzo
 */
public class DarAltaPanel extends javax.swing.JFrame {

    ArrayList<Funcionario> funcionarios = null;
    ArrayList<Obra> listadoObras = null;
    ArrayList<Ejemplar> listadoEjemplares = null;
    ArrayList<Edicion> ediciones = null;
    
    /**
     * Creates new form DarAltaPanel
     */
    public DarAltaPanel() {
        //Codigo con proposito de prueba:
        listadoObras = new ArrayList();
        listadoEjemplares = new ArrayList();
        Obra obraTest = new Obra("Calculo 1", "Subtitulo", "Autor1", "Autor2", "Autor3", "Matematica", "Educacion", "9780313338", null, TipoObra.DIARIO);
        listadoObras.add(obraTest);
        //Codigo que o es de prueba:
        
        
        initComponents();
        customComponents();
    }
    
    public DarAltaPanel(ArrayList<Funcionario> funcionarioList, ArrayList<Ejemplar> ejemplaresList, ArrayList<Obra> obrasList, ArrayList<Edicion> edicionesList){
        funcionarios = funcionarioList;
        listadoEjemplares = ejemplaresList;
        listadoObras = obrasList;
        ediciones = edicionesList;
        
        initComponents();
        customComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        tituloPanel = new javax.swing.JLabel();
        cartelObra = new javax.swing.JTextField();
        cartelObsrv = new javax.swing.JTextField();
        cartelCodigo = new javax.swing.JTextField();
        cartelFormaAdq = new javax.swing.JTextField();
        cartelUbicacion = new javax.swing.JTextField();
        codigoBarra = new javax.swing.JTextField();
        observaciones = new javax.swing.JTextField();
        fAdquisicion = new javax.swing.JTextField();
        menuObras = new javax.swing.JComboBox<>();
        volverBtn = new javax.swing.JButton();
        guardarEjemplarBtn = new javax.swing.JButton();
        columna = new javax.swing.JSpinner();
        posicion = new javax.swing.JSpinner();
        fila = new javax.swing.JSpinner();
        estante = new javax.swing.JSpinner();
        pasillo = new javax.swing.JSpinner();
        cartelPosicion = new javax.swing.JTextField();
        cartelPasillo = new javax.swing.JTextField();
        cartelFila = new javax.swing.JTextField();
        cartelColumna = new javax.swing.JTextField();
        cartelEstante = new javax.swing.JTextField();
        nuevaObraBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nuevo ejemplar");
        setResizable(false);

        bg.setBackground(new java.awt.Color(3, 33, 67));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloPanel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tituloPanel.setForeground(new java.awt.Color(255, 255, 255));
        tituloPanel.setText("ALTA DE EJEMPLAR");
        tituloPanel.setFocusable(false);
        bg.add(tituloPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        cartelObra.setEditable(false);
        cartelObra.setBackground(new java.awt.Color(3, 33, 67));
        cartelObra.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        cartelObra.setForeground(new java.awt.Color(255, 255, 255));
        cartelObra.setText("Obra");
        cartelObra.setBorder(null);
        cartelObra.setFocusable(false);
        bg.add(cartelObra, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 50, -1));

        cartelObsrv.setEditable(false);
        cartelObsrv.setBackground(new java.awt.Color(3, 33, 67));
        cartelObsrv.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        cartelObsrv.setForeground(new java.awt.Color(255, 255, 255));
        cartelObsrv.setText("Observaciones");
        cartelObsrv.setBorder(null);
        cartelObsrv.setFocusable(false);
        bg.add(cartelObsrv, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 120, -1));

        cartelCodigo.setEditable(false);
        cartelCodigo.setBackground(new java.awt.Color(3, 33, 67));
        cartelCodigo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        cartelCodigo.setForeground(new java.awt.Color(255, 255, 255));
        cartelCodigo.setText("Codigo");
        cartelCodigo.setBorder(null);
        cartelCodigo.setFocusable(false);
        bg.add(cartelCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, -1));

        cartelFormaAdq.setEditable(false);
        cartelFormaAdq.setBackground(new java.awt.Color(3, 33, 67));
        cartelFormaAdq.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        cartelFormaAdq.setForeground(new java.awt.Color(255, 255, 255));
        cartelFormaAdq.setText("Forma adquisicon");
        cartelFormaAdq.setBorder(null);
        cartelFormaAdq.setFocusable(false);
        bg.add(cartelFormaAdq, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 140, -1));

        cartelUbicacion.setEditable(false);
        cartelUbicacion.setBackground(new java.awt.Color(3, 33, 67));
        cartelUbicacion.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        cartelUbicacion.setForeground(new java.awt.Color(255, 255, 255));
        cartelUbicacion.setText("Ubicacion");
        cartelUbicacion.setBorder(null);
        cartelUbicacion.setFocusable(false);
        bg.add(cartelUbicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 90, -1));

        codigoBarra.setBackground(new java.awt.Color(0, 8, 16));
        codigoBarra.setForeground(new java.awt.Color(255, 255, 255));
        bg.add(codigoBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 220, -1));

        observaciones.setBackground(new java.awt.Color(0, 8, 16));
        observaciones.setForeground(new java.awt.Color(255, 255, 255));
        bg.add(observaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 220, -1));

        fAdquisicion.setBackground(new java.awt.Color(0, 8, 16));
        fAdquisicion.setForeground(new java.awt.Color(255, 255, 255));
        bg.add(fAdquisicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 220, -1));

        menuObras.setBackground(new java.awt.Color(0, 8, 16));
        menuObras.setForeground(new java.awt.Color(255, 255, 255));
        bg.add(menuObras, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 220, -1));

        volverBtn.setBackground(new java.awt.Color(96, 106, 135));
        volverBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        volverBtn.setForeground(new java.awt.Color(255, 255, 255));
        volverBtn.setText("Volver");
        volverBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });
        bg.add(volverBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 130, 30));

        guardarEjemplarBtn.setBackground(new java.awt.Color(96, 106, 135));
        guardarEjemplarBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        guardarEjemplarBtn.setForeground(new java.awt.Color(255, 255, 255));
        guardarEjemplarBtn.setText("Guardar ejemplar");
        guardarEjemplarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        guardarEjemplarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarEjemplarBtnActionPerformed(evt);
            }
        });
        bg.add(guardarEjemplarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 130, 30));

        columna.setModel(new javax.swing.SpinnerNumberModel(1, 1, 20, 1));
        bg.add(columna, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 60, -1));

        posicion.setModel(new javax.swing.SpinnerNumberModel(1, 1, 20, 1));
        bg.add(posicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 60, -1));

        fila.setModel(new javax.swing.SpinnerNumberModel(1, 1, 20, 1));
        bg.add(fila, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 60, -1));

        estante.setModel(new javax.swing.SpinnerNumberModel(1, 1, 20, 1));
        bg.add(estante, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 60, -1));

        pasillo.setModel(new javax.swing.SpinnerNumberModel(1, 1, 20, 1));
        bg.add(pasillo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 60, -1));

        cartelPosicion.setEditable(false);
        cartelPosicion.setBackground(new java.awt.Color(3, 33, 67));
        cartelPosicion.setFont(new java.awt.Font("Segoe UI Symbol", 0, 16)); // NOI18N
        cartelPosicion.setForeground(new java.awt.Color(255, 255, 255));
        cartelPosicion.setText("posicion");
        cartelPosicion.setBorder(null);
        cartelPosicion.setFocusable(false);
        bg.add(cartelPosicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 70, -1));

        cartelPasillo.setEditable(false);
        cartelPasillo.setBackground(new java.awt.Color(3, 33, 67));
        cartelPasillo.setFont(new java.awt.Font("Segoe UI Symbol", 0, 16)); // NOI18N
        cartelPasillo.setForeground(new java.awt.Color(255, 255, 255));
        cartelPasillo.setText("pasillo");
        cartelPasillo.setBorder(null);
        cartelPasillo.setFocusable(false);
        bg.add(cartelPasillo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 50, -1));

        cartelFila.setEditable(false);
        cartelFila.setBackground(new java.awt.Color(3, 33, 67));
        cartelFila.setFont(new java.awt.Font("Segoe UI Symbol", 0, 16)); // NOI18N
        cartelFila.setForeground(new java.awt.Color(255, 255, 255));
        cartelFila.setText("fila");
        cartelFila.setBorder(null);
        cartelFila.setFocusable(false);
        bg.add(cartelFila, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 30, -1));

        cartelColumna.setEditable(false);
        cartelColumna.setBackground(new java.awt.Color(3, 33, 67));
        cartelColumna.setFont(new java.awt.Font("Segoe UI Symbol", 0, 16)); // NOI18N
        cartelColumna.setForeground(new java.awt.Color(255, 255, 255));
        cartelColumna.setText("columna");
        cartelColumna.setBorder(null);
        cartelColumna.setFocusable(false);
        bg.add(cartelColumna, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 70, -1));

        cartelEstante.setEditable(false);
        cartelEstante.setBackground(new java.awt.Color(3, 33, 67));
        cartelEstante.setFont(new java.awt.Font("Segoe UI Symbol", 0, 16)); // NOI18N
        cartelEstante.setForeground(new java.awt.Color(255, 255, 255));
        cartelEstante.setText("estante");
        cartelEstante.setBorder(null);
        cartelEstante.setFocusable(false);
        bg.add(cartelEstante, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 60, -1));

        nuevaObraBtn.setBackground(new java.awt.Color(96, 106, 135));
        nuevaObraBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nuevaObraBtn.setForeground(new java.awt.Color(255, 255, 255));
        nuevaObraBtn.setText("Nueva");
        nuevaObraBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nuevaObraBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaObraBtnActionPerformed(evt);
            }
        });
        bg.add(nuevaObraBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 80, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        this.setVisible(false);
        new AdminPanel(funcionarios,listadoEjemplares,listadoObras,ediciones).setVisible(true);
    }//GEN-LAST:event_volverBtnActionPerformed

    private void nuevaObraBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaObraBtnActionPerformed
      this.setVisible(false);
      new NuevaObra(funcionarios,listadoEjemplares,listadoObras,ediciones).setVisible(true);
    }//GEN-LAST:event_nuevaObraBtnActionPerformed

    private void guardarEjemplarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarEjemplarBtnActionPerformed
        if(checkNoNulls()){
            nuevoEjemplar();
            setAllToNull();
            JOptionPane.showMessageDialog(rootPane, "Ejemplar creado exitosamente!", "Confirmacion", 1);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Hay campos sin completar", "Error", 2);
        }
    }//GEN-LAST:event_guardarEjemplarBtnActionPerformed

    private void nuevoEjemplar(){
        int pasilloValue = (Integer) pasillo.getValue();
        int estanteValue = (Integer) estante.getValue();
        int filaValue = (Integer) fila.getValue();
        int columnaValue = (Integer) columna.getValue();
        int posicionValue = (Integer) posicion.getValue();
        
        Ejemplar ejemplar = null;
        ejemplar = new Ejemplar(
                observaciones.getText(),
                codigoBarra.getText(),
                LocalDate.now(),
                fAdquisicion.getText(),
                new Identificacion(
                        ejemplar,
                        pasilloValue,
                        estanteValue,
                        filaValue,
                        columnaValue,
                        posicionValue
                ),
                (Obra) menuObras.getItemAt(menuObras.getSelectedIndex())
        );
        listadoEjemplares.add(ejemplar);
    }
    
    private boolean checkNoNulls(){
        return !(
                codigoBarra.getText().isEmpty()
                || fAdquisicion.getText().isEmpty()
                || observaciones.getText().isEmpty()
        );
    }
    
    private void setAllToNull(){
        codigoBarra.setText(null);
        fAdquisicion.setText(null);
        observaciones.setText(null);
    }
    
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
            java.util.logging.Logger.getLogger(DarAltaPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DarAltaPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DarAltaPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DarAltaPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DarAltaPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JTextField cartelCodigo;
    private javax.swing.JTextField cartelColumna;
    private javax.swing.JTextField cartelEstante;
    private javax.swing.JTextField cartelFila;
    private javax.swing.JTextField cartelFormaAdq;
    private javax.swing.JTextField cartelObra;
    private javax.swing.JTextField cartelObsrv;
    private javax.swing.JTextField cartelPasillo;
    private javax.swing.JTextField cartelPosicion;
    private javax.swing.JTextField cartelUbicacion;
    private javax.swing.JTextField codigoBarra;
    private javax.swing.JSpinner columna;
    private javax.swing.JSpinner estante;
    private javax.swing.JTextField fAdquisicion;
    private javax.swing.JSpinner fila;
    private javax.swing.JButton guardarEjemplarBtn;
    private javax.swing.JComboBox<Obra> menuObras;
    private javax.swing.JButton nuevaObraBtn;
    private javax.swing.JTextField observaciones;
    private javax.swing.JSpinner pasillo;
    private javax.swing.JSpinner posicion;
    private javax.swing.JLabel tituloPanel;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables
    
    private void customComponents(){
        crearListaObras();
    }
    
    private void crearListaObras() {
            menuObras.addItem(null);
            for (Obra o : listadoObras) {
                    menuObras.addItem(o);
            }
    }
}
