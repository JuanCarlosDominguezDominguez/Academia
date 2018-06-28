/*

 *  Derechos de autor: UV-software(c)
 *  @auto: Juan Carlos Domínguez Dominguez
 *  @nombre: Control de academias
 *  @versión 0.4.7
 *  Este producto no puede ser intercambiado bajo ninguna circunstancia
	
 */

package GUI;

import DAO.PlanDeCursoDAO;
import clases.Curso;
import clases.PlanDeCurso;
import clases.Profesor;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juuan
 */
public class VisualizarPlanDeCurso extends javax.swing.JFrame {
    private static Profesor profesor;
    private static int posicionCurso;
    private static int posicionExperiencia;
    private static Curso curso = new Curso();
    private static PlanDeCursoDAO planDeCursoDAO = new PlanDeCursoDAO();
    private static PlanDeCurso planDeCurso = new PlanDeCurso();
    public static DefaultTableModel modelo;

    public static int getPosicionCurso() {
        return posicionCurso;
    }

    public static int getPosicionExperiencia() {
        return posicionExperiencia;
    }

    public static void setPosicionExperiencia(int posicionExperiencia) {
        VisualizarPlanDeCurso.posicionExperiencia = posicionExperiencia;
    }
    
    public static void setPosicionCurso(int posicionCurso) {
        VisualizarPlanDeCurso.posicionCurso = posicionCurso;
    }

    public static Profesor getProfesor() {
        return profesor;
    }

    public static void setProfesor(Profesor profesor) {
        VisualizarPlanDeCurso.profesor = profesor;
    }
    /**
     * Creates new form VisualizarPlanDeCurso
     */
    public VisualizarPlanDeCurso() {
        initComponents();
        
        curso = profesor.getCursos().get(posicionCurso);
        planDeCurso = planDeCursoDAO.obtenerPlanDeCursoPorCurso(curso);
        mostrarDatosPrincipales();
        cargarTablaPlaneacion();
        cargarTablaBibliografia();
        cargarTablaEvaluaciones();
    }
    public void mostrarDatosPrincipales(){
        claveNrcOut.setText(Integer.toString(curso.getNrc()));
        experienciaEducativaOut.setText(curso.getExperienciaEducativa().getNombreEE());
        
        bloqueOut.setText(Integer.toString(curso.getBloque()));
        seccionOut.setText(Integer.toString(curso.getSeccion()));
        academicoOut.setText(profesor.getNombre());
        periodoOut.setText(curso.getPeriodo().getNombrePeriodo());
        objetivoGeneralIn.setText(planDeCurso.getObjetivoGeneral());
    }
    
    public static void cargarTablaPlaneacion(){
        modelo = (DefaultTableModel) planeacionTable.getModel();
        for(int i = 0; i<planDeCurso.getUnidades().size(); i++){
            Object nuevo[]= {""};
            modelo.addRow(nuevo);
            planeacionTable.setValueAt(planDeCurso.getUnidades().get(i).getNombre(), i, 0);
            for(int j = 0; j<planDeCurso.getUnidades().get(i).getTemas().size();j++){
                planeacionTable.setValueAt(planDeCurso.getUnidades().get(i).getTemas().get(j).getNombre(), i, 1);
            }
            planeacionTable.setValueAt(planDeCurso.getUnidades().get(i).getFecha(), i, 2);
            planeacionTable.setValueAt(planDeCurso.getUnidades().get(i).getTareasYPracticas(), i, 3);
            planeacionTable.setValueAt(planDeCurso.getUnidades().get(i).getTecnicaDidactica(), i, 4);
        }
    }
    
    public static void cargarTablaBibliografia(){
        modelo = (DefaultTableModel) bibliografiaTable.getModel();
        for(int i = 0; i < planDeCurso.getBibliografias().size();i++){
            Object nuevo[]= {""};
            modelo.addRow(nuevo);
            bibliografiaTable.setValueAt(planDeCurso.getBibliografias().get(i).getAutor(), i, 0);
            bibliografiaTable.setValueAt(planDeCurso.getBibliografias().get(i).getTituloLibro(), i, 1);
            bibliografiaTable.setValueAt(planDeCurso.getBibliografias().get(i).getEditorial(), i, 2);
            bibliografiaTable.setValueAt(planDeCurso.getBibliografias().get(i).getAnio(), i, 3);
        }
    }
    
