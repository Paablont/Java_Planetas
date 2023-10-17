/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframes;

import com.planeta.CopiarMoverArchivos;
import com.planeta.Planeta;
import com.planeta.RamonMiguelBinario;
import com.planeta.RamonMiguelBorrar;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.System.Logger.Level;
import java.nio.charset.Charset;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author pablo
 */
public class JFrameMostrarPlanetas extends javax.swing.JFrame {
   
    public JTextArea getJTextArea(){
        return txaArchivo;
    }
    public JTextField getJTextField(){
          return tfID;
    }
    /**
     * Creates new form LeerTXT
     */
    public JFrameMostrarPlanetas() {
        initComponents();
        this.setTitle("LeerTXT");
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        btnMostrarInfo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaArchivo = new javax.swing.JTextArea();
        txtID = new javax.swing.JLabel();
        tfID = new javax.swing.JTextField();
        btnBorrarPlaneta = new javax.swing.JButton();
        btnCopiarTXT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnMostrarInfo.setText("Mostrar información  del planeta");
        btnMostrarInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarInfoActionPerformed(evt);
            }
        });

        txaArchivo.setColumns(20);
        txaArchivo.setRows(5);
        jScrollPane1.setViewportView(txaArchivo);

        txtID.setText("ID PLANETA:");

        tfID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIDActionPerformed(evt);
            }
        });

        btnBorrarPlaneta.setText("Borrar Planeta");
        btnBorrarPlaneta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarPlanetaActionPerformed(evt);
            }
        });

        btnCopiarTXT.setText("Copiar archivo planetas txt");
        btnCopiarTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopiarTXTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCopiarTXT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBorrarPlaneta)
                        .addGap(98, 98, 98))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtID)
                                .addGap(18, 18, 18)
                                .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnMostrarInfo))
                        .addGap(52, 52, 52))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtID)
                            .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(btnMostrarInfo)
                        .addGap(10, 10, 10)
                        .addComponent(btnBorrarPlaneta)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(btnCopiarTXT)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFrameMostrarPlanetas.this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnMostrarInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarInfoActionPerformed
        JFramePropiedadesPlaneta frame = new JFramePropiedadesPlaneta();

        Planeta planeta = null;
        int id = Integer.parseInt(getJTextField().getText());
        if (Planeta.existePlanetaConID(id)) {
            try {
                frame.setIdDelPlaneta(id);
                planeta = RamonMiguelBinario.leerPlanetaSolo(id);
                frame.getJLabel2().setText(planeta.getNombre());
                frame.getJLabelDistSol().setText(Double.toString(planeta.getDistanciaSolar()));
                frame.getJLabelRadio().setText(Double.toString(planeta.getRadio()));
                frame.getJLabelVida().setText(Boolean.toString(planeta.isVida()));
                frame.getJLabelTipo().setText(planeta.getTipoPlaneta().toString());
                frame.setVisible(true);
            } catch (IOException ex) {
                //Luego poner un logger
            }
        } else {
            JOptionPane.showMessageDialog(null, "Porvafor introduce un ID valido", "Mensaje ID", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnMostrarInfoActionPerformed

    private void tfIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIDActionPerformed

    private void btnBorrarPlanetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarPlanetaActionPerformed
        JFramePropiedadesPlaneta frame = new JFramePropiedadesPlaneta();
        
        Planeta planeta = null;
        int id = Integer.parseInt(getJTextField().getText());
        
        try {
            RamonMiguelBorrar.BorrarArchivoSecuencialPorId(id);
            RamonMiguelBorrar.BorrarArchivoBinarioPorId(id);
            RamonMiguelBorrar.BorrarArchivoDatSatelites(id);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JFrameMostrarPlanetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBorrarPlanetaActionPerformed

    private void btnCopiarTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopiarTXTActionPerformed
        CopiarMoverArchivos.copiarArchivo();
    }//GEN-LAST:event_btnCopiarTXTActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameMostrarPlanetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameMostrarPlanetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameMostrarPlanetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameMostrarPlanetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameMostrarPlanetas().setVisible(true);
                
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrarPlaneta;
    private javax.swing.JButton btnCopiarTXT;
    private javax.swing.JButton btnMostrarInfo;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tfID;
    private javax.swing.JTextArea txaArchivo;
    private javax.swing.JLabel txtID;
    // End of variables declaration//GEN-END:variables
}
