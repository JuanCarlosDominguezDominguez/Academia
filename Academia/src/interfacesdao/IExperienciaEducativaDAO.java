/*

 *  Derechos de autor: UV-software(c)
 *  @auto: Juan Carlos Domínguez Dominguez
 *  @nombre: Control de academias
 *  @versión 0.1.3
 *  Este producto no puede ser intercambiado bajo ninguna circunstancia
	
 */

package interfacesdao;

import clases.ExperienciaEducativa;
import java.util.ArrayList;

/**
 *
 * @author Juuan
 */
public interface IExperienciaEducativaDAO {
    ExperienciaEducativa obtenerExperienciaEducativa(String codigo);
    ArrayList<ExperienciaEducativa> obtenerExperienciasEducativasPorAcademia(String nombreAcademia);
}
