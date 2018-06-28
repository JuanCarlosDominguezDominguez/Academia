/*

 *  Derechos de autor: UV-software(c)
 *  @auto: Juan Carlos Domínguez Dominguez
 *  @nombre: Control de academias
 *  @versión 0.2.1
 *  Este producto no puede ser intercambiado bajo ninguna circunstancia
	
 */

package clases;

import java.util.ArrayList;

/**
 *
 * @author Juuan
 */
public class PlanDeCurso {
    private String objetivoGeneral;
    private Curso curso;
    private String estado;
    private ArrayList<Bibliografia> bibliografias;
    private ArrayList<Unidad> unidades;
    private ArrayList<CriterioDeEvaluacion> criteriosDeEvaluacion;

    public PlanDeCurso() {
    }

    public PlanDeCurso(String objetivoGeneral, Curso curso, String estado, ArrayList<Bibliografia> bibliografias, ArrayList<Unidad> unidades, ArrayList<CriterioDeEvaluacion> criteriosDeEvaluacion) {
        this.objetivoGeneral = objetivoGeneral;
        this.curso = curso;
        this.estado = estado;
        this.bibliografias = bibliografias;
        this.unidades = unidades;
        this.criteriosDeEvaluacion = criteriosDeEvaluacion;
    }

    public String getObjetivoGeneral() {
        return objetivoGeneral;
    }

    public void setObjetivoGeneral(String objetivoGeneral) {
        this.objetivoGeneral = objetivoGeneral;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<Bibliografia> getBibliografias() {
        return bibliografias;
    }

    public void setBibliografias(ArrayList<Bibliografia> bibliografias) {
        this.bibliografias = bibliografias;
    }

    public ArrayList<Unidad> getUnidades() {
        return unidades;
    }

    public void setUnidades(ArrayList<Unidad> unidades) {
        this.unidades = unidades;
    }

    public ArrayList<CriterioDeEvaluacion> getCriteriosDeEvaluacion() {
        return criteriosDeEvaluacion;
    }

    public void setCriteriosDeEvaluacion(ArrayList<CriterioDeEvaluacion> criteriosDeEvaluacion) {
        this.criteriosDeEvaluacion = criteriosDeEvaluacion;
    }

    
}
