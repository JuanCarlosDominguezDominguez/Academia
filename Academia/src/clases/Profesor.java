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
    private String area;
    private String facultad;
    private ArrayList<Academia> academias;
    private ArrayList<Curso> cursos;

    public Profesor() {
    }

    public Profesor(String numeroDePersonal, String nombre, String gradoAcademico, String area, String facultad, ArrayList<Academia> academias, ArrayList<Curso> cursos) {
        this.numeroDePersonal = numeroDePersonal;
        this.nombre = nombre;
        this.gradoAcademico = gradoAcademico;
        this.area = area;
        this.facultad = facultad;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
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
