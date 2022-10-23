/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.GUI;

/**
 *
 * @author dalzo
 */
public class AdminPanel extends javax.swing.JFrame {

    /**
     * Creates new form AdminPanel
     */
    public AdminPanel() {
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
        logOutBoton = new javax.swing.JButton();
        darAltaBoton = new javax.swing.JButton();
        darBajaBoton = new javax.swing.JButton();
        registroBoton = new javax.swing.JButton();
        eliminarFBton = new javax.swing.JButton();
        irFuncionarioBoton = new javax.swing.JButton();
        tituloAdmin = new javax.swing.JLabel();
        adminLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AdminHome");
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

        logOutBoton.setBackground(new java.awt.Color(96, 106, 135));
        logOutBoton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        logOutBoton.setForeground(new java.awt.Color(255, 255, 255));
        logOutBoton.setText("Log Out");
        logOutBoton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logOutBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutBotonActionPerformed(evt);
            }
        });
        jPanel1.add(logOutBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 357, 100, -1));

        darAltaBoton.setBackground(new java.awt.Color(96, 106, 135));
        darAltaBoton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        darAltaBoton.setForeground(new java.awt.Color(255, 255, 255));
        darAltaBoton.setText("Dar de alta");
        darAltaBoton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        darAltaBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darAltaBotonActionPerformed(evt);
            }
        });
        jPanel1.add(darAltaBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 150, 40));

        darBajaBoton.setBackground(new java.awt.Color(96, 106, 135));
        darBajaBoton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        darBajaBoton.setForeground(new java.awt.Color(255, 255, 255));
        darBajaBoton.setText("Dar de baja");
        darBajaBoton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        darBajaBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darBajaBotonActionPerformed(evt);
            }
        });
        jPanel1.add(darBajaBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 150, 40));

        registroBoton.setBackground(new java.awt.Color(96, 106, 135));
        registroBoton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        registroBoton.setForeground(new java.awt.Color(255, 255, 255));
        registroBoton.setText("Registrar funcionario");
        registroBoton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registroBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroBotonActionPerformed(evt);
            }
        });
        jPanel1.add(registroBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 150, 40));

        eliminarFBton.setBackground(new java.awt.Color(96, 106, 135));
        eliminarFBton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        eliminarFBton.setForeground(new java.awt.Color(255, 255, 255));
        eliminarFBton.setText("Eliminar funcionario");
        eliminarFBton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eliminarFBton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarFBtonActionPerformed(evt);
            }
        });
        jPanel1.add(eliminarFBton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 150, 40));

        irFuncionarioBoton.setBackground(new java.awt.Color(96, 106, 135));
        irFuncionarioBoton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        irFuncionarioBoton.setForeground(new java.awt.Color(255, 255, 255));
        irFuncionarioBoton.setText("Panel funcionario");
        irFuncionarioBoton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(irFuncionarioBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 150, 40));

        tituloAdmin.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tituloAdmin.setForeground(new java.awt.Color(255, 255, 255));
        tituloAdmin.setText("PANEL DE ADMINISTRADOR");
        tituloAdmin.setFocusable(false);
        jPanel1.add(tituloAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        adminLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GUI/source/admin-icon-NotFilled.png"))); // NOI18N
        adminLogo.setFocusable(false);
        jPanel1.add(adminLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, -1, -1));

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

    private void registroBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroBotonActionPerformed
        this.setVisible(false);
        new NuevoFuncionario().setVisible(true);
    }//GEN-LAST:event_registroBotonActionPerformed

    private void eliminarFBtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarFBtonActionPerformed
        this.setVisible(false);
        new EliminarFuncionario().setVisible(true);
    }//GEN-LAST:event_eliminarFBtonActionPerformed

    private void logOutBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutBotonActionPerformed
        this.setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_logOutBotonActionPerformed

    private void darAltaBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_darAltaBotonActionPerformed
        this.setVisible(false);
        new DarAltaPanel().setVisible(true);
    }//GEN-LAST:event_darAltaBotonActionPerformed

    private void darBajaBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_darBajaBotonActionPerformed
        this.setVisible(false);
        new DarBajaPanel().setVisible(true);
    }//GEN-LAST:event_darBajaBotonActionPerformed

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
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminLogo;
    private javax.swing.JButton darAltaBoton;
    private javax.swing.JButton darBajaBoton;
    private javax.swing.JButton eliminarFBton;
    private javax.swing.JButton irFuncionarioBoton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logOutBoton;
    private javax.swing.JButton registroBoton;
    private javax.swing.JLabel tituloAdmin;
    private javax.swing.JLabel unerLogo;
    // End of variables declaration//GEN-END:variables
}
