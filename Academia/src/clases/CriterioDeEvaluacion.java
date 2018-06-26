/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Date;

/**
 *
 * @author Juuan
 */
public class CriterioDeEvaluacion {
    private String unidadesEvaluadas;
    private String criterioEvaluacion;
    private Date fecha;
    private String instrumento;
    private String porcentaje;
    private ExperienciaEducativa experienciaEducativa;
    
    public CriterioDeEvaluacion() {
    
    }

    public CriterioDeEvaluacion(String unidadesEvaluadas, String criterioEvaluacion, Date fecha, String instrumento, String porcentaje, ExperienciaEducativa experienciaEducativa) {
        this.unidadesEvaluadas = unidadesEvaluadas;
        this.criterioEvaluacion = criterioEvaluacion;
        this.fecha = fecha;
        this.instrumento = instrumento;
        this.porcentaje = porcentaje;
        this.experienciaEducativa = experienciaEducativa;
    }

    public String getUnidadesEvaluadas() {
        return unidadesEvaluadas;
    }

    public void setUnidadesEvaluadas(String unidadesEvaluadas) {
        this.unidadesEvaluadas = unidadesEvaluadas;
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
