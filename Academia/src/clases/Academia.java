/*

 *  Derechos de autor: UV-software(c)
 *  @auto: Juan Carlos Domínguez Dominguez
 *  @nombre: Control de academias
 *  @versión 0.1.3
 *  Este producto no puede ser intercambiado bajo ninguna circunstancia
	
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
    private ArrayList<ExperienciaEducativa> experienciasEducativas;

    public Academia() {
    }

    public Academia(String nombreAcademia, ArrayList<Profesor> profesores, Profesor coordinadorDeAcademia, ArrayList<ProgramaEducativo> programasEducativos, ArrayList<ExperienciaEducativa> experienciasEducativas) {
        this.nombreAcademia = nombreAcademia;
        this.profesores = profesores;
        this.coordinadorDeAcademia = coordinadorDeAcademia;
        this.programasEducativos = programasEducativos;
        this.experienciasEducativas = experienciasEducativas;
    }

    public ArrayList<ExperienciaEducativa> getExperienciasEducativas() {
        return experienciasEducativas;
    }

    public void setExperienciasEducativas(ArrayList<ExperienciaEducativa> experienciasEducativas) {
        this.experienciasEducativas = experienciasEducativas;
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
