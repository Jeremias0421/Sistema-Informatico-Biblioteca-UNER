/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.GUI;

import com.biblioteca.TipoDni;

/**
 *
 * @author dalzo
 */
public class NuevoLector extends javax.swing.JFrame {

    /**
     * Creates new form NuevoLector
     */
    public NuevoLector() {
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
        correo = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        apellido = new javax.swing.JTextField();
        dni = new javax.swing.JTextField();
        sexo = new javax.swing.JComboBox<>();
        nacimiento = new javax.swing.JFormattedTextField();
        userTxt = new javax.swing.JTextField();
        userTxt1 = new javax.swing.JTextField();
        userTxt2 = new javax.swing.JTextField();
        userTxt3 = new javax.swing.JTextField();
        userTxt4 = new javax.swing.JTextField();
        userTxt5 = new javax.swing.JTextField();
        tipoDni = new javax.swing.JComboBox<>();
        celular = new javax.swing.JTextField();
        nacionalidad = new javax.swing.JTextField();
        domicilio = new javax.swing.JTextField();
        codgioPostal = new javax.swing.JSpinner();
        departamento = new javax.swing.JTextField();
        localidad = new javax.swing.JTextField();
        userTxt6 = new javax.swing.JTextField();
        userTxt7 = new javax.swing.JTextField();
        userTxt8 = new javax.swing.JTextField();
        userTxt9 = new javax.swing.JTextField();
        userTxt10 = new javax.swing.JTextField();
        userTxt11 = new javax.swing.JTextField();
        userTxt12 = new javax.swing.JTextField();
        crearFuncionarioBtn = new javax.swing.JButton();
        crearFuncionarioBtn1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        bg.setBackground(new java.awt.Color(3, 33, 67));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloPanel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tituloPanel.setForeground(new java.awt.Color(255, 255, 255));
        tituloPanel.setText("NUEVO LECTOR");
        tituloPanel.setFocusable(false);
        bg.add(tituloPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        correo.setBackground(new java.awt.Color(0, 8, 16));
        correo.setForeground(new java.awt.Color(255, 255, 255));
        correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correoActionPerformed(evt);
            }
        });
        bg.add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 170, -1));

        nombre.setBackground(new java.awt.Color(0, 8, 16));
        nombre.setForeground(new java.awt.Color(255, 255, 255));
        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        bg.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 170, -1));

        apellido.setBackground(new java.awt.Color(0, 8, 16));
        apellido.setForeground(new java.awt.Color(255, 255, 255));
        apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidoActionPerformed(evt);
            }
        });
        bg.add(apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 170, -1));

        dni.setBackground(new java.awt.Color(0, 8, 16));
        dni.setForeground(new java.awt.Color(255, 255, 255));
        dni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dniActionPerformed(evt);
            }
        });
        bg.add(dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 170, -1));

        sexo.setBackground(new java.awt.Color(0, 8, 16));
        sexo.setForeground(new java.awt.Color(255, 255, 255));
        sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino", "Otro" }));
        bg.add(sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 170, -1));

        nacimiento.setBackground(new java.awt.Color(0, 8, 16));
        nacimiento.setForeground(new java.awt.Color(255, 255, 255));
        nacimiento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        nacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nacimientoActionPerformed(evt);
            }
        });
        bg.add(nacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 170, -1));

        userTxt.setEditable(false);
        userTxt.setBackground(new java.awt.Color(3, 33, 67));
        userTxt.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        userTxt.setForeground(new java.awt.Color(255, 255, 255));
        userTxt.setText("Nombre");
        userTxt.setBorder(null);
        userTxt.setFocusable(false);
        bg.add(userTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 90, -1));

        userTxt1.setEditable(false);
        userTxt1.setBackground(new java.awt.Color(3, 33, 67));
        userTxt1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        userTxt1.setForeground(new java.awt.Color(255, 255, 255));
        userTxt1.setText("Apellido");
        userTxt1.setBorder(null);
        userTxt1.setFocusable(false);
        bg.add(userTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 70, -1));

        userTxt2.setEditable(false);
        userTxt2.setBackground(new java.awt.Color(3, 33, 67));
        userTxt2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        userTxt2.setForeground(new java.awt.Color(255, 255, 255));
        userTxt2.setText("Sexo");
        userTxt2.setBorder(null);
        userTxt2.setFocusable(false);
        bg.add(userTxt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 50, -1));

        userTxt3.setEditable(false);
        userTxt3.setBackground(new java.awt.Color(3, 33, 67));
        userTxt3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        userTxt3.setForeground(new java.awt.Color(255, 255, 255));
        userTxt3.setText("Nacimiento");
        userTxt3.setBorder(null);
        userTxt3.setFocusable(false);
        bg.add(userTxt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 90, -1));

        userTxt4.setEditable(false);
        userTxt4.setBackground(new java.awt.Color(3, 33, 67));
        userTxt4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        userTxt4.setForeground(new java.awt.Color(255, 255, 255));
        userTxt4.setText("DNI");
        userTxt4.setBorder(null);
        userTxt4.setFocusable(false);
        bg.add(userTxt4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 50, -1));

        userTxt5.setEditable(false);
        userTxt5.setBackground(new java.awt.Color(3, 33, 67));
        userTxt5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        userTxt5.setForeground(new java.awt.Color(255, 255, 255));
        userTxt5.setText("Tipo DNI");
        userTxt5.setBorder(null);
        userTxt5.setFocusable(false);
        bg.add(userTxt5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 70, -1));

        tipoDni.setBackground(new java.awt.Color(0, 8, 16));
        tipoDni.setForeground(new java.awt.Color(255, 255, 255));
        tipoDni.setModel(new javax.swing.DefaultComboBoxModel<>(TipoDni.values()));
        bg.add(tipoDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 170, -1));

        celular.setBackground(new java.awt.Color(0, 8, 16));
        celular.setForeground(new java.awt.Color(255, 255, 255));
        celular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                celularActionPerformed(evt);
            }
        });
        bg.add(celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 170, -1));

        nacionalidad.setBackground(new java.awt.Color(0, 8, 16));
        nacionalidad.setForeground(new java.awt.Color(255, 255, 255));
        nacionalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nacionalidadActionPerformed(evt);
            }
        });
        bg.add(nacionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, 170, -1));

        domicilio.setBackground(new java.awt.Color(0, 8, 16));
        domicilio.setForeground(new java.awt.Color(255, 255, 255));
        domicilio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                domicilioActionPerformed(evt);
            }
        });
        bg.add(domicilio, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, 170, -1));

        codgioPostal.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        bg.add(codgioPostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 240, 170, -1));

        departamento.setBackground(new java.awt.Color(0, 8, 16));
        departamento.setForeground(new java.awt.Color(255, 255, 255));
        departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departamentoActionPerformed(evt);
            }
        });
        bg.add(departamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, 170, -1));

        localidad.setBackground(new java.awt.Color(0, 8, 16));
        localidad.setForeground(new java.awt.Color(255, 255, 255));
        localidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                localidadActionPerformed(evt);
            }
        });
        bg.add(localidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 170, -1));

        userTxt6.setEditable(false);
        userTxt6.setBackground(new java.awt.Color(3, 33, 67));
        userTxt6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        userTxt6.setForeground(new java.awt.Color(255, 255, 255));
        userTxt6.setText("Correo");
        userTxt6.setBorder(null);
        userTxt6.setFocusable(false);
        bg.add(userTxt6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 60, -1));

        userTxt7.setEditable(false);
        userTxt7.setBackground(new java.awt.Color(3, 33, 67));
        userTxt7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        userTxt7.setForeground(new java.awt.Color(255, 255, 255));
        userTxt7.setText("Celular");
        userTxt7.setBorder(null);
        userTxt7.setFocusable(false);
        bg.add(userTxt7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 60, -1));

        userTxt8.setEditable(false);
        userTxt8.setBackground(new java.awt.Color(3, 33, 67));
        userTxt8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        userTxt8.setForeground(new java.awt.Color(255, 255, 255));
        userTxt8.setText("Nacionalidad");
        userTxt8.setBorder(null);
        userTxt8.setFocusable(false);
        bg.add(userTxt8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 100, -1));

        userTxt9.setEditable(false);
        userTxt9.setBackground(new java.awt.Color(3, 33, 67));
        userTxt9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        userTxt9.setForeground(new java.awt.Color(255, 255, 255));
        userTxt9.setText("Domicilio");
        userTxt9.setBorder(null);
        userTxt9.setFocusable(false);
        bg.add(userTxt9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 70, -1));

        userTxt10.setEditable(false);
        userTxt10.setBackground(new java.awt.Color(3, 33, 67));
        userTxt10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        userTxt10.setForeground(new java.awt.Color(255, 255, 255));
        userTxt10.setText("Nro Postal");
        userTxt10.setBorder(null);
        userTxt10.setFocusable(false);
        bg.add(userTxt10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 80, -1));

        userTxt11.setEditable(false);
        userTxt11.setBackground(new java.awt.Color(3, 33, 67));
        userTxt11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        userTxt11.setForeground(new java.awt.Color(255, 255, 255));
        userTxt11.setText("Departamento");
        userTxt11.setBorder(null);
        userTxt11.setFocusable(false);
        bg.add(userTxt11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, 110, -1));

        userTxt12.setEditable(false);
        userTxt12.setBackground(new java.awt.Color(3, 33, 67));
        userTxt12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        userTxt12.setForeground(new java.awt.Color(255, 255, 255));
        userTxt12.setText("Localidad");
        userTxt12.setBorder(null);
        userTxt12.setFocusable(false);
        bg.add(userTxt12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, 80, -1));

        crearFuncionarioBtn.setBackground(new java.awt.Color(96, 106, 135));
        crearFuncionarioBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        crearFuncionarioBtn.setForeground(new java.awt.Color(255, 255, 255));
        crearFuncionarioBtn.setText("Guardar Lector");
        crearFuncionarioBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        crearFuncionarioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearFuncionarioBtnActionPerformed(evt);
            }
        });
        bg.add(crearFuncionarioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, 130, 30));

        crearFuncionarioBtn1.setBackground(new java.awt.Color(96, 106, 135));
        crearFuncionarioBtn1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        crearFuncionarioBtn1.setForeground(new java.awt.Color(255, 255, 255));
        crearFuncionarioBtn1.setText("Volver");
        crearFuncionarioBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        crearFuncionarioBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearFuncionarioBtn1ActionPerformed(evt);
            }
        });
        bg.add(crearFuncionarioBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 130, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        
    }//GEN-LAST:event_nombreActionPerformed

    private void apellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidoActionPerformed
        
    }//GEN-LAST:event_apellidoActionPerformed

    private void dniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniActionPerformed
        
    }//GEN-LAST:event_dniActionPerformed

    private void nacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nacimientoActionPerformed
        
    }//GEN-LAST:event_nacimientoActionPerformed

    private void correoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_correoActionPerformed

    private void celularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_celularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_celularActionPerformed

    private void nacionalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nacionalidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nacionalidadActionPerformed

    private void domicilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_domicilioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_domicilioActionPerformed

    private void departamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_departamentoActionPerformed

    private void localidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_localidadActionPerformed

    private void crearFuncionarioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearFuncionarioBtnActionPerformed
        
    }//GEN-LAST:event_crearFuncionarioBtnActionPerformed

    private void crearFuncionarioBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearFuncionarioBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_crearFuncionarioBtn1ActionPerformed

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
            java.util.logging.Logger.getLogger(NuevoLector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoLector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoLector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoLector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevoLector().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellido;
    private javax.swing.JPanel bg;
    private javax.swing.JTextField celular;
    private javax.swing.JSpinner codgioPostal;
    private javax.swing.JTextField correo;
    private javax.swing.JButton crearFuncionarioBtn;
    private javax.swing.JButton crearFuncionarioBtn1;
    private javax.swing.JTextField departamento;
    private javax.swing.JTextField dni;
    private javax.swing.JTextField domicilio;
    private javax.swing.JTextField localidad;
    private javax.swing.JFormattedTextField nacimiento;
    private javax.swing.JTextField nacionalidad;
    private javax.swing.JTextField nombre;
    private javax.swing.JComboBox<String> sexo;
    private javax.swing.JComboBox<TipoDni> tipoDni;
    private javax.swing.JLabel tituloPanel;
    private javax.swing.JTextField userTxt;
    private javax.swing.JTextField userTxt1;
    private javax.swing.JTextField userTxt10;
    private javax.swing.JTextField userTxt11;
    private javax.swing.JTextField userTxt12;
    private javax.swing.JTextField userTxt2;
    private javax.swing.JTextField userTxt3;
    private javax.swing.JTextField userTxt4;
    private javax.swing.JTextField userTxt5;
    private javax.swing.JTextField userTxt6;
    private javax.swing.JTextField userTxt7;
    private javax.swing.JTextField userTxt8;
    private javax.swing.JTextField userTxt9;
    // End of variables declaration//GEN-END:variables
}
