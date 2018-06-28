/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesdao;

import clases.Curso;
import java.util.List;

/**
 *
 * @author Juuan
 */
public interface ICursoDAO {
    List<Curso> obtenerCursosPorProfesor(String numeroDePersonal);
}
