/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.AcademiaDAO;
import DAO.CursoDAO;
import DAO.ExperienciaEducativaDAO;

/**
 *
 * @author Juuan
 */
public class SeleccionarAcademia extends javax.swing.JFrame {
    static private String numeroDePersonal;

    public static String getNumeroDePersonal() {
        return numeroDePersonal;
    }

    public static void setNumeroDePersonal(String numeroDePersonal) {
        SeleccionarAcademia.numeroDePersonal = numeroDePersonal;
    }
    
    /**
     * Creates new form SeleccionarAcademia
     */
    public SeleccionarAcademia() {
        initComponents();
        AcademiaDAO academiaDAO = new AcademiaDAO();
        for (int i = 0; i < academiaDAO.obetenerTodasLasAcademiasPorProfesor(numeroDePersonal).size(); i++){
            academiaIn.addItem(academiaDAO.obetenerTodasLasAcademiasPorProfesor(numeroDePersonal).get(i).getNombreAcademia());
        }
        
        CursoDAO cursoDAO = new CursoDAO();
        ExperienciaEducativaDAO experienciaEducativaDAO = new ExperienciaEducativaDAO();
        for(int i = 0; i < cursoDAO.obtenerCursosPorProfesor(numeroDePersonal).size(); i++){
            experienciaEducativaIn.addItem(experienciaEducativaDAO.obtenerExperienciaEducativa(cursoDAO.obtenerCursosPorProfesor(numeroDePersonal).get(i).getExperienciaEducativa().getCodigo()).getNombreEE());
        }
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content ofS
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        academiaIn = new javax.swing.JComboBox<>();
        mensajeText = new javax.swing.JLabel();
        experienciaEducativaText = new javax.swing.JLabel();
        experienciaEducativaIn = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mensajeText.setText("Bienvenido, elije una academia: ");

        experienciaEducativaText.setText("Elije una experiencia educativa:");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(experienciaEducativaText)
                            .addComponent(mensajeText)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(academiaIn, 0, 293, Short.MAX_VALUE)
                            .addComponent(experienciaEducativaIn, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(mensajeText, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(academiaIn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(experienciaEducativaText)
                .addGap(18, 18, 18)
                .addComponent(experienciaEducativaIn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(SeleccionarAcademia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeleccionarAcademia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeleccionarAcademia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeleccionarAcademia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeleccionarAcademia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> academiaIn;
    private javax.swing.JComboBox<String> experienciaEducativaIn;
    private javax.swing.JLabel experienciaEducativaText;
    private javax.swing.JLabel mensajeText;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
