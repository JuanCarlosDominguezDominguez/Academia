/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.AcademiaDAO;
import DAO.CursoDAO;
import DAO.ProfesorDAO;
import clases.Profesor;


/**
 *
 * @author Juuan
 */
public class SeleccionarExperienciaEducativa extends javax.swing.JFrame {
    private static String numeroDePersonal;

    public static String getNumeroDePersonal() {
        return numeroDePersonal;
    }

    public static void setNumeroDePersonal(String numeroDePersonal) {
        SeleccionarExperienciaEducativa.numeroDePersonal = numeroDePersonal;
    }
    
    /**
     * Creates new form SeleccionarAcademia
     */
    public SeleccionarExperienciaEducativa() {
        initComponents();
        
        Profesor profesor = new Profesor();
        profesor = obtenerProfesor(numeroDePersonal);

        for(int i = 0; i <profesor.getCursos().size(); i++){
            experienciaEducativaIn.addItem(profesor.getCursos().get(i).getExperienciaEducativa().getNombreEE());
        }
        
    }
    
    public Profesor obtenerProfesor(String numeroDePersonal){
        Profesor profesor = new Profesor();
        ProfesorDAO profesorDAO = new ProfesorDAO();
        AcademiaDAO academiaDAO = new AcademiaDAO();
        CursoDAO cursoDAO = new CursoDAO();
        profesor = profesorDAO.obtenerProfesor(numeroDePersonal);
        profesor.setAcademias(academiaDAO.obtenerTodasLasAcademiasPorProfesor(numeroDePersonal));
        profesor.setCursos(cursoDAO.obtenerCursosPorProfesor(numeroDePersonal));
        return profesor;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content ofS
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        mensajeText = new javax.swing.JLabel();
        experienciaEducativaText = new javax.swing.JLabel();
        experienciaEducativaIn = new javax.swing.JComboBox<>();
        aceptarButton = new javax.swing.JButton();
        salirButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mensajeText.setText("Bienvenido");

        experienciaEducativaText.setText("Elije una experiencia educativa:");

        aceptarButton.setText("Aceptar");
        aceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarButtonActionPerformed(evt);
            }
        });

        salirButton.setText("Salir");
        salirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(mensajeText))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(aceptarButton)
                        .addGap(46, 46, 46)
                        .addComponent(salirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(experienciaEducativaText))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(experienciaEducativaIn, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mensajeText, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(experienciaEducativaText)
                .addGap(18, 18, 18)
                .addComponent(experienciaEducativaIn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptarButton)
                    .addComponent(salirButton))
                .addContainerGap())
        );

        mensajeText.getAccessibleContext().setAccessibleName("Bienvenido, por favor elije una academia:\n");

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
        String experienciaEducativaSelecionada = experienciaEducativaIn.getSelectedItem().toString();
        Profesor profesor = new Profesor();
        profesor = obtenerProfesor(numeroDePersonal);
        for(int i = 0; i < profesor.getCursos().size(); i++){
            if(profesor.getCursos().get(i).getExperienciaEducativa().getNombreEE().equals(experienciaEducativaSelecionada)){
                if(profesor.getCursos().get(i).getExperienciaEducativa().getAcademia().getCoordinadorDeAcademia().getNumeroDePersonal().equals(profesor.getNumeroDePersonal())){
                    PantallaCoordinador.setCoordinador(profesor);
                    PantallaCoordinador.setPosicionCurso(i);
                    PantallaCoordinador pantallaCoordinador = new PantallaCoordinador();
                    pantallaCoordinador.setVisible(true);
                    dispose();
                }else{
                    PantallaProfesor.setProfesor(profesor);
                    PantallaProfesor.setPosicionCurso(i);
                    PantallaProfesor pantallaProfesor= new PantallaProfesor();
                    pantallaProfesor.setVisible(true);
                    dispose();
                }
            }
        }
    }//GEN-LAST:event_aceptarButtonActionPerformed

    private void salirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirButtonActionPerformed
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_salirButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SeleccionarExperienciaEducativa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeleccionarExperienciaEducativa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeleccionarExperienciaEducativa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeleccionarExperienciaEducativa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeleccionarExperienciaEducativa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JComboBox<String> experienciaEducativaIn;
    private javax.swing.JLabel experienciaEducativaText;
    private javax.swing.JLabel mensajeText;
    private javax.swing.JPanel panel;
    private javax.swing.JButton salirButton;
    // End of variables declaration//GEN-END:variables
}
