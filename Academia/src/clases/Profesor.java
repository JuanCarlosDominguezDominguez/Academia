/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author Juuan
 */
public class Profesor {
    private String numeroDePersonal;
    private String nombre;
    private String gradoAcademico;
    private ArrayList<Academia> academias;
    private ArrayList<Curso> cursos;

    public Profesor() {
    }

    public Profesor(String numeroDePersonal, String nombre, String gradoAcademico, ArrayList<Academia> academias, ArrayList<Curso> cursos) {
        this.numeroDePersonal = numeroDePersonal;
        this.nombre = nombre;
        this.gradoAcademico = gradoAcademico;
        this.academias = academias;
        this.cursos = cursos;
    }

    public String getNumeroDePersonal() {
        return numeroDePersonal;
    }

    public void setNumeroDePersonal(String numeroDePersonal) {
        this.numeroDePersonal = numeroDePersonal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGradoAcademico() {
        return gradoAcademico;
    }

    public void setGradoAcademico(String gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
    }

    public ArrayList<Academia> getAcademias() {
        return academias;
    }

    public void setAcademias(ArrayList<Academia> academias) {
        this.academias = academias;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }
    
    
    
}
