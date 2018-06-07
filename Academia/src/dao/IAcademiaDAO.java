/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import clases.Academia;
import java.util.List;

/**
 *
 * @author Juuan
 */
public interface IAcademiaDAO {
    boolean agregarAcademia(Academia academia);
    boolean eliminarAcademia(String nombreAcademia);
    Academia obtenerAcademiaPorNombre(String nombreAcademia);
    List<Academia> obtenerTodasLasAcademias();
}
