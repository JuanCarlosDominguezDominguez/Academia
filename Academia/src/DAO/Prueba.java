/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clases.Profesor;

/**
 *
 * @author Juuan
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Profesor profesor = new Profesor();
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
        }
    }
}
