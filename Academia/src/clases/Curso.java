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
public class Curso {
    private int nrc;
    private int bloque;
    private int seccion;
    private ExperienciaEducativa experienciaEducativa;
    private Periodo periodo;
    private Profesor profesor;

    public Curso() {
    }

    public Curso(int nrc, int bloque, int seccion, ExperienciaEducativa experienciaEducativa, Periodo periodo, Profesor profesor) {
        this.nrc = nrc;
        this.bloque = bloque;
        this.seccion = seccion;
        this.experienciaEducativa = experienciaEducativa;
        this.periodo = periodo;
        this.profesor = profesor;
    }

    public int getNrc() {
        return nrc;
    }

    public void setNrc(int nrc) {
        this.nrc = nrc;
    }

    public int getBloque() {
        return bloque;
    }

    public void setBloque(int bloque) {
        this.bloque = bloque;
    }

    public int getSeccion() {
        return seccion;
    }

    public void setSeccion(int seccion) {
        this.seccion = seccion;
    }

    public ExperienciaEducativa getExperienciaEducativa() {
        return experienciaEducativa;
    }

    public void setExperienciaEducativa(ExperienciaEducativa experienciaEducativa) {
        this.experienciaEducativa = experienciaEducativa;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    
}
