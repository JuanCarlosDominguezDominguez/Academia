/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Juuan
 */
public class Periodo {
    private Date fechaInicio;
    private Date fechaFin;
    private String nombrePeriodo;
    private ArrayList<Curso> cursos;
    private ArrayList<PlanDeCurso> planesDeCurso;

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getNombrePeriodo() {
        return nombrePeriodo;
    }

    public void setNombrePeriodo(String nombrePeriodo) {
        this.nombrePeriodo = nombrePeriodo;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    public ArrayList<PlanDeCurso> getPlanesDeCurso() {
        return planesDeCurso;
    }

    public void setPlanesDeCurso(ArrayList<PlanDeCurso> planesDeCurso) {
        this.planesDeCurso = planesDeCurso;
    }
}
