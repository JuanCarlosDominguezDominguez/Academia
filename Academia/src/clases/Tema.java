/*

 *  Derechos de autor: UV-software(c)
 *  @auto: Juan Carlos Domínguez Dominguez
 *  @nombre: Control de academias
 *  @versión 0.1.0
 *  Este producto no puede ser intercambiado bajo ninguna circunstancia
	
 */

package clases;

import java.util.Date;

/**
 *
 * @author Juuan
 */
public class Tema {
    private String nombre;

    public Tema() {
    }

    public Tema(String nombre, Date fecha) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
