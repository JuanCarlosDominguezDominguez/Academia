/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import clases.Curso;
import java.util.List;

/**
 *
 * @author Juuan
 */
public interface ICursoDAO {
    boolean agregarCurso(Curso curso);
    boolean eliminarCurso(String nrc);
    Curso obtenerCurso(String nrc);
    List<Curso> obtenerTodosLosCursos();
}
