/*

 *  Derechos de autor: UV-software(c)
 *  @auto: Juan Carlos Domínguez Dominguez
 *  @nombre: Control de academias
 *  @versión 0.1.5
 *  Este producto no puede ser intercambiado bajo ninguna circunstancia
	
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
    Curso obtenerCursoDeExperienciaEducativa(String codigo);
}
