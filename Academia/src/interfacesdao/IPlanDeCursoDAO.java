/*

 *  Derechos de autor: UV-software(c)
 *  @auto: Juan Carlos Domínguez Dominguez
 *  @nombre: Control de academias
 *  @versión 0.1.7
 *  Este producto no puede ser intercambiado bajo ninguna circunstancia
	
 */

package interfacesdao;

import clases.Curso;
import clases.PlanDeCurso;

/**
 *
 * @author Juuan
 */
public interface IPlanDeCursoDAO {
    boolean agregarPlanDeCurso(PlanDeCurso planDeCurso);
    PlanDeCurso obtenerPlanDeCursoPorCurso(Curso curso);
}
