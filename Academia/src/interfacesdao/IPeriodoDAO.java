/*

 *  Derechos de autor: UV-software(c)
 *  @auto: Juan Carlos Domínguez Dominguez
 *  @nombre: Control de academias
 *  @versión 0.1.0
 *  Este producto no puede ser intercambiado bajo ninguna circunstancia
	
 */

package interfacesdao;

import clases.Periodo;

/**
 *
 * @author Juuan
 */
public interface IPeriodoDAO {
    Periodo obtenerPeriodo(String nombrePeriodo);
}
