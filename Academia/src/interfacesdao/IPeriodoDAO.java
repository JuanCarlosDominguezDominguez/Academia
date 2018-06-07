/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesdao;

import clases.Periodo;
import java.util.List;

/**
 *
 * @author Juuan
 */
public interface IPeriodoDAO {
    boolean agregarPeriodo(Periodo periodo);
    boolean eliminarPeriodo(String nombrePeriodo);
    Periodo obtenerPeriodo(String nombrePeriodo);
    List<Periodo> obtenerTodosLosPeriodos();
}
