/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clases.CriterioDeEvaluacion;
import clases.Profesor;
import java.sql.Date;

/**
 *
 * @author Juuan
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Profesor profesor = new Profesor();
        ProfesorDAO profesorDAO = new ProfesorDAO();
        AcademiaDAO academiaDAO = new AcademiaDAO();
        CursoDAO cursoDAO = new CursoDAO();
        profesor = profesorDAO.obtenerProfesor("G34512333");
        profesor.setAcademias(academiaDAO.obtenerTodasLasAcademiasPorProfesor("G34512333"));
        profesor.setCursos(cursoDAO.obtenerCursosPorProfesor("G34512333"));
        
        System.out.println(profesor.getNombre());
        System.out.println(profesor.getAcademias().size());
        for(int i = 0; i < profesor.getAcademias().size(); i++){
            System.out.println(profesor.getAcademias().get(i).getNombreAcademia());
        }*/
        ExperienciaEducativaDAO experiencia = new ExperienciaEducativaDAO();
        //System.out.println(experiencia.obtenerExperienciaEducativa("PCS001").getAcademia().getCoordinadorDeAcademia().getNumeroDePersonal());
        CriterioDeEvaluacion criterio = new CriterioDeEvaluacion();
        criterio.setCriterioEvaluacion("hola");
        criterio.setExperienciaEducativa(experiencia.obtenerExperienciaEducativa("PCS001"));;
        criterio.setFecha(Date.valueOf("2010-10-10"));
        criterio.setInstrumento("hola");
        criterio.setPorcentaje("20");
        criterio.setUnidadesEvaluadas("hola");
        
        CriterioDeEvaluacionDAO dao = new CriterioDeEvaluacionDAO();
        dao.agregarCriterioDeEvaluacion(criterio);
        System.out.println(dao.agregarCriterioDeEvaluacion(criterio));
    }
}
