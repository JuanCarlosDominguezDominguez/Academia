/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesdao;

import clases.Academia;
import java.util.List;

/**
 *
 * @author Juuan
 */
public interface IAcademiaDAO {
    Academia obtenerAcademiaPorNombre(String nombreAcademia);
    List<Academia> obetenerTodasLasAcademiasPorProfesor(String numeroDePersonal);
}