    public static void cargarTablaEvaluaciones(){
        modelo = (DefaultTableModel) calendarioEvaluacionTable.getModel();
        for(int i = 0; i < planDeCurso.getCriteriosDeEvaluacion().size();i++){
            Object nuevo[]= {""};
            modelo.addRow(nuevo);
            calendarioEvaluacionTable.setValueAt(planDeCurso.getCriteriosDeEvaluacion().get(i).getUnidadesEvaluadas(), i, 0);
            calendarioEvaluacionTable.setValueAt(planDeCurso.getCriteriosDeEvaluacion().get(i).getFecha(), i, 1);
            calendarioEvaluacionTable.setValueAt(planDeCurso.getCriteriosDeEvaluacion().get(i).getCriterioEvaluacion(), i, 2);
            calendarioEvaluacionTable.setValueAt(planDeCurso.getCriteriosDeEvaluacion().get(i).getInstrumento(), i, 3);
            calendarioEvaluacionTable.setValueAt(planDeCurso.getCriteriosDeEvaluacion().get(i).getPorcentaje(), i, 4);
        }
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
        claveNrcText = new javax.swing.JLabel();
        academicoText = new javax.swing.JLabel();
        experienciaEducativaText = new javax.swing.JLabel();
        programaEducativoText = new javax.swing.JLabel();
        bloqueText = new javax.swing.JLabel();
        seccionText = new javax.swing.JLabel();
        periodoText = new javax.swing.JLabel();
        objetivoGeneralText = new javax.swing.JLabel();
        objetivoGeneralIn = new javax.swing.JTextField();
        planeacionText = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        planeacionTable = new javax.swing.JTable();
        bibliografiaText = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bibliografiaTable = new javax.swing.JTable();
        calendarioEvaluacionText = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        calendarioEvaluacionTable = new javax.swing.JTable();
        salirButton = new javax.swing.JButton();
        claveNrcOut = new javax.swing.JLabel();
        experienciaEducativaOut = new javax.swing.JLabel();
        programaEducativoOut = new javax.swing.JLabel();
        bloqueOut = new javax.swing.JLabel();
        seccionOut = new javax.swing.JLabel();
        academicoOut = new javax.swing.JLabel();
        periodoOut = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        claveNrcText.setText("CLAVE NRC: ");

        academicoText.setText("ACADÉMICO: ");

        experienciaEducativaText.setText("E.E: ");

        programaEducativoText.setText("P.E: ");

        bloqueText.setText("Bloque: ");

        seccionText.setText("Sección: ");

        periodoText.setText("PERIODO: ");

        objetivoGeneralText.setText("OBJETIVO GENERAL: ");

        objetivoGeneralIn.setEditable(false);
        objetivoGeneralIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                objetivoGeneralInActionPerformed(evt);
            }
        });

        planeacionText.setText("PLANEACIÓN: ");

        planeacionTable.setAutoCreateRowSorter(true);
        planeacionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Unidad", "Temas", "Fechas", "Tareas y prácticas", "Técnica didactica"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(planeacionTable);

        bibliografiaText.setText("BIBLIOGRAFÍA: ");

        bibliografiaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Autor(es)", "Título de libro", "Editorial", "Año"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(bibliografiaTable);

        calendarioEvaluacionText.setText("CALENDARIO DE EVALUACIÓN: ");

        calendarioEvaluacionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Unidad", "Fechas", "Criterio de evaluación: ", "Instrumento", "Porcentaje"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(calendarioEvaluacionTable);

        salirButton.setText("Salir");
        salirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirButtonActionPerformed(evt);
            }
        });

        claveNrcOut.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        experienciaEducativaOut.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        programaEducativoOut.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        bloqueOut.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        seccionOut.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        academicoOut.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        periodoOut.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addComponent(salirButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(objetivoGeneralIn)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calendarioEvaluacionText)
                            .addComponent(bibliografiaText)
                            .addComponent(planeacionText)
                            .addComponent(objetivoGeneralText)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(academicoText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(academicoOut, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(periodoText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(periodoOut, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(claveNrcText)
                                .addGap(4, 4, 4)
                                .addComponent(claveNrcOut, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(experienciaEducativaText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(experienciaEducativaOut, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(programaEducativoText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(programaEducativoOut, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bloqueText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bloqueOut, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(seccionText)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(seccionOut, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3))
                .addGap(32, 32, 32))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(experienciaEducativaOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(programaEducativoOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(claveNrcText)
                                .addComponent(experienciaEducativaText)
                                .addComponent(programaEducativoText)
                                .addComponent(bloqueText)
                                .addComponent(seccionText))
                            .addComponent(claveNrcOut, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bloqueOut, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seccionOut, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(academicoText)
                        .addComponent(periodoText))
                    .addComponent(academicoOut, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(periodoOut, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(objetivoGeneralText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(objetivoGeneralIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(planeacionText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bibliografiaText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(calendarioEvaluacionText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(salirButton)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirButtonActionPerformed
        int opcion = JOptionPane.showConfirmDialog(null, "Seguro que no deseas salir?", "Confirmacion", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == 0) {
            dispose();
        }
    }//GEN-LAST:event_salirButtonActionPerformed

    private void objetivoGeneralInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objetivoGeneralInActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_objetivoGeneralInActionPerformed

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
            java.util.logging.Logger.getLogger(VisualizarPlanDeCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisualizarPlanDeCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisualizarPlanDeCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisualizarPlanDeCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisualizarPlanDeCurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel academicoOut;
    private javax.swing.JLabel academicoText;
    public static javax.swing.JTable bibliografiaTable;
    private javax.swing.JLabel bibliografiaText;
    private javax.swing.JLabel bloqueOut;
    private javax.swing.JLabel bloqueText;
    public static javax.swing.JTable calendarioEvaluacionTable;
    private javax.swing.JLabel calendarioEvaluacionText;
    private javax.swing.JLabel claveNrcOut;
    private javax.swing.JLabel claveNrcText;
    private javax.swing.JLabel experienciaEducativaOut;
    private javax.swing.JLabel experienciaEducativaText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField objetivoGeneralIn;
    private javax.swing.JLabel objetivoGeneralText;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel periodoOut;
    private javax.swing.JLabel periodoText;
    public static javax.swing.JTable planeacionTable;
    private javax.swing.JLabel planeacionText;
    private javax.swing.JLabel programaEducativoOut;
    private javax.swing.JLabel programaEducativoText;
    private javax.swing.JButton salirButton;
    private javax.swing.JLabel seccionOut;
    private javax.swing.JLabel seccionText;
    // End of variables declaration//GEN-END:variables
}
