/*

 *  Derechos de autor: UV-software(c)
 *  @auto: Juan Carlos Domínguez Dominguez
 *  @nombre: Control de academias
 *  @versión 0.2.6
 *  Este producto no puede ser intercambiado bajo ninguna circunstancia
	
 */

package GUI;

import clases.Bibliografia;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juuan
 */
public class AgregarBibliografia extends javax.swing.JFrame {

    /**
     * Creates new form AgregarBibliografia
     */
    public AgregarBibliografia() {
        initComponents();
    }
    
    public boolean validarCampos(){
        if (autorIn.getText() == "" || tituloLibroIn.getText() == "" || editorialIn.getText() == "" || anioIn.getText() == ""){
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        bibliografiaText = new javax.swing.JLabel();
        autorText = new javax.swing.JLabel();
        tituloLibroText = new javax.swing.JLabel();
        editorialText = new javax.swing.JLabel();
        anioText = new javax.swing.JLabel();
        autorIn = new javax.swing.JTextField();
        tituloLibroIn = new javax.swing.JTextField();
        editorialIn = new javax.swing.JTextField();
        anioIn = new javax.swing.JTextField();
        aceptarButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bibliografiaText.setText("Bibliografia: ");

        autorText.setText("Autor(es): ");

        tituloLibroText.setText("Titulo de libro: ");

        editorialText.setText("Editorial: ");

        anioText.setText("Año: ");

        autorIn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                autorInKeyTyped(evt);
            }
        });

        tituloLibroIn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tituloLibroInKeyTyped(evt);
            }
        });

        editorialIn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                editorialInKeyTyped(evt);
            }
        });

        anioIn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                anioInKeyTyped(evt);
            }
        });

        aceptarButton.setText("Aceptar");
        aceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarButtonActionPerformed(evt);
            }
        });

        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(autorText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(autorIn))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(tituloLibroText)
                                .addGap(4, 4, 4)
                                .addComponent(tituloLibroIn))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(editorialText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editorialIn))))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(230, 230, 230)
                                .addComponent(bibliografiaText))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(aceptarButton)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(anioText)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(anioIn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(81, 81, 81)))
                                .addGap(103, 103, 103)
                                .addComponent(cancelarButton)))
                        .addGap(0, 142, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bibliografiaText)
                .addGap(31, 31, 31)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(autorText)
                            .addComponent(autorIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tituloLibroText)
                            .addComponent(tituloLibroIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(editorialText))
                    .addComponent(editorialIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anioText)
                    .addComponent(anioIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptarButton)
                    .addComponent(cancelarButton))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        if(!validarCampos()){
            JOptionPane.showMessageDialog(this, "Se deben llenar todos los campos");
        }else{
            Bibliografia bibliografia = new Bibliografia();
            bibliografia.setAutor(autorIn.getText());
            bibliografia.setTituloLibro(tituloLibroIn.getText());
            bibliografia.setEditorial(editorialIn.getText());
            bibliografia.setAnio(Integer.parseInt(anioIn.getText()));
            ElaborarPlanDeCurso.bibliografias.add(bibliografia);
            ElaborarPlanDeCurso.modelo = (DefaultTableModel) ElaborarPlanDeCurso.bibliografiaTable.getModel();
            Object nuevo[]= {""};
            ElaborarPlanDeCurso.modelo.addRow(nuevo);
            ElaborarPlanDeCurso.cargarTablaBibliografias();
            ElaborarPlanDeCurso.getEliminarBibliografiaButton().setEnabled(true);
            dispose();
        }
    }//GEN-LAST:event_aceptarButtonActionPerformed

    private void autorInKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_autorInKeyTyped
        if(autorIn.getText().length() > 200){
            evt.consume();
        }
    }//GEN-LAST:event_autorInKeyTyped

    private void tituloLibroInKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tituloLibroInKeyTyped
        if(tituloLibroIn.getText().length() > 100){
            evt.consume();
        }
    }//GEN-LAST:event_tituloLibroInKeyTyped

    private void editorialInKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editorialInKeyTyped
        if(editorialIn.getText().length() > 100){
            evt.consume();
        }
    }//GEN-LAST:event_editorialInKeyTyped

    private void anioInKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anioInKeyTyped
        char caracteres= evt.getKeyChar();
        if (caracteres<'0'||caracteres>'9') evt.consume();
        if(anioIn.getText().length() >= 4){
            evt.consume();
        }
    }//GEN-LAST:event_anioInKeyTyped

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarBibliografia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarBibliografia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarBibliografia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarBibliografia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarBibliografia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JTextField anioIn;
    private javax.swing.JLabel anioText;
    private javax.swing.JTextField autorIn;
    private javax.swing.JLabel autorText;
    private javax.swing.JLabel bibliografiaText;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JTextField editorialIn;
    private javax.swing.JLabel editorialText;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField tituloLibroIn;
    private javax.swing.JLabel tituloLibroText;
    // End of variables declaration//GEN-END:variables
}
