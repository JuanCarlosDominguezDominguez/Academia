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
public class PlanDeCurso {
    private String objetivoGeneral;
    private Periodo periodo;
    private ArrayList<Bibliografia> bibliografias;
    private ArrayList<Unidad> unidades;
    private ArrayList<CriterioDeEvaluacion> criteriosDeEvaluacion;

    public PlanDeCurso() {
    }

    public PlanDeCurso(String objetivoGeneral, Periodo periodo, ArrayList<Bibliografia> bibliografias, ArrayList<Unidad> unidades, ArrayList<CriterioDeEvaluacion> criteriosDeEvaluacion) {
        this.objetivoGeneral = objetivoGeneral;
        this.periodo = periodo;
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

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
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
