/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesdao;

import clases.Profesor;
import java.util.List;

/**
 *
 * @author Juuan
 */
public interface IProfesorDAO {
    Profesor obtenerProfesor(String numeroDePersonal);
}
