/*

 *  Derechos de autor: UV-software(c)
 *  @auto: Juan Carlos Domínguez Dominguez
 *  @nombre: Control de academias
 *  @versión 0.1.2
 *  Este producto no puede ser intercambiado bajo ninguna circunstancia
	
 */

package clases;

/**
 *
 * @author Juuan
 */
public class ProgramaEducativo {
    private String nombrePE;

    public ProgramaEducativo() {
    }

    public ProgramaEducativo(String nombrePE) {
        this.nombrePE = nombrePE;
    }

    public String getNombrePE() {
        return nombrePE;
    }

    public void setNombrePE(String nombrePE) {
        this.nombrePE = nombrePE;
    }
    
}
