/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframes;

import com.planeta.Satelite;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alumno
 */
public class JFrameCreadorSatelite extends javax.swing.JFrame {
    private String nombre;
    private double densidad;
    private String fecha;
    /**
     * Creates new form JFrameCreadorSatelite
     */
    public JFrameCreadorSatelite() {
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

        txtsatelite = new javax.swing.JLabel();
        txtnombresatelite = new javax.swing.JLabel();
        cajatextonombresatelite = new javax.swing.JTextField();
        txtdensidad = new javax.swing.JLabel();
        jTextFieldDensidad = new javax.swing.JTextField();
        textAnioDesSatelite = new javax.swing.JLabel();
        TextFieldAnioSatelite = new javax.swing.JTextField();
        btnCrearSatelite = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtsatelite.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtsatelite.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtsatelite.setLabelFor(this);
        txtsatelite.setText("SATELITE");

        txtnombresatelite.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtnombresatelite.setText("Nombre          ");

        txtdensidad.setText("Densidad      g/cm3");

        textAnioDesSatelite.setText("Año de descubrimiento");

        btnCrearSatelite.setText("Crear!");
        btnCrearSatelite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearSateliteActionPerformed(evt);
            }
        });

        jLabel1.setText("(DD/MM/YYYY)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(btnCrearSatelite, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtsatelite, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(txtnombresatelite, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textAnioDesSatelite, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TextFieldAnioSatelite, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 161, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cajatextonombresatelite, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldDensidad, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdensidad, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(128, 128, 128))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtsatelite)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(txtnombresatelite)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cajatextonombresatelite, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtdensidad, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldDensidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textAnioDesSatelite, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextFieldAnioSatelite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCrearSatelite)
                .addGap(52, 52, 52))
        );

        txtnombresatelite.getAccessibleContext().setAccessibleName("");
        cajatextonombresatelite.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearSateliteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearSateliteActionPerformed
        // TODO add your handling code here:
        String densidadAux;
        String fechaAux;
        nombre=cajatextonombresatelite.getText();
        densidadAux=jTextFieldDensidad.getText();
        if (esNumeroJose(densidadAux)) {
            densidad=Double.parseDouble(densidadAux);
        }else{
            JOptionPane.showMessageDialog(null, "El número no es válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
        fechaAux=TextFieldAnioSatelite.getText();
        if (validarFechaJose(fechaAux)) {
            fecha=fechaAux;
            Satelite s=new Satelite(nombre,densidad,fecha);
            System.out.println(s.toString());
        }else{
            JOptionPane.showMessageDialog(null, "La fecha no es valida", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
      
    }//GEN-LAST:event_btnCrearSateliteActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameCreadorSatelite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameCreadorSatelite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameCreadorSatelite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameCreadorSatelite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameCreadorSatelite().setVisible(true);
            }
        });
    }
     public static boolean validarFechaJose(String fecha) {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            LocalDate.parse(fecha, formatoFecha);
            return true; // La fecha es válida
        } catch (DateTimeParseException e) {
            return false; // La fecha no es válida
        }
    }
     public static boolean esNumeroJose(String input) {
        try {
            // Intenta convertir la cadena en un número double
            Double.parseDouble(input);
            return true; // La conversión tiene éxito, es un número válido
        } catch (NumberFormatException e) {
            return false; // La conversión lanza una excepción, no es un número válido
        }
    }
    
    
    
    
    
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextFieldAnioSatelite;
    private javax.swing.JButton btnCrearSatelite;
    private javax.swing.JTextField cajatextonombresatelite;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextFieldDensidad;
    private javax.swing.JLabel textAnioDesSatelite;
    private javax.swing.JLabel txtdensidad;
    private javax.swing.JLabel txtnombresatelite;
    private javax.swing.JLabel txtsatelite;
    // End of variables declaration//GEN-END:variables
}