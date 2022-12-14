/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.GUI;

import com.biblioteca.Biblioteca;
import com.biblioteca.Edicion;
import com.biblioteca.Ejemplar;
import com.biblioteca.Funcionario;
import com.biblioteca.Lector;
import com.biblioteca.Lectura;
import com.biblioteca.Obra;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dalzo
 */
public class TomarPrestamoPanel extends javax.swing.JFrame {

    ArrayList<Funcionario> funcionarios = null;
    ArrayList<Ejemplar> ejemplaresDisponibles = null;
    ArrayList<Obra> obras = null;
    ArrayList<Edicion> ediciones = null;
    ArrayList<Ejemplar> ejemplaresDeBaja = null;
    ArrayList<Lector> lectores = null;
    ArrayList<Ejemplar> ejemplaresPrestados = null;
    ArrayList<Ejemplar> ejemplaresReservados = null;
    Funcionario sesionActual = Biblioteca.getSesionActual();
    
    //Listas locales
    ArrayList<Ejemplar> ejemplaresPorPrestar = null;

    
    /**
     * Creates new form TomarPrestamoPanel
     */
    public TomarPrestamoPanel() {
        funcionarios = Biblioteca.cargarFuncionarios();
        ediciones = Biblioteca.cargarEdiciones();
        obras = Biblioteca.cargarObras(ediciones);
        ejemplaresDisponibles = Biblioteca.cargarEjemplaresDisponibles(obras);
        ejemplaresDeBaja = Biblioteca.cargarEjemplaresDeBaja(obras);
        lectores = Biblioteca.cargarLectores();
        ejemplaresPrestados = new ArrayList(); //Problema de lectura del csv
        ejemplaresReservados = new ArrayList(); //Problema de lectura del csv
        //Final
        initComponents();
        mostrarEjemplares();
    }
    
    public TomarPrestamoPanel(ArrayList<Funcionario> funcionariosList, ArrayList<Ejemplar> disponiblesList, ArrayList<Obra> obrasList, ArrayList<Edicion> edicionesList,ArrayList<Ejemplar> deBajaList, Funcionario funcionario){
        funcionarios = funcionariosList;
        ejemplaresDisponibles = disponiblesList;
        obras = obrasList;
        ediciones = edicionesList;
        ejemplaresDeBaja = deBajaList;
        sesionActual = funcionario;
        initComponents();
        mostrarEjemplares();
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
        plazo = new javax.swing.JSpinner();
        cartelCodigo = new javax.swing.JTextField();
        dni = new javax.swing.JTextField();
        volverBtn = new javax.swing.JButton();
        prestarBtn = new javax.swing.JButton();
        cartelPlazo = new javax.swing.JTextField();
        cartelLectura = new javax.swing.JTextField();
        tipoLectura = new javax.swing.JComboBox<>();
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
        bg.add(tituloPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        plazo.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));
        bg.add(plazo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 60, -1));

        cartelCodigo.setEditable(false);
        cartelCodigo.setBackground(new java.awt.Color(3, 33, 67));
        cartelCodigo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        cartelCodigo.setForeground(new java.awt.Color(255, 255, 255));
        cartelCodigo.setText("Lector DNI");
        cartelCodigo.setBorder(null);
        cartelCodigo.setFocusable(false);
        bg.add(cartelCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 80, 20));

        dni.setBackground(new java.awt.Color(0, 8, 16));
        dni.setForeground(new java.awt.Color(255, 255, 255));
        bg.add(dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 250, -1));

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
        bg.add(volverBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 130, 30));

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
        bg.add(prestarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 500, 130, 30));

        cartelPlazo.setEditable(false);
        cartelPlazo.setBackground(new java.awt.Color(3, 33, 67));
        cartelPlazo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        cartelPlazo.setForeground(new java.awt.Color(255, 255, 255));
        cartelPlazo.setText("Plazo");
        cartelPlazo.setBorder(null);
        cartelPlazo.setFocusable(false);
        bg.add(cartelPlazo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 90, -1));

        cartelLectura.setEditable(false);
        cartelLectura.setBackground(new java.awt.Color(3, 33, 67));
        cartelLectura.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        cartelLectura.setForeground(new java.awt.Color(255, 255, 255));
        cartelLectura.setText("Lectura en");
        cartelLectura.setBorder(null);
        cartelLectura.setFocusable(false);
        bg.add(cartelLectura, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 90, -1));

        tipoLectura.setBackground(new java.awt.Color(0, 8, 16));
        tipoLectura.setForeground(new java.awt.Color(255, 255, 255));
        tipoLectura.setModel(new javax.swing.DefaultComboBoxModel<>(Lectura.values()));
        bg.add(tipoLectura, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 250, -1));

        jTable1.setBackground(new java.awt.Color(0, 8, 16));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Titulo", " Identificacion", "Codigo", "Prestar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 740, 300));

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
        ejemplaresPorPrestar = generarListaEjemplares();
        if(lector != null){
            //Realiza el prestamo
            if(!ejemplaresPorPrestar.isEmpty()){
                realizarPrestamo(lector);
                mostrarEjemplares();
            }else{
                JOptionPane.showConfirmDialog(rootPane, "No hay ejemplares seleccionados", "Error", 2);
            }
        }else{
            this.setVisible(false);
            new NuevoLector(this.getName()).setVisible(true);
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
        if(tipoLectura.getSelectedItem().equals(Lectura.DOMICILIO)){
            try{
                int plazoValue = (Integer) plazo.getValue();
                Biblioteca.darPrestamoDomicilio(lector, ejemplaresPorPrestar, sesionActual, plazoValue, ejemplaresPrestados, ejemplaresDisponibles, ejemplaresReservados);
                //TODO: guardar cambios
            }catch(IllegalArgumentException e){
                JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Error", 2);
            }
        }else if((tipoLectura.getSelectedItem().equals(Lectura.SALA))){
            try{
                Biblioteca.darPrestamoSala(lector, ejemplaresPorPrestar, sesionActual, ejemplaresPrestados, ejemplaresDisponibles, ejemplaresReservados);
                //TODO: guardar cambios
                //No implementar hasta corregir problema con csv
                //Biblioteca.guardarEjemplaresDisponibles(ejemplaresDeBaja);
                Biblioteca.guardarEjemplaresReservados(ejemplaresReservados);
                Biblioteca.guardarEjemplaresPrestados(ejemplaresPrestados);
            }catch(IllegalArgumentException e){
                JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Error", 2);
            }
        }
    }
    
    private ArrayList<Ejemplar> generarListaEjemplares(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        ArrayList<Ejemplar> retorno = new ArrayList();
        
        for (int i = 0; i < model.getRowCount(); i++) {
            boolean check = (boolean) model.getValueAt(i, 3);
            if(check){
                retorno.add(ejemplaresDisponibles.get(i));
            }
        }
        return retorno;
    }
    
    private void mostrarEjemplares(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        for (Ejemplar ejemplar : ejemplaresDisponibles) {
            Object[] row = new Object[4];
            row[0] = ejemplar.getObra().getTitulo();
            row[1] = ejemplar.getSeUbica();
            row[2] = ejemplar.getCodigoDeBarra();
            row[3] = false;
            model.addRow(row);
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
    private javax.swing.JTextField cartelLectura;
    private javax.swing.JTextField cartelPlazo;
    private javax.swing.JTextField dni;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JSpinner plazo;
    private javax.swing.JButton prestarBtn;
    private javax.swing.JComboBox<Lectura> tipoLectura;
    private javax.swing.JLabel tituloPanel;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables
}
