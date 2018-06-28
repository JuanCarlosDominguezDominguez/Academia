/*

 *  Derechos de autor: UV-software(c)
 *  @auto: Juan Carlos Domínguez Dominguez
 *  @nombre: Control de academias
 *  @versión 0.1.7
 *  Este producto no puede ser intercambiado bajo ninguna circunstancia
	
 */

package clases;

import java.util.ArrayList;


/**
 *
 * @author Juuan
 */
public class ExperienciaEducativa {
    private String codigo;
    private String nombreEE;
    private String descripcion;
    private int numeroDeCreditos;
    private Curso curso;
    private ArrayList<ProgramaEducativo> programasEducativos;
    private Academia academia;

    public ExperienciaEducativa() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreEE() {
        return nombreEE;
    }

    public void setNombreEE(String nombreEE) {
        this.nombreEE = nombreEE;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumeroDeCreditos() {
        return numeroDeCreditos;
    }

    public void setNumeroDeCreditos(int numeroDeCreditos) {
        this.numeroDeCreditos = numeroDeCreditos;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public ArrayList<ProgramaEducativo> getProgramasEducativos() {
        return programasEducativos;
    }

    public void setProgramasEducativos(ArrayList<ProgramaEducativo> programasEducativos) {
        this.programasEducativos = programasEducativos;
    }

    public Academia getAcademia() {
        return academia;
    }

    public void setAcademia(Academia academia) {
        this.academia = academia;
    }

    public ExperienciaEducativa(String codigo, String nombreEE, String descripcion, int numeroDeCreditos, Curso curso, ArrayList<ProgramaEducativo> programasEducativos, Academia academia) {
        this.codigo = codigo;
        this.nombreEE = nombreEE;
        this.descripcion = descripcion;
        this.numeroDeCreditos = numeroDeCreditos;
        this.curso = curso;
        this.programasEducativos = programasEducativos;
        this.academia = academia;
    }

}
