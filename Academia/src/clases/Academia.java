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
public class Academia {
    private String nombreAcademia;
    private ArrayList<Profesor> profesores;
    private Profesor coordinadorDeAcademia;
    private ArrayList<ProgramaEducativo> programasEducativos;

    public Academia() {
    }

    public Academia(String nombreAcademia, ArrayList<Profesor> profesores, Profesor coordinadorDeAcademia, ArrayList<ProgramaEducativo> programasEducativos) {
        this.nombreAcademia = nombreAcademia;
        this.profesores = profesores;
        this.coordinadorDeAcademia = coordinadorDeAcademia;
        this.programasEducativos = programasEducativos;
    }

    public String getNombreAcademia() {
        return nombreAcademia;
    }

    public void setNombreAcademia(String nombreAcademia) {
        this.nombreAcademia = nombreAcademia;
    }

    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(ArrayList<Profesor> profesores) {
        this.profesores = profesores;
    }

    public Profesor getCoordinadorDeAcademia() {
        return coordinadorDeAcademia;
    }

    public void setCoordinadorDeAcademia(Profesor coordinadorDeAcademia) {
        this.coordinadorDeAcademia = coordinadorDeAcademia;
    }

    public ArrayList<ProgramaEducativo> getProgramasEducativos() {
        return programasEducativos;
    }

    public void setProgramasEducativos(ArrayList<ProgramaEducativo> programasEducativos) {
        this.programasEducativos = programasEducativos;
    }
    
    
}
