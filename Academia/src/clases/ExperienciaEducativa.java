/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;


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
    private ProgramaEducativo programaEducativo;

    public ExperienciaEducativa() {
    }

    public ExperienciaEducativa(String codigo, String nombreEE, String descripcion, int numeroDeCreditos, Curso curso, ProgramaEducativo programaEducativo) {
        this.codigo = codigo;
        this.nombreEE = nombreEE;
        this.descripcion = descripcion;
        this.numeroDeCreditos = numeroDeCreditos;
        this.curso = curso;
        this.programaEducativo = programaEducativo;
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

    public ProgramaEducativo getProgramaEducativo() {
        return programaEducativo;
    }

    public void setProgramaEducativo(ProgramaEducativo programaEducativo) {
        this.programaEducativo = programaEducativo;
    }
    
    
}
