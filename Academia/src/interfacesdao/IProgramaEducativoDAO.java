/*

 *  Derechos de autor: UV-software(c)
 *  @auto: Juan Carlos Domínguez Dominguez
 *  @nombre: Control de academias
 *  @versión 0.1.1
 *  Este producto no puede ser intercambiado bajo ninguna circunstancia
	
 */

package interfacesdao;
import clases.ProgramaEducativo;
/**
 *
 * @author Juuan
 */
public interface IProgramaEducativoDAO {
    ProgramaEducativo obtenerProgramaEducativo(String nombrePE);
}
