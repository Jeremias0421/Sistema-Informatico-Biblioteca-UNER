/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.GUI;

import com.biblioteca.Biblioteca;
import com.biblioteca.Edicion;
import com.biblioteca.Ejemplar;
import com.biblioteca.Funcionario;
import com.biblioteca.Obra;
import com.biblioteca.TipoFuncionario;
import java.util.ArrayList;

/**
 *
 * @author dalzo
 */
public class FuncionarioPanel extends javax.swing.JFrame {

    ArrayList<Funcionario> funcionarios = null;
    ArrayList<Ejemplar> ejemplaresDisponibles = null;
    ArrayList<Obra> obras = null;
    ArrayList<Edicion> ediciones = null;
    ArrayList<Ejemplar> ejemplaresDeBaja = null;
    Funcionario sesionActual = null;

    
    /**
     * Creates new form FuncionarioPanel
     */
    public FuncionarioPanel() {
        funcionarios = Biblioteca.cargarFuncionarios();
        ediciones = Biblioteca.cargarEdiciones();
        obras = Biblioteca.cargarObras(ediciones);
        ejemplaresDisponibles = Biblioteca.cargarEjemplaresDisponibles(obras);
        ejemplaresDeBaja = Biblioteca.cargarEjemplaresDeBaja(obras);
        sesionActual = Biblioteca.getSesionActual();
        initComponents();
    }
    
