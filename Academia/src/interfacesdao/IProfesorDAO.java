/*

 *  Derechos de autor: UV-software(c)
 *  @auto: Juan Carlos Domínguez Dominguez
 *  @nombre: Control de academias
 *  @versión 0.1.3
 *  Este producto no puede ser intercambiado bajo ninguna circunstancia
	
 */

package interfacesdao;

import clases.Profesor;

/**
 *
 * @author Juuan
 */
public interface IProfesorDAO {
    Profesor obtenerProfesor(String numeroDePersonal);
}
