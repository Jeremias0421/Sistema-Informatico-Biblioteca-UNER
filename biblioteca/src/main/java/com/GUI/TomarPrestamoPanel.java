/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.GUI;

import com.biblioteca.Biblioteca;
import com.biblioteca.Ejemplar;
import com.biblioteca.Lector;
import com.biblioteca.Lectura;
import java.util.ArrayList;

/**
 *
 * @author dalzo
 */
public class TomarPrestamoPanel extends javax.swing.JFrame {

    ArrayList<Lector> lectores = null;
    ArrayList<Ejemplar> ejemplares = null;
    
    /**
     * Creates new form TomarPrestamoPanel
     */
    public TomarPrestamoPanel() {
        //Test
        lectores = new ArrayList();
        ejemplares = new ArrayList();
        //Final
        initComponents();
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
        id = new javax.swing.JTextField();
        cartelID = new javax.swing.JTextField();
        cartelCodigo = new javax.swing.JTextField();
        dni = new javax.swing.JTextField();
        volverBtn = new javax.swing.JButton();
        prestarBtn = new javax.swing.JButton();
        cartelID1 = new javax.swing.JTextField();
        tipoPrestamo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tomar presatamo");
        setResizable(false);

        bg.setBackground(new java.awt.Color(3, 33, 67));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloPanel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tituloPanel.setForeground(new java.awt.Color(255, 255, 255));
        tituloPanel.setText("TOMA DE PRESTAMO");
        tituloPanel.setFocusable(false);
        bg.add(tituloPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, -1, -1));

        id.setBackground(new java.awt.Color(0, 8, 16));
        id.setForeground(new java.awt.Color(255, 255, 255));
        bg.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 250, -1));

        cartelID.setEditable(false);
        cartelID.setBackground(new java.awt.Color(3, 33, 67));
        cartelID.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        cartelID.setForeground(new java.awt.Color(255, 255, 255));
        cartelID.setText("Ejemplar ID");
        cartelID.setBorder(null);
        cartelID.setFocusable(false);
        bg.add(cartelID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 90, -1));

        cartelCodigo.setEditable(false);
        cartelCodigo.setBackground(new java.awt.Color(3, 33, 67));
        cartelCodigo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        cartelCodigo.setForeground(new java.awt.Color(255, 255, 255));
        cartelCodigo.setText("Lector DNI");
        cartelCodigo.setBorder(null);
        cartelCodigo.setFocusable(false);
        bg.add(cartelCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 90, -1));

        dni.setBackground(new java.awt.Color(0, 8, 16));
        dni.setForeground(new java.awt.Color(255, 255, 255));
        bg.add(dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 250, -1));

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
        bg.add(volverBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 130, 30));

        prestarBtn.setBackground(new java.awt.Color(96, 106, 135));
        prestarBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        prestarBtn.setForeground(new java.awt.Color(255, 255, 255));
        prestarBtn.setText("Prestar");
        prestarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        prestarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prestarBtnActionPerformed(evt);
            }
        });
        bg.add(prestarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 130, 30));

        cartelID1.setEditable(false);
        cartelID1.setBackground(new java.awt.Color(3, 33, 67));
        cartelID1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        cartelID1.setForeground(new java.awt.Color(255, 255, 255));
        cartelID1.setText("Tipo");
        cartelID1.setBorder(null);
        cartelID1.setFocusable(false);
        bg.add(cartelID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 90, -1));

        tipoPrestamo.setBackground(new java.awt.Color(0, 8, 16));
        tipoPrestamo.setForeground(new java.awt.Color(255, 255, 255));
        tipoPrestamo.setModel(new javax.swing.DefaultComboBoxModel<>(Lectura.values()));
        bg.add(tipoPrestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 250, -1));

        jTable1.setBackground(new java.awt.Color(0, 8, 16));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Usuario", "Nombre", "DNI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setFillsViewportHeight(true);
        jTable1.setGridColor(new java.awt.Color(0, 204, 204));
        jTable1.setSelectionBackground(new java.awt.Color(65, 75, 95));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setResizingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 360, 230));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        this.setVisible(false);
        new FuncionarioPanel().setVisible(true);
    }//GEN-LAST:event_volverBtnActionPerformed

    private void prestarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prestarBtnActionPerformed
        Lector lector = getLector();
        if(lector != null){
            //Realiza el prestamo
            realizarPrestamo(lector);
        }else{
            //Crea un nuevo Lector
        }
    }//GEN-LAST:event_prestarBtnActionPerformed

    private Lector getLector(){
        for (Lector lector : lectores) {
            if(lector.getDni().equals(dni.getText())){
                return lector;
            }
        }
        return null;
    }
    
    private void realizarPrestamo(Lector lector){
        if(tipoPrestamo.getSelectedItem().equals(Lectura.DOMICILIO)){
            
        }else if((tipoPrestamo.getSelectedItem().equals(Lectura.DOMICILIO))){
            
        }
        
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
            java.util.logging.Logger.getLogger(TomarPrestamoPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TomarPrestamoPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TomarPrestamoPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TomarPrestamoPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TomarPrestamoPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JTextField cartelCodigo;
    private javax.swing.JTextField cartelID;
    private javax.swing.JTextField cartelID1;
    private javax.swing.JTextField dni;
    private javax.swing.JTextField id;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton prestarBtn;
    private javax.swing.JComboBox<Lectura> tipoPrestamo;
    private javax.swing.JLabel tituloPanel;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables
}