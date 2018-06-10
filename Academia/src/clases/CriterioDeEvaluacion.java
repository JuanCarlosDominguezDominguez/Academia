/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Date;

/**
 *
 * @author Juuan
 */
public class CriterioDeEvaluacion {
    private int unidad;
    private String criterioEvaluacion;
    private Date fecha;
    private String instrumento;
    private String porcentaje;
    private ExperienciaEducativa experienciaEducativa;
    
    public CriterioDeEvaluacion() {
    
    }

    public CriterioDeEvaluacion(int unidad, String criterioEvaluacion, Date fecha, String instrumento, String porcentaje, ExperienciaEducativa experienciaEducativa) {
        this.unidad = unidad;
        this.criterioEvaluacion = criterioEvaluacion;
        this.fecha = fecha;
        this.instrumento = instrumento;
        this.porcentaje = porcentaje;
        this.experienciaEducativa = experienciaEducativa;
    }

    public int getUnidad() {
        return unidad;
    }

    public void setUnidad(int unidad) {
        this.unidad = unidad;
    }

    public String getCriterioEvaluacion() {
        return criterioEvaluacion;
    }

    public void setCriterioEvaluacion(String criterioEvaluacion) {
        this.criterioEvaluacion = criterioEvaluacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public ExperienciaEducativa getExperienciaEducativa() {
        return experienciaEducativa;
    }

    public void setExperienciaEducativa(ExperienciaEducativa experienciaEducativa) {
        this.experienciaEducativa = experienciaEducativa;
    }
    
}
