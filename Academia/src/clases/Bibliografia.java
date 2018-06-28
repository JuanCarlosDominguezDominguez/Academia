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
public class Bibliografia {
    private String autor;
    private String tituloLibro;
    private String editorial;
    private int anio;

    public Bibliografia() {
    }

    public Bibliografia(String autor, String tituloLibro, String editorial, int anio) {
        this.autor = autor;
        this.tituloLibro = tituloLibro;
        this.editorial = editorial;
        this.anio = anio;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    
}
