/*

 *  Derechos de autor: UV-software(c)
 *  @auto: Juan Carlos Domínguez Dominguez
 *  @nombre: Control de academias
 *  @versión 0.1.4
 *  Este producto no puede ser intercambiado bajo ninguna circunstancia
	
 */

package interfacesdao;

import clases.Academia;
import java.util.List;

/**
 *
 * @author Juuan
 */
public interface IAcademiaDAO {
    List<Academia> obtenerTodasLasAcademiasPorProfesor(String numeroDePersonal);
    Academia obtenerAcademiaPorExperienciaEducativa(String codigoEE);
}
