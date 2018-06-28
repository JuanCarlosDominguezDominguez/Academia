/*

 *  Derechos de autor: UV-software(c)
 *  @auto: Juan Carlos Domínguez Dominguez
 *  @nombre: Control de academias
 *  @versión 0.1.2
 *  Este producto no puede ser intercambiado bajo ninguna circunstancia
	
 */

package interfacesdao;

import clases.CriterioDeEvaluacion;
import java.util.ArrayList;

/**
 *
 * @author Juuan
 */
public interface ICriterioDeEvaluacionDAO {
    boolean agregarCriterioDeEvaluacion(CriterioDeEvaluacion criterioDeEvaluacion);
    ArrayList<CriterioDeEvaluacion> obtenerCriteriosDeEvaluacionPorExperienciaEducativa(String codigoEE);
}