    public FuncionarioPanel(ArrayList<Funcionario> funcionariosList, ArrayList<Ejemplar> disponiblesList, ArrayList<Obra> obrasList, ArrayList<Edicion> edicionesList,ArrayList<Ejemplar> deBajaList, Funcionario funcionario){
        funcionarios = funcionariosList;
        ejemplaresDisponibles = disponiblesList;
        obras = obrasList;
        ediciones = edicionesList;
        ejemplaresDeBaja = deBajaList;
        sesionActual = funcionario;
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

        jPanel1 = new javax.swing.JPanel();
        unerLogo = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        tomarPrestamoButon = new javax.swing.JButton();
        RecibirPrestamoBoton = new javax.swing.JButton();
        listPrestamosBoton = new javax.swing.JButton();
        listEjemplaresBoton = new javax.swing.JButton();
        reservarBoton = new javax.swing.JButton();
        tituloPanel = new javax.swing.JLabel();
        logoFuncionario = new javax.swing.JLabel();
        listMultadosBoton = new javax.swing.JButton();
        volverBtn1 = new javax.swing.JButton();
        listObrasBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FuncionarioHome");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(3, 33, 67));
        jPanel1.setMinimumSize(new java.awt.Dimension(500, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        unerLogo.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        unerLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GUI/source/unerLoginLogo.png"))); // NOI18N
        unerLogo.setFocusable(false);
        unerLogo.setPreferredSize(new java.awt.Dimension(391, 101));
        jPanel1.add(unerLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 250, 60));

        logoutButton.setBackground(new java.awt.Color(96, 106, 135));
        logoutButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("Log Out");
        logoutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        jPanel1.add(logoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, 100, -1));

        tomarPrestamoButon.setBackground(new java.awt.Color(96, 106, 135));
        tomarPrestamoButon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tomarPrestamoButon.setForeground(new java.awt.Color(255, 255, 255));
        tomarPrestamoButon.setText("Tomar prestamo");
        tomarPrestamoButon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tomarPrestamoButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tomarPrestamoButonActionPerformed(evt);
            }
        });
        jPanel1.add(tomarPrestamoButon, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 150, 40));

        RecibirPrestamoBoton.setBackground(new java.awt.Color(96, 106, 135));
        RecibirPrestamoBoton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RecibirPrestamoBoton.setForeground(new java.awt.Color(255, 255, 255));
        RecibirPrestamoBoton.setText("Recibir prestamo");
        RecibirPrestamoBoton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(RecibirPrestamoBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 150, 40));

        listPrestamosBoton.setBackground(new java.awt.Color(96, 106, 135));
        listPrestamosBoton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        listPrestamosBoton.setForeground(new java.awt.Color(255, 255, 255));
        listPrestamosBoton.setText("Lisatado prestamos");
        listPrestamosBoton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listPrestamosBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listPrestamosBotonActionPerformed(evt);
            }
        });
        jPanel1.add(listPrestamosBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 150, 40));

        listEjemplaresBoton.setBackground(new java.awt.Color(96, 106, 135));
        listEjemplaresBoton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        listEjemplaresBoton.setForeground(new java.awt.Color(255, 255, 255));
        listEjemplaresBoton.setText("Listado ejemplares");
        listEjemplaresBoton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listEjemplaresBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listEjemplaresBotonActionPerformed(evt);
            }
        });
        jPanel1.add(listEjemplaresBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 150, 40));

        reservarBoton.setBackground(new java.awt.Color(96, 106, 135));
        reservarBoton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        reservarBoton.setForeground(new java.awt.Color(255, 255, 255));
        reservarBoton.setText("Reservar ejemplar");
        reservarBoton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(reservarBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 150, 40));

        tituloPanel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tituloPanel.setForeground(new java.awt.Color(255, 255, 255));
        tituloPanel.setText("PANEL DE FUNCIONARIO");
        tituloPanel.setFocusable(false);
        jPanel1.add(tituloPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        logoFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GUI/source/funcionario-logo.png"))); // NOI18N
        logoFuncionario.setFocusable(false);
        jPanel1.add(logoFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, -1, -1));

        listMultadosBoton.setBackground(new java.awt.Color(96, 106, 135));
        listMultadosBoton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        listMultadosBoton.setForeground(new java.awt.Color(255, 255, 255));
        listMultadosBoton.setText("Lectores multados");
        listMultadosBoton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listMultadosBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listMultadosBotonActionPerformed(evt);
            }
        });
        jPanel1.add(listMultadosBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 150, 40));

        volverBtn1.setBackground(new java.awt.Color(96, 106, 135));
        volverBtn1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        volverBtn1.setForeground(new java.awt.Color(255, 255, 255));
        volverBtn1.setText("Volver");
        volverBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        volverBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(volverBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 100, -1));

        listObrasBtn.setBackground(new java.awt.Color(96, 106, 135));
        listObrasBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        listObrasBtn.setForeground(new java.awt.Color(255, 255, 255));
        listObrasBtn.setText("Listado Obras");
        listObrasBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listObrasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listObrasBtnActionPerformed(evt);
            }
        });
        jPanel1.add(listObrasBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 150, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listPrestamosBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listPrestamosBotonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listPrestamosBotonActionPerformed

    private void listEjemplaresBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listEjemplaresBotonActionPerformed
        this.setVisible(false);
        new ListadoEjemplares().setVisible(true);
    }//GEN-LAST:event_listEjemplaresBotonActionPerformed

    private void tomarPrestamoButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tomarPrestamoButonActionPerformed
        this.setVisible(false);
        new TomarPrestamoPanel().setVisible(true);
    }//GEN-LAST:event_tomarPrestamoButonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        this.setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void volverBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtn1ActionPerformed
        if(sesionActual.getTipoFuncionario().equals(TipoFuncionario.ADMIN)){
            this.setVisible(false);
            new AdminPanel().setVisible(true);
        }
    }//GEN-LAST:event_volverBtn1ActionPerformed

    private void listObrasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listObrasBtnActionPerformed
        this.setVisible(false);
        new ListadoObras().setVisible(true);
    }//GEN-LAST:event_listObrasBtnActionPerformed

    private void listMultadosBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listMultadosBotonActionPerformed
        this.setVisible(false);
        new LectoresMultados().setVisible(true);
    }//GEN-LAST:event_listMultadosBotonActionPerformed

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
            java.util.logging.Logger.getLogger(FuncionarioPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FuncionarioPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FuncionarioPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FuncionarioPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FuncionarioPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RecibirPrestamoBoton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton listEjemplaresBoton;
    private javax.swing.JButton listMultadosBoton;
    private javax.swing.JButton listObrasBtn;
    private javax.swing.JButton listPrestamosBoton;
    private javax.swing.JLabel logoFuncionario;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton reservarBoton;
    private javax.swing.JLabel tituloPanel;
    private javax.swing.JButton tomarPrestamoButon;
    private javax.swing.JLabel unerLogo;
    private javax.swing.JButton volverBtn1;
    // End of variables declaration//GEN-END:variables
}
