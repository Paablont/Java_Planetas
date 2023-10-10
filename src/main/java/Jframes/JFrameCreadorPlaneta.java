package Jframes;

import com.planeta.*;
import com.planeta.TipoPlaneta;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSlider;

/**
 * JFRAME de creación de un objeto planeta
 *
 * @authorPablo Villseñor
 */
public class JFrameCreadorPlaneta extends javax.swing.JFrame {

    //Declaración de variables
    private String nombre;
    private TipoPlaneta tipoPlaneta;
    private double radio;
    
    private double distancia;
    private boolean tieneVida = false;

    public JFrameCreadorPlaneta() {
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

        btnGroupDistSol = new javax.swing.ButtonGroup();
        btnGroupVida = new javax.swing.ButtonGroup();
        txtNombre = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        btnGuardarPlaneta = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        txtDIstSolKM = new javax.swing.JLabel();
        rbRocoso = new javax.swing.JRadioButton();
        rbGaseoso = new javax.swing.JRadioButton();
        rbHelado = new javax.swing.JRadioButton();
        txtRadio = new javax.swing.JLabel();
        tfRadio = new javax.swing.JTextField();
        rbSiVida = new javax.swing.JRadioButton();
        rbNoVida = new javax.swing.JRadioButton();
        txtTipoPlaneta = new javax.swing.JLabel();
        txtMaxSlider = new javax.swing.JLabel();
        jsDistancia = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtNombre.setText("Nombre");

        tfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreActionPerformed(evt);
            }
        });

        btnGuardarPlaneta.setText("Guardar");
        btnGuardarPlaneta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPlanetaActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        txtDIstSolKM.setText("Distancia al sol (millones de km)");

        btnGroupDistSol.add(rbRocoso);
        rbRocoso.setText("Rocoso");
        rbRocoso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbRocosoActionPerformed(evt);
            }
        });

        btnGroupDistSol.add(rbGaseoso);
        rbGaseoso.setText("Gaseoso");
        rbGaseoso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbGaseosoActionPerformed(evt);
            }
        });

        btnGroupDistSol.add(rbHelado);
        rbHelado.setText("Helado");
        rbHelado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbHeladoActionPerformed(evt);
            }
        });

        txtRadio.setText("Radio (en km2)");

        tfRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRadioActionPerformed(evt);
            }
        });

        btnGroupVida.add(rbSiVida);
        rbSiVida.setText("Tiene vida");
        rbSiVida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSiVidaActionPerformed(evt);
            }
        });

        btnGroupVida.add(rbNoVida);
        rbNoVida.setText("No tiene vida");
        rbNoVida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNoVidaActionPerformed(evt);
            }
        });

        txtTipoPlaneta.setText("Tipo de planeta");

        txtMaxSlider.setToolTipText("");
        txtMaxSlider.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtMaxSlider.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jsDistancia.setMajorTickSpacing(1000);
        jsDistancia.setMaximum(10000);
        jsDistancia.setMinimum(1000);
        jsDistancia.setMinorTickSpacing(500);
        jsDistancia.setPaintLabels(true);
        jsDistancia.setPaintTicks(true);
        jsDistancia.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsDistanciaStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbSiVida, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(rbNoVida, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(txtRadio))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(btnGuardarPlaneta, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(tfRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(58, 58, 58)
                        .addComponent(btnSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(95, 95, 95)
                                        .addComponent(txtTipoPlaneta))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rbRocoso, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(rbGaseoso)
                                        .addGap(33, 33, 33)
                                        .addComponent(rbHelado, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(189, 189, 189)
                                .addComponent(txtNombre))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(txtDIstSolKM)
                                .addGap(46, 46, 46)
                                .addComponent(txtMaxSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jsDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTipoPlaneta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbGaseoso)
                    .addComponent(rbHelado)
                    .addComponent(rbRocoso))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDIstSolKM)
                    .addComponent(txtMaxSlider))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jsDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSalir)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfRadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbNoVida)
                            .addComponent(rbSiVida))
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardarPlaneta, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreActionPerformed

    }//GEN-LAST:event_tfNombreActionPerformed

    /**
     * El botón crea un objeto planeta con las caracteristicas y llama a los metodos de escritura 
     * 
     *
     * @author Pablo Villaseñor
     */
    private void btnGuardarPlanetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPlanetaActionPerformed

        nombre = tfNombre.getText();

        
        distancia = jsDistancia.getValue();
        
        if (rbRocoso.isSelected()) {
            tipoPlaneta = TipoPlaneta.ROCOSO;
        } else if (rbGaseoso.isSelected()) {
            tipoPlaneta = TipoPlaneta.GASEOSO;
        } else if (rbHelado.isSelected()) {
            tipoPlaneta = TipoPlaneta.HELADO;
        }

       

        try {
            radio = Double.parseDouble(tfRadio.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El valor del radio no puede ser menor que 0");
            
        }
        
        /*La lista de un principio será nula y luego en algún JFrame de "ver informacion del planeta X" se añaden botones que permitan
        agregar satelites*/
        ArrayList<Satelite> listaSatelites = null;

        if (nombre.isEmpty() || distancia<0 || (!rbRocoso.isSelected() && !rbGaseoso.isSelected() && !rbHelado.isSelected()) || tfRadio.getText().isEmpty() 
                || radio < 0 || (!rbSiVida.isSelected() && !rbNoVida.isSelected())) {
            JOptionPane.showMessageDialog(this, "Faltan datos por rellenar");

        } else {
            JOptionPane.showMessageDialog(this, "El planeta se ha creado correctamente");
            //Cuidado con el id jeje
            Planeta p = new Planeta(144,nombre, distancia, radio, tieneVida, tipoPlaneta, listaSatelites);
            //Llamar a los metodos respectivos de guardarTXT y guardarBinario
            PabloJoseTexto.escribirTexto(p);
        }


    }//GEN-LAST:event_btnGuardarPlanetaActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        //Funcion de JFrame
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void rbGaseosoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbGaseosoActionPerformed

    }//GEN-LAST:event_rbGaseosoActionPerformed

    private void tfRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRadioActionPerformed

    }//GEN-LAST:event_tfRadioActionPerformed

    private void rbRocosoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbRocosoActionPerformed


    }//GEN-LAST:event_rbRocosoActionPerformed

    private void rbHeladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbHeladoActionPerformed


    }//GEN-LAST:event_rbHeladoActionPerformed

    private void rbSiVidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSiVidaActionPerformed

    }//GEN-LAST:event_rbSiVidaActionPerformed

    private void rbNoVidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNoVidaActionPerformed

    }//GEN-LAST:event_rbNoVidaActionPerformed

    private void jsDistanciaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsDistanciaStateChanged
        txtMaxSlider.setText("" + jsDistancia.getValue());
    }//GEN-LAST:event_jsDistanciaStateChanged

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
            java.util.logging.Logger.getLogger(JFrameCreadorPlaneta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameCreadorPlaneta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameCreadorPlaneta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameCreadorPlaneta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameCreadorPlaneta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupDistSol;
    private javax.swing.ButtonGroup btnGroupVida;
    private javax.swing.JButton btnGuardarPlaneta;
    private javax.swing.JButton btnSalir;
    private javax.swing.JSlider jsDistancia;
    private javax.swing.JRadioButton rbGaseoso;
    private javax.swing.JRadioButton rbHelado;
    private javax.swing.JRadioButton rbNoVida;
    private javax.swing.JRadioButton rbRocoso;
    private javax.swing.JRadioButton rbSiVida;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfRadio;
    private javax.swing.JLabel txtDIstSolKM;
    private javax.swing.JLabel txtMaxSlider;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtRadio;
    private javax.swing.JLabel txtTipoPlaneta;
    // End of variables declaration//GEN-END:variables
}
